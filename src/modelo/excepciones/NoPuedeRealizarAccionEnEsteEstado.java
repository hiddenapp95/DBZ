package modelo.excepciones;

public class NoPuedeRealizarAccionEnEsteEstado extends RuntimeException {
    private String message = null;
    public NoPuedeRealizarAccionEnEsteEstado() {
        super();
        this.message = "EL PERSONAJE ESTA INMOVILIZADO, NO SE PUEDE REALIZAR ESTA ACCION.";
    }
    public NoPuedeRealizarAccionEnEsteEstado(String message) {
        super(message);
        this.message = message;
    }

    public NoPuedeRealizarAccionEnEsteEstado(Throwable cause) {
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
