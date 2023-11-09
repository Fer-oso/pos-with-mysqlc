package services.exceptions;

public class ProductServiceException extends Exception{

    private static final long serialVersionUID = 1L;

    public ProductServiceException() {
    }

    public ProductServiceException(String message) {
        super(message);
    }

    public ProductServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}