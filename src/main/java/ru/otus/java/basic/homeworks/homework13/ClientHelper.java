package ru.otus.java.basic.homeworks.homework13;

import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;

/**
 * Класс хранит данные соединения и предоставляет элементарные
 * операции установки и закрытия соединения, отправки и получения сообщений
 */


public class ClientHelper implements Closeable {
    Socket socket;
    DataInputStream inStream;
    DataOutputStream outStream;

    /**
     * Конструктор для последующей ручной инициации соединения
     */
    public ClientHelper() {
        this.socket = null;
        this.inStream = null;
        this.outStream = null;
    }

    /**
     * Конструктор для принятия уже созданного сокета. Самостоятельно создает для него входящий и исходящий Datastream.
     *
     * @param socket Сокет для соединения
     * @throws IOException
     */
    public ClientHelper(Socket socket) throws IOException {
        this.socket = socket;
        this.inStream = new DataInputStream(socket.getInputStream());
        this.outStream = new DataOutputStream(socket.getOutputStream());
    }

    /**
     * Закрывает открытые датастримы и сокет.
     *
     * @throws IOException
     */
    public void close() throws IOException {
        inStream.close();
        outStream.close();
        socket.close();
    }

    /**
     * Отправляет на сервер сообщение-приветствие.
     *
     * @throws IOException
     */
    public void sayHello() throws IOException {
        System.out.println(send("Command_HELLO"));

    }

    /**
     * Отправляет в исходящий стрим сообщение и возвращает полученный ответ.
     *
     * @param command Сообщение для отправки
     * @return Полученный ответ
     * @throws IOException
     */
    public String send(String command) throws IOException {
        sendonly(command);
        return recieveonly();
    }

    /**
     * отправляет сообщение в исходящий стрим
     *
     * @param input Сообщение для отправки
     * @throws IOException
     */
    public void sendonly(String input) throws IOException {
        outStream.writeUTF(input);
        outStream.flush();
    }

    /**
     * Получает сообщение из входящего стрима
     *
     * @return Полученное сообщение
     * @throws IOException
     */
    public String recieveonly() throws IOException {
        return inStream.readUTF();


    }

    /**
     * устанавливает исходящее соединение с localhost, порот 8080
     * и создает входящий и исходящий стримы если соединение успешно установлено
     *
     * @return true если соединение установлено, false после 10 безуспешных попыток
     * @throws InterruptedException
     */
    public boolean connect() throws InterruptedException {
        int timeout = 1000;
        int connecRetries = 0;

        while (connecRetries < 10) {
            try {
                socket = new Socket("localhost", 8080);
                inStream = new DataInputStream(socket.getInputStream());
                outStream = new DataOutputStream(socket.getOutputStream());
                System.out.println("Connected.");
                return true;


            } catch (ConnectException e) {

                System.out.println(e.getMessage());

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            Thread.sleep(timeout);
            connecRetries++;
        }
        return false;

    }

}



