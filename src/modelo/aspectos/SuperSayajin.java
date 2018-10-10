package modelo.aspectos;

import modelo.excepciones.KiInsuficiente;
import modelo.excepciones.NoRealizoLosAtaquesEspecialesNecesarias;
import modelo.excepciones.PersonajeNoEstaDebajoDelPorcDeVidaNecesario;
import modelo.personajes.Personaje;

public class SuperSayajin extends Aspecto {


	private static final int PODER_DE_PELEA = 60;
	private static final int DISTANCIA_DE_ATAQUE = 4;
	private static final int VELOCIDAD = 5;
	private static final int COSTO_KI = 50;
	
	public SuperSayajin() {
		super("SUPER SAYAJIN", PODER_DE_PELEA, DISTANCIA_DE_ATAQUE, VELOCIDAD, COSTO_KI);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void transformarse(Personaje goku)
			throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario, NoRealizoLosAtaquesEspecialesNecesarias {
		super.transformarse(goku);
		
	}
	
	
}
