package com.pwr.internetowypomocnik.controller;

import com.pwr.internetowypomocnik.model.Product;
import com.pwr.internetowypomocnik.model.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;

/**
 * Created by Piotr on 2016-04-22.
 */
@RestController
public class ProductController {

    /**
     * GET /create  --> Create a new user and save it in the database.
     */
    @RequestMapping(value="/product/create", method= RequestMethod.POST)
    //(String name, int proteins, int carbohydrates, int fat, long id_user)
    public String create(@RequestParam("name") String name, @RequestParam("proteins") Integer proteins, @RequestParam("carbohydrates") Integer carbohydrates, @RequestParam("fat") Integer fat,@RequestParam(value = "user_id", required = false) Integer user_id) {
        String id_product = "";
        try {
            Product product = new Product(name,proteins, carbohydrates, fat, user_id);
            productDao.save(product);
            id_product = String.valueOf(product.getId_product());
        }
        catch (Exception ex) {
            return "Error creating the product: " + ex.toString();
        }
        return "product successfully created with id = " + id_product;
    }

    @RequestMapping(value="/product/get")
    public @ResponseBody Product getProducts()
    {
        Iterable<Product> productList = null;
        Product tmpProduct = null;
        try{
            productList = productDao.findAll();
            Iterator<Product> productIterator = productList.iterator();
            tmpProduct = productIterator.next();

        }
        catch (Exception ex){
            //return "Error receiving products:" + ex.toString();
        }
        return tmpProduct;
    }



    /**
     * GET /delete  --> Delete the user having the passed id.
     *
     */
    @RequestMapping("/product/delete")
    @ResponseBody
    public String delete(long id) {
        try {
            Product product = new Product(id);
           productDao.delete(product);
        }
        catch (Exception ex) {
            return "Error deleting the product:" + ex.toString();
        }
        return "Product succesfully deleted!";
    }


    /**
     * GET /update  --> Update the email and the name for the user in the
     * database having the passed id.
     */
    @RequestMapping("/product/update")
    @ResponseBody
    public String updateProduct(long id, String name) {
        try {
            Product product = productDao.findOne(id);
            product.setName(name);
            productDao.save(product);
        }
        catch (Exception ex) {
            return "Error updating the product: " + ex.toString();
        }
        return "Product succesfully updated!";
    }

    // Private fields

    @Autowired
    private ProductDao productDao;

}
