package com.rateThatFramework;


import com.rateThatFramework.dao.*;
import com.rateThatFramework.model.*;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Handles requests for the application home page.
 */
@Controller("/home")
public class HomeController {

    @Autowired
    private UserDAO userDao;
    @Autowired
    private FrameworkDAO frameDao;
    @Autowired
    private ReviewDAO reviewDao;
    @Autowired
    private RatingDAO ratingDao;


    @RequestMapping(value = "/home")
    public ModelAndView home(ModelMap model) {
        //ModelAndView MAW = new ModelAndView("home", modelMap);

        System.out.println("In homecontroller: " + model.get("user"));

        List<User> listUsers = userDao.list();
        model.addAttribute("userList", listUsers);

        List<Framework> listFramework = frameDao.list();
        model.addAttribute("frameworkList", listFramework);

        List<Rating> listRating = ratingDao.list();
        model.addAttribute("ratingList", listRating);

        List<Review> listReview = reviewDao.list();
        model.addAttribute("reviewList", listReview);
        return new ModelAndView("home", model);
    }
}