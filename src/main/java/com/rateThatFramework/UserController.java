package com.rateThatFramework;

import com.rateThatFramework.model.User;
import com.rateThatFramework.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class UserController {



    @RequestMapping(value="/user", method = RequestMethod.GET)
    public String init(ModelMap modelMap) {
        modelMap.put("info", "Hello User");
        return "registerNewUser";
    }

    @RequestMapping(value="/user/edit", method = RequestMethod.GET)
    public String edit(ModelMap modelMap) {
        modelMap.put("info", "Hello User");
        return "edit";
    }


    @RequestMapping(value="/user", method = RequestMethod.POST)
    public String submit(ModelMap modelMap, @ModelAttribute("user") @Valid User user) {
        DBHandler db = new DBHandler();
       /* String name = user.getName();
        String email = user.getEmail();
        String password = user.getPassword();
*/
        // String insertQuery = "INSERT INTO user(name, password, email) VALUES('" + name + "', '" + password + "', '" + email + "')";

        // System.out.println(insertQuery);

        db.insertQuery(user);

       /* Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery(insertQuery);
*/
        //int rows = query.executeUpdate();



        if (1 > 0) {
            modelMap.put("","Successfully added user :D" );
            return "true";
        }
        else
        {
            modelMap.put("", "Could not register user!");
            return "false";

        }

    }

    @RequestMapping(value="/user/edit/edit", method = RequestMethod.POST)
    public String edit(ModelMap modelMap, @ModelAttribute("user") @Valid User user) {
       /* String name = user.getName();
        String email = user.getEmail();
        String password = user.getPassword();
*/
        // String insertQuery = "INSERT INTO user(name, password, email) VALUES('" + name + "', '" + password + "', '" + email + "')";
        String editQuery = "";
        // System.out.println(insertQuery);


        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery(editQuery);

        int rows = query.executeUpdate();



        if (rows > 0) {
            modelMap.put("","Successfully updated user :D" );
            return "true";
        }
        else
        {
            modelMap.put("", "Update failed!");
            return "false";

        }

    }

    @RequestMapping(value="/user/edit/delete", method = RequestMethod.POST)
    public String delete(ModelMap modelMap, /*@ModelAttribute("user") @Valid User user*/ int deleteID) {
        DBHandler db = new DBHandler();
       /* String name = user.getName();
        String email = user.getEmail();
        String password = user.getPassword();
*/
        //int id = user.getId();
        // String insertQuery = "INSERT INTO user(name, password, email) VALUES('" + name + "', '" + password + "', '" + email + "')";
        String deleteQuery = "DELETE FROM user WHERE ID = " + deleteID;
        // System.out.println(insertQuery);

        //db.insertQuery(user);

        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery(deleteQuery);

        int rows = query.executeUpdate();



        if (rows > 0) {
            modelMap.put("","Successfully deleted user" );
            return "true";
        }
        else
        {
            modelMap.put("", "Could not delete user!");
            return "false";

        }

    }

}
