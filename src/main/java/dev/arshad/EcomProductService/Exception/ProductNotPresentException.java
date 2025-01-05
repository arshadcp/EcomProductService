package dev.arshad.EcomProductService.Exception;

public class ProductNotPresentException extends RuntimeException{
    public ProductNotPresentException(String message) {
        super(message);
    }
}
