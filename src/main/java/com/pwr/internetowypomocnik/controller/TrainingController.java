package com.pwr.internetowypomocnik.controller;

import com.pwr.internetowypomocnik.model.Training;
import com.pwr.internetowypomocnik.model.TrainingDao;
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
public class TrainingController {

    /**
     * GET /create  --> Create a new training and save it in the database.
     */
    @RequestMapping("/training/create")
    //String login, String password, String email, String first_name, String second_name, String sex, Integer age, Integer body_status_id, Integer training_id
    public String create(String str_date, Integer user_id){
        String id_training = "";
        int czas;
        try {
            DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
            Date date = formatter.parse(str_date);
            czas = date.getMinutes();
            Training training = new Training(date, user_id);
            trainingDao.save(training);
            id_training = String.valueOf(training.getId_training());
        }
        catch (Exception ex) {
            return "Error creating the training: " + ex.toString();
        }
        return "training successfully created with id = " + id_training + "  czas dziala oto minuty  : " + czas;
    }

    /**
     * GET /delete  --> Delete the training having the passed id.
     */
    @RequestMapping("/training/delete")
    @ResponseBody
    public String delete(long id_training) {
        try {
            Training training = new Training(id_training);
            trainingDao.delete(training);
        }
        catch (Exception ex) {
            return "Error deleting the training:" + ex.toString();
        }
        return "Training succesfully deleted!";
    }


    /**
     * GET /update  --> Update the email and the name for the training in the
     * database having the passed id.
     */
    @RequestMapping("/training/update")
    @ResponseBody
    public String updateTraining(long id_training, String login) {
        try {
            Training training = trainingDao.findOne(id_training);
            // training.setLogin(login);
            trainingDao.save(training);
        }
        catch (Exception ex) {
            return "Error updating the training: " + ex.toString();
        }
        return "Training succesfully updated!";
    }

    // Private fields

    @Autowired
    private TrainingDao trainingDao;

}
