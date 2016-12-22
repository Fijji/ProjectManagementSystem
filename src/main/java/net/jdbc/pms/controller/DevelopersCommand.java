package net.jdbc.pms.controller;

import net.jdbc.pms.dao.hibernateDao.hibConnectDAOImpl;
import net.jdbc.pms.dao.hibernateDao.hibDevelopersDAOImpl;
import net.jdbc.pms.factory.DeveloperFactory;
import net.jdbc.pms.view.ConsoleHelper;

import java.io.IOException;
import java.sql.SQLException;

public class DevelopersCommand implements Command {
    @Override
    public void execute() throws IOException, ClassNotFoundException, SQLException {
        DeveloperFactory developerFactory = new DeveloperFactory();
        hibDevelopersDAOImpl developerDao = new  hibDevelopersDAOImpl();


        String dev_name;
        int dev_id;
        int dev_salary;

        ConsoleHelper.writeMessage("* * * РАЗРАБОТЧИКИ * * *" + "\n" +
                "1 - Добавить | 2 - Удалить | 3 - Изменить | 4 - Показать всех | 5 - Найти по ID\n");
        int commandNumber = ConsoleHelper.readInt();

        switch (commandNumber) {
            case 1:
                ConsoleHelper.writeMessage("Укажите Имя разработчика:\n");
                dev_name = ConsoleHelper.readString();
                ConsoleHelper.writeMessage("\nУкажите ID разработчика:\n");
                dev_id = ConsoleHelper.readInt();
                ConsoleHelper.writeMessage("\nУкажите ЗП разработчика:\n");
                dev_salary = ConsoleHelper.readInt();
                ConsoleHelper.writeMessage("\nРазработчик создан!\n");

                developerFactory.createDeveloper(dev_id, dev_name, dev_salary);
                developerDao.showDeveloper(dev_id);
                hibConnectDAOImpl.statement.close();
                break;
            case 2:
                ConsoleHelper.writeMessage("Укажите ID разработчика:\n");
                dev_id = ConsoleHelper.readInt();
                developerDao.deleteElement(dev_id);
                ConsoleHelper.writeMessage("\nРазработчик удален!\n");
                break;
            case 3:
                ConsoleHelper.writeMessage("Укажите ID разработчика:\n");
                dev_id = ConsoleHelper.readInt();
                ConsoleHelper.writeMessage("Укажите новое Имя разработчика:\n");
                dev_name = ConsoleHelper.readString();
                ConsoleHelper.writeMessage("\nУкажите новую ЗП:\n");
                dev_salary = ConsoleHelper.readInt();
                developerDao.updateElement(dev_id, dev_name, dev_salary);
                ConsoleHelper.writeMessage("\nИзменения выполнены!\n");
                break;
            case 4:
                developerDao.showAllDevelopers();
                break;
            case 5:
                ConsoleHelper.writeMessage("Укажите ID разработчика:\n");
                dev_id = ConsoleHelper.readInt();
                developerDao.showDeveloper(dev_id);
                break;
            default:
                break;
        }
    }
}
