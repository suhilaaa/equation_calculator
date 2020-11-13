package com.company.xite.equation_calculator.calculator;

import com.company.xite.equation_calculator.Result;
import com.company.xite.equation_calculator.classifier.NumberClassificationService;
import com.company.xite.equation_calculator.classifier.NumberClassifier;
import com.company.xite.equation_calculator.equation.Equation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public Result performEquation(Equation equation, long userId) {
        Result result = new Result();
        result.setUserId(userId);
        switch (equation.getOperator()) {
            case "+":
                result.setResultNumber(equation.getFirstOperand() + equation.getSecondOperand());
                break;
            case "-":
                result.setResultNumber(equation.getFirstOperand() - equation.getSecondOperand());
                break;
            case "*":
            case "x":
            case "X":
                result.setResultNumber(equation.getFirstOperand() * equation.getSecondOperand());
                break;
            case "/":
                result.setResultNumber(equation.getFirstOperand() / equation.getSecondOperand());
        }
        result.setNumberClassifier(
                new NumberClassifier(NumberClassificationService.isNaturalNumber(result.getResultNumber()),
                        NumberClassificationService.isPositiveNumber(result.getResultNumber()),
                        NumberClassificationService.isNegativeNumber(result.getResultNumber()),
                        NumberClassificationService.isPrimeNumber(result.getResultNumber()),
                        NumberClassificationService.isWholeNumber(result.getResultNumber()))
        );

//        if(result.getHistory().size() < 5) {
//            this.result.getHistory().add(result);
//        }
//        if(this.result.getHistory().size() ==5){
//            this.result.getHistory().remove(0);
//            this.result.getHistory().add(result);
//        }
        return result;
    }
}
