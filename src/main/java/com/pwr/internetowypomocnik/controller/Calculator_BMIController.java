package com.pwr.internetowypomocnik.controller;

import com.pwr.internetowypomocnik.model.Calculator_BMI;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Bartek on 16.05.2016.
 */

@RestController
public class Calculator_BMIController {

    @RequestMapping("calculator_bmi/calculate")
    @ResponseBody
    public String calculate(Float weight, Float height){
        String value_BMI = "";
        try{
            Calculator_BMI calculator_bmi = new Calculator_BMI(weight, height);
            value_BMI = String.valueOf(calculator_bmi.calculate());
        }
        catch (Exception ex){
            return "Error calculating BMI: " + ex.toString();
        }

        return "BMI successfully calculated = " + value_BMI;
    }

}
