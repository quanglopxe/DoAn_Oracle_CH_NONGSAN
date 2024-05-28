/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Admin;

import DAO.DataProvider;
import DTO.Admin.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author Quang
 */
public class UserDAO {
    private static UserDAO instance;    
    
    
    
    public static UserDAO getInstance() {
        if (instance == null) {
            instance = new UserDAO();
        }
        return instance;
    }

    private UserDAO() {

    }
    public ArrayList<User> getInfoByName(String username) {
        ArrayList<User> listUser = new ArrayList<User>();
        try {
            ResultSet rs = DataProvider.getInstance().executeQuery("SELECT USERNAME, CREATED, EXPIRY_DATE, ACCOUNT_STATUS, LAST_LOGIN, PROFILE FROM DBA_USERS WHERE USERNAME = '" + username + "'");
            while (rs.next()) {
                User user = new User(rs);
                listUser.add(user);
            }
        } catch (SQLException ex) {
            // Handle the SQLException appropriately
            ex.printStackTrace(); // For example, printing the stack trace
        }
        return listUser;
    }
    public ArrayList<User> getInfo() {
        ArrayList<User> listUser = new ArrayList<User>();
        try {
            ResultSet rs = DataProvider.getInstance().executeQuery("SELECT USERNAME, CREATED, EXPIRY_DATE, ACCOUNT_STATUS, LAST_LOGIN, PROFILE FROM DBA_USERS");
            while (rs.next()) {
                User user = new User(rs);
                listUser.add(user);
            }
        } catch (SQLException ex) {
            // Handle the SQLException appropriately
            ex.printStackTrace(); // For example, printing the stack trace
        }
        return listUser;
    }
    public String getEmpname(String username)
    {
        String empName = null;
        try {
            ResultSet rs = DataProvider.getInstance().executeQuery("SELECT TENNV FROM CHNONGSAN.NhanVien where username = '" + username + "'");
            while (rs.next()) {
                empName = rs.getString("TENNV");                
            }
        } catch (SQLException ex) {
            // Handle the SQLException appropriately
            ex.printStackTrace(); // For example, printing the stack trace
        }
        return empName;
    }
    public Timestamp getLastLogin(String username) {   
        Timestamp lastLogin = null;
        try {
            ResultSet rs = DataProvider.getInstance().executeQuery("SELECT last_login FROM DBA_USERS where username = '" + username.toUpperCase() + "'");
            while (rs.next()) {
                lastLogin = rs.getTimestamp("last_login");                
            }
        } catch (SQLException ex) {
            // Handle the SQLException appropriately
            ex.printStackTrace(); // For example, printing the stack trace
        }
        return lastLogin;
    }
}
