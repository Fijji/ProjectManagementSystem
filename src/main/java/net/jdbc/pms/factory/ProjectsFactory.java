package net.jdbc.pms.factory;

import net.jdbc.pms.dao.hibernateDao.hibProjectsDAOImpl;

import java.sql.SQLException;

public class ProjectsFactory {
    public void createProject(int pj_id, String pj_name, String pj_desc, int pj_cost) throws SQLException {
        hibProjectsDAOImpl projectsDAO = new hibProjectsDAOImpl();
        projectsDAO.createElement(pj_id, pj_name, pj_desc, pj_cost);
    }
}
