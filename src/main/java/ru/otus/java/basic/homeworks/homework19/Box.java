package ru.otus.java.basic.homeworks.homework19;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    List<T> contents;
    int capacity;

    public Box() {
        contents = new ArrayList<>();
        capacity = 15;

    }

    public double getWeight() {
        double weight = 0;
        for (T fruit : contents) {
            weight += fruit.getWeight();
        }
        return weight;
    }

    public boolean addFruit(T fruit) {
        if (fruit == null) {
            return false;
        }
        if (contents.size() < capacity) {
            return contents.add(fruit);
        } else {
            System.out.println("The box is full. Something is lost :-)");
            return false;
        }
    }

    public T removeFruit() {
        if (!contents.isEmpty()) {
            return contents.remove(0);
        }
        return null;
    }

    public boolean compareTo(Box<?> otherBox) {
        return Math.abs(this.getWeight() - otherBox.getWeight()) < 0.000001;
    }

    public void transferTo(Box<? super T> otherBox, int count) {
        int totalInBox = contents.size();
        for (int i = 0; i < Math.min(count, totalInBox); i++) {
            otherBox.addFruit(this.removeFruit());
        }
    }

    public void getInfo() {
        System.out.println("Capacity: " + capacity + " Load: " + contents.size() + " Weight: " + getWeight());
    }

    @Override
    public String toString() {
        return "Box{" + "contents=" + contents + ", capasity=" + capacity + '}';
    }
}
