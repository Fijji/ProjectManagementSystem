package net.jdbc.pms;

import net.jdbc.pms.controller.*;
import net.jdbc.pms.dao.hibernateDao.hibConnectDAOImpl;
import net.jdbc.pms.view.ConsoleHelper;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
public static final Logger Log = Logger.getLogger(Main.class);
public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
    Log.info("Connecting to DB");
    hibConnectDAOImpl hiber = new hibConnectDAOImpl();
    Log.info("Connected successful!");
    Command command = null;
    int commandNumber;
    Log.info("CRUD started!");

    while (true) {
        ConsoleHelper.writeMessage("\nВыберите раздел: 1 - Разработчики | 2 - Компании разработчиков | 3 - Проекты | 4 - Покупатели | 5 - Навыки | 6 - Выход из системы");
        commandNumber = ConsoleHelper.readInt();
        switch (commandNumber) {
            case 1:
                command = new DevelopersCommand();
                command.execute();
                break;
            case 2:
                command = new CompanyCommand();
                command.execute();
                break;
            case 3:
                command = new ProjectsCommand();
                command.execute();
                break;
            case 4:
                command = new CustomersCommand();
                command.execute();
                break;
            case 5:
                command = new SkillsCommand();
                command.execute();
                break;
            case 6:
                hiber.closeConnect();
                Log.info("CRUD stopped!");
                return;
            default:
                break;
        }
    }
}
}
