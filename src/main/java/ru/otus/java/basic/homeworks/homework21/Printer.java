package ru.otus.java.basic.homeworks.homework21;

public class Printer {
    private char lastprinted = 0;

    public synchronized void printLetter(char letter, char previous, int repeats, boolean canBeFirst)  {
        for (int i = 0; i < repeats; i++) {
            while ((lastprinted != previous) && !(canBeFirst && lastprinted == 0)) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print(letter);
            lastprinted = letter;
            notifyAll();

        }
    }
}
