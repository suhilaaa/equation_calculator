package com.company.xite.equation_calculator;


import com.company.xite.equation_calculator.classifier.NumberClassifier;
import com.company.xite.equation_calculator.equation.Equation;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class Result {

    private long userId;
    private double resultNumber;
    private NumberClassifier numberClassifier;

    public Result(long userId, double resultNumber, NumberClassifier numberClassifier) {
        this.userId = userId;
        this.resultNumber = resultNumber;
        this.numberClassifier = numberClassifier;
    }

    public Result() {
    }

    public double getResultNumber() {
        return resultNumber;
    }

    public void setResultNumber(double resultNumber) {
        this.resultNumber = resultNumber;
    }

    public NumberClassifier getNumberClassifier() {
        return numberClassifier;
    }

    public void setNumberClassifier(NumberClassifier numberClassifier) {
        this.numberClassifier = numberClassifier;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return Double.compare(result.resultNumber, resultNumber) == 0 &&
                Objects.equals(userId, result.userId) &&
                Objects.equals(numberClassifier, result.numberClassifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, resultNumber, numberClassifier);
    }

    @Override
    public String toString() {
        return "Result{" +
                "userId='" + userId + '\'' +
                ", resultNumber=" + resultNumber +
                ", numberClassifier=" + numberClassifier +
                '}';
    }
}
