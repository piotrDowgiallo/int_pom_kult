package com.pwr.internetowypomocnik.controller;

import com.pwr.internetowypomocnik.model.LoggedUser;
import com.pwr.internetowypomocnik.model.User;
import com.pwr.internetowypomocnik.model.UserDao;
import org.hibernate.validator.internal.xml.MethodType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Piotr on 2016-04-22.
 */
@Controller
public class UserController {
    @Autowired private LoggedUser loggedUser;

    // TODO - delete
    @RequestMapping("/testowy")
    public String test() {
        System.out.println("In test method");
        return "Get received!";
    }

    @RequestMapping(value="/testowy", method= RequestMethod.POST)
    public String test2() {
        System.out.println("In test POST method");
        return "Get received!";
    }


    /**
     * GET /create  --> Create a new user and save it in the database.
     */
    @RequestMapping(value="/user/create", method= RequestMethod.POST)
    public String create(@RequestParam("login") String login, @RequestParam("password") String password, @RequestParam("email") String email, @RequestParam(value = "first_name", required = false) String first_name, @RequestParam(value="second_name", required = false) String second_name){
        System.out.println("In create method. Login = " + login + " Password: " + password + " Email: " + email + " First name: " + first_name + " Second_name: " + second_name);
        String id_user = "";
        try {
            User user = new User(login, password, email, first_name, second_name, null, null, null, null);
            userDao.save(user);
            id_user = String.valueOf(user.getId_user());
        }
        catch (Exception ex) {
            return "Error creating the user: " + ex.toString();
        }
        return "user successfully created with id = " + id_user;
    }

    @RequestMapping(value="/greeting", method = RequestMethod.GET)
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        System.out.println("In greeting method");
        model.addAttribute("name", name);
        return "pozalogowaniu";
    }

    @RequestMapping(value="/user/login", method = RequestMethod.GET)
    public String login(@RequestParam(value = "username", required = false) String username, @RequestParam(value = "password", required = false) String password){


        System.out.println("Login: " + username + " password: " + password);
        try{
            Iterable<User> userList = userDao.findAll();
            Iterator<User> iterator = userList.iterator();

            while(iterator.hasNext())
            {
                User tmp = iterator.next();
                System.out.println("Id user = " + tmp.getId_user() + " Username: " + tmp.getLogin());
                if(username.equals(tmp.getLogin()) && password.equals(tmp.getPassword()))
                {
                    loggedUser = new LoggedUser(tmp.getId_user(), tmp.getPassword(), tmp.getLogin(), tmp.getEmail(), tmp.getFirst_name(), tmp.getSecond_name(), tmp.getAge(), tmp.getSex(), tmp.getBody_status_id(), tmp.getDiet_id());
                    System.out.println("Found user! Logged user login = " + loggedUser.getLogin());
                    return "pozalogowaniu";

                }
            }
        }
        catch (Exception ex){
            return "Error loging the user: " + ex.toString();
        }
        return "niezalogowany";
    }
    /**
     * GET /delete  --> Delete the user having the passed id.
     */
    @RequestMapping("/user/delete")
    @ResponseBody
    public String delete(long id_user) {
        try {
            User user = new User(id_user);
            userDao.delete(user);
        }
        catch (Exception ex) {
            return "Error deleting the user:" + ex.toString();
        }
        return "User succesfully deleted!";
    }


    /**
     * GET /update  --> Update the email and the name for the user in the
     * database having the passed id.
     */
    @RequestMapping("/user/update")
    @ResponseBody
    public String updateUser(long id, String login, String password, String email, String first_name, String second_name, String sex, Integer age) {
        try {
            User user = userDao.findOne(id);

            if (login != null)
                user.setLogin(login);
            if (password != null)
                user.setPassword(password);
            if (email != null)
                user.setEmail(email);
            if (first_name != null)
                user.setFirst_name(first_name);
            if (second_name != null)
                user.setSecond_name(second_name);
            if (sex != null)
                user.setSex(sex);
            if (age != null)
                user.setAge(age);

            userDao.save(user);
        }
        catch (Exception ex) {
            return "Error updating the user: " + ex.toString();
        }
        return "User succesfully updated!";
    }

    @RequestMapping("/user/up2")
    @ResponseBody
    public String updateUser2(long id, String login) {
        try {
            User user = userDao.findOne(id);
            userDao.save(user);
        }
        catch (Exception ex) {
            return "Error updating the user2: " + ex.toString();
        }
        return "user2 succesfully updated!";
    }

    // Private fields

    @Autowired
    private UserDao userDao;


}
