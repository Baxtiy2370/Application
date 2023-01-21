package uz.b.application.config.exception;

public class InvalidTokenException extends Exception{
    private final Integer code;
    public InvalidTokenException(String message, Integer code){
        super(message);
        this.code = code;
    }
}
