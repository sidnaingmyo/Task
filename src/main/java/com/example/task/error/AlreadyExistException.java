package com.example.task.error;

public class AlreadyExistException extends RuntimeException {

    private String message;

    public AlreadyExistException(String message) {
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
