/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Admin;
import DAO.DataProvider;
import DTO.Admin.Roles;
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
public class RolesDAO {
    private static RolesDAO instance;    
    
    
    
    public static RolesDAO getInstance() {
        if (instance == null) {
            instance = new RolesDAO();
        }
        return instance;
    }

    private RolesDAO() {

    }
    public ArrayList<Roles> getInfo() {
        ArrayList<Roles> listRoles = new ArrayList<Roles>();
        try {
            ResultSet rs = DataProvider.getInstance().executeQuery("call sys.get_roles");
            while (rs.next()) {
                Roles user = new Roles(rs);
                listRoles.add(user);
            }
        } catch (SQLException ex) {
            // Handle the SQLException appropriately
            ex.printStackTrace(); // For example, printing the stack trace
        }
        return listRoles;
    }
    public int createRole(String roleName)
    {        
        int rs = DataProvider.getInstance().executeNonQuery("call sys.create_role",roleName);
        return rs;       
    }
    public int dropRole(String roleName)
    {        
        int rs = DataProvider.getInstance().executeNonQuery("call sys.drop_role",roleName);
        return rs;       
    }
}
