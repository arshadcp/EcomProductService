package dev.arshad.EcomProductService.Exception;

public class invalidTokenException extends RuntimeException{
    public invalidTokenException(String message) {
        super(message);
    }
}
