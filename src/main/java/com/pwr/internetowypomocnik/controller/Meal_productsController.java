package com.pwr.internetowypomocnik.controller;

import com.pwr.internetowypomocnik.model.Meal_products;
import com.pwr.internetowypomocnik.model.Meal_productsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Piotr on 2016-04-22.
 */
@RestController
public class Meal_productsController {

    /**
     * GET /create  --> Create a new meal_products and save it in the database.
     */
    @RequestMapping("/meal_products/create")
    //String login, String password, String email, String first_name, String second_name, String sex, Integer age, Integer body_status_id, Integer diet_id
    public String create(Integer product_id, Integer meal_id){
        String id_meal_products = "";
        try {
            Meal_products meal_products = new Meal_products(product_id,meal_id);
            meal_productsDao.save(meal_products);
            id_meal_products = String.valueOf(meal_products.getId_meal_products());
        }
        catch (Exception ex) {
            return "Error creating the meal_products: " + ex.toString();
        }
        return "meal_products successfully created with id = " + id_meal_products;
    }

    /**
     * GET /delete  --> Delete the meal_products having the passed id.
     */
    @RequestMapping("/meal_products/delete")
    @ResponseBody
    public String delete(long id_meal_products) {
        try {
            Meal_products meal_products = new Meal_products(id_meal_products);
           meal_productsDao.delete(meal_products);
        }
        catch (Exception ex) {
            return "Error deleting the meal_products:" + ex.toString();
        }
        return "Meal_products succesfully deleted!";
    }


    /**
     * GET /update  --> Update the email and the name for the meal_products in the
     * database having the passed id.
     */
    @RequestMapping("/meal_products/update")
    @ResponseBody
    public String updateMeal_products(long id_meal_products, String login) {
        try {
            Meal_products meal_products = meal_productsDao.findOne(id_meal_products);
           // meal_products.setLogin(login);
            meal_productsDao.save(meal_products);
        }
        catch (Exception ex) {
            return "Error updating the meal_products: " + ex.toString();
        }
        return "Meal_products succesfully updated!";
    }

    // Private fields

    @Autowired
    private Meal_productsDao meal_productsDao;

}
