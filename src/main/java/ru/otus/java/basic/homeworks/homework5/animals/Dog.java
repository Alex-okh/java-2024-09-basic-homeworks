package ru.otus.java.basic.homeworks.homework5.animals;

public class Dog extends Animal {
    public Dog(String name) {
        super(name);
        runSpeed = 10;
        swimSpeed = 2;
        endurance = 200;

        enduranceSpentSwim = 2;
    }
}
