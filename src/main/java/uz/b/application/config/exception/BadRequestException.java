package uz.b.application.config.exception;

public class BadRequestException extends Exception{
    public BadRequestException(String message){
        super(message);
    }
}
