package ru.otus.java.basic.homeworks.homework14;

public class MainApp {
    static double[] data = new double[100_000_000];

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 4; i++) {
            System.out.println("\nТестовый запуск №" + (i+1));


            System.out.println("Заполняем массив в 1 поток..");
            Timer.stamp();
            fillArray(data, 0, data.length);
            System.out.println("Заняло : " + Timer.stop() + " мс.");

            Thread filler1 = new Thread(() ->
                fillArray(data, 0, data.length / 4));
            ;

            Thread filler2 = new Thread(() ->
                fillArray(data, data.length / 4, data.length / 2));
            Thread filler3 = new Thread(() ->
                fillArray(data, data.length / 2, data.length / 4 * 3));
            Thread filler4 = new Thread(() ->
                fillArray(data, data.length / 4 * 3, data.length));

            System.out.println("Заполняем массив в 4 потока..");
            Timer.stamp();
            filler1.start();
            filler2.start();
            filler3.start();
            filler4.start();

            filler1.join();
            filler2.join();
            filler3.join();
            filler4.join();
            System.out.println("Заняло : " + Timer.stop() + " мс.");
        }
    }

    public static void fillArray(double[] array, int start, int end) {
        for (int i = start; i < end; i++) {
            array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
        }
    }

}
