package net.jdbc.pms.controller;

import net.jdbc.pms.dao.hibernateDao.hibConnectDAOImpl;
import net.jdbc.pms.dao.hibernateDao.hibCustomersDAOImpl;
import net.jdbc.pms.factory.CustomersFactrory;
import net.jdbc.pms.view.ConsoleHelper;

import java.io.IOException;
import java.sql.SQLException;

public class CustomersCommand implements Command {
    @Override
    public void execute() throws IOException, ClassNotFoundException, SQLException {
        CustomersFactrory customersFactrory = new CustomersFactrory();
        hibCustomersDAOImpl customersDAO = new hibCustomersDAOImpl();

        int customer_id;
        String customer_name;

        ConsoleHelper.writeMessage("* * * Покупатели * * *" + "\n" +
                "1 - Добавить | 2 - Удалить | 3 - Изменить | 4 - Показать всех | 5 - Найти по ID\n");
        int commandNumber = ConsoleHelper.readInt();

        switch (commandNumber) {
            case 1:
                ConsoleHelper.writeMessage("Укажите название компании- клиента:\n");
                customer_name = ConsoleHelper.readString();
                ConsoleHelper.writeMessage("\nУкажите ID компании- клиента:\n");
                customer_id = ConsoleHelper.readInt();
                ConsoleHelper.writeMessage("\nКлиент создан!\n");

                customersFactrory.createCustomer(customer_id, customer_name);
                customersDAO.showCustomers(customer_id);
                hibConnectDAOImpl.statement.close();
                break;
            case 2:
                ConsoleHelper.writeMessage("Укажите ID компании- клиента:\n");
                customer_id = ConsoleHelper.readInt();
                customersDAO.deleteElement(customer_id);
                ConsoleHelper.writeMessage("\nКлиент удален!\n");
                break;
            case 3:
                ConsoleHelper.writeMessage("Укажите ID компании- клиента:\n");
                customer_id = ConsoleHelper.readInt();
                ConsoleHelper.writeMessage("Укажите новое название компании- клиента:\n");
                customer_name = ConsoleHelper.readString();
                customersDAO.updateElement(customer_id, customer_name);
                ConsoleHelper.writeMessage("\nИзменения выполнены!\n");
                break;
            case 4:
                customersDAO.showAllCustomers();
                break;
            case 5:
                ConsoleHelper.writeMessage("Укажите ID компании- клиента:\n");
                customer_id = ConsoleHelper.readInt();
                customersDAO.showCustomers(customer_id);
                break;
            default:
                break;
        }
    }
}