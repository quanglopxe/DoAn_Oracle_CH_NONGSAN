package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataProvider {

    private static DataProvider instance = null;

    private static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
    private static String USERNAME;
    private static String PASSWORD;

    public static void setUSERNAME(String USERNAME) {
        if(USERNAME.substring(0,2).equals("ad")) {
            USERNAME += " as sysdba";
        }
        DataProvider.USERNAME = USERNAME;
    }

    public static void setPASSWORD(String PASSWORD) {
        DataProvider.PASSWORD = PASSWORD;
    }

    private Connection connection;

    // Phương thức khởi tạo private để ngăn chặn việc tạo instance từ bên ngoài.
    private DataProvider() {
        try {
            // Kết nối đến cơ sở dữ liệu
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Phương thức getInstance để lấy thể hiện duy nhất của lớp DataProvider
    public static synchronized DataProvider getInstance() {
        if (instance == null) {
            instance = new DataProvider();
        }
        return instance;
    }

    public ResultSet executeQuery(String query, Object... parameters) {
        ResultSet resultSet = null;
        try {
            if (query.toLowerCase().startsWith("call")) { // Nếu là gọi stored procedure
                StringBuilder sqlBuilder = new StringBuilder();
                sqlBuilder.append("{").append(query).append("(");
                for (int i = 0; i < parameters.length; i++) {
                    if (i > 0) {
                        sqlBuilder.append(", ");
                    }
                    sqlBuilder.append("?");
                }
                sqlBuilder.append(")}");

                CallableStatement callableStatement = connection.prepareCall(sqlBuilder.toString());
                for (int i = 0; i < parameters.length; i++) {
                    callableStatement.setObject(i + 1, parameters[i]);
                }

                resultSet = callableStatement.executeQuery();
            } else { // Nếu là truy vấn thông thường
                PreparedStatement statement = connection.prepareStatement(query);
                for (int i = 0; i < parameters.length; i++) {
                    statement.setObject(i + 1, parameters[i]);
                }
                resultSet = statement.executeQuery();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public int executeNonQuery(String query, Object... parameters) {
        int affectedRows = 0;
        try {
            if (query.toLowerCase().startsWith("call")) { // Nếu là gọi stored procedure
                StringBuilder sqlBuilder = new StringBuilder();
                sqlBuilder.append("{").append(query).append("(");
                for (int i = 0; i < parameters.length; i++) {
                    if (i > 0) {
                        sqlBuilder.append(", ");
                    }
                    sqlBuilder.append("?");
                }
                sqlBuilder.append(")}");

                CallableStatement callableStatement = connection.prepareCall(sqlBuilder.toString());
                for (int i = 0; i < parameters.length; i++) {
                    callableStatement.setObject(i + 1, parameters[i]);
                }

                callableStatement.execute();
                affectedRows = callableStatement.getUpdateCount();
            } else { // Nếu là truy vấn thông thường
                PreparedStatement statement = connection.prepareStatement(query);
                for (int i = 0; i < parameters.length; i++) {
                    statement.setObject(i + 1, parameters[i]);
                }
                affectedRows = statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
//            JOptionPane.showMessageDialog(null, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        return affectedRows;
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
