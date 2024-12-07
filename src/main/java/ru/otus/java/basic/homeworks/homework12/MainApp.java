package ru.otus.java.basic.homeworks.homework12;

import java.util.Scanner;

/**
 * Реализуйте приложение, позволяющее работать с текстовыми файлами
 * При старте приложения, в консоль выводится список текстовых файлов из корневого каталоге проекта
 * Далее программа запрашивает имя файла, с которым хочет работать пользователь
 * Содержимое файла выводится в консоль
 * Затем любую введенную пользователем строку необходимо записывать в указанный файл
 */

public class MainApp {
    public static void main(String[] args) {
        MyFileManager fileManager = new MyFileManager(".");
        Scanner sc = new Scanner(System.in);
        boolean working = true;

        fileManager.help();
        while (working) {
            String[] userInput = sc.nextLine().split(" ");

            try {
                switch (userInput[0]) {
                    case "mkdir" -> fileManager.makeDir(userInput[1]);
                    case "dir" -> fileManager.printContents();
                    case "show" -> fileManager.showFileContents(userInput[1]);
                    case "write" -> fileManager.writeLineToFile(userInput[1]);
                    case "cd" -> {
                        fileManager.change(userInput[1]);
                        fileManager.printContents();
                    }
                    case "rename" -> fileManager.rename(userInput[1], userInput[2]);
                    case "del" -> fileManager.delete(userInput[1]);
                    case "exit" -> working = false;
                    case "help" -> fileManager.help();
                    default -> System.out.println("Неизвестная команда");

                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Недостаточно аргументов");
            }

        }
    }


}


