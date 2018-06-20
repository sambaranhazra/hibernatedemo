package org.sambaran.data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.sambaran.data.entities.AccountType;

import java.util.Date;

public class Application
{
    public static void main(String[] args)
    {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
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
            AccountType account = session.get(AccountType.class, accountType.getAccountTypeId());
            System.out.println(account.getName());

        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
