package com.company.xite.equation_calculator;


import com.company.xite.equation_calculator.classifier.NumberClassifier;
import com.company.xite.equation_calculator.equation.Equation;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class Result {

    private long userId;
    private Equation equation;
    private double resultNumber;
    private NumberClassifier numberClassifier;
    private List<Result> history;

    public Result(long userId, Equation equation, double resultNumber, NumberClassifier numberClassifier, List<Result> history) {
        this.userId = userId;
        this.equation = equation;
        this.resultNumber = resultNumber;
        this.numberClassifier = numberClassifier;
        this.history = history;
    }

    public Result() {
    }

    public Equation getEquation() {
        return equation;
    }

    public void setEquation(Equation equation) {
        this.equation = equation;
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

    public List<Result> getHistory() {
        return history;
    }

    public void setHistory(List<Result> history) {
        this.history = history;
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
                Objects.equals(equation, result.equation) &&
                Objects.equals(numberClassifier, result.numberClassifier) &&
                Objects.equals(history, result.history);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, equation, resultNumber, numberClassifier, history);
    }

    @Override
    public String toString() {
        return "Result{" +
                "userId='" + userId + '\'' +
                ", equation=" + equation +
                ", resultNumber=" + resultNumber +
                ", numberClassifier=" + numberClassifier +
                ", history=" + history +
                '}';
    }
}
