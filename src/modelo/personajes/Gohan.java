package modelo.personajes;

import modelo.aspectos.Aspecto;
import modelo.aspectos.GohanNormal;
import modelo.aspectos.SuperSayajinFase1;
import modelo.aspectos.SuperSayajinFase2;
import modelo.ataques.Basico;
import modelo.ataques.Masenko;
import modelo.excepciones.KiInsuficiente;
import modelo.excepciones.NoRealizoLosAtaquesEspecialesNecesarias;
import modelo.excepciones.PersonajeNoEstaDebajoDelPorcDeVidaNecesario;
import modelo.juego.Casillero;
import modelo.juego.Coordenada;
import modelo.juego.Tierra;

public class Gohan extends Personaje {

	private static int KI = 0;
	private static String NOMBRE = "GOHAN";
	private static int PUNTOS_DE_VIDA = 300;

	public Gohan(Casillero unCasillero, Equipo unEquipo) {
		super(NOMBRE, KI, PUNTOS_DE_VIDA, new GohanNormal(), new Basico(), new Masenko(),unCasillero, unEquipo);
		this.aspectos.add(new SuperSayajinFase1());
		this.aspectos.add(new SuperSayajinFase2());
		
	}

	public void transformarse(Aspecto unAspecto)
			throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario, NoRealizoLosAtaquesEspecialesNecesarias {
		unAspecto.transformarse(this);

	}

}
