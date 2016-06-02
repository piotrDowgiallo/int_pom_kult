package com.pwr.internetowypomocnik.controller;

import com.pwr.internetowypomocnik.model.Body_status;
import com.pwr.internetowypomocnik.model.Body_statusDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Piotr on 2016-04-22.
 */
@RestController
public class Body_statusController {

    /**
     * GET /create  --> Create a new user and save it in the database.
     */
    @RequestMapping("/body_status/create")
    //(String name, int proteins, int carbohydrates, int fat, long id_user)
    public String create(Integer weight, Integer height, Integer biceps, Integer waist, Integer chest, Integer leg, float body_fat){
        String id_Body_status = "";
        try {
            Body_status Body_status = new Body_status( weight, height,  biceps,  waist,  chest, leg,body_fat);
            Body_statusDao.save(Body_status);
            id_Body_status = String.valueOf(Body_status.getId_body_status());
        }
        catch (Exception ex) {
            return "Error creating the Body_status: " + ex.toString();
        }
        return "Body_status successfully created with id = " + id_Body_status;
    }

    /**
     * GET /delete  --> Delete the user having the passed id.
     *
     */
    @RequestMapping("/body_status/delete")
    @ResponseBody
    public String delete(long id) {
        try {
            Body_status Body_status = new Body_status(id);
           Body_statusDao.delete(Body_status);
        }
        catch (Exception ex) {
            return "Error deleting the Body_status:" + ex.toString();
        }
        return "Body_status succesfully deleted!";
    }


    /**
     * GET /update  --> Update the email and the name for the user in the
     * database having the passed id.
     */
    @RequestMapping("/body_status/update")
    @ResponseBody
    public String updateBody_status(long id, String login) {
        try {
            Body_status Body_status = Body_statusDao.findOne(id);
            Body_statusDao.save(Body_status);
        }
        catch (Exception ex) {
            return "Error updating the Body_status: " + ex.toString();
        }
        return "Body_status succesfully updated!";
    }

    // Private fields

    @Autowired
    private Body_statusDao Body_statusDao;

}
