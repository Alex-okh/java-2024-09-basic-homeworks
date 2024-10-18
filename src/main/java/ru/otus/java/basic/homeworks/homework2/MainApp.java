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
        int[] test4 = {6, 5, 4, 3, 2, 1, 0};
        int[] test5 = {0, 1, 1, 1, 5, 1, 9};
        int[] test6 = {};

        System.out.println("------------Задача 1----------");
        System.out.println(Arrays.toString(sumArrays(test1, test2, test3, test4, test5, test6)));

        System.out.println("------------Задача 2----------");
        System.out.println(hasMiddlePoint(test2));

        System.out.println("------------Задача 3----------");
        System.out.println(isAccending(test4, false));

        System.out.println("------------Задача 4----------");
        System.out.println(Arrays.toString(reverseArray(test4)));


    }

    // Задача 1

    // Суммирует соответствующие элементы двух целочисленных массивов, возвращая массив большей длины.
    public static int[] sumTwoArrays(int[] arr1, int[] arr2) {
        int[] result;

        if (arr1.length > arr2.length) {
            result = Arrays.copyOf(arr1, arr1.length);
        } else {
            result = Arrays.copyOf(arr2, arr2.length);
        }

        for (int i = 0; i < Math.min(arr1.length, arr2.length); i++) {
            result[i] = arr1[i] + arr2[i];
        }
        return result;
    }

    // Суммирует последовательно любое количество целочисленных массивов поэлементно, возвращает массив максимальной длины.
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

    // Возвращает сумму элементов части массива, заданной 2 индексами, оба включительно.
    // Если первый индекс больше последнего, то сумма = 0.
    public static int partialSum(int[] arr1, int firstIndex, int lastIndex) {
        int sum = 0;
        if (firstIndex >= arr1.length || firstIndex > lastIndex) {
            return 0;
        }
        if (lastIndex >= arr1.length) {
            lastIndex = arr1.length - 1;
        }

        for (int i = firstIndex; i <= lastIndex; i++) {
            sum += arr1[i];
        }
        return sum;
    }

    // Проверяет есть ли точка между элементами массива, для которой суммы элементов справа и слева равны.
    public static boolean hasMiddlePoint(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (partialSum(arr, 0, i) == partialSum(arr, i + 1, arr.length - 1)) {
                return true;
            }
        }
        return false;
    }


    //Задача 3

    // Проверяет, что все элементы массива расположены по возрастанию (если параметр acending = true)
    // или по убыванию (если параметр acending = false)
    public static boolean isAccending(int[] arr1, boolean acending) {
        for (int i = 0; i < arr1.length - 1; i++) {
            if ((arr1[i] > arr1[i + 1] && acending) || (arr1[i] < arr1[i + 1] && !acending)) {
                return false;
            }
        }
        return true;
    }

    //Задача 4

    // Возвращает массив с обратным расположением элементов
    public static int[] reverseArray(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            result[i] = arr[arr.length - 1 - i];
        }
        return result;
    }


}
