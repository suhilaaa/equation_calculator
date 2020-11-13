package com.company.xite.equation_calculator.calculator;

import com.company.xite.equation_calculator.Result;
import com.company.xite.equation_calculator.classifier.NumberClassificationService;
import com.company.xite.equation_calculator.classifier.NumberClassifier;
import com.company.xite.equation_calculator.equation.Equation;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    private Result result;

    public Result performEquation(Equation equation) {
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
        result.setEquation(equation);
        return result;
    }
}
