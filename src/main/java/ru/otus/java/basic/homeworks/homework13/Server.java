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

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Server started.");
        Socket clientSocket = null;
        while (true) {
            try {
                clientSocket = socket.accept();
                clientConnected = true;
                System.out.println("Client connected. Port : " + clientSocket.getPort());
            } catch (IOException e) {
                System.out.println("Exception:  " + e.getMessage());
            }
            while (clientConnected) {
                ClientHelper client = null;
                try {
                    client = new ClientHelper(clientSocket);
                } catch (IOException e) {
                    System.out.println(e.getMessage());

                }

                String output = "";
                String input = "";
                try {
                    input = client.recieveonly();
                } catch (IOException e) {
                    System.out.println("Exception:  " + e.getMessage());
                } catch (NullPointerException e) {
                    System.out.println("Exception:  " + e.getMessage());
                    clientConnected = false;
                }
                System.out.println("Server received: " + input);
                switch (input) {
                    case "exit" -> {
                        try {
                            client.close();
                            clientConnected = false;
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println("Connection closed.");
                    }
                    case "Command_HELLO" -> output = """
                        ---------------------------------------------------------------------------------------------------------
                        Welcome to calculator server v.0.9. Please send a string with an equation to calculate or "exit" to exit.
                        + - * / ^ operations are supported. Brackets are supported. Please use . or , as decimal separator.
                        ---------------------------------------------------------------------------------------------------------""";
                    case "Command_DIE" -> System.exit(0);
                    default -> {
                        try {
                            output = Calculator.calculate(input);
                        } catch (Exception e) {
                            output = "Could not calculate due to internal error. Sorry.";
                        }
                    }
                }
                if (clientConnected) try {
                    client.sendonly(output);
                    System.out.println("Server sent: " + output);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                    clientConnected = false;
                }
            }


        }

    }
}


