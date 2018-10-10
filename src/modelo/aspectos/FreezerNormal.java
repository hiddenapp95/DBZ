package modelo.aspectos;

import modelo.excepciones.KiInsuficiente;
import modelo.excepciones.NoRealizoLosAtaquesEspecialesNecesarias;
import modelo.excepciones.PersonajeNoEstaDebajoDelPorcDeVidaNecesario;
import modelo.personajes.Personaje;

public class FreezerNormal extends Aspecto {

	private static final int PODER_DE_PELEA = 20;
	private static final int DISTANCIA_DE_ATAQUE = 2;
	private static final int VELOCIDAD = 4;
	private static final int COSTO_KI = 0;

	public FreezerNormal() {
		super("NORMAL", PODER_DE_PELEA, DISTANCIA_DE_ATAQUE, VELOCIDAD, COSTO_KI);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void transformarse(Personaje freezer)
			throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario, NoRealizoLosAtaquesEspecialesNecesarias {
		super.transformarse(freezer);

	}

}
