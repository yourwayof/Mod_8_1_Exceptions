package Exceptions;

public class InvalidStringFormatException extends RuntimeException {
    public InvalidStringFormatException (String message){
        super(message);
    }
}
