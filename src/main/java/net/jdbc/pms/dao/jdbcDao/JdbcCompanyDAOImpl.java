package net.jdbc.pms.dao.jdbcDao;

import net.jdbc.pms.dao.CompanyDAO;
import net.jdbc.pms.model.Company;
import net.jdbc.pms.view.ConsoleHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcCompanyDAOImpl implements CompanyDAO {
    private List<Company> listCompanies = null;


    public List<Company> readingAllElements() throws SQLException {
        String sql = "SELECT * FROM company";
        resultProcessing(sql);
        return listCompanies;
    }


    public List<Company> readingElementsWhereName(String com_name) throws SQLException {
        String sql = "SELECT * FROM company WHERE com_name = " + com_name;
        resultProcessing(sql);
        return listCompanies;
    }

    public List<Company> readingElement(int com_id) throws SQLException {
        String sql = "SELECT * FROM company WHERE com_id = " + com_id;
        resultProcessing(sql);
        return listCompanies;
    }

    public void updateElement(int com_id, String com_name) throws SQLException {
        String sql = "UPDATE company SET com_name = ? WHERE com_id =?";
        JdbcConnectDAOImpl.changeRecord(sql, com_id, com_name);
    }

    public void deleteElement(int com_id) throws SQLException {
        String sql = "DELETE FROM company WHERE com_id = ?";
        JdbcConnectDAOImpl.changeRecord(sql, com_id);
    }

    public void createElement(int com_id, String com_name) throws SQLException {
        String sql = "INSERT INTO company(com_id, com_name) VALUES(?, ?)";
        JdbcConnectDAOImpl.addRecord(sql, com_id, com_name);
    }

    public void showAllCompanies() throws SQLException {
        readingAllElements();
        for (Company company : listCompanies) {
            ConsoleHelper.writeMessage(company.toString());
        }
    }

    public void showCompany(int com_id) throws SQLException {
        readingElement(com_id);
        for (Company company : listCompanies) {
            ConsoleHelper.writeMessage(company.toString());
        }
    }

    private void resultProcessing(String sql) throws SQLException {
        ResultSet resultSetCompanies = JdbcConnectDAOImpl.selectRecord(sql);
        listCompanies = new ArrayList<>();

        while (resultSetCompanies.next()) {
            int com_id = resultSetCompanies.getInt("com_id");
            String com_name = resultSetCompanies.getString("com_name");
            listCompanies.add(new Company(com_id, com_name));
        }
        resultSetCompanies.close();
    }
}

