package modelo.excepciones;

public class AunNoHayEquipoGanador extends Exception {
	private String message = null;
    public AunNoHayEquipoGanador() {
        super();
    }
    public AunNoHayEquipoGanador(String message) {
        super(message);
        this.message = message;
    }
    public AunNoHayEquipoGanador(Throwable cause) {
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
