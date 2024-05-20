/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Admin;

import DAO.DataProvider;
import DTO.Admin.Datafile;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Quang
 */
public class DatafileDAO {
    private static DatafileDAO instance;

    public static DatafileDAO getInstance() {
        if (instance == null) {
            instance = new DatafileDAO();
        }
        return instance;
    }

    private DatafileDAO() {

    }

    public ArrayList<Datafile> getAllDatafile() {
        ArrayList<Datafile> listDatafile = new ArrayList<Datafile>();
        try {
            ResultSet rs = DataProvider.getInstance().executeQuery("SELECT file_name, file_id FROM dba_data_files");
            while (rs.next()) {
                Datafile dtf = new Datafile(rs);
                listDatafile.add(dtf);
            }
        } catch (SQLException ex) {
            // Handle the SQLException appropriately
            ex.printStackTrace(); // For example, printing the stack trace
        }
        return listDatafile;
    }
    public ArrayList<Datafile> getDatafileByID(int file_id) {
        ArrayList<Datafile> listDatafile = new ArrayList<Datafile>();
        try {
            ResultSet rs = DataProvider.getInstance().executeQuery("SELECT file_name, file_id, tablespace_name FROM dba_data_files WHERE file_id = " + file_id);
            while (rs.next()) {
                Datafile dtf = new Datafile(rs);
                listDatafile.add(dtf);
            }
        } catch (SQLException ex) {
            // Handle the SQLException appropriately
            ex.printStackTrace(); // For example, printing the stack trace
        }
        return listDatafile;
    }
}
