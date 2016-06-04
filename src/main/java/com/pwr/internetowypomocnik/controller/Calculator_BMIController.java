package com.pwr.internetowypomocnik.controller;

import com.pwr.internetowypomocnik.model.Calculator_BMI;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Bartek on 16.05.2016.
 */

@RestController
public class Calculator_BMIController {

    @RequestMapping(value = "/calculator_bmi/calculate", method = RequestMethod.POST)
    public @ResponseBody String calculate(@RequestParam ("weight") Float weight, @RequestParam ("height") Float height){
        System.out.println("In calculator method");
        String value_BMI = "";
        try{
            Calculator_BMI calculator_bmi = new Calculator_BMI(weight, height);
            value_BMI = String.valueOf(calculator_bmi.calculate());
        }
        catch (Exception ex){
            return "Error calculating BMI: " + ex.toString();
        }
        System.out.println("Value BMI: " + value_BMI);
        return value_BMI;
    }

}
