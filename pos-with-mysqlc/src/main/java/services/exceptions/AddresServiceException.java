package services.exceptions;

public class AddresServiceException extends Exception{

    private static final long serialVersionUID = 1L;

    public AddresServiceException() {
    }

    public AddresServiceException(String message) {
        super(message);
    }

    public AddresServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}