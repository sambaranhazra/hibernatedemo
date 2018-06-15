package org.sambaran.data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.sambaran.data.entities.AccountType;

import java.util.Date;
import java.util.Properties;

public class Application {
    public static void main(String[] args) {

        /*Configuration*/
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(AccountType.class);
        configuration.setProperties(new Properties() {
            {
                put("hibernate.connection.username", "infinite");
                put("hibernate.connection.password", "skills");
                put("hibernate.connection.driver_class", "org.mariadb.jdbc.Driver");
                put("hibernate.connection.url", "jdbc:mysql://localhost:3306/ifinances");
            }
        });

        SessionFactory sessionFactory = configuration.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build());
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        AccountType accountType = new AccountType();
        accountType.setName("Salary Savings");
        Date createdDate = new Date();
        accountType.setCreatedDate(createdDate);
        accountType.setLastUpdatedDate(createdDate);
        accountType.setCreatedBy("Babai");
        accountType.setLastUpdatedBy("Babai");
        session.save(accountType);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
