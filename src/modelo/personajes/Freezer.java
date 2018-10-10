package modelo.personajes;

import modelo.aspectos.Aspecto;
import modelo.aspectos.Definitivo;
import modelo.aspectos.FreezerNormal;
import modelo.aspectos.SegundaForma;
import modelo.ataques.Basico;
import modelo.ataques.RayoMortal;
import modelo.excepciones.KiInsuficiente;
import modelo.excepciones.NoRealizoLosAtaquesEspecialesNecesarias;
import modelo.excepciones.PersonajeNoEstaDebajoDelPorcDeVidaNecesario;
import modelo.juego.Casillero;
import modelo.juego.Coordenada;
import modelo.juego.Tierra;

public class Freezer extends Personaje {

	private static int KI = 0;
	private static String NOMBRE = "FREEZER";
	private static int PUNTOS_DE_VIDA = 400;
	
	
	public Freezer(Casillero unCasillero, Equipo unEquipo) {
		super(NOMBRE, KI, PUNTOS_DE_VIDA, new FreezerNormal(), new Basico(), new RayoMortal(), unCasillero, unEquipo);
		this.aspectos.add(new SegundaForma());
		this.aspectos.add(new Definitivo());
	}

	public void transformarse(Aspecto unAspecto)
			throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario, NoRealizoLosAtaquesEspecialesNecesarias {
		unAspecto.transformarse(this);

	}

}
