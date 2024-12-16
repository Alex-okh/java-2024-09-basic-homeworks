package ru.otus.java.basic.homeworks.homework13;

import ru.otus.java.basic.homeworks.homework13.calculator.Calculator;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    public static void main(String[] args) {
        boolean clientConnected = false;
        ServerSocket socket = null;
        try {
            socket = new ServerSocket(8080);
            System.out.println("Server started.");
            Socket clientSocket = null;
            while (true) {
                clientSocket = socket.accept();
                clientConnected = true;
                System.out.println("Client connected. Port : " + clientSocket.getPort());
                while (clientConnected) {
                    try {
                        ClientHelper client = new ClientHelper(clientSocket);
                        String output = "";
                        String input = "";
                        input = client.recieveonly();
                        System.out.println("Server received: " + input);
                        switch (input) {
                            case "exit" -> {
                                client.close();
                                System.out.println("Connection closed.");
                            }
                            case "Command_HELLO" -> output = """
                                ---------------------------------------------------------------------------------------------------------
                                Welcome to calculator server v.0.9. Please send a string with an equation to calculate or "exit" to exit.
                                + - * / ^ operations are supported. Brackets are supported. Please use . or , as decimal separator.
                                ---------------------------------------------------------------------------------------------------------""";
                            case "Command_DIE" -> System.exit(0);
                            default -> output = Calculator.calculate(input);
                        }
                        client.sendonly(output);
                        System.out.println("Server sent: " + output);

                    } catch (RuntimeException | IOException e) {
                        System.out.println(e.getMessage());
                        clientConnected = false;
                    }
                }
            }
        } catch (RuntimeException | IOException e) {
            System.out.println("Could not start server.");
            System.out.println(e.getMessage());


        }
    }
}


