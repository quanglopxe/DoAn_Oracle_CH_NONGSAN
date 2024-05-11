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
public class Session {

    int sid, serial;
    String username, program;

    public int getSid() {
        return sid;
    }

    public int getSerial() {
        return serial;
    }

    public String getUsername() {
        return username;
    }

    public String getProgram() {
        return program;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public Session(ResultSet rs) {
        try {
            this.sid = rs.getInt("sid");
            this.serial = rs.getInt("serial#");
            this.username = rs.getString("username");
            this.program = rs.getString("program");
        } catch (SQLException ex) {
            Logger.getLogger(Session.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
