package ru.otus.java.basic.homeworks.homework13;

import ru.otus.java.basic.homeworks.homework13.calculator.Calculator;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.EmptyStackException;


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
        Socket client = null;
        while (true) {
            try {
                client = socket.accept();
                clientConnected = true;
                System.out.println("Client connected. Port : " + client.getPort());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            while (clientConnected) {
                DataInputStream inputstream = null;
                try {
                    inputstream = new DataInputStream(client.getInputStream());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                DataOutputStream outputstream = null;
                try {
                    outputstream = new DataOutputStream(client.getOutputStream());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                String output = "";
                String input = null;
                try {
                    input = inputstream.readUTF();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Server received: " + input);
                switch (input) {
                    case "exit" -> {
                        try {
                            inputstream.close();
                            outputstream.close();
                            client.close();
                            clientConnected = false;
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println("Connection closed.");
                    }
                    case "Command_HELLO" -> output = """
                        Welcome to calculator server v.0.1. Please send a string with an equation to calculate or "exit" to exit.
                        Only + - * / operations supported. Brackets should have an operator * if needed.
                        """;
                    case "Command_DIE" -> System.exit(0);
                    default -> {
                        try {
                            output = Calculator.calculate(input);
                        } catch (ArithmeticException e) {
                            output = e.getMessage();
                        } catch (EmptyStackException e) {
                            output = "not supported yet.";
                        }
                    }
                }
                if (clientConnected) try {
                    outputstream.writeUTF(output);
                    outputstream.flush();
                    System.out.println("Server sent: " + output);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }


        }

    }
}


//    public static String calculate(String input) {
//        String[] operands = input.split("[-+*/]");
//        String operator = input.replace("[\d]", "");
//        try {
//            switch (operator) {
//                case "+" -> {
//                    return "Result: " + (Double.parseDouble(operands[0]) + Double.parseDouble(operands[1]));
//                }
//                case "-" -> {
//                    return "Result: " + (Double.parseDouble(operands[0]) - Double.parseDouble(operands[1]));
//                }
//                case "*" -> {
//                    return "Result: " + (Double.parseDouble(operands[0]) * Double.parseDouble(operands[1]));
//                }
//                case "/" -> {
//                    return "Result: " + (Double.parseDouble(operands[0]) / Double.parseDouble(operands[1]));
//                }
//                default -> {
//                    return "Unknown operator: " + operator;}
//            }
//        } catch (NumberFormatException e) {
//            return e.getMessage();
//        } catch (ArithmeticException e) {
//            return e.getMessage();
//        }
//    }
//
//
//}
