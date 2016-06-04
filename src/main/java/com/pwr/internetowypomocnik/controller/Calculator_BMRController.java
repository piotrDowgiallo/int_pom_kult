package com.pwr.internetowypomocnik.controller;

import com.pwr.internetowypomocnik.model.Calculator_BMR;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Bartek on 16.05.2016.
 */
@RestController
public class Calculator_BMRController {

    @RequestMapping(value="calculator_bmr/calculate", method = RequestMethod.POST)
    @ResponseBody
    public String calculate(@RequestParam ("weight") Double weight, @RequestParam ("height") Double height, @RequestParam ("age") Double age){
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

        return value_BMR;
    }

}
