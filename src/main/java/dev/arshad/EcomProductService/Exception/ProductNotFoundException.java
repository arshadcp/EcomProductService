package dev.arshad.EcomProductService.Exception;

public class ProductNotFoundException extends ProductNotPresentException{
    public ProductNotFoundException(String message) {
        super(message);
    }
}
