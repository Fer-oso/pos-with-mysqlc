package services.exceptions;

public class ClientServiceException extends Exception{

    private static final long serialVersionUID = 1L;

    public ClientServiceException(String message) {
        super(message);
    }

    public ClientServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClientServiceException(Throwable cause) {
        super(cause);
    }
}