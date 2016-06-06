package com.pwr.internetowypomocnik.controller;

import com.pwr.internetowypomocnik.model.Exercise;
import com.pwr.internetowypomocnik.model.ExerciseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;

/**
 * Created by Piotr on 2016-04-22.
 */
@RestController
public class ExerciseController {

    /**
     * GET /create  --> Create a new exercise and save it in the database.
     */
    @RequestMapping(value="/exercise/create", method= RequestMethod.POST)
    //String login, String password, String email, String first_name, String second_name, String sex, Integer age, Integer body_status_id, Integer exercise_id
    public String create(@RequestParam("name") String name,@RequestParam("muscle_group") String muscle_group,@RequestParam("description") String description,@RequestParam("difficulty") String difficulty){
        String id_exercise = "";
        try {
            Exercise exercise = new Exercise(name, muscle_group, description, difficulty);
            exerciseDao.save(exercise);
            id_exercise = String.valueOf(exercise.getId_exercise());
        }
        catch (Exception ex) {
            return "Error creating the exercise: " + ex.toString();
        }
        return "exercise successfully created with id = " + id_exercise;
    }



    @RequestMapping(value="/exercise/get")
    public @ResponseBody Iterable<Exercise> getExercises()
    {
        Iterable<Exercise> exerciseList = null;
        Exercise tmpExercise = null;
        try{
            exerciseList = exerciseDao.findAll();
            Iterator<Exercise> exerciseIterator = exerciseList.iterator();
            tmpExercise = exerciseIterator.next();

        }
        catch (Exception ex){
        }
        return exerciseList;
    }


    /**
     * GET /delete  --> Delete the exercise having the passed id.
     */
    @RequestMapping("/exercise/delete")
    @ResponseBody
    public String delete(long id_exercise) {
        try {
            Exercise exercise = new Exercise(id_exercise);
           exerciseDao.delete(exercise);
        }
        catch (Exception ex) {
            return "Error deleting the exercise:" + ex.toString();
        }
        return "Exercise succesfully deleted!";
    }


    /**
     * GET /update  --> Update the email and the name for the exercise in the
     * database having the passed id.
     */
    @RequestMapping("/exercise/update")
    @ResponseBody
    public String updateExercise(long id_exercise, String login) {
        try {
            Exercise exercise = exerciseDao.findOne(id_exercise);
           // exercise.setLogin(login);
            exerciseDao.save(exercise);
        }
        catch (Exception ex) {
            return "Error updating the exercise: " + ex.toString();
        }
        return "Exercise succesfully updated!";
    }

    // Private fields

    @Autowired
    private ExerciseDao exerciseDao;

}
