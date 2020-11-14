package com.company.xite.equation_calculator.equation;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EquationServiceTest {

    EquationService equationService;

    @Before
    public void setUp() throws Exception {
        equationService = new EquationService();
    }

    @Test
    public void getEquation() {
       Equation equation =  equationService.getEquation(" -0002 / 0");
       assertEquals(equation.getFirstOperand() ,-2,0);
       assertEquals(equation.getSecondOperand() ,0,0);
       assertEquals(equation.getOperator() ,"/");
    }
}