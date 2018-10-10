package modelo.excepciones;

public class LaVelocidadNoAlcanzaParaMoverseEstaDistancia extends Exception {
    private String message = null;
    public LaVelocidadNoAlcanzaParaMoverseEstaDistancia() {
        super();
    }
    public LaVelocidadNoAlcanzaParaMoverseEstaDistancia(String message) {
        super(message);
        this.message = message;
    }
    public LaVelocidadNoAlcanzaParaMoverseEstaDistancia(Throwable cause) {
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
