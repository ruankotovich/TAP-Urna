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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.serial.SerialBlob;
import ru.exlege.model.bean.Candidato;
import ru.exlege.model.pojo.ConnectionFactory;
import ru.exlege.model.pojo.Validable;

/**
 *
 * @author dmitry
 */
public class CandidatoDao {

    private static PreparedStatement stmt;
    private static Connection con;
    private static ResultSet rs;

    public static boolean cadastrar(Validable<Candidato> candidatoVal) {
        Candidato candidato = candidatoVal.validate();
        if (candidato != null) {
            String query = "INSERT INTO `candidatos` (`can_pid`, `can_nome`, `can_partido`, `can_foto`) VALUES (?,?,?,?)";
            con = ConnectionFactory.openPersistentConnection(10000);
            try {
                stmt = con.prepareStatement(query);
                stmt.setLong(1, candidato.getPid());
                stmt.setString(2, candidato.getNome());
                stmt.setString(3, candidato.getPartido());
                if (candidato.getFoto() != null) {
                    stmt.setBlob(4, new SerialBlob(candidato.getFoto()));
                } else {
                    stmt.setBigDecimal(4, null);
                }
                stmt.execute();
                con.close();
                ConnectionFactory.notifyThreadDeleted();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(CandidatoDao.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        } else {
            return false;
        }
    }

    public static Candidato consultar(int pid) {
        Candidato eleitor;
        String query = "SELECT * FROM `candidatos` where `can_pid`=?;";
        con = ConnectionFactory.openPersistentConnection(10000);
        try {
            stmt = con.prepareStatement(query);
            stmt.setInt(1, pid);
            rs = stmt.executeQuery();
            if (rs.next()) {
                eleitor = new Candidato(pid);
                eleitor.setNome(rs.getString("can_nome"));
                eleitor.setPartido(rs.getString("can_partido"));
                eleitor.setFoto(rs.getBlob("can_foto"));
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

    public static boolean deletar(int pid) {
        String query = "DELETE FROM `candidatos` WHERE can_pid = ?";
        con = ConnectionFactory.openPersistentConnection(10000);
        try {
            stmt = con.prepareStatement(query);
            stmt.setLong(1, pid);
            stmt.execute();
            con.close();
            ConnectionFactory.notifyThreadDeleted();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CandidatoDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static boolean alterar(int pid, Candidato candidato) {
        candidato = candidato.validate();
        if (candidato != null) {
            String query = "UPDATE `candidatos` set can_pid=?, can_nome=?, can_partido=?, can_foto=? where can_pid=?";
            con = ConnectionFactory.openPersistentConnection(10000);
            try {
                stmt = con.prepareStatement(query);
                stmt.setLong(1, candidato.getPid());
                stmt.setString(2, candidato.getNome());
                stmt.setString(3, candidato.getPartido());
                if (candidato.getFoto() != null) {
                    stmt.setBlob(4, new SerialBlob(candidato.getFoto()));
                } else {
                    stmt.setBigDecimal(4, null);
                }
                stmt.setLong(5, pid);
                stmt.execute();
                con.close();
                ConnectionFactory.notifyThreadDeleted();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(CandidatoDao.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        } else {
            return false;
        }
    }

    public static ArrayList<Candidato> candidatos() {
        ArrayList arrayList = new ArrayList();
        Candidato current;
        con = ConnectionFactory.openPersistentConnection(10000);
        try {
            stmt = con.prepareStatement("SELECT * FROM `candidatos` WHERE can_pid > 0 order by can_nome asc,can_partido asc");
            rs = stmt.executeQuery();
            while (rs.next()) {
                current = new Candidato(rs.getInt("can_pid"));
                current.setNome(rs.getString("can_nome"));
                current.setPartido(rs.getString("can_partido"));
                current.setFoto(rs.getBlob("can_foto"));
                arrayList.add(current);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(CandidatoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnectionFactory.notifyThreadDeleted();

        return arrayList;
    }

    public static ArrayList<Candidato> candidatosQuery(String query) {
        ArrayList arrayList = new ArrayList();
        Candidato current;
        con = ConnectionFactory.openPersistentConnection(10000);
        try {
            stmt = con.prepareStatement("SELECT * FROM `candidatos` WHERE can_pid > 0 AND (can_pid like ? OR can_nome like ? OR can_partido like ?) order by can_nome asc,can_partido asc");
            stmt.setString(1, "%" + query + "%");
            stmt.setString(2, "%" + query + "%");
            stmt.setString(3, "%" + query + "%");
            rs = stmt.executeQuery();
            while (rs.next()) {
                current = new Candidato(rs.getInt("can_pid"));
                current.setNome(rs.getString("can_nome"));
                current.setPartido(rs.getString("can_partido"));
                current.setFoto(rs.getBlob("can_foto"));
                arrayList.add(current);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(CandidatoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnectionFactory.notifyThreadDeleted();

        return arrayList;
    }

    public static Candidato getWhite() {
        Candidato current;
        con = ConnectionFactory.openPersistentConnection(10000);
        try {
            stmt = con.prepareStatement("select vot_can_pid, count(*) as c from votos group by vot_can_pid order by c desc;");
            rs = stmt.executeQuery();
            if (rs.next()) {
                current = new Candidato(rs.getInt("vot_can_pid"));
                return current;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CandidatoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
}
