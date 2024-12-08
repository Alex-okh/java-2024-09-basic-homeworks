package ru.otus.java.basic.homeworks.homework11;

public class Timer {
    static long timestamp;

    public static void stamp() {
        timestamp = System.currentTimeMillis();
    }

    public static long stop() {
        return System.currentTimeMillis() - timestamp;
    }

}

