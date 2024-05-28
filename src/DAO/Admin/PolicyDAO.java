/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Admin;
import DAO.DataProvider;
import DTO.Admin.Policy;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Quang
 */
public class PolicyDAO {
    private static PolicyDAO instance;    
    
    
    
    public static PolicyDAO getInstance() {
        if (instance == null) {
            instance = new PolicyDAO();
        }
        return instance;
    }

    private PolicyDAO() {

    }

    public ArrayList<Policy> getInfo() {
        ArrayList<Policy> listPolicy = new ArrayList<Policy>();
        try {
            ResultSet rs = DataProvider.getInstance().executeQuery("SELECT policy_name, object_schema, object_name, policy_owner, SEL, INS, UPD, DEL, policy_column_options FROM dba_audit_policies");
            while (rs.next()) {
                Policy policy = new Policy(rs);
                listPolicy.add(policy);
            }
        } catch (SQLException ex) {
            // Handle the SQLException appropriately
            ex.printStackTrace(); // For example, printing the stack trace
        }
        return listPolicy;
    }
    
    public static void setupAuditPolicy(Connection connection, String policyName, String schemaName, String tableName, String[] operations) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("BEGIN\n");
        sql.append("  DBMS_FGA.ADD_POLICY(\n");
        sql.append("    policy_name => ?,\n");
        sql.append("    object_schema => ?, \n");
        sql.append("    object_name => ?,\n");                   
        sql.append("    statement_types => ?\n");
        sql.append("  );\n");
        sql.append("END;");

        try (PreparedStatement stmt = connection.prepareStatement(sql.toString())) {
            stmt.setString(1, policyName);
            stmt.setString(2, schemaName);
            stmt.setString(3, tableName);            
            stmt.setString(4, String.join(",", operations));
            stmt.executeUpdate();
        }
    }

    public static void enableAuditPolicy(Connection connection, String policyName) throws SQLException {
        String sql = "BEGIN DBMS_FGA.ENABLE_POLICY(policy_name => ?); END;";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, policyName);
            stmt.executeUpdate();
        }
    }

    public static void disableAuditPolicy(Connection connection, String policyName) throws SQLException {
        String sql = "BEGIN DBMS_FGA.DISABLE_POLICY(policy_name => ?); END;";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, policyName);
            stmt.executeUpdate();
        }
    }
}
