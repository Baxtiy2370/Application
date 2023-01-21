package uz.b.application.config.exception;

public class SmsFailedException extends Exception{
    public SmsFailedException(String message){
        super(message);
    }
}
