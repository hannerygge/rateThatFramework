package com.rateThatFramework;


import com.rateThatFramework.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


@Controller
@SessionAttributes("user")
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
    public String submit(HttpSession session, ModelMap modelMap, @ModelAttribute("Loginuser") @Valid LoginUser input, RedirectAttributes redir) {

        User checkeduser = bll.userCheck(input);
        System.out.println("checkeduser is " + checkeduser);
        if(checkeduser == null){
            redir.addFlashAttribute("error", "Invalid UserName / Password");
            return "redirect:login";
        }
        else {
            session.setAttribute("user", checkeduser);
            return "redirect:home";
        }


    }

    @RequestMapping(value="/logout", method = RequestMethod.POST)
    public void logout(HttpSession session, ModelMap modelMap, @ModelAttribute("Loginuser") @Valid LoginUser input, RedirectAttributes redir) {
        session.setAttribute("user", null);
        return;
    }
}