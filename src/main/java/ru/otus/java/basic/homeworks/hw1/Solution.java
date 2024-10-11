package ru.otus.java.basic.homeworks.hw1;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        greetings();
        checkSign(2, 3, -3);
        selectColor();
        compareNumbers();
        addOrSubtractAndPrint(10, 4, true);

        for (int i = 0; i < 1000; i++) {
            int sum = 0;
            int rand = getRndInt(-100, 101);
            sum += rand;
            System.out.println(sum);
        }

// (*)
        Scanner sc = new Scanner(System.in);
        System.out.println("""
            Введите номер метода для выполнения:
            1 - greetings
            2 - checkSign
            3 - selectColor
            4 - compareNumbers
            5 - addOrSubtractAndPrint
            """);
        int choise = sc.nextInt();

        switch (choise) {
            case 1 -> greetings();
            case 2 -> checkSign(getRndInt(-100, 101), getRndInt(-100, 101), getRndInt(-100, 101));
            case 3 -> selectColor();
            case 4 -> compareNumbers();
            case 5 -> {
                boolean inc = false;
                if (getRndInt(-100, 101) > 0) {
                    inc = true;
                }
                addOrSubtractAndPrint(getRndInt(-100, 101), getRndInt(-100, 101), inc);
            }
            default -> System.out.println("Нет такого метода");
        }

    }

    // Задача 1
    public static void greetings() {
        System.out.println("Hello\nWorld\nfrom\nJava");
    }

    // Задача 2
    public static void checkSign(int a, int b, int c) {
        if (a + b + c >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    // Задача 3
    public static void selectColor() {
        int data = 20;
        if (data <= 10) {
            System.out.println("Красный");
        } else if (data <= 20) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    // Задача 4
    public static void compareNumbers() {
        int a = 10;
        int b = 20;
        if (a >= b) {
            System.out.println("a>=b");
        } else {
            System.out.println("a<b");
        }

    }

    // Задача 5
    public static void addOrSubtractAndPrint(int initValue, int delta, boolean increment) {
        if (increment) {
            System.out.println(initValue + delta);
        } else {
            System.out.println(initValue - delta);
        }

    }

    public static int getRndInt(int min, int max) {
        return (int) (Math.random() * (max - min) + min);
    }
}
