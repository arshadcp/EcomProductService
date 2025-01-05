package dev.arshad.EcomProductService.Exception;

public class NoProductFoundException extends RuntimeException{
    public NoProductFoundException() {
    }

    public NoProductFoundException(String message) {
        super(message);
    }

    public NoProductFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoProductFoundException(Throwable cause) {
        super(cause);
    }

    public NoProductFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
