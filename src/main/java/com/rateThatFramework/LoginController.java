package com.rateThatFramework;


import com.rateThatFramework.model.*;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;
import java.util.List;
import org.hibernate.*;


@Controller
public class LoginController {
    private  DBHandler db = new DBHandler();

    @RequestMapping(value = {"/login"})
    public String returnMyView(){
        return "redirect:index.jsp";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String init(ModelMap modelMap) {
        modelMap.put("info", "Hello User");
        return "index/index";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submit(ModelMap modelMap, @ModelAttribute("user") @Valid LoginUser input) {
        String username = input.getUsername();
        String password = input.getPassword();
        List<User> results = null;

        //check username/password in db

        //find user in db
        String query = "SELECT * FROM USERS WHERE name = " + username;
        db.Query(query, User.class);
        if(!results.isEmpty()){
            modelMap.put("error", "Invalid UserName / Password");
            return "index";
        }
        User user = results.get(0);
        if(!(password != user.getPassword())){
            modelMap.put("error", "Invalid UserName / Password");
            return "index";
        }
        modelMap.put("user", user);
        return "balance"; //logged in successfully!
    }
}