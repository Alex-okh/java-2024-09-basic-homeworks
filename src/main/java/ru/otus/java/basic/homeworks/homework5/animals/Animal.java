package ru.otus.java.basic.homeworks.homework5.animals;

//У каждого животного есть имя, скорость бега и плавания (м/с), и выносливость (измеряется в условных единицах)

public class Animal {
    String name;
    int runSpeed;
    int swimSpeed;
    int endurance;

    int enduranceSpentRun;
    int enduranceSpentSwim;

    public Animal(String name) {
        this.name = name;
        runSpeed = 0;
        swimSpeed = 0;
        endurance = 0;
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
        System.out.println("\nМеня зовут " + name + ".");
        System.out.println("Я - " + getClass().getSimpleName() + ". Я бегаю со скоростью " + runSpeed + " м/c и плаваю со скоростью " + swimSpeed + " м/с.");
        System.out.println("Сейчас моя выносливость " + endurance + " единиц.\n");
    }


}


