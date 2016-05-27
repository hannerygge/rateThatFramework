package com.rateThatFramework;


import com.rateThatFramework.model.*;
import com.rateThatFramework.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;
import java.util.List;


@Controller
public class LoginController {
    private BLL bll = new BLL();
/*
    @RequestMapping(value = {"/login"})
    public String returnMyView(){
        return "redirect:index.jsp";
    }*/

    @RequestMapping( method = RequestMethod.GET)
    public String init(ModelMap modelMap) {
        modelMap.put("info", "Hello User");
        return "login";
    }

    @RequestMapping( value = "/registerNewUser", method = RequestMethod.GET)
    public String newUser(ModelMap modelMap) {
        modelMap.put("info", "Hello User");
        return "registerNewUser";
    }



    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String submit(ModelMap modelMap, @ModelAttribute("LoginUser") @Valid LoginUser input) {

        User checkeduser = bll.userCheck(input);

        if(checkeduser == null){
            modelMap.put("error", "Invalid UserName / Password");
            return "redirect:login";
        }
        else {
            modelMap.addAttribute("user", checkeduser);
            return "redirect:home";
        }

    }
}