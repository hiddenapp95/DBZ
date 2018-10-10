package modelo.personajes;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import modelo.aspectos.Aspecto;
import modelo.ataques.Ataque;
import modelo.consumibles.Consumible;
import modelo.estados.Estado;
import modelo.estados.Inmovilizado;
import modelo.estados.Muerto;
import modelo.estados.Vivo;
import modelo.excepciones.JugadorInvalido;
import modelo.excepciones.KiInsuficiente;
import modelo.excepciones.LaVelocidadNoAlcanzaParaMoverseEstaDistancia;
import modelo.excepciones.NoRealizoLosAtaquesEspecialesNecesarias;
import modelo.excepciones.PersonajeNoEstaDebajoDelPorcDeVidaNecesario;
import modelo.excepciones.PersonajesDeUnMismoEquipoNoPuedenAtacarse;
import modelo.juego.Casillero;
import modelo.juego.Coordenada;

public abstract class Personaje {

	private int ki;
	private String nombre;
	private int puntosDeVidaInicial;
	protected double puntosDeVida;
	protected Aspecto aspecto;
	private Ataque ataqueBasico;
	protected Ataque ataqueEspecial;
	private Casillero casillero;
	protected Estado estadoActual;
	protected Equipo equipo;
	private Vector<Consumible> consumibles;
	protected List<Aspecto> aspectos;
	protected int cantidadDeAtaquesEspecialesRealizados;

	public Personaje(String nombre, int ki, int puntosDeVida, Aspecto aspecto, Ataque ataqueBasico,
			Ataque ataqueEspecial, Casillero unCasillero, Equipo unEquipo) {
		this.ki = ki;
		this.nombre = nombre;
		this.puntosDeVidaInicial = puntosDeVida;
		this.puntosDeVida = puntosDeVida;
		this.aspecto = aspecto;
		this.ataqueBasico = ataqueBasico;
		this.ataqueEspecial = ataqueEspecial;
		this.casillero = unCasillero;
		unCasillero.addCharacter(this);
		this.estadoActual = new Vivo();
		this.incorporarPersonajeAEquipo(unEquipo);
		this.consumibles = new Vector<Consumible>();
		this.aspectos = new ArrayList<Aspecto>();
		aspectos.add(aspecto);
		this.cantidadDeAtaquesEspecialesRealizados = 0;
	}

	public Casillero obtenerCasillero() {
		return this.casillero;
	}

	public void setCasillero(Casillero unCasillero) {
		this.casillero = unCasillero;
	}

	public void setEstado(Aspecto nuevoEstado) {
		this.aspecto = nuevoEstado;
	}

	public void increaseKi(int cantidadDeKi) {
		this.ki = this.ki + cantidadDeKi;
	}

	public double obtenerPuntosDeVida() {
		return this.puntosDeVida;
	}

	public int obtenerKi() {
		return this.ki;
	}

	public String obtenerNombreDeAspecto() {
		return this.aspecto.obtenerNombre();
	}

	public void aumentarVelocidad(int aumentoDeVelocidad) {
		this.aspecto.aumentarVelocidad(aumentoDeVelocidad);
	}

	public void restarVelocidad(int restoDeVelocidad) {
		this.aspecto.disminuirVelocidad(restoDeVelocidad);
	}

	public void aumentarAtaque(int aumentoDeAtaque) {
		this.aspecto.aumentarPoderDePelea(aumentoDeAtaque);
	}

	public void restarAtaque(int restoDeAtaque) {
		this.aspecto.disminuirPoderDePelea(restoDeAtaque);
	}

	public int obtenerPoderDePelea() {
		return this.aspecto.obtenerPoderDePelea();
	}

	public int obtenerDistanciaDeAtaque() {
		return this.aspecto.obtenerDistanciaDeAtaque();
	}

	public int obtenerVelocidad() {
		return aspecto.obtenerVelocidad();
	}

	public void cambiarDeAspecto(Aspecto unAspecto) {
		this.aspecto = unAspecto;

	}

	public int obtenerPuntosDeVidaInicial(){
		return puntosDeVidaInicial;
	}

	public void usarKi(int costoKi) throws KiInsuficiente {
		if (this.ki < costoKi) {
			throw new KiInsuficiente();
		}
		this.ki -= costoKi;

	}

