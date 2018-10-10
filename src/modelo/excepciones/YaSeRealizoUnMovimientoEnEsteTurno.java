package modelo.excepciones;

public class YaSeRealizoUnMovimientoEnEsteTurno extends Exception {
	
    private String message = null;
    public YaSeRealizoUnMovimientoEnEsteTurno() {
        super();
        this.message = "El equipo ya realizó un movimiento en este turno";
    }
    public YaSeRealizoUnMovimientoEnEsteTurno(String message) {
        super(message);
        this.message = message;
    }
    public YaSeRealizoUnMovimientoEnEsteTurno(Throwable cause) {
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
