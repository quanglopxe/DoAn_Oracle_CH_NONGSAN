/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO.Admin;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Quang
 */
public class User {
    String USERNAME, ACCOUNT_STATUS, PROFILE;
    static String TENNV;
    Timestamp CREATED, EXPIRY_DATE;
    static Timestamp LAST_LOGIN;

    public String getUSERNAME() {
        return USERNAME;
    }

    public String getACCOUNT_STATUS() {
        return ACCOUNT_STATUS;
    }

    public String getPROFILE() {
        return PROFILE;
    }

    public static String getTENNV() {
        return TENNV;
    }

    public Timestamp getCREATED() {
        return CREATED;
    }

    public Timestamp getEXPIRY_DATE() {
        return EXPIRY_DATE;
    }

    public static Timestamp getLAST_LOGIN() {
        return LAST_LOGIN;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    public void setACCOUNT_STATUS(String ACCOUNT_STATUS) {
        this.ACCOUNT_STATUS = ACCOUNT_STATUS;
    }

    public void setPROFILE(String PROFILE) {
        this.PROFILE = PROFILE;
    }

    public static void setTENNV(String TENNV) {
        User.TENNV = TENNV;
    }

    public void setCREATED(Timestamp CREATED) {
        this.CREATED = CREATED;
    }

    public void setEXPIRY_DATE(Timestamp EXPIRY_DATE) {
        this.EXPIRY_DATE = EXPIRY_DATE;
    }

    public static void setLAST_LOGIN(Timestamp LAST_LOGIN) {
        User.LAST_LOGIN = LAST_LOGIN;
    }
    

    
    public User(String Username)
    {        
        this.USERNAME = Username;            
    }
    public User(ResultSet rs) {
        try {            
            this.USERNAME = rs.getString("USERNAME");  
            this.CREATED  = rs.getTimestamp("CREATED");                                  
            this.EXPIRY_DATE  = rs.getTimestamp("EXPIRY_DATE");
            this.ACCOUNT_STATUS  = rs.getString("ACCOUNT_STATUS");
            this.LAST_LOGIN  = rs.getTimestamp("LAST_LOGIN");
            this.PROFILE = rs.getString("PROFILE");
            
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
