package com.rateThatFramework;


import com.rateThatFramework.dao.UserDAO;
import com.rateThatFramework.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

    @Autowired
    private UserDAO userDao;

    @RequestMapping(value="/")
    public ModelAndView home() {
        List<User> listUsers = userDao.list();
        ModelAndView model = new ModelAndView("home");
        model.addObject("userList", listUsers);
        return model;
    }

}