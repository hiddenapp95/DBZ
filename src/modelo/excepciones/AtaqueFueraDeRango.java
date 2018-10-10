package modelo.excepciones;

/**
 * Created by marianoogimenez on 4/6/17.
 */

public class AtaqueFueraDeRango extends RuntimeException {
    private String message = null;
    public AtaqueFueraDeRango() {
        super();
    }
    public AtaqueFueraDeRango(String message) {
        super(message);
        this.message = message;
    }

    public AtaqueFueraDeRango(Throwable cause) {
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