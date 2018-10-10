package modelo.personajes;

import modelo.aspectos.Aspecto;
import modelo.aspectos.Fortalecido;
import modelo.aspectos.PiccoloNormal;
import modelo.aspectos.Protector;
import modelo.ataques.Basico;
import modelo.ataques.Makankosappo;
import modelo.excepciones.KiInsuficiente;
import modelo.excepciones.NoRealizoLosAtaquesEspecialesNecesarias;
import modelo.excepciones.PersonajeNoEstaDebajoDelPorcDeVidaNecesario;
import modelo.juego.Casillero;
import modelo.juego.Coordenada;
import modelo.juego.Tierra;

public class Piccolo extends Personaje {

	private static int KI = 0;
	private static String NOMBRE = "PICCOLO";
	private static int PUNTOS_DE_VIDA = 500;

	public Piccolo(Casillero unCasillero, Equipo unEquipo) {
		super(NOMBRE, KI, PUNTOS_DE_VIDA, new PiccoloNormal(), new Basico(), new Makankosappo(), unCasillero, unEquipo);
		this.aspectos.add(new Fortalecido());
		this.aspectos.add(new Protector());
	}

	public void transformarse(Aspecto aspecto)
			throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario, NoRealizoLosAtaquesEspecialesNecesarias {
		aspecto.transformarse(this);

	}

}
