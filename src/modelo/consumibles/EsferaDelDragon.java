package modelo.consumibles;

import modelo.personajes.Equipo;
import modelo.personajes.Personaje;

/**
 * Created by Franco on 6/11/2017.
 */
public class EsferaDelDragon extends Consumible {

    public EsferaDelDragon(){
        cantidadDeUsosRestantes = 2;
        nombre = "ESFERA DEL DRAGON";
    }

    public void aplicarConsumible(Personaje unPersonaje){
        sumarEsferaDelDragonAEquipo(unPersonaje.obtenerEquipo());
        personaje = unPersonaje;

    }

    public void sumarEsferaDelDragonAEquipo(Equipo unEquipo){
        unEquipo.sumarEsferaDelDragon();
    }

}
