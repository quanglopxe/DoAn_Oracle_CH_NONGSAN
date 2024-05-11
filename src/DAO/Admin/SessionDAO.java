/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Admin;

import DAO.DataProvider;
import DTO.Admin.Session;
import DTO.Admin.Process;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class SessionDAO {

    private static SessionDAO instance;

    public static SessionDAO getInstance() {
        if (instance == null) {
            instance = new SessionDAO();
        }
        return instance;
    }

    private SessionDAO() {

    }

    public ArrayList<Session> getInfo() {
        ArrayList<Session> listSession = new ArrayList<Session>();
        try {
            ResultSet rs = DataProvider.getInstance().executeQuery("SELECT s.sid, s.serial#, s.username, s.program from v$session s where type != 'BACKGROUND'");
            while (rs.next()) {
                Session session = new Session(rs);
                listSession.add(session);
            }
        } catch (SQLException ex) {
            // Handle the SQLException appropriately
            ex.printStackTrace(); // For example, printing the stack trace
        }
        return listSession;
    }

    public int huySession(int sid, int serial) {
        String sql = "ALTER SYSTEM KILL SESSION '" + sid + "," + serial + "' IMMEDIATE";
        int rs = DataProvider.getInstance().executeNonQuery(sql);
        return rs;
    }

    public Process getProcess(int sid) {
        Process process = null;
        try {
            ResultSet rs = DataProvider.getInstance().executeQuery("select p.spid, s.username, s.program from v$session s, v$process p where p.addr=s.paddr and s.type!='BACKGROUND' and s.sid=" + sid);
            while (rs.next()) {
                process = new Process(rs);
            }
        } catch (SQLException ex) {
            // Handle the SQLException appropriately
            ex.printStackTrace(); // For example, printing the stack trace
        }
        return process;
    }
}
