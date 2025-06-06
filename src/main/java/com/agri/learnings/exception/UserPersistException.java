package com.agri.learnings.exception;

public class UserPersistException extends RuntimeException {
    String responseCode;
    String message;

    public UserPersistException(String responseCode, String message) {
        this.message = message;
        this.responseCode = responseCode;
    }
}
