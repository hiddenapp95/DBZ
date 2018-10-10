package modelo.personajes;

import modelo.aspectos.Aspecto;
import modelo.aspectos.CellNormal;
import modelo.aspectos.Perfecto;
import modelo.aspectos.SemiPerfecto;
import modelo.ataques.Absorber;
import modelo.ataques.Basico;
import modelo.excepciones.KiInsuficiente;
import modelo.excepciones.NoRealizoLosAtaquesEspecialesNecesarias;
import modelo.excepciones.PersonajeNoEstaDebajoDelPorcDeVidaNecesario;
import modelo.juego.Casillero;
import modelo.juego.Coordenada;
import modelo.juego.Tierra;

public class Cell extends Personaje {

	private static int KI = 0;
	private static String NOMBRE = "CELL";
	private static int PUNTOS_DE_VIDA = 500; 

	public Cell(Casillero unCasillero, Equipo unEquipo) {
		super(NOMBRE, KI, PUNTOS_DE_VIDA, new CellNormal(), new Basico(), new Absorber(), unCasillero, unEquipo);
		this.aspectos.add(new SemiPerfecto());
		this.aspectos.add(new Perfecto());
	}

	public void ataqueEspecial(Personaje unPersonaje) throws KiInsuficiente {
		super.ataqueEspecial(unPersonaje);
		this.cantidadDeAtaquesEspecialesRealizados += 1;
		if(this.puntosDeVida + this.obtenerPoderDePelea() > this.obtenerPuntosDeVidaInicial()){
			this.puntosDeVida = this.obtenerPuntosDeVidaInicial();
			return;
		}
		this.puntosDeVida += this.obtenerPoderDePelea();
	}

	public void transformarse(Aspecto unAspecto)
			throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario, NoRealizoLosAtaquesEspecialesNecesarias {
		unAspecto.transformarse(this);

	}

	

}
