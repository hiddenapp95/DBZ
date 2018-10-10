package modelo.excepciones;

import java.io.IOException;

/**
 * Created by Franco on 6/4/2017.
 */
public class CasilleroOcupado extends RuntimeException {
    private String message = null;
    public CasilleroOcupado() {
        super();
    }
    public CasilleroOcupado(String message) {
        super(message);
        this.message = message;
    }
    public CasilleroOcupado(Throwable cause) {
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
