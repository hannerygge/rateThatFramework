package com.rateThatFramework;

import com.rateThatFramework.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.support.StringMultipartFileEditor;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by hanne_000 on 03.05.2016.
 */
public class CreateUser {


    private DBHandler db = new DBHandler();

 /*   @RequestMapping(value = {"/"})
    public String returnMyView() {
        return "redirect:index.jsp";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String init(ModelMap modelMap) {
        modelMap.put("info", "Hello User");
        return "index/index";
    }
*/


    @RequestMapping(method = RequestMethod.POST)
    public String insert(ModelMap modelMap, User user) {

        String name = user.getName();
        String email = user.getEmail();
        String password = user.getPassword();
        int admin = user.getAdmin();

        String query = "insert into user(name, password, email, admin) values('" + name + "', '" + password + "', '" + email + "', " + admin + ")";

        db.insertQuery(query);


        return "complete";
    }


}
