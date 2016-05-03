package com.rateThatFramework;

import com.rateThatFramework.model.Framework;
import com.rateThatFramework.model.User;
import com.rateThatFramework.utils.HibernateUtil;
import org.apache.commons.logging.Log;
import org.hibernate.*;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import java.util.List;

/**
 * Created by Andre on 03.05.2016.
 */
public class DBHandler implements ApplicationContextAware {
    private ApplicationContext context;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    public List Query(String input, Class expect) {
        System.out.println("input = " + input);
        List results = null;
        Session session = HibernateUtil.getSessionFactory().openSession();;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            SQLQuery query = session.createSQLQuery(input);
            query.addEntity(expect);
            results = query.list();
            System.out.println(results);
            tx.commit();
        } catch (Exception e) {
            System.out.println("EXCEPTION! " + e.getMessage());
            if (tx != null) tx.rollback();
            e.printStackTrace();


        } finally {
            session.close();
        }
        return results;
    }

    public void insertQuery(User user){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(user);
        tx.commit();
        session.close();


    }

    public void insertFrameworkQuery(Framework framework){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(framework);
        tx.commit();
        session.close();

    }

}
