package net.jdbc.pms.dao.hibernateDao;

import net.jdbc.pms.dao.CustomersDAO;
import net.jdbc.pms.dao.jdbcDao.JdbcConnectDAOImpl;
import net.jdbc.pms.model.Customers;
import net.jdbc.pms.view.ConsoleHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class hibCustomersDAOImpl implements CustomersDAO {
    private List<Customers> listCustomers = null;


    public List<Customers> readingAllElements() throws SQLException {
        String sql = "SELECT * FROM Customers";
        resultProcessing(sql);
        return listCustomers;
    }

    public List<Customers> readingElementsWhereName(String customer_name) throws SQLException {
        String sql = "SELECT * FROM Customers WHERE com_name = " + customer_name;
        resultProcessing(sql);
        return listCustomers;
    }

    public List<Customers> readingElement(int customer_id) throws SQLException {
        String sql = "SELECT * FROM Customers WHERE customer_id = " + customer_id;
        resultProcessing(sql);
        return listCustomers;
    }

    public void updateElement(int customer_id, String customer_name) throws SQLException {
        String sql = "UPDATE Customers SET customer_name = ? WHERE customer_id =?";
        hibConnectDAOImpl.changeRecord(sql, customer_id, customer_name);
    }

    public void deleteElement(int customer_id) throws SQLException {
        String sql = "DELETE FROM Customers WHERE customer_id = ?";
        hibConnectDAOImpl.changeRecord(sql, customer_id);
    }

    public void createElement(int customer_id, String customer_name) throws SQLException {
        String sql = "INSERT INTO Customers(customer_id, customer_name) VALUES(?, ?)";
        hibConnectDAOImpl.addRecord(sql, customer_id, customer_name);
    }

    public void showAllCustomers() throws SQLException {
        readingAllElements();
        for (Customers customers : listCustomers) {
            ConsoleHelper.writeMessage(customers.toString());
        }
    }

    public void showCustomers(int customer_id) throws SQLException {
        readingElement(customer_id);
        for (Customers customers : listCustomers) {
            ConsoleHelper.writeMessage(customers.toString());
        }
    }

    private void resultProcessing(String sql) throws SQLException {
        ResultSet resultSetCustomers = hibConnectDAOImpl.selectRecord(sql);
        listCustomers = new ArrayList<>();

        while (resultSetCustomers.next()) {
            int customer_id = resultSetCustomers.getInt("customer_id");
            String customer_name = resultSetCustomers.getString("customer_name");
            listCustomers.add(new Customers(customer_id, customer_name));
        }
        resultSetCustomers.close();
    }
}
