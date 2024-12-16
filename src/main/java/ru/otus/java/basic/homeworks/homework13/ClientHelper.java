package ru.otus.java.basic.homeworks.homework13;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;

public class ClientHelper {
    Socket socket;
    DataInputStream inStream;
    DataOutputStream outStream;

    public ClientHelper() {
        this.socket = null;
        this.inStream = null;
        this.outStream = null;
    }

    public ClientHelper(Socket socket) throws IOException {
        this.socket = socket;
        this.inStream = new DataInputStream(socket.getInputStream());
        this.outStream = new DataOutputStream(socket.getOutputStream());
    }


    public void close() throws IOException {
        inStream.close();
        outStream.close();
        socket.close();
    }

    public void sayHello() throws IOException {
        System.out.println(send("Command_HELLO"));

    }

    public String send(String command) throws IOException {
        sendonly(command);
        return recieveonly();
    }

    public void sendonly(String input) throws IOException {
        outStream.writeUTF(input);
        outStream.flush();
    }

    public String recieveonly() throws IOException {
        String result = inStream.readUTF();
        return result;


    }

    public boolean connect() throws InterruptedException {
        int timeout = 1000;
        int connecRetries = 0;

        while (connecRetries < 10) {
            try {
                socket = new Socket("localhost", 8080);
                inStream = new DataInputStream(socket.getInputStream());
                outStream = new DataOutputStream(socket.getOutputStream());
                System.out.println("Connected.");
                if (inStream != null && outStream != null) {
                    return true;
                }

            } catch (ConnectException e) {

                System.out.println(e.getMessage());
                if (connecRetries > 10) break;

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Thread.sleep(timeout);
            connecRetries++;
        }
        return false;

    }

}



