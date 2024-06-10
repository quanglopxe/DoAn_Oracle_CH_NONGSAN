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
public class Roles {
    String role, password_required;

    public String getRole() {
        return role;
    }

    public String getPassword_required() {
        return password_required;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPassword_required(String password_required) {
        this.password_required = password_required;
    }

    public Roles() {
    }
    public Roles(ResultSet rs) {
        try {
            this.role = rs.getString("role");
            this.password_required = rs.getString("password_required");            
            
        } catch (SQLException ex) {
            Logger.getLogger(Roles.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
