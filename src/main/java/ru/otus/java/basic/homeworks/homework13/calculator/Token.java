package ru.otus.java.basic.homeworks.homework13.calculator;

public class Token {
    private final String lexeme;
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
        this.lexeme = removeBrackets(lexeme);
    }

    public void process() {
        try {
            numValue = Double.parseDouble(lexeme);
            type = TokenTypes.NUMBER;
            return;
        } catch (NumberFormatException e) {
            numValue = 0;
            type = TokenTypes.OPERATOR;
        }
        int splitPoint = findSplitPoint(lexeme);
        if (splitPoint == -1) {
            throw new MyParseExeption("Operator missed at: " + lexeme);
        }
        if (splitPoint == lexeme.length() - 1 || splitPoint == 0) {
            throw new MyParseExeption("Parse error. Operator at last/first position: " + lexeme);
        }
        value = lexeme.substring(splitPoint, splitPoint + 1);
        left = new Token(lexeme.substring(0, splitPoint));
        right = new Token(lexeme.substring(splitPoint + 1));
        left.process();
        right.process();


    }

    /**
     * Определяет точку (положение оператора) в выражении по которой будет происходить разделение
     *
     * @param lexeme выражение
     * @return позиция разделения
     */
    private int findSplitPoint(String lexeme) {

        for (String[] operator : operators) {
            for (int k = lexeme.length() - 1; k >= 0; k--) {
                if (lexeme.charAt(k) == '(')
                    throw new MyParseExeption("Parse error. Brackets mismatch at " + lexeme);
                if (lexeme.charAt(k) == ')') {
                    k = passBrackets(lexeme, k);
                }
                for (int j = 0; j < operator.length; j++) {

                    if (operator[j].equals(lexeme.substring(k, k + 1))) {
                        return k;
                    }
                }
            }
        }
        return -1;
    }

    /**
     * Определяет позицию в выражении после пропуска выражения в скобках.
     * Вызывается при обнаружении скобки при обработке.
     *
     * @param lexeme выражение
     * @param k      позиция закрывающей скобки
     * @return позиция перед открывающей скобкой.
     */
    private int passBrackets(String lexeme, int k) {
        int level = 1;
        while (level > 0) {
            k--;
            if (lexeme.charAt(k) == '(') level--;
            if (lexeme.charAt(k) == ')') level++;
            if (k == 0 && level > 0)
                throw new MyParseExeption("Parse error. Brackets mismatch at " + lexeme);
        }
        return k;
    }

    /**
     * Удаляет незначащие скобки в начале и конце выражения.
     *
     * @param input выражение для обработки
     * @return обработанное выражение
     */
    private String removeBrackets(String input) {
        while (input.startsWith("(") && input.endsWith(")")) {
            String tmp = input.substring(1, input.length() - 1);
            if (checkBrackets(tmp)) {
                input = tmp;
            } else break;
        }
        return input;
    }

    /**
     * Вычисляет результат выражения в токене
     *
     * @return результат расчета double
     */
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
                    if (right.calc() == 0.0)
                        throw new MyParseExeption("Division by zero at: " + lexeme);
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

    /**
     * проверяет корректность скобок в выражении
     *
     * @param tmp строка для оценки
     * @return true если скобки расставлены корректно, false если найдено несоответствие.
     */
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
