package ru.otus.java.basic.homeworks.homework13;

import java.io.IOException;
import java.util.Scanner;


public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Client is starting...");
        ClientHelper client = new ClientHelper();
        if (!client.connect()) {
            System.out.println("Could not connect. Exiting...");
            System.exit(1);

        }
        client.sayHello();

        String input = "";
        boolean connectionClosed = false;
        Scanner sc = new Scanner(System.in);

        while (!input.equals("exit") && !connectionClosed) {
            System.out.print("-->");
            String recieved = "";
            input = sc.nextLine();
            try {
                recieved = client.send(input);
            } catch (IOException e) {
                connectionClosed = true;
                System.out.println("Connection closed");
            }
            System.out.println(recieved);
        }
        System.out.println("Client is shutting down...");
        sc.close();
        client.close();


    }

}








