package ru.otus.java.basic.homeworks.homework12;

import java.io.*;
import java.util.Scanner;

public class MyFileManager {
    private File currentPoint;

    MyFileManager(String start) {
        currentPoint = new File(start);
    }

    /**
     * метод выводит в консоль список файлов  и подкаталогов в текущем каталоге.
     */
    public void printContents() {
        if (!currentPoint.isDirectory()) return;
        File[] directoryContents = currentPoint.listFiles();

        String fullPath = "";
        try {
            fullPath = currentPoint.getCanonicalPath();
        } catch (IOException e) {
            fullPath = "Не удалось получить путь";
        }
        System.out.println("Текущий каталог: " + fullPath);

        if (directoryContents == null) {
            return;
        }
        for (File file : directoryContents) {
            if (file.isDirectory()) {
                System.out.println("<DIR>   : " + file.getName());
            }
        }
        for (File file : directoryContents) {
            if (!file.isDirectory()) {
                System.out.println("        : " + file.getName());
            }
        }


    }

    /**
     * Метод переименовывает файл или каталог
     *
     * @param fileToRename имя объекта в текущем каталоге для переименования.
     * @param newName      новое имя
     */
    public void rename(String fileToRename, String newName) {
        File renamedFile = new File(fileToRename);
        if (!renamedFile.renameTo(new File(newName))) {
            System.out.println("Не удалось переименовать.");
        }
    }

    /**
     * Метод меняет текущий каталог на указанный на уровень ниже или выше.
     *
     * @param newDir Новый каталог (".." для перехода на уровень выше).
     */
    public void change(String newDir) {
        String fullPath = "";
        String newPath = "";
        try {
            fullPath = currentPoint.getCanonicalPath();
        } catch (IOException e) {
            System.out.println("Произошла ошибка при получении пути.");
            return;
        }
        if (newDir.equals("..")) {
            String[] pathParts = fullPath.split("\\\\");
            if (pathParts.length < 2) {
                newPath = pathParts[0] + "\\";
            } else {
               StringBuilder sb = new StringBuilder(pathParts[0] + "\\");
                for (int i = 1; i < pathParts.length - 1; i++) {
                    sb.append(pathParts[i]);
                    sb.append("\\");
                }
                newPath = sb.toString();

            }
        } else {
            newPath = fullPath + "\\" + newDir;
        }

        File newFile = new File(newPath);
        if (newFile.exists() && newFile.isDirectory()) {
            currentPoint = newFile;

        } else {
            System.out.println("Не получилось сменить каталог на " + newDir);
        }
    }

    /**
     * Метод выводит указанный файл в консоль.
     *
     * @param fileToShow имя файла для вывода.
     */
    public void showFileContents(String fileToShow) {
        File file = new File(fileToShow);
        if (file.isDirectory()) {
            System.out.println("Не могу вывести каталог в консоль...");
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine();
            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Файл не найден");
        }

    }

    /**
     * Запрашивает строку из консоли и дописывает в указанный файл.
     *
     * @param fileToWrite имя файла для записи.
     */
    public void writeLineToFile(String fileToWrite) {
        File file = new File(fileToWrite);
        if (!file.isDirectory()) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Введите строку для записи в файл \n");
                String line = sc.nextLine();
                bw.write(line);
                bw.flush();
                System.out.println("Строка успешно добавлена.");
            } catch (IOException e) {
                System.out.println("Произошла ошибка при записи.");
            }

        } else {
            System.out.println("Не могу записать данные в папку");
        }

    }

    /**
     * Удаляет указанный файл или каталог
     *
     * @param fileToDelete имя удаляемого объекта.
     */
    public void delete(String fileToDelete) {
        File file = new File(fileToDelete);
        if (file.delete()) {
            System.out.println("Файл (каталог) " + fileToDelete + " успешно удален.");
        } else {
            System.out.println("Не удалось удалить " + fileToDelete);
        }
    }

    /**
     * Создает каталог с заданным именем в текущей папке
     * @param dir имя создаваемого каталога
     */
    public void makeDir(String dir) {
        File dirFile = new File(dir);
        if (dirFile.exists()) {
            System.out.println(dir + " уже существует");
        } else {
            if (!dirFile.mkdir()) {
                System.out.println("Не удалось создать каталог " + dir);
            } else {
                System.out.println("Каталог " + dir + " успешно создан.");
            }
        }
    }

    /**
     * Выводит в консоль соощение с описанием.
     */
    public void help() {
        System.out.println("""

            Введите команду. Варианты:

            mkdir              - создать каталог
            dir                - файлы в текущем каталоге
            show <имя файла>   - вывести содержимое в консоль
            write <имя файла>  - записать строку в файл
            cd <имя каталога>  - перейти в каталог (используйте .. для перехода на уровень выше)
            rename <старое имя> <новое имя> - переименовать файл или каталог
            del <имя файла>    - удалить файл или каталог
            exit               - выход
            help               - вывести это сообщение
            """);
    }
}






