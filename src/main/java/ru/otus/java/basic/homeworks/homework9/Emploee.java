package ru.otus.java.basic.homeworks.homework9;

public class Emploee {
    private String name;
    private int age;

    public Emploee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Сотрудник " +
            name + ", его возраст: " + age;
    }
}
