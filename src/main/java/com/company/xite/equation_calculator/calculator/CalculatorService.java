package com.company.xite.equation_calculator.calculator;

import com.company.xite.equation_calculator.equation.EquationResponse;
import com.company.xite.equation_calculator.equation.EquationResult;
import com.company.xite.equation_calculator.classifier.NumberClassificationService;
import com.company.xite.equation_calculator.classifier.NumberClassifier;
import com.company.xite.equation_calculator.equation.Equation;
import com.company.xite.equation_calculator.user.UserEquation;
import com.company.xite.equation_calculator.user.UserService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    private UserService userService;

    public CalculatorService(UserService userService) {
        this.userService = userService;
    }

    public EquationResponse performEquation(Equation equation, long userId) {
        EquationResult equationResult = new EquationResult();
        equationResult.setResultNumber(getEquationResult(equation));
        equationResult.setNumberClassifier(
                new NumberClassifier(NumberClassificationService.isNaturalNumber(equationResult.getResultNumber()),
                        NumberClassificationService.isPositiveNumber(equationResult.getResultNumber()),
                        NumberClassificationService.isNegativeNumber(equationResult.getResultNumber()),
                        NumberClassificationService.isPrimeNumber(equationResult.getResultNumber()),
                        NumberClassificationService.isWholeNumber(equationResult.getResultNumber()))
        );
        userService.addEquation(userId, new UserEquation(equation, equationResult));

//        if(result.getHistory().size() < 5) {
//            this.result.getHistory().add(result);
//        }
//        if(this.result.getHistory().size() ==5){
//            this.result.getHistory().remove(0);
//            this.result.getHistory().add(result);
//        }
        return new EquationResponse(equationResult,userService.getLatestUserEquations(userId));
    }

    private double getEquationResult(Equation equation) {
        switch (equation.getOperator()) {
            case "+":
                return equation.getFirstOperand() + equation.getSecondOperand();
            case "-":
                return equation.getFirstOperand() - equation.getSecondOperand();
            case "*":
            case "x":
            case "X":
                return equation.getFirstOperand() * equation.getSecondOperand();
            case "/":
                return equation.getFirstOperand() / equation.getSecondOperand();
        }
        return 0;
    }


}
