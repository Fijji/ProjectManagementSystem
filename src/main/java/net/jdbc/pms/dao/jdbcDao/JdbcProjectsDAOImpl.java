package net.jdbc.pms.dao.jdbcDao;

import net.jdbc.pms.dao.ProjectsDAO;
import net.jdbc.pms.model.Projects;
import net.jdbc.pms.view.ConsoleHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcProjectsDAOImpl implements ProjectsDAO {
    private List<Projects> listProjects = null;


    protected List<Projects> readingAllElements() throws SQLException {
        String sql = "SELECT * FROM Projects";
        resultProcessing(sql);
        return listProjects;
    }

    protected List<Projects> readingElementsWhereName(String pj_name) throws SQLException {
        String sql = "SELECT * FROM Projects WHERE pj_name = " + pj_name;
        resultProcessing(sql);
        return listProjects;
    }

    protected List<Projects> readingElement(int pj_id) throws SQLException {
        String sql = "SELECT * FROM Projects WHERE pj_id = " + pj_id;
        resultProcessing(sql);
        return listProjects;
    }

    public void updateElement(int pj_id, String pj_name, String pj_desc, int pj_cost) throws SQLException {
        String sql = "UPDATE Projects SET pj_name = ?, pj_desc =?, pj_cost =? WHERE pj_id =?";
        JdbcConnectDAOImpl.changeRecord(sql, pj_id, pj_name, pj_desc, pj_cost);
    }

    public void deleteElement(int pj_id) throws SQLException {
        String sql = "DELETE FROM Projects WHERE pj_id = ?";
        JdbcConnectDAOImpl.changeRecord(sql, pj_id);
    }

    public void createElement(int pj_id, String pj_name, String pj_desc, int pj_cost ) throws SQLException {
        String sql = "INSERT INTO Projects(pj_id, pj_name,  pj_desc, pj_cost) VALUES(?, ?)";
        JdbcConnectDAOImpl.addRecord(sql, pj_id, pj_name, pj_desc, pj_cost);
    }

    public void showAllProjects() throws SQLException {
        readingAllElements();
        for (Projects project : listProjects) {
            ConsoleHelper.writeMessage(project.toString());
        }
    }

    public void showProjects(int pj_id) throws SQLException {
        readingElement(pj_id);
        for (Projects project : listProjects) {
            ConsoleHelper.writeMessage(project.toString());
        }
    }

    private void resultProcessing(String sql) throws SQLException {
        ResultSet resultSetProjects = JdbcConnectDAOImpl.selectRecord(sql);
        listProjects = new ArrayList<>();

        while (resultSetProjects.next()) {
            int pj_id = resultSetProjects.getInt("pj_id");
            String pj_name = resultSetProjects.getString("pj_name");
            String pj_desc = resultSetProjects.getString("pj_desc");
            int pj_cost = resultSetProjects.getInt("pj_cost");
            listProjects.add(new Projects(pj_id, pj_name, pj_desc, pj_cost));
        }
        resultSetProjects.close();
    }
}
