package ru.otus.java.basic.homeworks.homework5.animals;

public class Cat extends Animal {
    public Cat(String name) {
        super(name);
        runSpeed = 5;
        swimSpeed = 0;
        endurance = 100;

        enduranceSpentSwim = 0;
    }

@Override
    public int swim(int distance) {
    System.out.println(name + " заставили плыть на " + distance + " метров.");
    System.out.println("Но " + name + " не умеет плавать. У него лапки.");
    return -1;
}
}
