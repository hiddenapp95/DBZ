package modelo.consumibles;

import modelo.personajes.Personaje;

/**
 * Created by Franco on 6/11/2017.
 */
public class NubeVoladora extends Consumible{
    public int aumento;

    public NubeVoladora(){
        cantidadDeUsosRestantes = 3;
        nombre = "NUBE VOLADORA";
    }

    public void pasarTurno(){
        usar();
    }

    public void aplicarConsumible(Personaje unPersonaje){
        aumento = unPersonaje.obtenerVelocidad();
        unPersonaje.aumentarVelocidad(aumento);
        personaje = unPersonaje;
    }

    public void deshacerEfecto(Personaje unPersonaje){
        unPersonaje.restarVelocidad(aumento);
    }
}
