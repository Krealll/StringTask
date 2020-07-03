package com.krealll.day5.exception;

public class FileException extends Exception {

    public FileException(){}

    public FileException(String message) {
        super((message));
    }

    public FileException(Throwable reason) {
        super((reason));
    }

    public FileException(String message, Throwable reason) {
        super(message, reason);
    }
}
