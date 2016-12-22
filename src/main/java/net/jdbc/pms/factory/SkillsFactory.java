package net.jdbc.pms.factory;

import net.jdbc.pms.dao.hibernateDao.hibSkillsDAOImpl;

import java.sql.SQLException;

public class SkillsFactory {
    public void createSkill(int sk_id, String sk_name) throws SQLException {
        hibSkillsDAOImpl skillsDAO = new hibSkillsDAOImpl();
        skillsDAO.createElement(sk_id, sk_name);
    }
}
