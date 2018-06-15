package org.sambaran.data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Application {
    public static void main(String[] args) {


        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        /*AccountType accountType = new AccountType();
        accountType.setName("Salary Savings");
        Date createdDate = new Date();
        accountType.setCreatedDate(createdDate);
        accountType.setLastUpdatedDate(createdDate);
        accountType.setCreatedBy("Babai");
        accountType.setLastUpdatedBy("Babai");
        session.save(accountType);*/
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
