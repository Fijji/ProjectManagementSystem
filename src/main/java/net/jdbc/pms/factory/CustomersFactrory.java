package net.jdbc.pms.factory;

import net.jdbc.pms.dao.hibernateDao.hibCustomersDAOImpl;

import java.sql.SQLException;

public class CustomersFactrory {
    public void createCustomer(int customerID, String customer_name) throws SQLException {
        hibCustomersDAOImpl customersDAO = new hibCustomersDAOImpl();
        customersDAO.createElement(customerID, customer_name);
    }
}
