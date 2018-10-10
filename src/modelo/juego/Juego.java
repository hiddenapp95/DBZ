package modelo.juego;

import java.util.Vector;

import modelo.excepciones.AtaqueFueraDeRango;
import modelo.excepciones.AunNoHayEquipoGanador;
import modelo.excepciones.KiInsuficiente;
import modelo.excepciones.LaVelocidadNoAlcanzaParaMoverseEstaDistancia;
import modelo.excepciones.MovimientoInvalido;
import modelo.excepciones.YaSeRealizoUnAtaqueEnEsteTurno;
import modelo.excepciones.YaSeRealizoUnMovimientoEnEsteTurno;
import modelo.personajes.Cell;
import modelo.personajes.EnemigosDeLaTierra;
import modelo.personajes.Equipo;
import modelo.personajes.Freezer;
import modelo.personajes.Gohan;
import modelo.personajes.Goku;
import modelo.personajes.GuerrerosZ;
import modelo.personajes.MajinBoo;
import modelo.personajes.Personaje;
import modelo.personajes.Piccolo;

public class Juego {

	private Tierra tierra;
	private Turno turno;
	Equipo equipoGanador = null;
	private Equipo guerrerosZ;
	private Equipo enemigosDeLatierra;

	public Juego() {
		this.tierra = new Tierra();
		this.guerrerosZ = new GuerrerosZ();
		this.enemigosDeLatierra = new EnemigosDeLaTierra();
		this.turno = new Turno(this.guerrerosZ, this.enemigosDeLatierra, tierra);
		this.crearPersonajesEnTierra();

	}

	private void crearPersonajesEnTierra() {
		Goku goku = new Goku(tierra.obtenerCasillero(new Coordenada(0, 0)), this.guerrerosZ);
		Gohan gohan = new Gohan(tierra.obtenerCasillero(new Coordenada(0, 1)), this.guerrerosZ);
		Piccolo piccolo = new Piccolo(tierra.obtenerCasillero(new Coordenada(1, 0)), this.guerrerosZ);
		Cell cell = new Cell(tierra.obtenerCasillero(new Coordenada(tierra.getLastRow(), tierra.getLastColumn())),
				this.enemigosDeLatierra);
		MajinBoo majinBoo = new MajinBoo(
				tierra.obtenerCasillero(new Coordenada(tierra.getLastRow() - 1, tierra.getLastColumn())),
				this.enemigosDeLatierra);
		Freezer freezer = new Freezer(
				tierra.obtenerCasillero(new Coordenada(tierra.getLastRow(), tierra.getLastColumn() - 1)),
				this.enemigosDeLatierra);
	}

	public void ataqueBasico(Personaje personajeAgresor, Personaje personajeAAtacar)
			throws YaSeRealizoUnAtaqueEnEsteTurno {

		Equipo equipoContrincante = verificarAtaque(personajeAgresor, personajeAAtacar);

		personajeAgresor.atacar(personajeAAtacar);
		verificarGanadorLuegoDeAtaque(equipoContrincante);

	}

	public void ataqueEspecial(Personaje personajeAgresor, Personaje personajeAAtacar)
			throws YaSeRealizoUnAtaqueEnEsteTurno, KiInsuficiente {

		Equipo equipoContrincante = verificarAtaque(personajeAgresor, personajeAAtacar);

		personajeAgresor.ataqueEspecial(personajeAAtacar);
		
		verificarGanadorLuegoDeAtaque(equipoContrincante);

	}

	private void verificarGanadorLuegoDeAtaque(Equipo equipoContrincante) throws YaSeRealizoUnAtaqueEnEsteTurno {
		//Sumo un nuevo ataque en turno y verifico si hay algun ganador
		this.turno.nuevoAtaque();
		if (equipoContrincante.perdio()) {
			this.equipoGanador = turno.obtenerEquipoActual();
		}
	}

	private Equipo verificarAtaque(Personaje personajeAgresor, Personaje personajeAAtacar)
			throws YaSeRealizoUnAtaqueEnEsteTurno {
		//verifica que no exeda de los ataques por turno, que pueda atacar dentro del limite de ataque
		//Si pasan esas validaciones devuelve el equipo contrincante, de lo contrario lanza error.
		Equipo equipoContrincante = personajeAAtacar.obtenerEquipo();
	
		if (!tierra.coordenadasEstanEnRadio(personajeAgresor.obtenerCoordenada(), personajeAAtacar.obtenerCoordenada(),
				personajeAgresor.obtenerDistanciaDeAtaque())) {
			throw new AtaqueFueraDeRango();
		}
		this.turno.realizoAtaque(); //Lanza error si excede de los ataques por turno
		return equipoContrincante;
	}

	public void mover(Personaje personajeAMover, Casillero unCasillero)
			throws YaSeRealizoUnMovimientoEnEsteTurno, LaVelocidadNoAlcanzaParaMoverseEstaDistancia {
		Equipo equipoActual = personajeAMover.obtenerEquipo();
		
		tierra.puedoMoverPersonajeACasillero(personajeAMover,unCasillero);//lanza error si no se puede mover a ese casillero
		
		this.turno.realizoMovimiento();
		personajeAMover.moverseACasillero(unCasillero);
		this.turno.nuevoMovimiento();
		if (equipoActual.cantidadDeEsferasDelDragon() == 7) {
			this.equipoGanador = turno.obtenerEquipoActual();
		}
	}

	public Equipo equipoGanador() throws AunNoHayEquipoGanador {
		if (this.equipoGanador == null)
			throw new AunNoHayEquipoGanador();
		return this.equipoGanador;
	}

	public Vector<Casillero> casillerosALosQuePuedeMoverse(Coordenada unaCoordenada) {
		Personaje personajeAMover = this.tierra.obtenerPersonaje(unaCoordenada);
		return this.tierra.casillerosEnLineaRectaADistancia(unaCoordenada, personajeAMover.obtenerVelocidad());
	}

	public Vector<Casillero> casillerosALosQuePuedeAtacar(Coordenada unaCoordenada) {
		Personaje personajeAMover = this.tierra.obtenerPersonaje(unaCoordenada);
		return this.tierra.espaciosOcupadosEnRadio(unaCoordenada, personajeAMover.obtenerDistanciaDeAtaque());
	}

	public void pasarTurno() {
		this.turno.cambiarTurno();
	}

	public Tierra obtenerTierra() {
		return tierra;
	}

	public Turno obtenerTurno() {
		return turno;
	}

	public Vector<Casillero> obtenerPosicionDeMiembrosDelEquipoActual() {
		Equipo equipoActual = turno.obtenerEquipoActual();
		return equipoActual.obtenerPosicionDeMiembros();
	}

}
