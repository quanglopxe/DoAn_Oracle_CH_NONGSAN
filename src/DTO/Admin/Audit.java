/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO.Admin;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Quang
 */
public class Audit {
    String username, action_name, sql_text, db_user, object_schema, object_name, policy_name;
    Date timestamp;
    public void setUsername(String username) {
        this.username = username;
    }

    public void setAction_name(String action_name) {
        this.action_name = action_name;
    }

    public String getUsername() {
        return username;
    }

    public String getAction_name() {
        return action_name;
    }
    
    public Audit() {
    }
    
    public String getSql_text() {
        return sql_text;
    }

    public String getDb_user() {
        return db_user;
    }

    public String getObject_schema() {
        return object_schema;
    }

    public String getObject_name() {
        return object_name;
    }

    public String getPolicy_name() {
        return policy_name;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setSql_text(String sql_text) {
        this.sql_text = sql_text;
    }

    public void setDb_user(String db_user) {
        this.db_user = db_user;
    }

    public void setObject_schema(String object_schema) {
        this.object_schema = object_schema;
    }

    public void setObject_name(String object_name) {
        this.object_name = object_name;
    }

    public void setPolicy_name(String policy_name) {
        this.policy_name = policy_name;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
    public Audit(ResultSet rs) {
        try {            
            this.timestamp = rs.getDate("timestamp");
            this.sql_text = rs.getString("sql_text");
            this.db_user = rs.getString("db_user");
            this.object_schema = rs.getString("object_schema");
            this.object_name = rs.getString("object_name");
            this.policy_name = rs.getString("policy_name");            
            this.username = rs.getString("username");
            this.action_name = rs.getString("action_name");
        } catch (SQLException ex) {
            Logger.getLogger(Audit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
