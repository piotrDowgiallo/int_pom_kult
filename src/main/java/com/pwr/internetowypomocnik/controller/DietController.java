package com.pwr.internetowypomocnik.controller;

import com.pwr.internetowypomocnik.model.Diet;
import com.pwr.internetowypomocnik.model.DietDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Piotr on 2016-04-22.
 */
@RestController
public class DietController {

    /**
     * GET /create  --> Create a new diet and save it in the database.
     */
    @RequestMapping("/diet/create")
    //String login, String password, String email, String first_name, String second_name, String sex, Integer age, Integer body_status_id, Integer diet_id
    public String create(Integer total_calories, Integer carbohydrates, Integer proteins, Integer fat, Integer fluid){
        String id_diet = "";
        try {
            Diet diet = new Diet(total_calories, carbohydrates, proteins,fat,  fluid);
            dietDao.save(diet);
            id_diet = String.valueOf(diet.getId_diet());
        }
        catch (Exception ex) {
            return "Error creating the diet: " + ex.toString();
        }
        return "diet successfully created with id = " + id_diet;
    }

    /**
     * GET /delete  --> Delete the diet having the passed id.
     */
    @RequestMapping("/diet/delete")
    @ResponseBody
    public String delete(long id_diet) {
        try {
            Diet diet = new Diet(id_diet);
           dietDao.delete(diet);
        }
        catch (Exception ex) {
            return "Error deleting the diet:" + ex.toString();
        }
        return "Diet succesfully deleted!";
    }


    /**
     * GET /update  --> Update the email and the name for the diet in the
     * database having the passed id.
     */
    @RequestMapping("/diet/update")
    @ResponseBody
    public String updateDiet(long id_diet, String login) {
        try {
            Diet diet = dietDao.findOne(id_diet);
           // diet.setLogin(login);
            dietDao.save(diet);
        }
        catch (Exception ex) {
            return "Error updating the diet: " + ex.toString();
        }
        return "Diet succesfully updated!";
    }

    // Private fields

    @Autowired
    private DietDao dietDao;

}
