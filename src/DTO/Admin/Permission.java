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
public class Permission {
    String grantee, privilege, admin_option, common;

    public String getGrantee() {
        return grantee;
    }

    public String getPrivilege() {
        return privilege;
    }

    public String getAdmin_option() {
        return admin_option;
    }

    public String getCommon() {
        return common;
    }

    public void setGrantee(String grantee) {
        this.grantee = grantee;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    public void setAdmin_option(String admin_option) {
        this.admin_option = admin_option;
    }

    public void setCommon(String common) {
        this.common = common;
    }

    public Permission() {
    }
    
    public Permission(ResultSet rs) {
        try {
            this.grantee = rs.getString("grantee");
            this.privilege = rs.getString("privilege");            
            
        } catch (SQLException ex) {
            Logger.getLogger(Permission.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
