package com.pwr.internetowypomocnik.controller;

import com.pwr.internetowypomocnik.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;

/**
 * Created by Piotr on 2016-04-22.
 */
@RestController
public class Training_exercisesController {

    /**
     * GET /create  --> Create a new user and save it in the database.
     */
    @RequestMapping(value = "/training_exercises/create", method = RequestMethod.POST)
    //String login, String password, String email, String first_name, String second_name, String sex, Integer age, Integer body_status_id, Integer diet_id
    public String create(@RequestParam("exercise") String exercise, @RequestParam("repetitions") Integer repetitions, @RequestParam("series") Integer series, @RequestParam("date") String date, @RequestParam("load_kg") Float load_kg){
        try {
            Iterable<Exercise> exerciseList = exerciseDao.findAll();
            Iterator<Exercise> exerciseIterator = exerciseList.iterator();
            Exercise tmpExercise = null;
            while(exerciseIterator.hasNext())
            {
                tmpExercise = exerciseIterator.next();
                if(exercise.equals(tmpExercise.getName()))
                    break;
            }

            Iterable<Training> trainingList = trainingDao.findAll();
            Iterator<Training> trainingIterator = trainingList.iterator();
            Training tmpTraining = null;
            while(trainingIterator.hasNext())
            {
                tmpTraining = trainingIterator.next();
                if(date.equals(tmpTraining.getDate()))
                    break;
            }

            Training_exercises training_exercises = new Training_exercises(tmpExercise.getId_exercise(), tmpTraining.getId_training(), series, repetitions, load_kg );
            training_exercisesDao.save(training_exercises);
            //id_training_exercises = String.valueOf(training_exercises.getId_training_exercises());
        }
        catch (Exception ex) {
            return "Error creating the Training_exercises: " + ex.toString();
        }
        return "Training_exercises successfully created";
    }

    /**
     * GET /delete  --> Delete the Training_exercises having the passed id.
     */
    @RequestMapping("/training_exercises/delete")
    @ResponseBody
    public String delete(long id_training_exercises) {
        try {
            Training_exercises training_exercises = new Training_exercises(id_training_exercises);
            training_exercisesDao.delete(training_exercises);
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
    @RequestMapping("/training_exercises/update")
    @ResponseBody
    public String updateTraining_exercises(long id_training_exercises, Float load_kg) {
        try {
            Training_exercises training_exercises = training_exercisesDao.findOne(id_training_exercises);
            training_exercises.setLoad_kg(load_kg);
            training_exercisesDao.save(training_exercises);
        }
        catch (Exception ex) {
            return "Error updating the Training_exercises: " + ex.toString();
        }
        return "Training_exercises succesfully updated!";
    }

    // Private fields

    @Autowired
    private Training_exercisesDao training_exercisesDao;
    private ExerciseDao exerciseDao;
    private TrainingDao trainingDao;

}
