package ru.otus.java.basic.homeworks.hw1;

public class Solution {
    public static void main(String[] args) {
        greetings();
        checkSign(2, 3, -3);


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
}
