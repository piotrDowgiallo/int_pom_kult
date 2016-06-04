package com.pwr.internetowypomocnik.model;

/**
 * Created by Bartek on 16.05.2016.
 */
public class Calculator_BMI {

    private Float weight;
    private Float height;

    public Calculator_BMI(Float weight, Float height) {
        this.weight = weight;
        this.height = height;
    }

    public void setMass(Float weight) { this.weight = weight/100; }

    public void setHeight(Float height) {
        this.height = height/100;
    }

    public Float calculate() {

        return weight/(height*height);
    }
}
