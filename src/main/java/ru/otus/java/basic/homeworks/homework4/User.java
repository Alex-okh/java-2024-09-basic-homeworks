package ru.otus.java.basic.homeworks.homework4;

public class User {
    private String name;
    private String surname;
    private String secondname;
    private int birthYear;
    private String emailAddress;

    public int getBirthYear() {
        return birthYear;
    }

    public User(String name, String surname, String secondname, int birthYear, String emailAddress) {
        this.name = name;
        this.surname = surname;
        this.secondname = secondname;
        this.birthYear = birthYear;
        this.emailAddress = emailAddress;
    }

    public void printInfo() {
        System.out.println("\n------------------------------------------");
        System.out.println("ФИО: " + surname + " " + name + " " + secondname);
        System.out.println("Год рождения: " + birthYear);
        System.out.println("email: " + emailAddress);
        System.out.println("------------------------------------------");
    }

}
