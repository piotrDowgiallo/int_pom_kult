package com.pwr.internetowypomocnik.controller;

import com.pwr.internetowypomocnik.model.Meal;
import com.pwr.internetowypomocnik.model.MealDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Piotr on 2016-04-22.
 */
@RestController
public class MealController {

    /**
     * GET /create  --> Create a new meal and save it in the database.
     */
    @RequestMapping("/meal/create")
    //String login, String password, String email, String first_name, String second_name, String sex, Integer age, Integer body_status_id, Integer meal_id
    public String create(String str_date, Integer user_id){
        String id_meal = "";
        int czas;
        try {
            DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
            Date date = formatter.parse(str_date);
            czas = date.getMinutes();
            Meal meal = new Meal(date, user_id);
            mealDao.save(meal);
            id_meal = String.valueOf(meal.getId_meal());
        }
        catch (Exception ex) {
            return "Error creating the meal: " + ex.toString();
        }
        return "meal successfully created with id = " + id_meal + "  czas dziala oto minuty  : " + czas;
    }

    /**
     * GET /delete  --> Delete the meal having the passed id.
     */
    @RequestMapping("/meal/delete")
    @ResponseBody
    public String delete(long id_meal) {
        try {
            Meal meal = new Meal(id_meal);
           mealDao.delete(meal);
        }
        catch (Exception ex) {
            return "Error deleting the meal:" + ex.toString();
        }
        return "Meal succesfully deleted!";
    }


    /**
     * GET /update  --> Update the email and the name for the meal in the
     * database having the passed id.
     */
    @RequestMapping("/meal/update")
    @ResponseBody
    public String updateMeal(long id_meal, String login) {
        try {
            Meal meal = mealDao.findOne(id_meal);
           // meal.setLogin(login);
            mealDao.save(meal);
        }
        catch (Exception ex) {
            return "Error updating the meal: " + ex.toString();
        }
        return "Meal succesfully updated!";
    }

    // Private fields

    @Autowired
    private MealDao mealDao;

}
