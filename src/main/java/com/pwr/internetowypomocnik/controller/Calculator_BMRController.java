package com.pwr.internetowypomocnik.controller;

import com.pwr.internetowypomocnik.model.Calculator_BMR;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Bartek on 16.05.2016.
 */
@RestController
public class Calculator_BMRController {

    @RequestMapping("calculator_bmr/calculate")
    @ResponseBody
    public String calculate(Double weight, Double height, Double age){
        String value_BMR = "";
        try{
            Calculator_BMR calculator_bmr = new Calculator_BMR(weight, height, age);
            value_BMR = String.valueOf(calculator_bmr.calculate_men());

            /*if(tutaj opcja z checkbox)
            *   value_BMR = String.valueOf(calculator_bmr.calculate_men());
            * else
            *   value_BMR = String.valueOf(calculator_bmr.calculate_women());*/
        }
        catch (Exception ex){
            return "Error calculating BMR: " + ex.toString();
        }

        return "BMR successfully calculated = " + value_BMR + " kcal";
    }

}
