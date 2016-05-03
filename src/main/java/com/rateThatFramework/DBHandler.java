package com.rateThatFramework;

import com.rateThatFramework.utils.HibernateUtil;
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
        List results = null;
        Session session = HibernateUtil.getSessionFactory().openSession();;
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
