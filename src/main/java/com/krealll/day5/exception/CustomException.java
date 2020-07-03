package com.krealll.day5.exception;

public class CustomException extends  Exception {

    public CustomException(){}

    public CustomException(String message) {
        super((message));
    }

    public CustomException(Throwable reason) {
        super((reason));
    }

    public CustomException(String message, Throwable reason) {
        super(message, reason);
    }
}
