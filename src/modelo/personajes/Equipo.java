package modelo.personajes;

import java.util.HashMap;
import java.util.Vector;

import modelo.excepciones.PersonajeNoEstaDebajoDelPorcDeVidaNecesario;
import modelo.excepciones.PersonajeNoEstaEnEsteEquipo;
import modelo.juego.Casillero;

/**
 * Created by marianoogimenez on 10/6/17.
 */
public abstract class Equipo {
    private int cantidadDeEsferasDelDragon = 0;
    private HashMap<String,Personaje> miembrosDelEquipo = new HashMap<String, Personaje>();

    public void agregarPersonaje(Personaje personaje){
        miembrosDelEquipo.put(personaje.getNombre(), personaje);
    }

    public boolean contienePersonaje(Personaje unPersonaje){
        return miembrosDelEquipo.containsValue(unPersonaje);
    }

    public Personaje obtenerPersonaje(String nombrePersonaje){
    	if(!(this.miembrosDelEquipo.containsKey(nombrePersonaje))){throw new PersonajeNoEstaEnEsteEquipo();}
        return miembrosDelEquipo.get(nombrePersonaje);
    }



    public void sumarEsferaDelDragon(){
        cantidadDeEsferasDelDragon +=1;
    }
/*
    public void sumarKiAMiembros(int ki){
        for(Personaje personaje : miembrosDelEquipo.values()){
            personaje.incrementarKi(ki);
        }
    }*/

	public void pasarTurno() {
		for(Personaje personaje : miembrosDelEquipo.values()){
            personaje.pasarTurno();
        }
		
	}

	public boolean perdio() {
		for(Personaje personaje : miembrosDelEquipo.values()){
            if(personaje.sigoVivo()) {
            	return false;
            }
        }
		return true;
		
	}

	public void companeroMenosVida(String nombrePersonaje, int porcentajeVida) throws PersonajeNoEstaDebajoDelPorcDeVidaNecesario {
		Personaje personaje = this.obtenerPersonaje(nombrePersonaje);
		personaje.estaEnMenosDePorcentaje(porcentajeVida);

	}

	public abstract String nombreDelEquipo();

	public int cantidadDeEsferasDelDragon(){
	    return cantidadDeEsferasDelDragon;
    }

    public Vector<Casillero> obtenerPosicionDeMiembros(){
	    Vector<Casillero> casilleros = new Vector<Casillero>();
        for(Personaje personaje : miembrosDelEquipo.values()){
        	if(personaje.sigoVivo()) {
        		casilleros.add(personaje.obtenerCasillero());
        	}
        }
        return casilleros;
    }

}

