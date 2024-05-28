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
public class PGADAO {
    private static PGADAO instance;

    public static PGADAO getInstance() {
        if (instance == null) {
            instance = new PGADAO();
        }
        return instance;
    }

    private PGADAO() {

    }

    public ArrayList<TableData> getInfo() {
        ArrayList<TableData> listPGA = new ArrayList<TableData>();
        try {
            ResultSet rs = DataProvider.getInstance().executeQuery("SELECT NAME, ROUND(VALUE / 1024 / 1024, 2) AS VALUE_MB FROM V$PGASTAT");
            while (rs.next()) {
                String name = rs.getString("NAME");
                String value = rs.getString("VALUE_MB");
                TableData data = new TableData(name, value);
                listPGA.add(data);
            }
        } catch (SQLException ex) {
            // Handle the SQLException appropriately
            ex.printStackTrace(); // For example, printing the stack trace
        }
        return listPGA;
    }
    
}
