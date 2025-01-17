package ru.otus.java.basic.homeworks.homework20;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import static ru.otus.java.basic.homeworks.homework20.SearchUtils.*;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String filename = "";
        String searchPattern = "";
        boolean needToSearch = true;

        while (filename.isEmpty()) {
            System.out.println("Please enter a file name: ");
            filename = sc.nextLine();
        }
        while (needToSearch) {
            while (searchPattern.isEmpty()) {
                System.out.println("Please enter a search pattern: ");
                searchPattern = sc.nextLine();
            }

            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                System.out.println(countMatches(reader, searchPattern) + " matches found.");
            } catch (IOException e) {
                System.out.println("Error reading file: " + filename + "  " + e.getMessage());
            }

            needToSearch = false;
            System.out.println("Want to search something else? (Enter Y to repeat)");
            String answer = sc.nextLine();
            if (answer.equalsIgnoreCase("y")) {
                needToSearch = true;
                searchPattern = "";
            }
        }
    }
}
