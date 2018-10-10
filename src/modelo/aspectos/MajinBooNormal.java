package modelo.aspectos;

import modelo.excepciones.KiInsuficiente;
import modelo.excepciones.NoRealizoLosAtaquesEspecialesNecesarias;
import modelo.excepciones.PersonajeNoEstaDebajoDelPorcDeVidaNecesario;
import modelo.personajes.Personaje;

public class MajinBooNormal extends Aspecto {

	private static final int PODER_DE_PELEA = 30;
	private static final int DISTANCIA_DE_ATAQUE = 2;
	private static final int VELOCIDAD = 2;
	private static final int COSTO_KI = 0;

	public MajinBooNormal() {
		super("NORMAL", PODER_DE_PELEA, DISTANCIA_DE_ATAQUE, VELOCIDAD, COSTO_KI);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void transformarse(Personaje majinBoo)
			throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario, NoRealizoLosAtaquesEspecialesNecesarias {
		super.transformarse(majinBoo);

	}
}
