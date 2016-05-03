package com.rateThatFramework;


import com.rateThatFramework.dao.*;
import com.rateThatFramework.model.*;
import org.hibernate.Hibernate;
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
    @Autowired
    private FrameworkDAO frameDao;
    @Autowired
    private ReviewDAO reviewDao;
    @Autowired
    private RatingDAO ratingDao;


    @RequestMapping(value="/")
    public ModelAndView home() {
        ModelAndView model = new ModelAndView("home");


        List<User> listUsers = userDao.list();
        model.addObject("userList", listUsers);

        List<Framework> listFramework = frameDao.list();
        model.addObject("frameworkList", listFramework);

        List<Rating> listRating = ratingDao.list();
        model.addObject("ratingList", listRating);

        List<Review> listReview = reviewDao.list();
        model.addObject("reviewList", listReview);
        return model;
    }

}