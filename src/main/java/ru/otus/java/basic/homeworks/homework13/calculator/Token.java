package ru.otus.java.basic.homeworks.homework13.calculator;

public class Token {
    private String lexeme;
    private Token left;
    private Token right;
    private TokenTypes type;
    private String value;
    private double numValue;

    private final String[] op1 = {"+", "-"};
    private final String[] op2 = {"*", "/"};
    private final String[] op3 = {"^"};
    private final String[][] operators = {op1, op2, op3};

    public Token(String lexeme) {
        while (lexeme.charAt(0) == '(' && lexeme.charAt(lexeme.length() - 1) == ')') {
            String tmp = lexeme.substring(1, lexeme.length() - 1);
            if (checkBrackets(tmp)) {
                lexeme = tmp;
            } else break;
        }
        this.lexeme = lexeme;
        try {
            numValue = Double.parseDouble(lexeme);
            type = TokenTypes.NUMBER;
            return;
        } catch (NumberFormatException e) {
            numValue = 0;
            type = TokenTypes.OPERATOR;
        }
        for (int i = 0; i < operators.length; i++) {
            for (int j = 0; j < operators[i].length; j++) {
                for (int k = lexeme.length() - 1; k >= 0; k--) {
                    int level = 0;
                    if (lexeme.charAt(k) == '(')
                        throw new MyParseExeption("Parse error. Brackets mismatch at " + lexeme);
                    if (lexeme.charAt(k) == ')') {
                        level++;
                        while (level > 0) {
                            k--;
                            if (lexeme.charAt(k) == '(') level--;
                            if (lexeme.charAt(k) == ')') level++;
                            if (k == 0 && level > 0)
                                throw new MyParseExeption("Parse error. Brackets mismatch at " + lexeme);
                        }

                    }
                    if (operators[i][j].equals(lexeme.substring(k, k + 1))) {
                        if (k == lexeme.length() - 1) {
                            throw new MyParseExeption("Parse error. Operator at last position: " + lexeme);
                        }
                        if (k == 0) {
                            throw new MyParseExeption("Parse error. Operator at first position: " + lexeme);
                        }
                        value = operators[i][j];
                        left = new Token(lexeme.substring(0, k));
                        right = new Token(lexeme.substring(k + 1));
                        return;
                    }
                }
            }


        }


    }

    public double calc() {
        if (type == TokenTypes.NUMBER) {
            return numValue;
        }
        double result = 0;
        if (type == TokenTypes.OPERATOR) {
            switch (value) {
                case "+" -> {
                    return left.calc() + right.calc();
                }
                case "-" -> {
                    return left.calc() - right.calc();
                }
                case "*" -> {
                    return left.calc() * right.calc();
                }
                case "/" -> {
                    if (right.calc() == 0.0) throw new MyParseExeption("Division by zero at: " + lexeme);
                    return left.calc() / right.calc();

                }
                case "^" -> {
                    return Math.pow(left.calc(), right.calc());
                }
                default -> throw new MyParseExeption("Unknown operator: " + lexeme);

            }
        }
        return result;
    }

    private boolean checkBrackets(String tmp) {
        int level = 0;
        for (int i = 0; i < tmp.length(); i++) {
            if (tmp.charAt(i) == '(') level++;
            if (tmp.charAt(i) == ')') level--;
            if (level < 0) {
                return false;
            }
        }
        return level == 0;
    }
}
