package ru.otus.java.basic.homeworks.homework9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainApp {

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));

        List<Emploee> list2 = new ArrayList<>();
        list2.add(new Emploee("Саша", 15));
        list2.add(new Emploee("Лена", 22));
        list2.add(new Emploee("Вася", 40));
        list2.add(new Emploee("Света", 35));
        list2.add(new Emploee("Чингачгук", 105));
        list2.add(new Emploee("Лёлик", 10));


        System.out.println(minMax(2, 10));
        System.out.println(sumOverFive(list1));
        System.out.println(fillList(list1, 77));
        System.out.println(increaseList(list1, 2));
        System.out.println(extractNames(list2));
        System.out.println(extractNamesByAge(list2, 29));
        System.out.println("Средний возраст сотрудников " + (checkAverageAge(list2, 43) ? "больше " : "меньше или равен ") + "цели");
        System.out.println(findYoungest(list2));
        System.out.println(findYoungest2(list2));


    }

    // Задание 1
    public static List<Integer> minMax(int min, int max) {
        List<Integer> result = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            result.add(i);
        }
        return result;
    }

    //Задание 2
    public static int sumOverFive(List<Integer> list) {
        int sum = 0;
        for (Integer e : list) {
            if (e > 5) sum += e;
        }
        return sum;
    }

    //Задание 3

    public static List<Integer> fillList(List<Integer> list, int numberToFill) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, numberToFill);
        }
        return list;
    }

    //Задание 4
    public static List<Integer> increaseList(List<Integer> list, int numberToFill) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i) + numberToFill);
        }
        return list;
    }

    //Задание 5
    public static List<String> extractNames(List<Emploee> list) {
        List<String> result = new ArrayList<>();
        for (Emploee e : list) {
            result.add(e.getName());
        }
        return result;
    }

    //Задание 6
    public static List<String> extractNamesByAge(List<Emploee> list, int age) {
        List<String> result = new ArrayList<>();
        for (Emploee e : list) {
            if (e.getAge() >= age) result.add(e.getName());
        }
        return result;
    }

    //Задание 7
    public static boolean checkAverageAge(List<Emploee> list, int age) {
        int sumAge = 0;
        for (Emploee e : list) {
            sumAge += e.getAge();
        }
        double averageAge = (double) sumAge / list.size();
        return averageAge > age;
    }

    //Задание 8 Прошу прокомментировать какая из реализаций предпочтительнее.
    public static Emploee findYoungest(List<Emploee> list) {
        int lowestAge = list.get(0).getAge();
        int youngestNumber = 0;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).getAge() < lowestAge) {
                lowestAge = list.get(i).getAge();
                youngestNumber = i;
            }
        }
        return list.get(youngestNumber);
    }

    public static Emploee findYoungest2(List<Emploee> list) {
        Emploee youngest = list.get(0);
        for (Emploee e : list) {
            if (e.getAge() < youngest.getAge()) youngest = e;
        }
        return youngest;
    }


}

