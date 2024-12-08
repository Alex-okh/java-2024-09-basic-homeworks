package ru.otus.java.basic.homeworks.homework11.persondb;

public enum Position {
    MANAGER, DIRECTOR, DRIVER, ENGINEER, SENIOR_MANAGER, DEVELOPER, QA,
    JANITOR, PLUMBER, BRANCH_DIRECTOR, JUNIOR_DEVELOPER;

    public static Position random() {
        return Position.values()[(int) (Math.random() * Position.values().length)];
    }

}
