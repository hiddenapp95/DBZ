package modelo.personajes;

import modelo.aspectos.Aspecto;
import modelo.aspectos.GokuNormal;
import modelo.aspectos.KaioKen;
import modelo.aspectos.SuperSayajin;
import modelo.ataques.Basico;
import modelo.ataques.Kamehameha;
import modelo.excepciones.KiInsuficiente;
import modelo.excepciones.NoRealizoLosAtaquesEspecialesNecesarias;
import modelo.excepciones.PersonajeNoEstaDebajoDelPorcDeVidaNecesario;
import modelo.juego.Casillero;
import modelo.juego.Coordenada;
import modelo.juego.Tierra;

public class Goku extends Personaje {

	private static int KI = 0;
	private static String NOMBRE = "GOKU";
	private static int PUNTOS_DE_VIDA = 500;

	public Goku(Casillero unCasillero, Equipo unEquipo) {
		super(NOMBRE, KI, PUNTOS_DE_VIDA, new GokuNormal(), new Basico(), new Kamehameha(),unCasillero, unEquipo);
		this.aspectos.add(new KaioKen());
		this.aspectos.add(new SuperSayajin());
	}

	public int obtenerPoderDePelea() {
		int poderDePelea = aspecto.obtenerPoderDePelea();
		if (obtenerPuntosDeVida() < PUNTOS_DE_VIDA * 0.3) {
			poderDePelea *= 1.2;
		}
		return poderDePelea;
	}

	public void transformarse(Aspecto unAspecto)
			throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario, NoRealizoLosAtaquesEspecialesNecesarias {
		unAspecto.transformarse(this);

	}

}
