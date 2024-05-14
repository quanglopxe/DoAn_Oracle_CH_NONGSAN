/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Admin;

import DAO.DataProvider;
import DTO.Admin.TableData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Quang
 */
public class SGADAO {
    private static SGADAO instance;

    public static SGADAO getInstance() {
        if (instance == null) {
            instance = new SGADAO();
        }
        return instance;
    }

    private SGADAO() {

    }

    public ArrayList<TableData> getInfo() {
        ArrayList<TableData> listSGA = new ArrayList<TableData>();
        try {
            ResultSet rs = DataProvider.getInstance().executeQuery("SELECT NAME, VALUE FROM V$SGA");
            while (rs.next()) {
                String name = rs.getString("NAME");
                String value = rs.getString("VALUE");
                TableData data = new TableData(name, value);
                listSGA.add(data);
            }
        } catch (SQLException ex) {
            // Handle the SQLException appropriately
            ex.printStackTrace(); // For example, printing the stack trace
        }
        return listSGA;
    }
}
