package dev.arshad.EcomProductService.Exception;

public class invalidCartException extends RuntimeException{
    public invalidCartException(String message) {
        super(message);
    }
}