	public void incrementarKi(int ki) {
		this.ki += ki;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void quitarVida(double puntosDePoder) {
		this.puntosDeVida -= puntosDePoder;
		this.verificoSiMurio();

	}

	private void verificoSiMurio() {
		if (this.puntosDeVida <= 0) {
			this.puntosDeVida = 0; // para que el porcentaje me de correctamente.
			this.estadoActual = new Muerto();
			this.casillero.removeCharacter();
			this.casillero = null; 
		}

	}

	public void moverseACasillero(Casillero unCasillero) throws LaVelocidadNoAlcanzaParaMoverseEstaDistancia {
		if (unCasillero.obtenerDistancia(this.casillero) > this.aspecto.obtenerVelocidad()) {
			throw new LaVelocidadNoAlcanzaParaMoverseEstaDistancia();
		}
		this.estadoActual.mover();
		unCasillero.addCharacter(this);
		this.casillero.removeCharacter();
		this.casillero = unCasillero;
	}
	
	public void atacar(Personaje unPersonaje) {
		this.puedoAtacar(unPersonaje);
		this.ataqueBasico.realizar(this, unPersonaje);
	}

	public void ataqueEspecial(Personaje unPersonaje) throws KiInsuficiente {
		this.puedoAtacar(unPersonaje);
		this.usarKi(this.ataqueEspecial.obtenerCostoKi());
		this.ataqueEspecial.realizar(this, unPersonaje);
	}
	
	private void puedoAtacar(Personaje unPersonaje) {
		this.ataqueACompaniero(unPersonaje);
		this.estadoActual.atacar();
	}
	
	private void ataqueACompaniero(Personaje unPersonaje) {
		if (this.esCompanieroDe(unPersonaje)) {
			throw new PersonajesDeUnMismoEquipoNoPuedenAtacarse();
		}
	}

	public void estaEnMenosDePorcentaje(int unPorcentaje) throws PersonajeNoEstaDebajoDelPorcDeVidaNecesario {
		double porcentajeActual = ((puntosDeVida * 100 / puntosDeVidaInicial));
		if (!(porcentajeActual < unPorcentaje)) {
			throw new PersonajeNoEstaDebajoDelPorcDeVidaNecesario();
		}
	}

	public void inmovilizar() {
		this.estadoActual = new Inmovilizado();
	}

	public String obtenerEstadoActual() {
		return this.estadoActual.obtenerNombre();
	}

	public Equipo obtenerEquipo() {
		return equipo;
	}

	public boolean esCompanieroDe(Personaje otroPersonaje) {
		return equipo.contienePersonaje(otroPersonaje);
	}

	public Vector<Consumible> obtenerConsumibles() {
		return this.consumibles;
	}

	public Vector<Consumible> obtenerEsferasDelDragon() {
		Vector<Consumible> esferasDelDragon = new Vector<Consumible>();
		for (Consumible consumible : consumibles) {
			if (consumible.obtenerNombre() == "ESFERA DEL DRAGON") {
				esferasDelDragon.add(consumible);
			}
		}
		return esferasDelDragon;
	}

	public void agarrarConsumible(Consumible unConsumible) {
		this.consumibles.add(unConsumible);
		unConsumible.aplicarConsumible(this);
	}

	public void aumentarVida(int aumentoDeVida) {
		if (this.puntosDeVida + aumentoDeVida >= this.puntosDeVidaInicial) {
			this.puntosDeVida = this.puntosDeVidaInicial;
			return;
		}
			this.puntosDeVida += aumentoDeVida;
	}

	public void pasarTurno() {
		this.estadoActual.pasarTurno(this);
		
	}

	public void desinmovilizar() {
		
		this.estadoActual = new Vivo();

	}

	public boolean sigoVivo() {
		return this.estadoActual.sigoVivo();
	}

	public void companeroMenosVida(String nombrePersonaje, int porcentajeVida)
			throws PersonajeNoEstaDebajoDelPorcDeVidaNecesario {
		this.equipo.companeroMenosVida(nombrePersonaje, porcentajeVida);
	}

	public void incorporarPersonajeAEquipo(Equipo unEquipo) {
		this.equipo = unEquipo;
		this.equipo.agregarPersonaje(this);
	}

	public void nuevosConsumibles(Vector<Consumible> nuevosConsumibles) {
		consumibles = nuevosConsumibles;
	}

	public String nombreDeEquipoAlQuePertenece() {
		return this.equipo.nombreDelEquipo();
	}


	public Coordenada obtenerCoordenada() {
		return casillero.obtenerCoordenada();
	}

	public abstract void transformarse(Aspecto unAspecto)
			throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario, NoRealizoLosAtaquesEspecialesNecesarias;	

	public List<Aspecto> obtenerTransformaciones() {
		return this.aspectos;
	}

	public Aspecto obtenerAspecto(){
		return this.aspecto;
	}

	public String obtenerNombreAtaqueBasico(){
		return this.ataqueBasico.nombre;
	}

	public int obtenerCostoAtaqueBasico(){
		return this.ataqueBasico.obtenerCostoKi();
	}

	public String obtenerNombreAtaqueEspecial(){
		return this.ataqueEspecial.nombre;
	}

	public int obtenerCostoAtaqueEspecial(){
		return this.ataqueEspecial.obtenerCostoKi();
	}

	public void puedeAccionar() {
		this.estadoActual.puedeAccionar();
	}

	public void realizoCantidadDeAtaquesEspeciales(int cantidad) throws NoRealizoLosAtaquesEspecialesNecesarias {
		if (!(this.cantidadDeAtaquesEspecialesRealizados >= cantidad)) {
			throw new NoRealizoLosAtaquesEspecialesNecesarias();
		}
	}

	public int obtenerPorcentajeDeVida() {
		return (int)((puntosDeVida/puntosDeVidaInicial)*100);

	}
}