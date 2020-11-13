package com.company.xite.equation_calculator.calculator;

import com.company.xite.equation_calculator.Result;
import com.company.xite.equation_calculator.equation.Equation;
import com.company.xite.equation_calculator.equation.EquationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController {
    @Autowired
    private EquationService equationService;

    @Autowired
    private CalculatorService calculatorService;

    @RequestMapping(method = RequestMethod.POST, value ="/calculate/{userId}")
    public Result calculate(@PathVariable long userId, @RequestBody String equation){
        Equation formattedEquation = equationService.getEquation("5+6");
        return calculatorService.performEquation(formattedEquation);
    }
}
