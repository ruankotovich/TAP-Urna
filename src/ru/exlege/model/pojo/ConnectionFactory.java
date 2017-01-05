/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.exlege.model.pojo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author dmitry
 */
public final class ConnectionFactory {

    private static final String USER, PASSWORD, URL;
    private static final int MAX_CONNECTIONS_THREAD = 5;
    private static int connections = 0;

    static {
        String newoUser = null, newoPassword = null, newoUrl = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("connection.ex"));
            if (reader.ready()) {
                newoUser = reader.readLine();
                newoPassword = reader.readLine();
                newoUrl = reader.readLine();
            }
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Arquivo Não Encontrado (connection.ex)", "Erro", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Buffer de entrada/saida corrompido", "Erro", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

        USER = newoUser;
        PASSWORD = newoPassword;
        URL = newoUrl;
    }

    public static boolean testConnection(String user, String password) {
        return ConnectionFactory.openPersistentConnection(1, false, user, password) != null;
    }

    public static boolean testConnection() {
        return ConnectionFactory.openPersistentConnection(1) != null;
    }

    public static boolean testPeriodicConnection() {
        return ConnectionFactory.openPersistentConnection(1) != null;
    }

    public static Connection openPersistentConnection() {
        return ConnectionFactory.openPersistentConnection(5000, true, USER, PASSWORD);
    }

    public static Connection openPersistentConnection(int timeout) {
        return ConnectionFactory.openPersistentConnection(timeout, true, USER, PASSWORD);
    }

    public static Connection openPersistentConnection(int timeout, boolean exitOnError, String user, String password) {
        final Connection connection;
        Connection pivot = null;
        if (connections < MAX_CONNECTIONS_THREAD) {
            try {
                pivot = DriverManager.getConnection(URL, user, password);
                connections++;
            } catch (SQLException ex) {
                pivot = null;
                try {
                    PrintWriter pw = new PrintWriter(new File("log" + new SimpleDateFormat("ddMMyyy_hhmmss").format(new java.util.Date()) + ".txt"));
                    pw.write(ex.toString());
                    pw.close();
                    if (exitOnError) {
                        new Thread(() -> {
                            try {
                                Thread.sleep(5000);
                            } catch (InterruptedException ex1) {
                                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex1);
                            }
                            System.exit(0);
                        }).start();
                    }
                } catch (FileNotFoundException ex1) {
                    Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex1);
                }
            } finally {
                connection = pivot;
            }

            new Thread(() -> {
                try {
                    Thread.sleep(timeout);
                } catch (InterruptedException ex) {
                    closeConnection(connection);
                }
                closeConnection(connection);
            }).start();
            return connection;
        } else {
            throw new Error("ConnectionThreadPoll excedded the limit (" + connections + ">" + MAX_CONNECTIONS_THREAD + ")");
        }
    }

    private static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                if (connection.isClosed()) {
                    System.err.println("[EVENT] Connection already closed, connectionThread amount : " + connections);
                } else {
                    connection.close();
                    connections--;
                    System.err.println("[EVENT] Connection closed by timeout, connectionThread amount : " + connections);
                }
            } catch (SQLException ex1) {
                System.err.println("[EVENT] Connection already closed, connectionThread amount : " + connections);
            }

        } else {
            System.err.println("[EVENT] Connection does not long exist, connectionThread amount : " + connections);
        }
    }

    public static void notifyThreadDeleted() {
        if (connections > 0) {
            connections--;
        }
    }
}
