package ru.otus.java.basic.homeworks.homework8;

import java.security.InvalidParameterException;

public class AppArraySizeException extends InvalidParameterException {
    public AppArraySizeException (String message) {
        super(message);
    }

}
