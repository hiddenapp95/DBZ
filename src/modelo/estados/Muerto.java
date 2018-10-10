package modelo.estados;

import modelo.excepciones.NoPuedeRealizarAccionEnEsteEstado;

public class Muerto extends Estado {

	public Muerto() {
		super("MUERTO");
		
	}
	
	public boolean sigoVivo() {
		// TODO Auto-generated method stub
		return false;
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
