package com.company.xite.equation_calculator;

import com.company.xite.equation_calculator.equation.Equation;

import java.util.Objects;

public class History {

    private Equation equation;
    private Result result;

    public History(Equation equation, Result result) {
        this.equation = equation;
        this.result = result;
    }

    public Equation getEquation() {
        return equation;
    }

    public void setEquation(Equation equation) {
        this.equation = equation;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        History history = (History) o;
        return Objects.equals(equation, history.equation) &&
                Objects.equals(result, history.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(equation, result);
    }

    @Override
    public String toString() {
        return "History{" +
                "equation=" + equation +
                ", result=" + result +
                '}';
    }
}
