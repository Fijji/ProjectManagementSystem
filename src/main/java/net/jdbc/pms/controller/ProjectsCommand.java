package net.jdbc.pms.controller;

import net.jdbc.pms.dao.hibernateDao.hibConnectDAOImpl;
import net.jdbc.pms.dao.hibernateDao.hibProjectsDAOImpl;
import net.jdbc.pms.factory.ProjectsFactory;
import net.jdbc.pms.view.ConsoleHelper;

import java.io.IOException;
import java.sql.SQLException;

public class ProjectsCommand implements Command {
    @Override
    public void execute() throws IOException, ClassNotFoundException, SQLException {
        ProjectsFactory projectsFactory = new ProjectsFactory();
        hibProjectsDAOImpl projectsDAO = new hibProjectsDAOImpl();

        String pj_name;
        String pj_desc;
        int pj_id;
        int pj_cost;

        ConsoleHelper.writeMessage("* * * Проекты * * *" + "\n" +
                "1 - Добавить | 2 - Удалить | 3 - Изменить | 4 - Показать всех | 5 - Найти по ID\n");
        int commandNumber = ConsoleHelper.readInt();

        switch (commandNumber){
            case 1:
                ConsoleHelper.writeMessage("Укажите название проекта:\n");
                pj_name = ConsoleHelper.readString();
                ConsoleHelper.writeMessage("Краткое описание проекта:\n");
                pj_desc = ConsoleHelper.readString();
                ConsoleHelper.writeMessage("\nУкажите ID проекта:\n");
                pj_id = ConsoleHelper.readInt();
                ConsoleHelper.writeMessage("\nУкажите стоимость проекта:\n");
                pj_cost = ConsoleHelper.readInt();
                ConsoleHelper.writeMessage("\nПроект создан!\n");

                projectsFactory.createProject(pj_id, pj_name, pj_desc, pj_cost);
                projectsDAO.showProjects(pj_id);
                hibConnectDAOImpl.statement.close();
                break;
            case 2:
                ConsoleHelper.writeMessage("Укажите ID проекта:\n");
                pj_id = ConsoleHelper.readInt();
                projectsDAO.deleteElement(pj_id);
                ConsoleHelper.writeMessage("\nПроект удален!\n");
                break;
            case 3:
                ConsoleHelper.writeMessage("Укажите ID проекта:\n");
                pj_id = ConsoleHelper.readInt();
                ConsoleHelper.writeMessage("Укажите новое название проекта:\n");
                pj_name = ConsoleHelper.readString();
                ConsoleHelper.writeMessage("Укажите новое описание проекта:\n");
                pj_desc = ConsoleHelper.readString();
                ConsoleHelper.writeMessage("\nУкажите новую стоимость проекта:\n");
                pj_cost = ConsoleHelper.readInt();
                projectsDAO.updateElement(pj_id, pj_name,pj_desc, pj_cost);
                ConsoleHelper.writeMessage("\nИзменения выполнены!\n");
                break;
            case 4:
                projectsDAO.showAllProjects();
                break;
            case 5:
                ConsoleHelper.writeMessage("Укажите ID проекта:\n");
                pj_id = ConsoleHelper.readInt();
                projectsDAO.showProjects(pj_id);
                break;
            default:
                break;
        }
    }
}
