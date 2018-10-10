package modelo.aspectos;

import modelo.excepciones.KiInsuficiente;
import modelo.excepciones.NoRealizoLosAtaquesEspecialesNecesarias;
import modelo.excepciones.PersonajeNoEstaDebajoDelPorcDeVidaNecesario;
import modelo.personajes.Personaje;

public class KaioKen extends Aspecto {

	private static final int PODER_DE_PELEA = 40;
	private static final int DISTANCIA_DE_ATAQUE = 4;
	private static final int VELOCIDAD = 3;
	private static final int COSTO_KI = 20;

	public KaioKen() {
		super("KAIO KEN", PODER_DE_PELEA, DISTANCIA_DE_ATAQUE, VELOCIDAD, COSTO_KI);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void transformarse(Personaje goku)
			throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario, NoRealizoLosAtaquesEspecialesNecesarias {
		super.transformarse(goku);

	}
}
