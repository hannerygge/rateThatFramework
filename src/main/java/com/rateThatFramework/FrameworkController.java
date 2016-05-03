package com.rateThatFramework;

import com.rateThatFramework.model.Framework;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by hanne_000 on 03.05.2016.
 */
@Controller
public class FrameworkController {

    @RequestMapping(value="/framework", method = RequestMethod.GET)
    public String init(ModelMap modelMap) {
        modelMap.put("info", "Hello User");
        return "newFramework";
    }


    @RequestMapping(value="/framework", method = RequestMethod.POST)
    public String submit(ModelMap modelMap, @ModelAttribute("framework") @Valid Framework framework) {
        DBHandler db = new DBHandler();
       /* String name = user.getName();
        String email = user.getEmail();
        String password = user.getPassword();
*/
        // String insertQuery = "INSERT INTO user(name, password, email) VALUES('" + name + "', '" + password + "', '" + email + "')";

        // System.out.println(insertQuery);

        db.insertFrameworkQuery(framework);

       /* Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery(insertQuery);
*/
        //int rows = query.executeUpdate();


        if (1 > 0) {
            modelMap.put("", "Successfully added user :D");
            return "noe";
        } else {
            modelMap.put("", "You failed!");
            return "noeAnnet";

        }

    }

}
