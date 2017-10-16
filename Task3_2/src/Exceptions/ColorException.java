package Exceptions;

// if selected color of a flower is not in inventory
public class ColorException extends Exception{

    public ColorException(String message) {

        super(message);
    }

    public ColorException(String message, Throwable cause) {

        super(message, cause);
    }
}
