package services.exceptions;

public class ClientServiceExceptions extends Exception{

    private static final long serialVersionUID = 1L;

    public ClientServiceExceptions(String message) {
        super(message);
    }

    public ClientServiceExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public ClientServiceExceptions(Throwable cause) {
        super(cause);
    }

}