package modelo.excepciones;

public class YaSeRealizoUnAtaqueEnEsteTurno extends Exception {
	
    private String message = null;
    public YaSeRealizoUnAtaqueEnEsteTurno() {
        super();
        this.message = "El equipo ya realizó un ataque en este turno";

    }
    public YaSeRealizoUnAtaqueEnEsteTurno(String message) {
        super(message);

        this.message = message;
    }
    public YaSeRealizoUnAtaqueEnEsteTurno(Throwable cause) {
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
