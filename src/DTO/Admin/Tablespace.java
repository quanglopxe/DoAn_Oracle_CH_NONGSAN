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
public class Tablespace {
    String tablespace_name, user, file_name;

    public Tablespace(String tablespace_name, String file_name) {
        this.tablespace_name = tablespace_name;
        this.file_name = file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    public void setTablespace_name(String tablespace_name) {
        this.tablespace_name = tablespace_name;
    }

    

    public String getTablespace_name() {
        return tablespace_name;
    }

    
    public Tablespace(ResultSet rs) {
        try {
            this.tablespace_name = rs.getString("tablespace_name");
            this.user = rs.getString("user");                        
        } catch (SQLException ex) {
            Logger.getLogger(Tablespace.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
