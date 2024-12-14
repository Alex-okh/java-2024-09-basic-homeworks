package ru.otus.java.basic.homeworks.homework13;

import ru.otus.java.basic.homeworks.homework13.calculator.Calculator;

public class Main {
    public static void main(String[] args) {
        String answer = Calculator.calculate("(2+3)*(3*(7^4+3*2)-5)^2/1000000");
        System.out.println(answer);
    }
}
