package ru.otus.java.basic.homeworks.homework13;

import org.w3c.dom.ls.LSOutput;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketOption;
import java.net.SocketOptions;
import java.util.Scanner;


public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {
        int timeout = 1000;
        int connecRetries = 0;

        DataInputStream inputStream = null;
        DataOutputStream outputStream = null;
        Socket socket = null;

        System.out.println("Client is starting...");


        while (socket == null) {
            System.out.println("Connecting to server...");

            try {
                socket = new Socket("localhost", 8080);

                inputStream = new DataInputStream(socket.getInputStream());
                outputStream = new DataOutputStream(socket.getOutputStream());
                System.out.println("Connected.");

            } catch (
                ConnectException e) {
                System.out.println(e.getMessage());
                if (connecRetries > 10) break;

            } catch (
                IOException e) {
                throw new RuntimeException(e);
            }
            Thread.sleep(timeout);
            connecRetries++;
        }
        if (inputStream == null || outputStream == null) {
            System.out.println("Could not connect. Exiting...");
            System.exit(1);
        }
        outputStream.writeUTF("Command_HELLO");
        outputStream.flush();
        try {
            String result = inputStream.readUTF();
            System.out.println(result);
        } catch (
            EOFException e) {
            System.out.println("Connection closed.");
        }

        String input = "";
        Scanner sc = new Scanner(System.in);
        while (!input.equals("exit")) {

            System.out.print("-->");
            input = sc.nextLine();
            outputStream.writeUTF(input);
            outputStream.flush();
            try {
                String result = inputStream.readUTF();
                System.out.println(result);
            } catch (
                EOFException e) {
                System.out.println("Connection closed.");
            }
        }
        System.out.println("Client is shutting down...");
        sc.close();
        inputStream.close();
        outputStream.close();
        socket.close();


    }
}



