package modelo.excepciones;

public class PersonajeNoEstaDebajoDelPorcDeVidaNecesario extends Exception {

    private String message = null;
    public PersonajeNoEstaDebajoDelPorcDeVidaNecesario() {
        super();
        this.message = "Personaje por debajo del nivel de vida necesario para realizar esta acción";
    }
    public PersonajeNoEstaDebajoDelPorcDeVidaNecesario(String message) {
        super(message);
        this.message = message;
    }
    public PersonajeNoEstaDebajoDelPorcDeVidaNecesario(Throwable cause) {
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
