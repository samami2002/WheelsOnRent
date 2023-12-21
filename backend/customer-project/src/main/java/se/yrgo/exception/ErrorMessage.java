package se.yrgo.exception;

import org.springframework.http.HttpStatus;

public class ErrorMessage {
    private final HttpStatus status;
    private final String error;
    private final String message;

    public ErrorMessage(HttpStatus status, String message) {
        this.status = status;
        this.error = status.getReasonPhrase();
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }
}
