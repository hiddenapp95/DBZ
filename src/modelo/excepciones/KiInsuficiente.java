package modelo.excepciones;

public class KiInsuficiente extends Exception {
	
	    private String message = null;
	    public KiInsuficiente() {
	        super();
			this.message = "Ki insuficiente para realizar esta acción";
	    }
	    public KiInsuficiente(String message) {
	        super(message);
	        this.message = message;
	    }
	    public KiInsuficiente(Throwable cause) {
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
