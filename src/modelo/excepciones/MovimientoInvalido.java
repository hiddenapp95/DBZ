package modelo.excepciones;

@SuppressWarnings("serial")
public class MovimientoInvalido extends RuntimeException{
	
	public MovimientoInvalido() {
		super();
	}
	
	public MovimientoInvalido(String msg) {
		super(msg);
	}

}
