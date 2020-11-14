package com.company.xite.equation_calculator.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
@RunWith(MockitoJUnitRunner.class)
class UserServiceTest {

    UserService userService;

    @BeforeEach
    public void setUp() {
        userService = new UserService();
    }

    @Test
    void addEquation() {
        UserEquation userEquation = mock(UserEquation.class);
        userService.addEquation(123L, userEquation);
        assertEquals(userService.getAllUserEquations(123L).size(), 1);
        assertEquals(userService.getLatestUserEquations(123L).size(), 0);
    }
    @Test
    void addEquation2() {
        UserEquation userEquation = mock(UserEquation.class);
        userService.addEquation(123L, userEquation);
        userService.addEquation(123L, userEquation);
        userService.addEquation(123L, userEquation);
        userService.addEquation(123L, userEquation);
        userService.addEquation(123L, userEquation);
        userService.addEquation(123L, userEquation);
        userService.addEquation(123L, userEquation);
        assertEquals(userService.getAllUserEquations(123L).size(), 7);
        assertEquals(userService.getLatestUserEquations(123L).size(), 5);
    }

    @Test
    void getLatestUserEquations() {
    }
}