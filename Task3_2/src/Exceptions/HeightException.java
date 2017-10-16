package Exceptions;

// if entered flower height is less than 25cm

public class HeightException extends Exception {
    public HeightException(String message) {
        super(message);
    }

    public HeightException(String message, Throwable cause) {
        super(message, cause);
    }
}

