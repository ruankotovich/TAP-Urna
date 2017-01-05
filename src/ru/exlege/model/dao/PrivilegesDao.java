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
import ru.exlege.model.pojo.ConnectionFactory;

/**
 *
 * @author dmitry
 */
public class PrivilegesDao {

    public static boolean verifyPrivileges(String password) {
        PreparedStatement stmt;
        ResultSet rs;
        Connection con = ConnectionFactory.openPersistentConnection(10000);

        try {
            stmt = con.prepareStatement("SELECT * FROM administrator_privileges WHERE adm_key = md5(?)");
            stmt.setString(1, password);
            rs = stmt.executeQuery();
            if (rs.next()) {
                con.close();
                ConnectionFactory.notifyThreadDeleted();
                return true;
            } else {
                con.close();
                ConnectionFactory.notifyThreadDeleted();
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PrivilegesDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static boolean verifyDeadlock() {
        PreparedStatement stmt;
        ResultSet rs;
        Connection con = ConnectionFactory.openPersistentConnection(10000);

        try {
            stmt = con.prepareStatement("SELECT * FROM administrator_privileges WHERE adm_deadlock=b'1';");
            rs = stmt.executeQuery();
            if (rs.next()) {
                con.close();
                ConnectionFactory.notifyThreadDeleted();
                return true;
            } else {
                con.close();
                ConnectionFactory.notifyThreadDeleted();
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PrivilegesDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static boolean revokeDeadlock() {
        PreparedStatement stmt;
        Connection con = ConnectionFactory.openPersistentConnection(10000);

        try {
            stmt = con.prepareStatement("UPDATE administrator_privileges set adm_deadlock=b'0';");
            stmt.execute();
            con.close();
            ConnectionFactory.notifyThreadDeleted();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PrivilegesDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static boolean doDeadlock(String password) {
        PreparedStatement stmt;
        Connection con = ConnectionFactory.openPersistentConnection(10000);

        try {
            stmt = con.prepareStatement("UPDATE administrator_privileges set adm_deadlock=b'1' where adm_key = md5(?);");
            stmt.setString(1, password);
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PrivilegesDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
