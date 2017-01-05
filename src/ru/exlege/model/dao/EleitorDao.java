/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.exlege.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import ru.exlege.model.bean.Eleitor;
import ru.exlege.model.pojo.ConnectionFactory;
import ru.exlege.model.pojo.Validable;

/**
 *
 * @author dmitry
 */
public class EleitorDao {

    private static PreparedStatement stmt;
    private static Connection con;
    private static ResultSet rs;

    public static boolean cadastrar(Validable<Eleitor> eleitorVal) {
        Eleitor eleitor = eleitorVal.validate();
        if (eleitor != null) {
            String query = "INSERT INTO `eleitores`(`ele_titulo`,`ele_nome`,`ele_dataNasc`)VALUES(?,?,?);";
            con = ConnectionFactory.openPersistentConnection(10000);
            try {
                stmt = con.prepareStatement(query);
                stmt.setLong(1, eleitor.getTitulo());
                stmt.setString(2, eleitor.getNome());
                stmt.setString(3, eleitor.getNascimento());
                stmt.execute();
                con.close();
                ConnectionFactory.notifyThreadDeleted();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(EleitorDao.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        } else {
            return false;
        }
    }

    public static Eleitor consultar(long titulo) {
        Eleitor eleitor;
        String query = "SELECT * FROM `eleitores` where `ele_titulo`=?;";
        con = ConnectionFactory.openPersistentConnection(10000);
        try {
            stmt = con.prepareStatement(query);
            stmt.setLong(1, titulo);
            rs = stmt.executeQuery();
            if (rs.next()) {
                eleitor = new Eleitor(titulo);
                eleitor.setNome(rs.getString("ele_nome"));
                eleitor.setNascimento(rs.getString("ele_dataNasc"));
                con.close();
                ConnectionFactory.notifyThreadDeleted();
                return eleitor;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EleitorDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static boolean deletar(long titulo) {
        Eleitor eleitor;
        String query = "DELETE FROM `eleitores` where `ele_titulo`=?;";
        con = ConnectionFactory.openPersistentConnection(10000);
        try {
            stmt = con.prepareStatement(query);
            stmt.setLong(1, titulo);
            stmt.execute();
            con.close();
            ConnectionFactory.notifyThreadDeleted();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EleitorDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static boolean alterar(long titulo, Eleitor ele) {
        ele = ele.validate();
        if (ele != null) {
            String query = "update eleitores set ele_nome =?,ele_dataNasc=?,ele_titulo=? where ele_titulo=?";
            con = ConnectionFactory.openPersistentConnection(10000);
            try {
                stmt = con.prepareStatement(query);
                stmt.setString(1, ele.getNome());
                stmt.setString(2, ele.getNascimento());
                stmt.setLong(3, ele.getTitulo());
                stmt.setLong(4, titulo);
                stmt.execute();
                con.close();
                ConnectionFactory.notifyThreadDeleted();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(EleitorDao.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        } else {
            return false;
        }
    }
}
