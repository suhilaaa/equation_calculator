package com.company.xite.equation_calculator.calculator;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class CalculatorControllerTest {
    Map<String, Object> requestBody;
    private long userId;

    @Before
    public void setUp() throws Exception {
        requestBody.put("equation", "");
        userId = 1l;
    }

    @Test
    public void testCalculateWithEmptyBody(){
//        CalculatorController.calculate(userId, requestBody);
    }
}