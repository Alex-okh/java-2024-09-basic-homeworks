package ru.otus.java.basic.homeworks.homework5;

//Описание/Пошаговая инструкция выполнения домашнего задания:
//Создайте классы Cat, Dog и Horse с наследованием от класса Animal
//У каждого животного есть имя, скорость бега и плавания (м/с), и выносливость (измеряется в условных единицах)
//Затраты выносливости:
//Все животные на 1 метр бега тратят 1 ед выносливости,
//Собаки на 1 метр плавания - 2 ед.
//Лошади на 1 метр плавания тратят 4 единицы
//Кот плавать не умеет.
//Реализуйте методы run(int distance) и swim(int distance), которые должны возвращать время, затраченное на указанное действие, и “понижать выносливость” животного. Если выносливости не хватает, то возвращаем время -1 и указываем что у животного появилось состояние усталости. При выполнении действий пишем сообщения в консоль.
//Добавляем метод info(), который выводит в консоль состояние животного.

import ru.otus.java.basic.homeworks.homework5.animals.*;


public class MainApp {

    public static void main(String[] args) {
        Cat cat = new Cat("Барсик");
        Horse horse = new Horse("Зорька");
        Dog dog = new Dog("Альма");

        Animal[] animals = new Animal[]{cat, horse, dog};

        for (Animal animal : animals) {
            animal.info();
            System.out.println("Попросили пробежать 100 метров " + animal.getName() + ". Заняло: " + animal.run(100));
            System.out.println("Попросили проплыть 50 метров " + animal.getName() + ". Заняло: " + animal.swim(50));
            animal.info();
        }

    }
}
