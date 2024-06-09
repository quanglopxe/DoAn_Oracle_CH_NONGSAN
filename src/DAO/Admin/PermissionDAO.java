/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Admin;
import DAO.DataProvider;
import DTO.Admin.Permission;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Quang
 */
public class PermissionDAO {
    private static PermissionDAO instance;    
    
    
    
    public static PermissionDAO getInstance() {
        if (instance == null) {
            instance = new PermissionDAO();
        }
        return instance;
    }

    private PermissionDAO() {

    }
    public ArrayList<Permission> getInfo() {
        ArrayList<Permission> listPermission = new ArrayList<Permission>();
        try {
            ResultSet rs = DataProvider.getInstance().executeQuery("call sys.getPrivsList");
            while (rs.next()) { 
                String priv = rs.getString("privilege");
                Permission permission = new Permission(priv);
                listPermission.add(permission);
            }
        } catch (SQLException ex) {
            // Handle the SQLException appropriately
            ex.printStackTrace(); // For example, printing the stack trace
        }
        return listPermission;
    }
    public ArrayList<Permission> getInfoByUser(String username) {
        ArrayList<Permission> listPermission = new ArrayList<Permission>();
        try {
            ResultSet rs = DataProvider.getInstance().executeQuery("call sys.view_user_permissions", username);
            while (rs.next()) {
                Permission permission = new Permission(rs);
                listPermission.add(permission);
            }
        } catch (SQLException ex) {
            // Handle the SQLException appropriately
            ex.printStackTrace(); // For example, printing the stack trace
        }
        return listPermission;
    }
    public int grantUserPrivilege(String username, String privs)
    {
        int rs = DataProvider.getInstance().executeNonQuery("call sys.grant_permission",username, privs);
        return rs;
    }
    public int revokeUserPrivilege(String username, String privs)
    {
        int rs = DataProvider.getInstance().executeNonQuery("call sys.revoke_user_privilege",username, privs);
        return rs;
    }
    
    
}
