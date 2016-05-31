package com.rateThatFramework;

import com.rateThatFramework.dao.FrameworkDAO;
import com.rateThatFramework.dao.RatingDAO;
import com.rateThatFramework.dao.ReviewDAO;
import com.rateThatFramework.dao.UserDAO;
import com.rateThatFramework.model.Framework;
import com.rateThatFramework.model.Rating;
import com.rateThatFramework.model.Review;
import com.rateThatFramework.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by hanne_000 on 27.05.2016.
 */

@Controller
public class ReviewController {

    @Autowired
    private UserDAO userDao;
    @Autowired
    private FrameworkDAO frameDao;
    @Autowired
    private ReviewDAO reviewDao;
    @Autowired
    private RatingDAO ratingDao;



    @RequestMapping(value="/newReview", method = RequestMethod.GET)
    public String init(ModelMap modelMap) {
        modelMap.put("info", "Hello User");
        return "newReview";
    }



    @RequestMapping(value = "/review", method = RequestMethod.GET)
    public ModelAndView test(ModelMap modelMap) {

        ModelAndView model = new ModelAndView("newReview");

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


    @RequestMapping(value= "/review", method = RequestMethod.POST)
    public ModelAndView submit(ModelMap modelMap, @ModelAttribute("Review") @Valid Review review) {
        DBHandler db = new DBHandler();

        User user = new User();
        Framework framework = new Framework();
        Review r = new Review();



        user.setAdmin(0);
        user.setPassword("testig1");
        user.setEmail("testinghjlvvr1");
        user.setName("testing1");

        db.insertQuery(user);


        framework.setName("test1");
        framework.setWebsiteLink("test1");
        framework.setDescription("test1");

        db.insertFrameworkQuery(framework);

        r.setUser(user);
        r.setFramework(framework);
        r.setId(review.getId());
        r.setReview(review.getReview());

        db.insertReviewQuery(r);


        if (1 > 0) {
            modelMap.put("","Successfully added user :D" );
            return test(modelMap);
        }
        else
        {
            modelMap.put("", "Could not register user!");
            return test(modelMap);

        }

    }

    @ModelAttribute("review")
    public Review createNewRevire(){
        return new Review();
    }
}
