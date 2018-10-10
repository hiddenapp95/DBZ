package modelo.excepciones;

public class PrimerCasilleroRecienSeleccionado extends RuntimeException {
    private String message = null;
    public PrimerCasilleroRecienSeleccionado() {
        super();
    }
    public PrimerCasilleroRecienSeleccionado(String message) {
        super(message);
        this.message = message;
    }

    public PrimerCasilleroRecienSeleccionado(Throwable cause) {
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
