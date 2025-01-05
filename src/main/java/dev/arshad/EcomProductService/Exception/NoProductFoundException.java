package dev.arshad.EcomProductService.Exception;

public class NoProductFoundException extends ProductNotPresentException{
    public NoProductFoundException(String message) {
        super(message);
    }
}
