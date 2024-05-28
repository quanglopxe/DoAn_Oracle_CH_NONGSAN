/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Admin;
import DAO.DataProvider;
import DTO.Admin.Audit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Quang
 */
public class AuditDAO {
    private static AuditDAO instance;    
    
    
    
    public static AuditDAO getInstance() {
        if (instance == null) {
            instance = new AuditDAO();
        }
        return instance;
    }

    private AuditDAO() {

    }
    public ArrayList<Audit> getInfo() {
        ArrayList<Audit> listAudit = new ArrayList<Audit>();
        try {
            ResultSet rs = DataProvider.getInstance().executeQuery("select timestamp, sql_text, db_user, object_schema, object_name, policy_name from dba_fga_audit_trail");
            while (rs.next()) {
                Audit policy = new Audit(rs);
                listAudit.add(policy);
            }
        } catch (SQLException ex) {
            // Handle the SQLException appropriately
            ex.printStackTrace(); // For example, printing the stack trace
        }
        return listAudit;
    }
    public static void setupUserAudit(Connection connection, String AuditType ,String username) throws SQLException {
        String sql = "AUDIT " + AuditType + " BY " + username;
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.executeUpdate();
        }
    }
    public static List<Audit> getAuditRecords()
    {
        List<Audit> auditRecords = new ArrayList<>();
        try {
        ResultSet rs = DataProvider.getInstance().executeQuery("select username, action_name, timestamp, sql_text from dba_audit_trail");
        while (rs.next()) {
                Audit rec = new Audit(rs);
                auditRecords.add(rec);
            }
        } catch (SQLException ex) {
            // Handle the SQLException appropriately
            ex.printStackTrace(); // For example, printing the stack trace
        }
        return auditRecords;
    }
}
