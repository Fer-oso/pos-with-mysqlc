package persistence.dao.exceptios;

public class DaoExceptions extends Exception{

    private static final long serialVersionUID = 1L;

    public DaoExceptions() {
    }

    public DaoExceptions(String message) {
        super(message);
    }

    public DaoExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public DaoExceptions(Throwable cause) {
        super(cause);
    }

}