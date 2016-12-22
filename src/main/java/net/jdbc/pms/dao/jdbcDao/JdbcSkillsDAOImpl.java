package net.jdbc.pms.dao.jdbcDao;

import net.jdbc.pms.dao.SkillsDAO;
import net.jdbc.pms.model.Skills;
import net.jdbc.pms.view.ConsoleHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcSkillsDAOImpl implements SkillsDAO {
    private List<Skills> listSkills = null;


    protected List<Skills> readingAllElements() throws SQLException {
        String sql = "SELECT * FROM Skills";
        resultProcessing(sql);
        return listSkills;
    }

    protected List<Skills> readingElementsWhereName(String sk_name) throws SQLException {
        String sql = "SELECT * FROM Skills WHERE sk_name = " + sk_name;
        resultProcessing(sql);
        return listSkills;
    }

    protected List<Skills> readingElement(int sk_id) throws SQLException {
        String sql = "SELECT * FROM Skills WHERE sk_id = " + sk_id;
        resultProcessing(sql);
        return listSkills;
    }

    public void updateElement(int sk_id, String sk_name) throws SQLException {
        String sql = "UPDATE Skills SET sk_name = ? WHERE sk_id =?";
        JdbcConnectDAOImpl.changeRecord(sql, sk_id, sk_name);
    }

    public void deleteElement(int sk_id) throws SQLException {
        String sql = "DELETE FROM Skills WHERE sk_id = ?";
        JdbcConnectDAOImpl.changeRecord(sql, sk_id);
    }

    public void createElement(int sk_id, String sk_name) throws SQLException {
        String sql = "INSERT INTO Skills(sk_id, sk_name) VALUES(?, ?)";
        JdbcConnectDAOImpl.addRecord(sql, sk_id, sk_name);
    }

    public void showAllSkills() throws SQLException {
        readingAllElements();
        for (Skills skills : listSkills) {
            ConsoleHelper.writeMessage(skills.toString());
        }
    }

    public void showSkills(int sk_id) throws SQLException {
        readingElement(sk_id);
        for (Skills skills : listSkills) {
            ConsoleHelper.writeMessage(skills.toString());
        }
    }

    private void resultProcessing(String sql) throws SQLException {
        ResultSet resultSetSkills = JdbcConnectDAOImpl.selectRecord(sql);
        listSkills = new ArrayList<>();

        while (resultSetSkills.next()) {
            int sk_id = resultSetSkills.getInt("sk_id");
            String sk_name = resultSetSkills.getString("sk_name");
            listSkills.add(new Skills(sk_id, sk_name));
        }
        resultSetSkills.close();
    }
}
