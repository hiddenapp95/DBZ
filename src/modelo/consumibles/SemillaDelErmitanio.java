package modelo.consumibles;

import modelo.personajes.Personaje;

/**
 * Created by Franco on 6/11/2017.
 */
public class SemillaDelErmitanio extends Consumible {
    private static int AUMENTO_DE_VIDA = 100;


    public SemillaDelErmitanio(){
        cantidadDeUsosRestantes = 0;
        nombre = "SEMILLA DEL ERMITANIO";
    }
    @Override
    public void aplicarConsumible(Personaje unPersonaje) {
        unPersonaje.aumentarVida(AUMENTO_DE_VIDA);
        personaje = unPersonaje;
    }
}
