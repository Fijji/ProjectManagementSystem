package net.jdbc.pms.factory;

import net.jdbc.pms.dao.hibernateDao.hibDevelopersDAOImpl;

import java.sql.SQLException;

public class DeveloperFactory {
    public void createDeveloper(int developerID, String name, int teamID) throws SQLException {
        hibDevelopersDAOImpl developerDAO = new hibDevelopersDAOImpl();
        developerDAO.createElement(developerID, name, teamID);
    }
}
