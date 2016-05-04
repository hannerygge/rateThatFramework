package com.rateThatFramework;

import com.rateThatFramework.model.*;
import com.rateThatFramework.dao.*;
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

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserDAO userDao;
    @Autowired
    private FrameworkDAO frameDao;
    @Autowired
    private ReviewDAO reviewDao;
    @Autowired
    private RatingDAO ratingDao;



    @RequestMapping(value = "/newUser", method = RequestMethod.GET)
    public String init(ModelMap modelMap) {
        modelMap.put("info", "Hello User");
        return "registerNewUser";
    }

    @RequestMapping(value= "/editUser", method = RequestMethod.GET)
    public String editUser(ModelMap modelMap) {
        modelMap.put("info", "Hello User");
        return "user";
    }


    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView test(ModelMap modelMap) {

        ModelAndView model = new ModelAndView("user");


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


    @RequestMapping(value= "/user", method = RequestMethod.POST)
    public String submit(ModelMap modelMap, @ModelAttribute("User") @Valid User user) {
        DBHandler db = new DBHandler();
       /* String name = user.getName();
        String email = user.getEmail();
        String password = user.getPassword();
*/
        // String insertQuery = "INSERT INTO user(name, password, email) VALUES('" + name + "', '" + password + "', '" + email + "')";

        // System.out.println(insertQuery);

        db.insertQuery(user);

       /* Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery(insertQuery);
*/
        //int rows = query.executeUpdate();



        if (1 > 0) {
            modelMap.put("","Successfully added user :D" );
            return "addtrueuser";
        }
        else
        {
            modelMap.put("", "Could not register user!");
            return "addfalse";

        }

    }

    @RequestMapping(value= "/user/update", method = RequestMethod.POST)
    public ModelAndView update(ModelMap modelMap, @ModelAttribute("User") @Valid User input) {
        System.out.println("UPDATE");
        System.out.println(input);
        System.out.println(input.getName());
        System.out.println(input.getEmail());

        Session session = HibernateUtil.getSessionFactory().openSession();



        // System.out.println(insertQuery);



        /*Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery(editQuery);

        int rows = query.executeUpdate();



        if (rows > 0) {
            modelMap.put("","Successfully updated user :D" );
            return "updatetrue";
        }
        else
        {
            modelMap.put("", "Update failed!");
            return "updatefalse";

        }*/

        User user = new User();

        user.setId(input.getId());
        user.setName(input.getName());
        user.setPassword(input.getPassword());
        user.setEmail(input.getEmail());
        user.setAdmin(input.getAdmin());

        DBHandler db = new DBHandler();

        db.updateUserQuery(user);

        boolean rows = true;//db.deleteById(User.class, user.getId());

        if (rows) {
            //modelMap.put("","Successfully deleted user" );
            return test(modelMap);
        }
        else
        {
            //modelMap.put("", "Could not delete user!");
            //return "redirect:user";
            return test(modelMap);
        }



    }

    @ModelAttribute("user")
    public User createNewUser(){
        return new User();
    }


    @RequestMapping(value= "/delete/user", method = RequestMethod.POST)
    public ModelAndView deleteuser(ModelMap modelMap, @ModelAttribute("user") @Valid User input, BindingResult result) {
        System.out.println("DELETE");
        System.out.println(input);
        System.out.println(input.getId());
        //DBHandler db = new DBHandler();
       /* String name = user.getName();
        String email = user.getEmail();
        String password = user.getPassword();
*/
        //int id = user.getId();
        // String insertQuery = "INSERT INTO user(name, password, email) VALUES('" + name + "', '" + password + "', '" + email + "')";
   //     String deleteQuery = "DELETE FROM User WHERE id = :parameter";
   //     System.out.println(deleteQuery);

        //db.insertQuery(user);

        //Session session = HibernateUtil.getSessionFactory().openSession();
        /*Query query = session.createQuery(deleteQuery);
        query.setParameter("parameter", 2);
        System.out.println(query.toString());
*/
        //User user = new User();
        //user.setId(2);
        //session.delete(user);
        //int rows = query.executeUpdate();

        DBHandler db = new DBHandler();
        boolean rows = db.deleteById(User.class, input.getId());

        if (rows) {
            //modelMap.put("","Successfully deleted user" );
            return test(modelMap);
        }
        else
        {
            //modelMap.put("", "Could not delete user!");
            //return "redirect:user";
            return test(modelMap);
        }

    }

}
