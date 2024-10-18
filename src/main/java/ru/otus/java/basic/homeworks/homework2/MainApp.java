package ru.otus.java.basic.homeworks.homework2;

import java.util.Arrays;

/**
 * Домашнее задание
 * Цель домашнего задания: науùитþсā реúатþ простýе задаùи с исполþзованием изуùеннýх конструкøий
 * āзýка Java.
 * ● Реализуйте метод, принимаĀûий на вход набор øелоùисленнýх массивов, и полуùаĀûий новýй
 * массив равнýй сумме входāûих;
 * Пример: { 1, 2, 3 }
 * + { 2, 2 }
 * + { 1, 1, 1, 1, 1}
 * = { 4, 5, 4, 1, 1 }
 * ● Реализуйте метод, проверāĀûий ùто естþ “тоùка” в массиве, в которой сумма левой и правой ùасти
 * равнý. “Тоùка находитсā между ÿлементами”;
 * Пример: { 1, 1, 1, 1, 1, | 5 }, { 5, | 3, 4, -2 }, { 7, 2, 2, 2 }, { 9, 4 }
 * ● Реализуйте метод, проверāĀûий ùто все ÿлементý массива идут в порāдке убýваниā или
 * возрастаниā (по вýбору полþзователā)
 * ● Реализуйте метод, “перевораùиваĀûий” входāûий массив
 * Пример: { 1 2 3 4 } => { 4 3 2 1 }
 */

public class MainApp {
    public static void main(String[] args) {
        int[] test1 = {1, 2, 3};
        int[] test2 = {2, 2};
        int[] test3 = {1, 1, 1, 1, 1};
        int[] test4 = {1, 1, 1, 1, 5, 6, 7};
        int[] test5 = {1, 1, 1, 1, 5, 6, 7};
        int[] test6 = {};


        System.out.println(Arrays.toString(sumArrays(test1, test2, test3, test4, test5, test6)));

    }
// Задача 1
    public static int[] sumTwoArrays(int[] arr1, int[] arr2) {
        int[] result = new int[Math.max(arr1.length, arr2.length)];

        for (int i = 0; i < Math.min(arr1.length, arr2.length); i++) {
            result[i] = arr1[i] + arr2[i];
        }

        for (int i = Math.min(arr1.length, arr2.length); i < Math.max(arr1.length, arr2.length); i++) {
            if (i < arr1.length) {
                result[i] = arr1[i];
            } else {
                result[i] = arr2[i];
            }
        }

        return result;
    }

    public static int[] sumArrays(int[]... arrays) {
        int arraysCount = arrays.length;
        int maxArrayLength = 0;
        for (int i = 0; i < arraysCount; i++) {
            if (arrays[i].length > maxArrayLength) {
                maxArrayLength = arrays[i].length;
            }
        }
        if (maxArrayLength == 0) {
            return new int[0];
        }

        int[] result = new int[maxArrayLength];
        for (int i = 0; i < arraysCount; i++) {
            result = sumTwoArrays(result, arrays[i]);
        }

        return result;

    }

 //Задача 2


}
