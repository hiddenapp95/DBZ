package modelo.excepciones;

/**
 * Created by marianoogimenez on 4/6/17.
 */

public class CasilleroVacio extends RuntimeException {
    private String message = null;
    public CasilleroVacio() {
        super();
    }
    public CasilleroVacio(String message) {
        super(message);
        this.message = message;
    }

    public CasilleroVacio(Throwable cause) {
        super(cause);
    }

    @Override
    public String toString() {
        return message;
    }
    @Override
    public String getMessage() {
        return message;
    }
}