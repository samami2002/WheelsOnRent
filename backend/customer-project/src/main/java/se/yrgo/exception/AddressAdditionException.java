package se.yrgo.exception;

public class AddressAdditionException extends RuntimeException {
    public AddressAdditionException(String message) {
        super(message);
    }

    public AddressAdditionException(String message, Throwable cause) {
        super(message, cause);
    }
}
