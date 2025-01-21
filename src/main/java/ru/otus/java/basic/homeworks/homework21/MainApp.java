package ru.otus.java.basic.homeworks.homework21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainApp {
    public static void main(String[] args) {
        Printer printer = new Printer();
        ExecutorService eservice = Executors.newFixedThreadPool(3);
        eservice.execute(() -> printer.printLetter('A', 'C', 5,true));
        eservice.execute(() -> printer.printLetter('B', 'A', 5,false));
        eservice.execute(() -> printer.printLetter('C', 'B', 5,false));
        eservice.shutdown();
    }


}

