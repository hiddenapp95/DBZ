package modelo.estados;

import modelo.excepciones.NoPuedeRealizarAccionEnEsteEstado;
import modelo.personajes.Personaje;

public class Inmovilizado extends Estado{

	
	private int turnosRestantes;
	private static String NOMBRE = "INMOVILIZADO";
	
	

	public Inmovilizado() {
		super(NOMBRE);
		this.turnosRestantes = 3;
	}

	public void incrementarKi(int cantidadDeKi,Personaje personaje) {
		
	}
	
	
	public void pasarTurno(Personaje personaje) {
		this.pasarTurnoConsumible(personaje);
		this.turnosRestantes -= 1;
		if(this.turnosRestantes==0) personaje.desinmovilizar();
		
	}
	
	public void atacar() {
		throw new NoPuedeRealizarAccionEnEsteEstado();
		
	}
	
	public void mover() {
		throw new NoPuedeRealizarAccionEnEsteEstado();
		
	}
	
	public void puedeAccionar() {
		// TODO Auto-generated method stub
		throw new NoPuedeRealizarAccionEnEsteEstado();
	}
}
