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
            modelMap.put("", "You failed!");
            return "false";

        }

    }


}
