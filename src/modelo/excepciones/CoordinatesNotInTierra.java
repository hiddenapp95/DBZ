package modelo.excepciones;

/**
 * Created by marianoogimenez on 4/6/17.
 */
public class CoordinatesNotInTierra extends RuntimeException {
    private String message = null;
    public CoordinatesNotInTierra() {
        super();
    }
    public CoordinatesNotInTierra(String message) {
        super(message);
        this.message = message;
    }

    public CoordinatesNotInTierra(Throwable cause) {
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
