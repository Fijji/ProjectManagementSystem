package net.jdbc.pms.dao.jdbcDao;

import net.jdbc.pms.dao.ConnectDAO;
import org.apache.log4j.Logger;

import java.sql.*;

public class JdbcConnectDAOImpl implements ConnectDAO {
    public static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    public static final String DATABASE_URL = "jdbc:oracle:thin:@localhost:1521:XE";

    public static final String USER = "system";
    public static final String PASSWORD = "system";

    public static Connection connection = null;
    public static Statement statement = null;
    public static PreparedStatement preparedStatement = null;
    public static final Logger Log = Logger.getLogger(JdbcConnectDAOImpl.class);

    public static void ConnectDB() throws SQLException, ClassNotFoundException {
        Class.forName(JDBC_DRIVER);
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
    }

    public static ResultSet selectRecord(String sql) throws SQLException {
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        return resultSet;
    }

    public static void changeRecord(String sql, int id, String name, int salary) throws SQLException {
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(3, id);
        preparedStatement.setInt(2, salary);
        preparedStatement.setString(1, name);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public static void changeRecord(String sql, int id) throws SQLException {
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public static void changeRecord(String sql, int id, String name) throws SQLException {
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(2, id);
        preparedStatement.setString(1, name);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public static void changeRecord(String sql, int id, String name, String desc, int cost) throws SQLException {
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, desc);
        preparedStatement.setInt(3, cost);
        preparedStatement.setInt(4, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public static void addRecord(String sql, String name, int... id) throws SQLException {
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id[0]);
        preparedStatement.setString(2, name);
        if (id.length == 2) {
            preparedStatement.setInt(3, id[1]);
        }
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public static void addRecord(String sql, int id, String name, String desc, int cost) throws SQLException {
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(2, name);
        preparedStatement.setString(3, desc);
        preparedStatement.setInt(4, cost);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public static void addRecord(String sql, int id, String name) throws SQLException {
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, name);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public static void closeConnect() throws SQLException {
        connection.close();
    }
}
