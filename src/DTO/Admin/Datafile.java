/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO.Admin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Quang
 */
public class Datafile {

    public String getFile_name() {
        return file_name;
    }

    public String getTablespace_name() {
        return tablespace_name;
    }

    public Integer getFile_id() {
        return file_id;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public void setTablespace_name(String tablespace_name) {
        this.tablespace_name = tablespace_name;
    }

    public void setFile_id(Integer file_id) {
        this.file_id = file_id;
    }
    String file_name, tablespace_name;
    Integer file_id;
    public Datafile(ResultSet rs) {
        try {            
            this.file_name = rs.getString("file_name");  
            this.file_id = rs.getInt("file_id");                                  
            this.tablespace_name = rs.getString("tablespace_name");
        } catch (SQLException ex) {
            Logger.getLogger(Datafile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
