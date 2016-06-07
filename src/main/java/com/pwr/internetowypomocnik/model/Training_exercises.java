package com.pwr.internetowypomocnik.model;

/**
 * Created by Piotr on 2016-05-07.
 */

import javax.persistence.*;
import javax.validation.constraints.NotNull;
@Entity
@Table(name = "training_exercises")

public class Training_exercises {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id_training_exercises;
    private long exercise_id;
    private long training_id;
    private Integer series;
    private Integer repetitions;
    private Float load_kg;

    public Training_exercises(long exercise_id, long training_id, Integer series, Integer repetitions, Float load_kg) {
        this.exercise_id = exercise_id;
        this.training_id = training_id;
        this.series = series;
        this.repetitions = repetitions;
        this.load_kg = load_kg;
    }

    public Training_exercises() {
    }

    public Training_exercises(long id) {
        this.id_training_exercises = id;
    }

    public long getId_training_exercises() {
        return id_training_exercises;
    }

    public void setId_training_exercises(long id_training_exercises) {
        this.id_training_exercises = id_training_exercises;
    }

    public long getExercise_id() {
        return exercise_id;
    }

    public void setExercise_id(Integer exercise_id) {
        this.exercise_id = exercise_id;
    }

    public long getTraining_id() {
        return training_id;
    }

    public void setTraining_id(Integer training_id) {
        this.training_id = training_id;
    }

    public Integer getSeries() {
        return series;
    }

    public void setSeries(Integer series) {
        this.series = series;
    }

    public Integer getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(Integer repetitions) {
        this.repetitions = repetitions;
    }

    public Float getLoad_kg() {
        return load_kg;
    }

    public void setLoad_kg(Float load_kg) {
        this.load_kg = load_kg;
    }
}
