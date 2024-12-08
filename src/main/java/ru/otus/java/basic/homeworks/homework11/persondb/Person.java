package ru.otus.java.basic.homeworks.homework11.persondb;

public class Person {
    private String name;
    private Position position;
    private final Long id;
    private static long idCounter = 0L;

    public Person(String name, Position position) {
        this.name = name;
        this.position = position;
        this.id = ++idCounter;
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "\nСотрудник: " + name + "\nДолжность: " + position + "\nid=" + id;
    }
}
