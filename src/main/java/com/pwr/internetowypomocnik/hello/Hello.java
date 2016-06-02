package com.pwr.internetowypomocnik.hello;

import com.pwr.internetowypomocnik.model.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Piotr on 2016-04-22.
 */
@RestController
public class Hello {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
//
//    @RequestMapping("/")
//    public String index() {
//        return "Greetings from Spring Boot!";
//    }

    @RequestMapping("/nic")
    public String nic() {
        return "Cos innego!";
    }

//    /**
//     * GET /create  --> Create a new user and save it in the database.
//     */
//    @RequestMapping("/create")
//    public String create(String login, String password, String email, String firstName, String secondName, int age, char sex) {
//        String userId = "";
//        try {
//            Megauser user = new Megauser(login, password, email, firstName, secondName, age, sex, 0, 0, 0, 0, 0);
////            megauserDao.save(user);
//            userId = String.valueOf(user.getId());
//        }
//        catch (Exception ex) {
//            return "Error creating the user: " + ex.toString();
//        }
//        return "Megauser successfully created with id = " + userId;
//    }

    @Autowired
    private UserDao userDao;
}
