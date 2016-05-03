package com.rateThatFramework.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Andre on 19.04.2016.
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory(){
    try{
        return new Configuration().configure().buildSessionFactory();
    } catch (Throwable ex){
        System.err.println("Sessionfactory creation failed." + ex);
        throw new ExceptionInInitializerError(ex);
    }
    }

    public static SessionFactory getSessionFactory() { return sessionFactory; }

    public static void shutdown() { getSessionFactory().close();}
}
