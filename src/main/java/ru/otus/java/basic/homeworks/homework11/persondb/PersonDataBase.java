package ru.otus.java.basic.homeworks.homework11.persondb;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PersonDataBase {
    Map<Long, Person> persons;
    Set <Position> management;


    public PersonDataBase() {
        persons = new HashMap<>();
        management = new HashSet<>();

        management.add(Position.MANAGER);
        management.add(Position.DIRECTOR);
        management.add(Position.BRANCH_DIRECTOR);
        management.add(Position.SENIOR_MANAGER);
    }

    public Person findById(long id) {
        return persons.get(id);
    }

    public void add(Person person) {
        persons.put(person.getId(), person);

    }

    public boolean isManager(Person person) {
        return management.contains(person.getPosition());
    }

    public boolean isEmployee(long id) {
        return !management.contains(findById(id).getPosition());

    }


}

