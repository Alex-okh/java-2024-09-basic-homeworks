package ru.otus.java.basic.homeworks.homework14;

public abstract class Timer {
    static long timestamp;

    public static void stamp() {
        timestamp = System.currentTimeMillis();
    }

    public static long stop() {
        return System.currentTimeMillis() - timestamp;
    }
}
