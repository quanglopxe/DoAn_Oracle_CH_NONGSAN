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
 * @author Admin
 */
public class Process {
    int spid;
    String username, program;

    public int getSpid() {
        return spid;
    }

    public String getUsername() {
        return username;
    }

    public String getProgram() {
        return program;
    }

    public void setSpid(int spid) {
        this.spid = spid;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public Process(ResultSet rs) {
        try {
            this.spid = rs.getInt("spid");
            this.username = rs.getString("username");
            this.program = rs.getString("program");
        } catch (SQLException ex) {
            Logger.getLogger(Session.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
