package com.rateThatFramework;


import com.rateThatFramework.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;
import java.util.List;


@Controller
public class LoginController {
    private  DBHandler db = new DBHandler();
/*
    @RequestMapping(value = {"/login"})
    public String returnMyView(){
        return "redirect:index.jsp";
    }*/

    @RequestMapping(method = RequestMethod.GET)
    public String init(ModelMap modelMap) {
        modelMap.put("info", "Hello User");
        return "login";
    }

    @RequestMapping(value="login", method = RequestMethod.POST)
    public String submit(ModelMap modelMap, @ModelAttribute("LoginUser") @Valid LoginUser input) {
        String username = input.getUsername();
        String password = input.getPassword();
        List<User> results = null;

        //check username/password in db

        //find user in db
        String query = "SELECT * FROM USERS WHERE name = '" + username + "'";
        results = db.Query(query, User.class);

        if(results == null){
            modelMap.put("error", "Invalid UserName / Password");
            return "redirect:login";
        }

        if(!results.isEmpty()){
            modelMap.put("error", "Invalid UserName / Password");
            return "redirect:login";
        }
        User user = results.get(0);
        if(!(password != user.getPassword())){
            modelMap.put("error", "Invalid UserName / Password");
            return "redirect:login";
        }
        modelMap.put("user", user);
        return "redirect:balance"; //logged in successfully!
    }
}