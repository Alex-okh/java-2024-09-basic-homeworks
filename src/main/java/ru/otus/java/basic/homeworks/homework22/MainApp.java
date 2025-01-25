package ru.otus.java.basic.homeworks.homework22;

import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("Homework 22");
    }

    public static int[] trimAfterOne(int[] numbers) {
        if (numbers == null) {
            throw new RuntimeException("NULL input, int[] expected.");
        }
        for (int i = numbers.length - 1; i >= 0; i--) {
            if (numbers[i] == 1) {
                return Arrays.copyOfRange(numbers, i + 1, numbers.length);
            }
        }
        throw new RuntimeException("At least one <1> element expected, none found");
    }

    public static boolean checkOneAndTwoOnly(int[] numbers) {
        if (numbers == null || numbers.length < 2) {
            return false;
        }

        boolean onesFound = false;
        boolean twosFound = false;

        for (int number : numbers) {
            if (number == 1) {
                onesFound = true;
                continue;
            }
            if (number == 2) {
                twosFound = true;
                continue;
            }
            return false;
        }
        return onesFound && twosFound;
    }
}
