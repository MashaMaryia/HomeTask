package Exceptions;

// if selected type of a lily is not in inventory
public class LilyTypeException extends Exception{

    public LilyTypeException(String message) {
        super(message);
    }

    public LilyTypeException(String message, Throwable cause) {
        super(message, cause);
    }
}
