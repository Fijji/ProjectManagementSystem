package net.jdbc.pms.dao.jdbcDao;

import net.jdbc.pms.dao.DevelopersDAO;
import net.jdbc.pms.dao.hibernateDao.hibConnectDAOImpl;
import net.jdbc.pms.model.Developers;
import net.jdbc.pms.view.ConsoleHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcDevelopersDAOImpl implements DevelopersDAO{
    private List<Developers> listDevelopers = null;


    public List<Developers> readingAllElements() throws SQLException {
        String sql = "SELECT * FROM developers";
        resultProcessing(sql);
        return listDevelopers;
    }

    public List<Developers> readingElementsWhereSalary(int dev_salary) throws SQLException {
        String sql = "SELECT * FROM developers WHERE dev_name = " + dev_salary;
        resultProcessing(sql);
        return listDevelopers;
    }

    public List<Developers> readingElement(int dev_id) throws SQLException {
        String sql = "SELECT * FROM developers WHERE dev_id = " + dev_id;
        resultProcessing(sql);
        return listDevelopers;
    }

    public void updateElement(int dev_id, String dev_name, int dev_salary) throws SQLException {
        String sql = "UPDATE developers SET dev_name = ?, dev_salary =? WHERE dev_id =?";
        JdbcConnectDAOImpl.changeRecord(sql, dev_id, dev_name, dev_salary);
    }

    public void deleteElement(int dev_id) throws SQLException {
        String sql = "DELETE FROM developers WHERE dev_id = ?";
        hibConnectDAOImpl.changeRecord(sql, dev_id);
    }

    public void createElement(int dev_id, String dev_name, int dev_salary) throws SQLException {
        String sql = "INSERT INTO developers(dev_id, dev_name, dev_salary) VALUES(?, ?, ?)";
        hibConnectDAOImpl.addRecord(sql, dev_id, dev_name, dev_salary);
    }

    public void showAllDevelopers() throws SQLException {
        readingAllElements();
        for (Developers developer :listDevelopers){
            ConsoleHelper.writeMessage(developer.toString());
        }
    }

    public void showDeveloper(int dev_id) throws SQLException {
        readingElement(dev_id);
        for (Developers developer :listDevelopers){
            ConsoleHelper.writeMessage(developer.toString());
        }
    }

    private void resultProcessing(String sql) throws SQLException {
        ResultSet resultSetDevelopers = JdbcConnectDAOImpl.selectRecord(sql);
        listDevelopers = new ArrayList<>();

        while (resultSetDevelopers.next()){
            int dev_id = resultSetDevelopers.getInt("dev_id");
            String dev_name = resultSetDevelopers.getString("dev_name");
            int dev_salary = resultSetDevelopers.getInt("dev_salary");
            listDevelopers.add(new Developers(dev_id, dev_name, dev_salary));
        }
        resultSetDevelopers.close();
    }
}
