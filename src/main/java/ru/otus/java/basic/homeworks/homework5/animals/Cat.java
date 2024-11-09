package ru.otus.java.basic.homeworks.homework5.animals;

public class Cat extends Animal {
    public Cat(String name) {
        super(name, 5,0,100);
        enduranceSpentSwim = 0;
    }

@Override
    public int swim(int distance) {
    System.out.printf("""

    %s заставили плыть на %d метров.
    Но %1$s не умеет плавать. У него лапки.

    """,name,distance);
    return -1;
}
}
