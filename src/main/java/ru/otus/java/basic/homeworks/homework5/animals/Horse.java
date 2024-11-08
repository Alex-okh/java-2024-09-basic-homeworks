package ru.otus.java.basic.homeworks.homework5.animals;

public class Horse extends Animal {
    public Horse(String name) {
        super(name);
        runSpeed = 20;
        swimSpeed = 3;
        endurance = 500;

        enduranceSpentSwim = 4;
    }
}
