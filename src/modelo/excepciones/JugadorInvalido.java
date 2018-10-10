package modelo.excepciones;

public class JugadorInvalido extends RuntimeException {
	private String message = null;

	public JugadorInvalido() {
		super();
	}

	public JugadorInvalido(String message) {
		super(message);
		this.message = message;
	}

    public JugadorInvalido(Throwable cause) {
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
