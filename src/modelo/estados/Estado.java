package modelo.estados;

import modelo.consumibles.Consumible;
import modelo.personajes.Personaje;

import java.util.Vector;

public class Estado {

	private String nombre;
	
	public Estado(String nombre) {
		this.nombre = nombre;
	}
	

	public String obtenerNombre() {
		// TODO Auto-generated method stub
		return this.nombre;
	}

	public void pasarTurno(Personaje personaje) {
		personaje.incrementarKi(5);
		this.pasarTurnoConsumible(personaje);
		
	}
	
	public void pasarTurnoConsumible(Personaje personaje) {
		Vector<Consumible> consumiblesNoExpirados = new Vector<Consumible>();
		
		if(!personaje.obtenerConsumibles().isEmpty()){
			for(Consumible consumible : personaje.obtenerConsumibles()){
				consumible.pasarTurno();
				if(consumible.expiro()){
					consumible.deshacerEfecto(personaje);
					continue;
				}
				consumiblesNoExpirados.add(consumible);
			}
			personaje.nuevosConsumibles(consumiblesNoExpirados);
		}
	}

	public boolean sigoVivo() {
		// TODO Auto-generated method stub
		return true;
	}


	public void atacar() {
		// TODO Auto-generated method stub
		
	}
	
	public void mover() {
		// TODO Auto-generated method stub
		
	}


	public void puedeAccionar() {
		// TODO Auto-generated method stub

	}
}
