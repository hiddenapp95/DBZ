package modelo.juego;

import modelo.consumibles.Consumible;
import modelo.consumibles.EsferaDelDragon;
import modelo.consumibles.NubeVoladora;
import modelo.consumibles.SemillaDelErmitanio;
import modelo.excepciones.YaSeRealizoUnAtaqueEnEsteTurno;
import modelo.excepciones.YaSeRealizoUnMovimientoEnEsteTurno;
import modelo.personajes.Equipo;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;


public class Turno {

    Equipo equipoActual;
    Equipo equipoDeshabilitado;
    Tierra tierra;
    private static int MAX_ATAQUES =1;
    private static int MAX_MOVIMIENTOS =1;
    int cantidadDeAtaques;
    int cantidadDeMovimientos;
    LinkedList<Consumible> consumiblesDisponibles;

    public Turno(Equipo guerrerosZ, Equipo enemigosDeLatierra,Tierra tierra){
    	this.equipoActual = guerrerosZ;
    	this.equipoDeshabilitado = enemigosDeLatierra;
    	this.tierra = tierra;
    	this.consumiblesDisponibles = new LinkedList<>();
    	this.consumiblesDisponibles.addLast(new SemillaDelErmitanio());
    	this.consumiblesDisponibles.addLast(new EsferaDelDragon());
    	this.consumiblesDisponibles.addLast(new NubeVoladora());
        if(Math.random()<0.5){
            swapEquipos();
        }
        this.restaurarValores();
    }

    private void restaurarValores() {
    	this.cantidadDeAtaques=0;
        this.cantidadDeMovimientos=0;
	}

	public Equipo obtenerEquipoActual(){
        return equipoActual;
    }

    private void swapEquipos(){
        Equipo aux = equipoActual;
        equipoActual = equipoDeshabilitado;
        equipoDeshabilitado = aux;
    }
    public void cambiarTurno(){
        equipoActual.pasarTurno();
        //equipoDeshabilitado.pasarTurno();
        this.swapEquipos();
        this.restaurarValores();
        generarConsumibleRandom();
    }

    public void generarConsumibleRandom(){
        Random numeroRandom = new Random();
        float chance = numeroRandom.nextFloat();

        if (chance <= 0.10f){ //si va a aparecer un consumible
            int randomColumna = tierra.numeroDeColumnaRandom();
            int randomRow = tierra.numeroDeFilaRandom();
            Coordenada unaCoordenada = new Coordenada(randomRow,randomColumna);
            Consumible unConsumible = nuevoConsumibleRandom(consumiblesDisponibles);
            tierra.obtenerCasillero(unaCoordenada).addConsumible(unConsumible);
        }
    }

    public Consumible nuevoConsumibleRandom(LinkedList<Consumible> unaListaDeConsumibles){
        Random randomNumber = new Random();
        int index = randomNumber.nextInt(unaListaDeConsumibles.size());
        LinkedList<Consumible> listaCopia = new LinkedList<>(unaListaDeConsumibles);
        Collections.shuffle(listaCopia);
        return listaCopia.get(index);
    }

	public void nuevoAtaque() throws YaSeRealizoUnAtaqueEnEsteTurno {
		if(this.cantidadDeAtaques <MAX_ATAQUES) {
			this.cantidadDeAtaques =+ 1;
		}else {
			throw new YaSeRealizoUnAtaqueEnEsteTurno();
		}
		
	}
	public void realizoAtaque() throws YaSeRealizoUnAtaqueEnEsteTurno {
		if(this.cantidadDeAtaques ==MAX_ATAQUES)	throw new YaSeRealizoUnAtaqueEnEsteTurno();
	}
	
	public void nuevoMovimiento() throws YaSeRealizoUnMovimientoEnEsteTurno {
		if(this.cantidadDeMovimientos < MAX_MOVIMIENTOS) {
			this.cantidadDeMovimientos =+ 1;
		}else {
			throw new YaSeRealizoUnMovimientoEnEsteTurno();
		}
		
	}
	public void realizoMovimiento() throws YaSeRealizoUnMovimientoEnEsteTurno {
		if(this.cantidadDeMovimientos ==MAX_MOVIMIENTOS)	throw new YaSeRealizoUnMovimientoEnEsteTurno();
	}

	public String nombreEquipoActual(){
        return equipoActual.nombreDelEquipo();
    }

    public int cantidadDeEsferasDelDragonEquipoActual(){
	    return equipoActual.cantidadDeEsferasDelDragon();
    }

    public int movimientosRestantes(){
        return this.MAX_MOVIMIENTOS-cantidadDeMovimientos;
    }

    public int ataquesRestantes(){
        return this.MAX_ATAQUES-cantidadDeAtaques;
    }



}
