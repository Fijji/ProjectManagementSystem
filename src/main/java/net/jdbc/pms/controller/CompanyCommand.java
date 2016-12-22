package net.jdbc.pms.controller;

import net.jdbc.pms.dao.hibernateDao.hibCompanyDAOImpl;
import net.jdbc.pms.factory.CompanyFactory;
import net.jdbc.pms.view.ConsoleHelper;

import java.io.IOException;
import java.sql.SQLException;

public class CompanyCommand implements Command {
    @Override
    public void execute() throws IOException, ClassNotFoundException, SQLException {
        CompanyFactory companyFactory = new CompanyFactory();
        hibCompanyDAOImpl companyDAO = new  hibCompanyDAOImpl();


        String com_name;
        int com_id;

        ConsoleHelper.writeMessage("* * * Компании разработчиков * * *" + "\n" +
                "1 - Добавить | 2 - Удалить | 3 - Изменить | 4 - Показать все | 5 - Найти по ID\n");
        int commandNumber = ConsoleHelper.readInt();

        switch (commandNumber) {
            case 1:
                ConsoleHelper.writeMessage("Укажите название компании:\n");
                com_name = ConsoleHelper.readString();
                ConsoleHelper.writeMessage("\nУкажите ID компании:\n");
                com_id = ConsoleHelper.readInt();
                ConsoleHelper.writeMessage("\nКомпания создана!\n");
                companyFactory.createCompany(com_id, com_name);
                companyDAO.showCompany(com_id);
//                companyDAO.closeConnect();
                break;
            case 2:
                ConsoleHelper.writeMessage("Укажите ID компании:\n");
                com_id = ConsoleHelper.readInt();
                companyDAO.deleteElement(com_id);
                ConsoleHelper.writeMessage("\nКомпания удалена!\n");
                break;
            case 3:
                ConsoleHelper.writeMessage("Укажите ID компании:\n");
                com_id = ConsoleHelper.readInt();
                ConsoleHelper.writeMessage("Укажите новое название компании:\n");
                com_name = ConsoleHelper.readString();
                companyDAO.updateElement(com_id, com_name);
                ConsoleHelper.writeMessage("\nИзменения выполнены!\n");
                break;
            case 4:
                companyDAO.showAllCompanies();
                break;
            case 5:
                ConsoleHelper.writeMessage("Укажите ID компании:\n");
                com_id = ConsoleHelper.readInt();
                companyDAO.showCompany(com_id);
                break;
            default:
                break;
        }
    }
}