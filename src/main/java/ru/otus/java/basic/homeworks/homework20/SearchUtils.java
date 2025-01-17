package ru.otus.java.basic.homeworks.homework20;

import java.io.BufferedReader;
import java.io.IOException;

public class SearchUtils {

    public static int countMatches(BufferedReader input, String pattern) throws IOException {
        int count = 0;
        String line = input.readLine();
        while (line != null) {
            count = count + countMatches(line, pattern);
            line = input.readLine();
        }
        return count;
    }


    public static int countMatches(String text, String pattern) {
        int count = 0;
        char firstChar = pattern.charAt(0);
        int index = 0;
        int lastIndex = text.length() - pattern.length();
        while (index <= lastIndex) {
            if (text.charAt(index) == firstChar && text.startsWith(pattern, index)) {
                count++;
                index = index + pattern.length() - 1;
            }

            index++;
        }
        return count;
    }
}
