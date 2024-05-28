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
    static String USERNAME, ACCOUNT_STATUS, PROFILE, TENNV;

    public static void setTENNV(String TENNV) {
        User.TENNV = TENNV;
    }

    public static String getTENNV() {
        return TENNV;
    }
    static Timestamp CREATED, EXPIRY_DATE, LAST_LOGIN;

    public static void setCREATED(Timestamp CREATED) {
        User.CREATED = CREATED;
    }

    public static void setEXPIRY_DATE(Timestamp EXPIRY_DATE) {
        User.EXPIRY_DATE = EXPIRY_DATE;
    }

    public static void setLAST_LOGIN(Timestamp LAST_LOGIN) {
        User.LAST_LOGIN = LAST_LOGIN;
    }

    public User() {
    }

    public static String getUSERNAME() {
        return USERNAME;
    }

    public static String getACCOUNT_STATUS() {
        return ACCOUNT_STATUS;
    }

    public static String getPROFILE() {
        return PROFILE;
    }

    

    public static void setUSERNAME(String USERNAME) {
        User.USERNAME = USERNAME;
    }

    public static void setACCOUNT_STATUS(String ACCOUNT_STATUS) {
        User.ACCOUNT_STATUS = ACCOUNT_STATUS;
    }

    public static void setPROFILE(String PROFILE) {
        User.PROFILE = PROFILE;
    }

    public static Timestamp getCREATED() {
        return CREATED;
    }

    public static Timestamp getEXPIRY_DATE() {
        return EXPIRY_DATE;
    }

    public static Timestamp getLAST_LOGIN() {
        return LAST_LOGIN;
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
