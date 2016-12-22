package net.jdbc.pms.controller;

import net.jdbc.pms.dao.hibernateDao.hibConnectDAOImpl;
import net.jdbc.pms.dao.hibernateDao.hibSkillsDAOImpl;
import net.jdbc.pms.factory.SkillsFactory;
import net.jdbc.pms.view.ConsoleHelper;

import java.io.IOException;
import java.sql.SQLException;

public class SkillsCommand implements Command{
    @Override
    public void execute() throws IOException, ClassNotFoundException, SQLException {
        SkillsFactory skillsFactory = new SkillsFactory();
        hibSkillsDAOImpl skillsDAO = new hibSkillsDAOImpl();

        String dev_name;
        int sk_id;
        String sk_name;

        ConsoleHelper.writeMessage("* * * Навыки * * *" + "\n" +
                "1 - Добавить | 2 - Удалить | 3 - Изменить | 4 - Показать всех | 5 - Найти по ID\n");
        int commandNumber = ConsoleHelper.readInt();

        switch (commandNumber){
            case 1:
                ConsoleHelper.writeMessage("Укажите название навыка разработчика:\n");
                sk_name = ConsoleHelper.readString();
                ConsoleHelper.writeMessage("\nУкажите ID навыка:\n");
                sk_id = ConsoleHelper.readInt();
                ConsoleHelper.writeMessage("\nНавык создан!\n");

                skillsFactory.createSkill(sk_id,sk_name);
                skillsDAO.showSkills(sk_id);
                hibConnectDAOImpl.statement.close();
                break;
            case 2:
                ConsoleHelper.writeMessage("Укажите ID навыка:\n");
                sk_id = ConsoleHelper.readInt();
                skillsDAO.deleteElement(sk_id);
                ConsoleHelper.writeMessage("\nНавык удален!\n");
                break;
            case 3:
                ConsoleHelper.writeMessage("Укажите ID навыка:\n");
                sk_id = ConsoleHelper.readInt();
                ConsoleHelper.writeMessage("Укажите новое название навыка:\n");
                sk_name = ConsoleHelper.readString();
                skillsDAO.updateElement(sk_id, sk_name);
                ConsoleHelper.writeMessage("\nИзменения выполнены!\n");
                break;
            case 4:
                skillsDAO.showAllSkills();
                break;
            case 5:
                ConsoleHelper.writeMessage("Укажите ID навыка:\n");
                sk_id = ConsoleHelper.readInt();
                skillsDAO.showSkills(sk_id);
                break;
            default:
                break;
        }
    }
}