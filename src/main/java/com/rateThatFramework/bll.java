package com.rateThatFramework;

import com.rateThatFramework.model.LoginUser;
import com.rateThatFramework.model.User;
import com.rateThatFramework.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Andre on 27.05.2016.
 */
public class BLL {

    DBHandler db = new DBHandler();
    //Static variables

    public User userCheck(LoginUser user){
        String username = user.getUsername();
        String password = user.getPassword();

        List<com.rateThatFramework.model.User> results = null;

        //Session session = HibernateUtil.getSessionFactory().openSession();

        //check username/password in db

        //find user in db
        String query = "SELECT * FROM user WHERE email = '" + username + "'";
        results = db.Query(query, User.class);
/*
        Query query = session.createQuery("from User where username = :username");
        query.setParameter("username", input.getUsername(q));
*/
        //db.Query(query);

        if(results == null || results.size() == 0) {
            System.out.println("results == null || size == 0");
            return null;
        }
        if(!(password.equals(results.get(0).getPassword()))){
            System.out.println("password not equal");
            return null;
        }
        System.out.println("found user, correct password");
        return results.get(0);

    }
}
