package ru.otus.java.basic.homeworks.homework19;

import java.util.Random;

public class MainApp {
    public static void main(String[] args) {
        Random rand = new Random();
        System.out.println("--------------------------Homework 19--------------------------");
        System.out.println("----------------------Создаем коробки с фруктами---------------");
        Box<Apple> boxOfApples = new Box<>();
        Box<Orange> boxOfOranges = new Box<>();
        Box<Fruit> boxOfFruits = new Box<>();

        System.out.println("------------------Наполняем сортированные коробки---------------");
        for (int i = 0; i < 5; i++) {
            Apple apple = new Apple(rand.nextDouble(1, 3));
            Orange orange = new Orange(rand.nextDouble(1, 3));
            boxOfApples.addFruit(apple);
            boxOfOranges.addFruit(orange);
        }
        System.out.println("---------------Наполняем несортированную коробку---------------");
        for (int i = 0; i < 7; i++) {
            Apple apple = new Apple(rand.nextDouble(1, 3));
            Orange orange = new Orange(rand.nextDouble(1, 3));
            boxOfFruits.addFruit(apple);
            boxOfFruits.addFruit(orange);
        }
        System.out.println("---------------информация о коробках---------------");
        boxOfApples.getInfo();
        boxOfOranges.getInfo();
        boxOfFruits.getInfo();

        System.out.println("---------------сравним коробки---------------------");
        System.out.println(boxOfApples.compareTo(boxOfOranges));
        System.out.println(boxOfFruits.compareTo(boxOfApples));

        System.out.println("---------------пробуем пересыпать------------------");
        // boxOfOranges.transferTo(boxOfApples, 2); ошибка компиляции
        boxOfOranges.transferTo(boxOfFruits, 5);
        //  boxOfFruits.transferTo(boxOfApples, 2); ошибка компиляции

        System.out.println("-------в итоге протеряли 4 апельсина:---------------");
        System.out.println(boxOfApples);
        System.out.println(boxOfOranges);
        System.out.println(boxOfFruits);


    }
}
