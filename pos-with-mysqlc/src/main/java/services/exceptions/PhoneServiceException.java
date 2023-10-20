package services.exceptions;

public class PhoneServiceException extends Exception{
    
    private static final long serialVersionUID = 1L;

    public PhoneServiceException() {
    }

    public PhoneServiceException(String message) {
        super(message);
    }

    public PhoneServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}