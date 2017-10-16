package Exceptions;

public class FlowerKindException extends Exception {

    public FlowerKindException(String message) {
        super(message);
    }

    public FlowerKindException(String message, Throwable cause) {
        super(message, cause);
    }
}
