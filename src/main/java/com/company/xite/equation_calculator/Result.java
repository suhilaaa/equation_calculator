package com.company.xite.equation_calculator;


import com.company.xite.equation_calculator.classifier.NumberClassifier;
import com.company.xite.equation_calculator.equation.Equation;

import java.util.List;
import java.util.Objects;

public class Result {

    private Equation equation;
    private double resultNumber;
    private NumberClassifier numberClassifier;
    private List<Result> history;

    public Result(Equation equation, double resultNumber, NumberClassifier numberClassifier, List<Result> history) {
        this.equation = equation;
        this.resultNumber = resultNumber;
        this.numberClassifier = numberClassifier;
        this.history = history;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com.company.xite.equation_calculator.Result result = (com.company.xite.equation_calculator.Result) o;
        return Double.compare(result.resultNumber, resultNumber) == 0 &&
                Objects.equals(equation, result.equation) &&
                Objects.equals(numberClassifier, result.numberClassifier) &&
                Objects.equals(history, result.history);
    }

    @Override
    public int hashCode() {
        return Objects.hash(equation, resultNumber, numberClassifier, history);
    }

    @Override
    public String toString() {
        return "Result{" +
                "equation=" + equation +
                ", resultNumber=" + resultNumber +
                ", numberClassifier=" + numberClassifier +
                ", history=" + history +
                '}';
    }
}
