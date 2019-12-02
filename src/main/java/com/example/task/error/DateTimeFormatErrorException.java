package com.example.task.error;

public class DateTimeFormatErrorException extends RuntimeException {

    private String message;

    public DateTimeFormatErrorException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
