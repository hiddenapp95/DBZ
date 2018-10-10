package modelo.aspectos;

import modelo.excepciones.KiInsuficiente;
import modelo.excepciones.NoRealizoLosAtaquesEspecialesNecesarias;
import modelo.excepciones.PersonajeNoEstaDebajoDelPorcDeVidaNecesario;
import modelo.personajes.Personaje;

public class Perfecto extends Aspecto {

	private static final int PODER_DE_PELEA = 80;
	private static final int DISTANCIA_DE_ATAQUE = 4;
	private static final int VELOCIDAD = 4;
	private static final int COSTO_KI = 0;
	private static final int CANTIDAD_DE_ABSORCIONES = 8;

	public Perfecto() {
		super("PERFECTO", PODER_DE_PELEA, DISTANCIA_DE_ATAQUE, VELOCIDAD, COSTO_KI);
		// TODO Auto-generated constructor stub
	}

	public void transformarse(Personaje cell)
			throws KiInsuficiente, NoRealizoLosAtaquesEspecialesNecesarias, PersonajeNoEstaDebajoDelPorcDeVidaNecesario {
		cell.realizoCantidadDeAtaquesEspeciales(CANTIDAD_DE_ABSORCIONES);
		super.transformarse(cell);
	}

}
