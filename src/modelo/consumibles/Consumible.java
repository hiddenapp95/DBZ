package modelo.consumibles;

import modelo.personajes.Personaje;

/**
 * Created by Franco on 6/11/2017.
 */
public abstract class Consumible {
    protected int cantidadDeUsosRestantes;
    protected Personaje personaje;
    protected String nombre;

    public void pasarTurno(){}
    public abstract void aplicarConsumible(Personaje unPersonaje);
    public void usar(){
        cantidadDeUsosRestantes -= 1;
    }
    public void deshacerEfecto(Personaje unPersonaje){}
    public boolean expiro(){
        return (cantidadDeUsosRestantes == 0);
    }
    public String obtenerNombre(){ return nombre;}
    
    
}
