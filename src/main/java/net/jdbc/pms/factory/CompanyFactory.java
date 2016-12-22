package net.jdbc.pms.factory;

import net.jdbc.pms.dao.hibernateDao.hibCompanyDAOImpl;

import java.sql.SQLException;

public class CompanyFactory {
    public void createCompany(int com_id, String com_name) throws SQLException {
        hibCompanyDAOImpl companyDAO = new hibCompanyDAOImpl();
        companyDAO.createElement(com_id, com_name);
    }
}
