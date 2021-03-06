package com.rateThatFramework;

import com.rateThatFramework.dao.FrameworkDAO;
import com.rateThatFramework.dao.RatingDAO;
import com.rateThatFramework.dao.ReviewDAO;
import com.rateThatFramework.dao.UserDAO;
import com.rateThatFramework.model.Framework;
import com.rateThatFramework.model.Rating;
import com.rateThatFramework.model.Review;
import com.rateThatFramework.model.User;
import com.rateThatFramework.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.awt.*;
import java.util.List;

/**
 * Created by hanne_000 on 03.05.2016.
 */
@Controller
public class FrameworkController {

    @Autowired
    private UserDAO userDao;
    @Autowired
    private FrameworkDAO frameDao;
    @Autowired
    private ReviewDAO reviewDao;
    @Autowired
    private RatingDAO ratingDao;



    @RequestMapping(value="/newFramework", method = RequestMethod.GET)
    public String init(ModelMap modelMap) {
        modelMap.put("info", "Hello User");
        return "newFramework";
    }

    @RequestMapping(value="/editFramework", method = RequestMethod.GET)
    public String editUser(ModelMap modelMap) {
        modelMap.put("info", "Hello User");
        return "framework";
    }



    @RequestMapping(value="/framework", method = RequestMethod.GET)
    public ModelAndView edit(ModelMap modelMap) {

        ModelAndView model = new ModelAndView("framework", modelMap);


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



    @RequestMapping(value="/framework", method = RequestMethod.POST)
    public ModelAndView submit(ModelMap modelMap, @ModelAttribute("Framework") @Valid Framework framework) {
        DBHandler db = new DBHandler();

       db.insertFrameworkQuery(framework);

        if (1 > 0) {
            modelMap.put("","Successfully added user :D" );
            return edit(modelMap);
        }
        else
        {
            modelMap.put("", "Could not register user!");
            return edit(modelMap);

        }

    }

    @RequestMapping(value="/update/framework", method = RequestMethod.POST)
    public ModelAndView update(ModelMap modelMap, @ModelAttribute("Framework") @Valid Framework input) {
        System.out.println("UPDATE");


        Framework framework = new Framework();

        framework.setId(input.getId());
        framework.setName(input.getName());
        framework.setDescription(input.getDescription());
        framework.setWebsiteLink(input.getWebsiteLink());

        DBHandler db = new DBHandler();

        db.updateFrameworkQuery(framework);

        boolean rows = true;//db.deleteById(User.class, user.getId());

        if (rows) {
            //modelMap.put("","Successfully deleted user" );
            return edit(modelMap);
        }
        else
        {
            //modelMap.put("", "Could not delete user!");
            //return "redirect:user";
            return edit(modelMap);
        }

    }


    @ModelAttribute("framework")
    public Framework createNewFramework(){
        return new Framework();
    }

    @RequestMapping(value="/delete/framework", method = RequestMethod.POST)
    public ModelAndView deleteframework(ModelMap modelMap, @ModelAttribute("framework") @Valid Framework input, BindingResult result) {
            System.out.println("DELETE");
            System.out.println(input);
            System.out.println(input.getId());

            DBHandler db = new DBHandler();

        boolean rows = db.deleteById(Framework.class, input.getId());

        if (rows) {
            //modelMap.put("","Successfully deleted user" );
            return edit(modelMap);
        }
        else
        {
            //modelMap.put("", "Could not delete user!");
            return edit(modelMap);
        }

     }

    @RequestMapping(value = "/review/framework", method = RequestMethod.POST)
    public String reviewFramework(@ModelAttribute("reviewframework") @Valid Framework input, RedirectAttributes redir ){

            redir.addFlashAttribute("framework", input);
            return "redirect:/review";


    }


}
