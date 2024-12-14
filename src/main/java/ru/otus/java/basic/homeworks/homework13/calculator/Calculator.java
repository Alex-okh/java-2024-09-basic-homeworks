package ru.otus.java.basic.homeworks.homework13.calculator;

public class Calculator {
    public static String calculate(String expression) {

        try {
            Token root = new Token(prepareString(expression));
            return root.calc() + "";
        } catch (MyParseExeption e) {
            return e.getMessage();
        } catch (Exception e) {
            return "Bad expression. Please try again.";
        }

    }

    public static String prepareString(String in) {
        String out = in.replace(" ", "").replace(",", ".");
        for (int i = 0; i < out.length() - 1; i++) {
            if (Character.isDigit(in.charAt(i)) && in.charAt(i + 1) == '(') {
                out = out.substring(0, i) + "*" + out.substring(i);
            }
        }
        return out;
    }
}
