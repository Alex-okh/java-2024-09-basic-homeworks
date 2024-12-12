package ru.otus.java.basic.homeworks.homework13;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) {
        DataInputStream inputStream;
        DataOutputStream outputStream;


        System.out.println("Client is starting...");
        System.out.println("Connecting to server...");

        try (Socket socket = new Socket("localhost", 8080)) {
            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());
            System.out.println("Connected to server");

        } catch (ConnectException e) {
            System.out.println("Connection refused");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        outputStream.writeUTF("Hello");
        try {
            String result = inputStream.readUTF();
            System.out.println(result);
        } catch (EOFException e) {
            System.out.println("Сервер закрыл соединение.");
        }

    }
}
