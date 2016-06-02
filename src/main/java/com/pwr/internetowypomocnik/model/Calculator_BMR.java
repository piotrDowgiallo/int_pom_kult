package com.pwr.internetowypomocnik.model;

/**
 * Created by Bartek on 16.05.2016.
 */
public class Calculator_BMR {

    private Double weight;
    private Double height;
    private Double age;

    public Calculator_BMR(Double weight, Double height, Double age) {
        this.weight = weight;
        this.height = height;
        this.age = age;
    }

    public Double calculate_men(){
        return 13.7516*weight+5.0033*height-6.7550*age+66.4730;
    }

    public Double calculate_women(){
        return 9.5634*weight+1.8496*height-4.6756*age+655.0955;
    }

}
