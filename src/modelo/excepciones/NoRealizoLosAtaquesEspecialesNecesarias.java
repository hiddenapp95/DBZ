package modelo.excepciones;

public class NoRealizoLosAtaquesEspecialesNecesarias extends Exception {
	
    private String message = null;
    public NoRealizoLosAtaquesEspecialesNecesarias() {
        super();
        this.message = "El personaje no realizo las absorciones necesarias para transformarse";
    }
    public NoRealizoLosAtaquesEspecialesNecesarias(String message) {
        super(message);
        this.message = message;
    }
    public NoRealizoLosAtaquesEspecialesNecesarias(Throwable cause) {
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
