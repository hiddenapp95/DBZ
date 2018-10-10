package modelo.excepciones;

/**
 * Created by marianoogimenez on 10/6/17.
 */
public class PersonajesDeUnMismoEquipoNoPuedenAtacarse extends RuntimeException {
    private String message = null;
    public PersonajesDeUnMismoEquipoNoPuedenAtacarse() {
        super();
    }
    public PersonajesDeUnMismoEquipoNoPuedenAtacarse(String message) {
        super(message);
        this.message = message;
    }

    public PersonajesDeUnMismoEquipoNoPuedenAtacarse(Throwable cause) {
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