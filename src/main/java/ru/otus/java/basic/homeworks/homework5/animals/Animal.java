package ru.otus.java.basic.homeworks.homework5.animals;

//У каждого животного есть имя, скорость бега и плавания (м/с), и выносливость (измеряется в условных единицах)

public class Animal {
    protected String name;
    protected int runSpeed;
    protected int swimSpeed;
    protected int endurance;

    protected int enduranceSpentRun;
    protected int enduranceSpentSwim;

    public Animal(String name, int runSpeed, int swimSpeed, int endurance) {
        this.name = name;
        this.runSpeed = runSpeed;
        this.swimSpeed = swimSpeed;
        this.endurance = endurance;
        enduranceSpentRun = 1;
        enduranceSpentSwim = 1;

    }

    public String getName() {
        return name;
    }

    public int run(int distance) {
        System.out.println(name + " заставили бежать на " + distance + " метров.");
        System.out.println("Это займет у него " + distance / runSpeed + " секунд.");
        if (endurance > distance * enduranceSpentRun) {
            endurance -= distance * enduranceSpentRun;
            return distance / runSpeed;
        }
        System.out.println("Но " + name + " слишком устал, чтобы так далеко бегать...");
        return -1;
    }


    public int swim(int distance) {
        System.out.println(name + " заставили плыть на " + distance + " метров.");
        System.out.println("Это займет у него " + distance / swimSpeed + " секунд.");
        if (endurance >= distance * enduranceSpentSwim) {
            endurance -= distance * enduranceSpentSwim;
            return distance / swimSpeed;
        }
        System.out.println("Но " + name + " слишком устал, чтобы так далеко плыть...");
        return -1;
    }

    public void info() {
        System.out.printf("""
            %nМеня зовут %s. Я - %s.
            Я бегаю со скоростью %d м/c и плаваю со скоростью %d м/с.
            Сейчас моя выносливость %d единиц.%n
            """, name, getClass().getSimpleName(), runSpeed, swimSpeed, endurance);
//


    }
}


