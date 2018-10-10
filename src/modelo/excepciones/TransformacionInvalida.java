package modelo.excepciones;

@SuppressWarnings("serial")
public class TransformacionInvalida extends RuntimeException {

	public TransformacionInvalida() {
		super();
	}

	public TransformacionInvalida(String msg) {
		super(msg);
	}
}
