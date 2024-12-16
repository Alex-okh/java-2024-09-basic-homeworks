package ru.otus.java.basic.homeworks.homework13.calculator;

public class Calculator {
    /**
     * Выполняет расчет по выражению.
     *
     * @param expression выражение для расчета.
     * @return Результат в текстовом виде или текстовое описание ошибки расчета.
     */

    public static String calculate(String expression) {

        try {
            Token root = new Token(prepareString(expression));
            root.process();
            return root.calc() + "";
        } catch (MyParseExeption e) {
            return e.getMessage();
        } catch (Exception e) {
            return "Bad expression. Please try again.";
        }

    }

    /**
     * Форматирует строку для более удобного расчета.
     * Удаляет пробелы, заменяет , на .
     * Добавляет сивол * между числом и открывающей скобкой.
     *
     * @param in Входная строка для обработки
     * @return Обработанная строка
     */
    public static String prepareString(String in) {
        String out = in.replace(" ", "").replace(",", ".");
        for (int i = 0; i < out.length() - 1; i++) {
            if (Character.isDigit(in.charAt(i)) && in.charAt(i + 1) == '(') {
                out = out.substring(0, i + 1) + "*" + out.substring(i + 1);
            }
        }
        return out;
    }
}
