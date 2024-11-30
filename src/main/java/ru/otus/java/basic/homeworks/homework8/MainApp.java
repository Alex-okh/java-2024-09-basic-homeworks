package ru.otus.java.basic.homeworks.homework8;

/**
 * Домашнее задание 8 - Исключения.
 * Реализуйте метод, аргументом которого является двумерный строковый массив размером 4х4. Если передан массив другого размера необходимо бросить исключение AppArraySizeException.
 * <p>
 * Метод должен обойти все элементы массива, преобразовать в int и просуммировать. Если в каком-то элементе массива преобразование не удалось
 * (например, в ячейке лежит текст вместо числа), должно быть брошено исключение AppArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
 * <p>
 * В методе main() необходимо вызвать полученный метод, обработать возможные исключения AppArraySizeException и AppArrayDataException и вывести результат расчета
 * (сумму элементов, при условии что подали на вход корректный массив).
 */

public class MainApp {
    public static void main(String[] args) {
        String[][] array1 = {{"1", "1", "1"}, {"1", "1", "1"}, {"1", "1", "1"}};
        String[][] array2 = {{"1", "1", "1", "2"}, {"1", "1", "1", "2"}, {"1", "1", "1", "2"}, {"1", "1", "1", "2"}};
        String[][] array3 = {{"1", "1", "1", "2"}, {"1", "1", "1", "2"}, {"1", "1", "1", "2"}, {"1", "Один", "1", "2"}};

        System.out.println("\nпробуем массив 1.");
        try {
            System.out.println("Сумма элементов массива: " + sumStringArray(array1));
        } catch (AppArraySizeException | AppArrayDataException e) {
            System.out.println("Расчет не удался. Ошибка: " + e.getMessage());
        }

        System.out.println("\nпробуем массив 2.");
        try {
            System.out.println("Сумма элементов массива: " + sumStringArray(array2));
        } catch (AppArraySizeException | AppArrayDataException e) {
            System.out.println("Расчет не удался. Ошибка: " + e.getMessage());
        }

        System.out.println("\nпробуем массив 3.");
        try {
            System.out.println("Сумма элементов массива: " + sumStringArray(array3));
        } catch (AppArraySizeException | AppArrayDataException e) {
            System.out.println("Расчет не удался. Ошибка: " + e.getMessage());
        }

    }

    /**
     * Метод считает сумму значений двумерного массива 4*4
     * @param strings массив строк 4*4, содержащих числа
     * @return Сумма всех элементов массива
     * @throws AppArrayDataException В случае, если массив содержит элемент, не преобразуемый в int
     * @throws AppArraySizeException В случае, если размерность массива отличается от 4*4
     */
    public static int sumStringArray(String[][] strings) throws AppArrayDataException, AppArraySizeException {
        final int expectedArraySize = 4;

        if (strings.length != expectedArraySize) {
            throw new AppArraySizeException("Размер массива отличаетсся от 4х4");
        }
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].length != expectedArraySize) {
                throw new AppArraySizeException("Размер массива отличается от 4х4");
            }
        }

        int sum = 0;
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings[i].length; j++) {
                try {
                    sum += Integer.parseInt(strings[i][j]);
                } catch (NumberFormatException e) {
                    throw new AppArrayDataException("Некорректные данные в ячейке [%d][%d]. Содержимое: '%s' не удалось преобразовать в число.".formatted(i, j, strings[i][j]));
                }
            }

        }
        return sum;
    }
}
