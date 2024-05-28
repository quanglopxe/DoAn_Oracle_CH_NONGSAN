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
public class Policy {
    String policy_name, object_schema, object_name, policy_owner, policy_column_options, SEL, INS, UPD, DEL;

    public Policy() {        
    }

    public void setSEL(String SEL) {
        this.SEL = SEL;
    }

    public void setINS(String INS) {
        this.INS = INS;
    }

    public void setUPD(String UPD) {
        this.UPD = UPD;
    }

    public void setDEL(String DEL) {
        this.DEL = DEL;
    }

    public String getSEL() {
        return SEL;
    }

    public String getINS() {
        return INS;
    }

    public String getUPD() {
        return UPD;
    }

    public String getDEL() {
        return DEL;
    }

    public String getPolicy_name() {
        return policy_name;
    }

    public String getObject_schema() {
        return object_schema;
    }

    public String getObject_name() {
        return object_name;
    }

    public String getPolicy_owner() {
        return policy_owner;
    }

    public String getPolicy_column_options() {
        return policy_column_options;
    }

    public void setPolicy_name(String policy_name) {
        this.policy_name = policy_name;
    }

    public void setObject_schema(String object_schema) {
        this.object_schema = object_schema;
    }

    public void setObject_name(String object_name) {
        this.object_name = object_name;
    }

    public void setPolicy_owner(String policy_owner) {
        this.policy_owner = policy_owner;
    }

    public void setPolicy_column_options(String policy_column_options) {
        this.policy_column_options = policy_column_options;
    }
    public Policy(ResultSet rs) {
        try {
            this.policy_name = rs.getString("policy_name");
            this.object_schema = rs.getString("object_schema");
            this.object_name = rs.getString("object_name");
            this.policy_owner = rs.getString("policy_owner");
            this.SEL = rs.getString("SEL");
            this.INS = rs.getString("INS");
            this.UPD = rs.getString("UPD");
            this.DEL = rs.getString("DEL");
            this.policy_column_options = rs.getString("policy_column_options");
            
        } catch (SQLException ex) {
            Logger.getLogger(Policy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
