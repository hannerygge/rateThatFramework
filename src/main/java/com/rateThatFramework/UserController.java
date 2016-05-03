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

@Controller("/registerNewUser")
public class UserController {



    @RequestMapping(method = RequestMethod.GET)
    public String init(ModelMap modelMap) {
        modelMap.put("info", "Hello User");
        return "/home";
    }


    @RequestMapping(method = RequestMethod.POST)
    public boolean insert(ModelMap modelMap, @ModelAttribute("user") @Valid User user) {

        String name = user.getName();
        String email = user.getEmail();
        String password = user.getPassword();
        int admin = user.getAdmin();

        String insertQuery = "insert into user(name, password, email, admin) values('" + name + "', '" + password + "', '" + email + "', " + admin + ")";

        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery(insertQuery);

        int rows = query.executeUpdate();

        if (rows > 0) {
            modelMap.put("","Successfully added user :D" );
            return true;
        }
        else
        {
            modelMap.put("", "You failed!");
            return false;

        }

    }


}
