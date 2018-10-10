package modelo.personajes;

import modelo.aspectos.Aspecto;
import modelo.aspectos.BooMalo;
import modelo.aspectos.BooOriginal;
import modelo.aspectos.MajinBooNormal;
import modelo.ataques.Basico;
import modelo.ataques.ConvertirEnChocolate;
import modelo.excepciones.KiInsuficiente;
import modelo.excepciones.NoRealizoLosAtaquesEspecialesNecesarias;
import modelo.excepciones.PersonajeNoEstaDebajoDelPorcDeVidaNecesario;
import modelo.juego.Casillero;
import modelo.juego.Coordenada;
import modelo.juego.Tierra;

public class MajinBoo extends Personaje {

	private static int KI = 0;
	private static String NOMBRE = "MAJIN BOO";
	private static int PUNTOS_DE_VIDA = 300;
	
	public MajinBoo(Casillero unCasillero, Equipo unEquipo) {
		super(NOMBRE, KI, PUNTOS_DE_VIDA, new MajinBooNormal(), new Basico(), new ConvertirEnChocolate(), unCasillero,
				unEquipo);
		this.aspectos.add(new BooMalo());
		this.aspectos.add(new BooOriginal());
	}

	public void transformarse(Aspecto unAspecto)
			throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario, NoRealizoLosAtaquesEspecialesNecesarias {
		unAspecto.transformarse(this);

	}
}
