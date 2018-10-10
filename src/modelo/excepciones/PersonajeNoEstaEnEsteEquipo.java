package modelo.excepciones;

public class PersonajeNoEstaEnEsteEquipo extends RuntimeException {
    private String message = null;
    public PersonajeNoEstaEnEsteEquipo() {
        super();
    }
    public PersonajeNoEstaEnEsteEquipo(String message) {
        super(message);
        this.message = message;
    }

    public PersonajeNoEstaEnEsteEquipo(Throwable cause) {
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
