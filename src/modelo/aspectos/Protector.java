package modelo.aspectos;

import modelo.excepciones.KiInsuficiente;
import modelo.excepciones.NoRealizoLosAtaquesEspecialesNecesarias;
import modelo.excepciones.PersonajeNoEstaDebajoDelPorcDeVidaNecesario;
import modelo.personajes.Personaje;

public class Protector extends Aspecto {

	private static final int PODER_DE_PELEA = 60;
	private static final int DISTANCIA_DE_ATAQUE = 6;
	private static final int VELOCIDAD = 4;
	private static final int COSTO_KI = 0;

	public Protector() {
		super("PROTECTOR", PODER_DE_PELEA, DISTANCIA_DE_ATAQUE, VELOCIDAD, COSTO_KI);
		// TODO Auto-generated constructor stub
	}

	public void transformarse(Personaje piccolo)
			throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario, NoRealizoLosAtaquesEspecialesNecesarias {
		piccolo.companeroMenosVida("GOHAN", 20);
		super.transformarse(piccolo);

	}

}
