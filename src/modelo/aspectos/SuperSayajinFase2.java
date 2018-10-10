package modelo.aspectos;

import modelo.excepciones.KiInsuficiente;
import modelo.excepciones.NoRealizoLosAtaquesEspecialesNecesarias;
import modelo.excepciones.PersonajeNoEstaDebajoDelPorcDeVidaNecesario;
import modelo.personajes.Personaje;

public class SuperSayajinFase2 extends Aspecto {

	private static final int PODER_DE_PELEA = 100;
	private static final int DISTANCIA_DE_ATAQUE = 4;
	private static final int VELOCIDAD = 3;
	private static final int COSTO_KI = 30;

	public SuperSayajinFase2() {
		super("SUPER SAYAJIN FASE 2", PODER_DE_PELEA, DISTANCIA_DE_ATAQUE, VELOCIDAD, COSTO_KI);
		// TODO Auto-generated constructor stub
	}

	public void transformarse(Personaje gohan)
			throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario, NoRealizoLosAtaquesEspecialesNecesarias {
		gohan.companeroMenosVida("GOKU", 20);
		gohan.companeroMenosVida("PICCOLO", 20);
		super.transformarse(gohan);

	}

}
