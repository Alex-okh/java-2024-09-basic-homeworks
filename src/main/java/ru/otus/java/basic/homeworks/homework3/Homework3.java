package ru.otus.java.basic.homeworks.homework3;

import java.util.Arrays;

public class Homework3 {

    public static void main(String[] args) {
        int[][] array1 = {
            {1, 2, 3, 4, 5},
            {4, -5, 6, 8, 7},
            {7, 100, 2, 8, 9},
            {4, 2, 3, 6, 5},
            {5, 6, 3, 8, 9}};

        System.out.println("Исходный массив для задач: " + Arrays.deepToString(array1) + "\n" + "--------------------------");
        System.out.println("Задача 1");
        System.out.println("Сумма положительных элементов массива: " + sumOfPositiveElements(array1));
        System.out.println("---------------------------------------------" + "\n");

        System.out.println("Задача 2");
        System.out.println("Квадрат со стороной 10 из звездочек:");
        printSquare(10);
        System.out.println("---------------------------------------------" + "\n");

        System.out.println("Задача 3");
        System.out.println("Зануляем обе диагонали двумерного массива. Результат:");
        zeroDiagonal(array1, true, true);
        System.out.println(Arrays.deepToString(array1));
        System.out.println("---------------------------------------------" + "\n");

        System.out.println("Задача 4");
        System.out.println("Максимальный элемент массива: " + findMax(array1));
        System.out.println("---------------------------------------------" + "\n");

        System.out.println("Задача 5");
        System.out.println("Сумма элементов второй строки массива: " + countSecondLineSum(array1));
        System.out.println("---------------------------------------------" + "\n");

        System.out.println("А теперь нарисуем ёлочку в массиве размерностью 25*25");

        int[][] array2 = buildArray(51, '\u00B7');
        makeChristmasTree(array2, '\u25CF');
        printArray(array2);


    }

    /* Задача 1
     Реализовать метод sumOfPositiveElements(..), принимающий в качестве аргумента целочисленный двумерный массив,
       метод должен посчитать и вернуть сумму всех элементов массива, которые больше 0.
    */

    public static int sumOfPositiveElements(int[][] inputArray) {
        int result = 0;
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray[i].length; j++) {
                if (inputArray[i][j] > 0) {
                    result += inputArray[i][j];
                }
            }
        }
        return result;
    }

    /* Задача 2
    Реализовать метод, который принимает в качестве аргумента int size
    и печатает в консоль квадрат из символов * со сторонами соответствующей длины;
     */

    public static void printSquare(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /* Задача 3
    Реализовать метод, принимающий в качестве аргумента двумерный целочисленный массив,
    и зануляющий его диагональные элементы (можно выбрать любую из диагоналей, или занулить обе);
     */

    public static void zeroDiagonal(int[][] inputArray, boolean firstDiag, boolean secondDiag) {
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray[i].length; j++) {
                if ((i == j && firstDiag) || (i == inputArray.length - j - 1) && secondDiag) {
                    inputArray[i][j] = 0;
                }
            }
        }
    }

    /* Задача 4
    Реализовать метод findMax(int[][] array) который должен найти и вернуть максимальный элемент массива;
    */

    public static int findMax(int[][] inputArray) {
        int maxValue = inputArray[0][0];
        for (int i = 1; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray[i].length; j++) {
                if (inputArray[i][j] > maxValue) {
                    maxValue = inputArray[i][j];
                }
            }
        }
        return maxValue;
    }

    /* Задача 5
    Реализуйте метод, который считает сумму элементов второй строки двумерного массива,
    если второй строки не существует, то в качестве результата необходимо вернуть -1
     */

    public static int countSecondLineSum(int[][] inputArray) {
        int sum = 0;
        if (inputArray.length < 2) {
            return -1;
        }
        for (int i = 0; i < inputArray[1].length; i++) {
            sum += inputArray[1][i];
        }
        return sum;
    }


    //*********
    // Метод строит массив заданного размера и заполняет элементы переданным кодом символа

    public static int[][] buildArray(int size, char fillChar) {
        int[][] result = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result[i][j] = fillChar;
            }
        }
        return result;
    }

    // Метод печатает массив, используя значения элементов в качестве кодов символов
    public static void printArray(int[][] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray[i].length; j++) {
                System.out.print(Character.toString(inputArray[i][j]));
            }
            System.out.println();

        }
    }

    // Метод рисует в переданном массиве ёлочку
    public static void makeChristmasTree(int[][] inputArray, char fillChar) {
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray[i].length; j++) {
                if (((inputArray.length / 2 - i / 2.05 <= j) && (inputArray.length / 2 + i / 2.05 >= j) && (i % 4) != 0) || (Math.abs(j - inputArray.length / 2) <= 1) && i > 3) {
                    inputArray[i][j] = fillChar;
                }

            }

        }
    }


}



