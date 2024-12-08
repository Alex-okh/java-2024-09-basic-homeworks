package ru.otus.java.basic.homeworks.homework11.persondb;

import java.util.HashMap;
import java.util.Map;

public class PersonDataBase {
    Map<Long, Person> persons;

    public PersonDataBase() {
        persons = new HashMap<>();
    }

    public Person findById(long id) {
        return persons.get(id);
    }

    public void add(Person person) {
        persons.put(person.getId(), person);

    }

    public static boolean isManager(Person person) {
        Position position = person.getPosition();

        return (
                position == Position.MANAGER ||
                position == Position.DIRECTOR ||
                position == Position.BRANCH_DIRECTOR ||
                position == Position.SENIOR_MANAGER);
    }

    public boolean isEmployee(long id) {
        Person person = findById(id);
        return !isManager(person);
    }


}

