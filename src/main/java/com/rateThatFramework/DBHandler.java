package com.rateThatFramework;

import com.rateThatFramework.model.User;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContext;
import java.util.List;

/**
 * Created by Andre on 03.05.2016.
 */
public class DBHandler {
    @Autowired
    ApplicationContext context;

    public List Query(String input, Class expect) {
        List results = null;
        SessionFactory sessionFact = (SessionFactory) context.getBean("sessionFactory");
        Session session = sessionFact.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            SQLQuery query = session.createSQLQuery(input);
            query.addEntity(expect);
            results = query.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();


        } finally {
            session.close();
        }
        return results;
    }

    public void insertQuery(String input ){
        SessionFactory sessionFact = (SessionFactory) context.getBean("sessionFactory");
        Session session = sessionFact.openSession();



            Query query = session.createQuery(input);

            query.executeUpdate();



    }
}
