package com.rateThatFramework;


import com.rateThatFramework.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;


@Controller
public class LoginController {

    @RequestMapping(value = {"/"})
    public String returnMyView(){
        return "redirect:index.jsp";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String init(ModelMap modelMap) {
        modelMap.put("info", "Hello User");
        return "index/index";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submit(ModelMap modelMap, @ModelAttribute("user") @Valid User input) {
        String password = input.getPassword();
        if (password != null && password.equals("password")) {
            modelMap.put("userInfo", input.getEmail());
            return "balance";
        } else {
            modelMap.put("error", "Invalid UserName / Password");
            return "index";
        }

    }
}