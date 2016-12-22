package net.jdbc.pms.dao.hibernateDao;

import net.jdbc.pms.dao.ConnectDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.ReturningWork;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class hibConnectDAOImpl implements ConnectDAO{
    public hibConnectDAOImpl(){
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    private static SessionFactory sessionFactory;
    public static Statement statement = null;

    public static ResultSet selectRecord(String sql) throws SQLException {
    Session session = sessionFactory.openSession();
        ResultSet resultSet = session.doReturningWork(new ReturningWork<ResultSet>() {
            @Override
            public ResultSet execute(Connection connection) throws SQLException {
                statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                return resultSet;
            }
        });
        session.close();
        return resultSet;

    }

    public static void changeRecord(String sql, int id, String name, int salary) throws SQLException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();;
        session.createNativeQuery(sql)
                .setParameter(1, id)
                .setParameter(2, name)
                .setParameter(3, salary)
                .executeUpdate();
        transaction.commit();
        session.close();
    }

    public static void changeRecord(String sql, int id) throws SQLException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();;
        session.createNativeQuery(sql)
                .setParameter(1, id)
                .executeUpdate();
        transaction.commit();
        session.close();
    }

    public static void changeRecord(String sql, int id, String name) throws SQLException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();;
        session.createNativeQuery(sql)
                .setParameter(1, id)
                .setParameter(2, name)
                .executeUpdate();
        transaction.commit();
        session.close();
    }

    public static void changeRecord(String sql, int id, String name, String desc, int cost) throws SQLException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();;
        session.createQuery(sql)
                .setParameter(4, id)
                .setParameter(1, name)
                .setParameter(2, desc)
                .setParameter(3, cost)
                .executeUpdate();
        transaction.commit();
        session.close();
    }

    public static void addRecord(String sql, int id, String name, String desc, int cost) throws SQLException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();;
        session.createNativeQuery(sql)
                .setParameter(4, id)
                .setParameter(1, name)
                .setParameter(2, desc)
                .setParameter(3, cost)
                .executeUpdate();
        transaction.commit();
        session.close();
    }

    public static void addRecord(String sql, int id, String name, int salary) throws SQLException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();;
        session.createNativeQuery(sql)
                .setParameter(0, id)
                .setParameter(2, name).setParameter(3, salary)
                .executeUpdate();
        transaction.commit();
        session.close();
    }

    public static void closeConnect() throws SQLException {
        sessionFactory.close();
    }


    public static void addRecord(String sql, int id, String name) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.createNativeQuery(sql)
                .setParameter(1, id)
                .setParameter(2, name)
                .executeUpdate();
        transaction.commit();
        session.close();
    }


}

