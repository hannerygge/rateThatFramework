package com.rateThatFramework;

import com.rateThatFramework.model.Framework;
import com.rateThatFramework.model.Rating;
import com.rateThatFramework.model.Review;
import com.rateThatFramework.model.User;
import com.rateThatFramework.utils.HibernateUtil;
import org.hibernate.*;

import java.awt.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Andre on 03.05.2016.
 */
public class DBHandler {

    public List Query(String input, Class expect) {
        System.out.println("input = " + input);
        List results = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
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

    public void insertQuery(User input){
        Session session = HibernateUtil.getSessionFactory().openSession();;
        Transaction tx = session.beginTransaction();
        session.save(input);
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

    public void insertRatingQuery(Rating rating){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(rating);
        tx.commit();
        session.close();
    }

    public void insertReviewQuery(Review review){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(review);
        tx.commit();
        session.close();

    }




    public boolean deleteById(Class<?> type, Serializable id) {
        Session session = HibernateUtil.getSessionFactory().openSession();;
        Transaction tx = session.beginTransaction();
        Object persistentInstance = session.load(type, id);
        if (persistentInstance != null) {
            session.delete(persistentInstance);
            System.out.println("delete true!");

        }
        else
        {
            session.close();
            return false;
        }
        tx.commit();
        session.close();
        return true;
    }

    public void updateUserQuery(User user){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(user);
        tx.commit();
        session.close();

    }


    public void updateFrameworkQuery(Framework framework){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(framework);
        tx.commit();
        session.close();

    }
}
