package modelo.excepciones;

/**
 * Created by Franco on 6/18/2017.
 */
public class NoHayConsumibleEnElCasillero extends RuntimeException{
    private String message = null;
    public NoHayConsumibleEnElCasillero() {
        super();
    }
    public NoHayConsumibleEnElCasillero(String message) {
        super(message);
        this.message = message;
    }
    public NoHayConsumibleEnElCasillero(Throwable cause) {
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
