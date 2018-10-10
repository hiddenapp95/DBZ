package modelo.juego;

import modelo.excepciones.CasilleroOcupado;
import modelo.excepciones.CasilleroVacio;
import modelo.personajes.Gohan;
import modelo.personajes.Goku;
import modelo.personajes.GuerrerosZ;
import modelo.personajes.Personaje;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by marianoogimenez on 4/6/17.
 */
public class CasilleroTest {
    @Test
    public void crearEspacioYVerQueEstaVacio(){
        Casillero casillero = new Casillero();
        assertTrue(!casillero.tienePersonaje());
    }

    @Test (expected = CasilleroVacio.class)
    public void obtenerPersonajeEnEspacioVacioLanzaExcepcion(){
        Casillero casillero = new Casillero();
        casillero.getPersonaje();
    }

    @Test
    public void agregarPersonajeYObtenerlo(){
        Casillero casillero = new Casillero();
        Personaje goku = new Goku(casillero,new GuerrerosZ());
        assertEquals(goku, casillero.getPersonaje());
        assertTrue(casillero.tienePersonaje());
    }

    @Test
    public void agregarPersonajeYBorrarlo(){
        Casillero casillero = new Casillero();
        Personaje goku = new Goku(casillero,new GuerrerosZ());
        casillero.removeCharacter();
        assertTrue(!casillero.tienePersonaje());
    }

    @Test (expected = CasilleroOcupado.class)
    public void agregarPersonajeEnElMismoEspacioQueOtroLanzaExcepcion(){
        Casillero casillero = new Casillero();
        Personaje goku = new Goku(casillero,new GuerrerosZ());
        Personaje gohan = new Gohan(casillero,new GuerrerosZ());
    }

}
