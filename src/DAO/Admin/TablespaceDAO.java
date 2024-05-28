/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Admin;

import DAO.DataProvider;
import DTO.Admin.Tablespace;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Quang
 */
public class TablespaceDAO {
    private static TablespaceDAO instance;

    public static TablespaceDAO getInstance() {
        if (instance == null) {
            instance = new TablespaceDAO();
        }
        return instance;
    }

    private TablespaceDAO() {

    }

    public ArrayList<Tablespace> getInfo() {
        ArrayList<Tablespace> listTablespace = new ArrayList<Tablespace>();
        try {
            ResultSet rs = DataProvider.getInstance().executeQuery("SELECT username, default_tablespace  FROM DBA_USERS");
            while (rs.next()) {
                Tablespace tbs = new Tablespace(rs);
                listTablespace.add(tbs);
            }
        } catch (SQLException ex) {
            // Handle the SQLException appropriately
            ex.printStackTrace(); // For example, printing the stack trace
        }
        return listTablespace;
    }
    
    public ArrayList<Tablespace> getInfoByOwner(String user) {
        ArrayList<Tablespace> listTablespace = new ArrayList<Tablespace>();
        try {
            ResultSet rs = DataProvider.getInstance().executeQuery("SELECT username, default_tablespace  FROM DBA_USERS WHERE username = '" + user.toUpperCase() + "'");
            while (rs.next()) {
                Tablespace tbs = new Tablespace(rs);
                listTablespace.add(tbs);
            }
        } catch (SQLException ex) {
            // Handle the SQLException appropriately
            ex.printStackTrace(); // For example, printing the stack trace
        }
        return listTablespace;
    }

    public ArrayList<Tablespace> createTablespace(String tablespace_name, String file_name) {
        ArrayList<Tablespace> listTablespace = new ArrayList<Tablespace>();
        int rs = DataProvider.getInstance().executeNonQuery("CREATE TABLESPACE " + tablespace_name + " DATAFILE '" + file_name + "' SIZE 20M" );
        // For example, printing the stack trace
        if (rs > 0) {
            Tablespace tbs = new Tablespace(tablespace_name, file_name);
            listTablespace.add(tbs);
        }
        return listTablespace;
    }
}
