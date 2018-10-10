package modelo.juego;

import modelo.excepciones.CoordinatesNotInTierra;
import modelo.personajes.EnemigosDeLaTierra;
import modelo.personajes.Freezer;
import modelo.personajes.Goku;
import modelo.personajes.GuerrerosZ;
import modelo.personajes.Personaje;
import org.junit.Test;

import java.util.Vector;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by marianoogimenez on 4/6/17.
 */
public class TierraTest {

    @Test
    public void obtenerPersonajeDeUnaPosicion(){
        Tierra tierra = new Tierra();
        Coordenada coordenada = new Coordenada(6,7);
        Personaje freezer = new Freezer(tierra.obtenerCasillero(coordenada), new EnemigosDeLaTierra());
        assertEquals(freezer, tierra.obtenerPersonaje(coordenada));

    }

    @Test (expected = CoordinatesNotInTierra.class)
    public void obtenerPersonajeDeUnaPosicionQueNoExisteLanzaExcepcion(){

        Tierra tierra = new Tierra();
        Coordenada unasCoordenada = new Coordenada(9000,90000);
        tierra.obtenerPersonaje(unasCoordenada);
    }

    @Test
    public void tierraNoContieneCordenadasFila1000yCol1000(){
        Tierra tierra = new Tierra();
        Coordenada coordenada = new Coordenada(5,5);
        assertTrue(tierra.contieneCoordenadas(coordenada));
        coordenada = new Coordenada(10000,1000);
        assertTrue(!tierra.contieneCoordenadas(coordenada));

    }
    @Test
    public void obtenerEspaciosQueEstanEnRadio1DeUnasCoordenadas(){
       Tierra tierra = new Tierra();
       Coordenada coordenada = new Coordenada(5,5);
       Vector<Casillero> casilleros = tierra.espaciosEnRadio(coordenada,1);
       assertEquals(8, casilleros.size());
       assertTrue(casilleros.contains(tierra.obtenerCasillero(new Coordenada(4,4))));
       assertTrue(casilleros.contains(tierra.obtenerCasillero(new Coordenada(4,5))));
       assertTrue(casilleros.contains(tierra.obtenerCasillero(new Coordenada(4,6))));
       assertTrue(casilleros.contains(tierra.obtenerCasillero(new Coordenada(5,4))));
       assertTrue(casilleros.contains(tierra.obtenerCasillero(new Coordenada(5,6))));
       assertTrue(casilleros.contains(tierra.obtenerCasillero(new Coordenada(6,4))));
       assertTrue(casilleros.contains(tierra.obtenerCasillero(new Coordenada(6,5))));
       assertTrue(casilleros.contains(tierra.obtenerCasillero(new Coordenada(6,6))));

    }


   @Test
    public void obtenerEspaciosQueEstanEnRadio2EnBordeDeLaTierra(){
        Tierra tierra = new Tierra();
        Coordenada coordenada = new Coordenada(0,0);
        Vector<Casillero> casilleros = tierra.espaciosEnRadio(coordenada,2);
        assertEquals(8, casilleros.size());
        assertTrue(casilleros.contains(tierra.obtenerCasillero(new Coordenada(0,1))));
        assertTrue(casilleros.contains(tierra.obtenerCasillero(new Coordenada(0,1))));
        assertTrue(casilleros.contains(tierra.obtenerCasillero(new Coordenada(1,0))));
        assertTrue(casilleros.contains(tierra.obtenerCasillero(new Coordenada(1,1))));
        assertTrue(casilleros.contains(tierra.obtenerCasillero(new Coordenada(1,2))));
        assertTrue(casilleros.contains(tierra.obtenerCasillero(new Coordenada(2,0))));
        assertTrue(casilleros.contains(tierra.obtenerCasillero(new Coordenada(2,1))));
        assertTrue(casilleros.contains(tierra.obtenerCasillero(new Coordenada(2,2))));

    }


    @Test
    public void verQueDosCoordenadasEstanEnUnRadio(){
        Tierra tierra = new Tierra();
        Coordenada coordenadaGoku = new Coordenada(4,4);
        Coordenada coordenadaGohan = new Coordenada(6,5);

        assertTrue(tierra.coordenadasEstanEnRadio(coordenadaGohan, coordenadaGoku,2));
        assertTrue(tierra.coordenadasEstanEnRadio(coordenadaGoku, coordenadaGohan,2));
        assertTrue(!tierra.coordenadasEstanEnRadio(coordenadaGohan, coordenadaGoku,1));

    }


    @Test
    public void verMovimientosPosiblesAPartirDeElCasilleroDeFila5YColumnaMoviendome1Vez(){
        Tierra tierra = new Tierra();
        Coordenada unaCoordenada = new Coordenada(5,5);
        Vector<Coordenada> coordenadasPosibles =  tierra.coordenadasEnLineaRectaADistancia(unaCoordenada,1);
        assertEquals(8, coordenadasPosibles.size());
        assertTrue(coordenadasPosibles.contains(new Coordenada(5,6)));
        assertTrue(coordenadasPosibles.contains(new Coordenada(5,4)));
        assertTrue(coordenadasPosibles.contains(new Coordenada(6,6)));
        assertTrue(coordenadasPosibles.contains(new Coordenada(6,4)));
        assertTrue(coordenadasPosibles.contains(new Coordenada(4,6)));
        assertTrue(coordenadasPosibles.contains(new Coordenada(4,4)));
        assertTrue(coordenadasPosibles.contains(new Coordenada(6,5)));
        assertTrue(coordenadasPosibles.contains(new Coordenada(4,5)));

    }


    @Test
    public void verMovimientosPosiblesAPartirDeElCasilleroDeFila0YColumna0Moviendome1Vez(){
        Tierra tierra = new Tierra();
        Coordenada unaCoordenada = new Coordenada(0,0);
        Vector<Coordenada> coordenadasPosibles =  tierra.coordenadasEnLineaRectaADistancia(unaCoordenada,1);
        assertEquals(3, coordenadasPosibles.size());
        assertTrue(coordenadasPosibles.contains(new Coordenada(0,1)));
        assertTrue(coordenadasPosibles.contains(new Coordenada(1,0)));
        assertTrue(coordenadasPosibles.contains(new Coordenada(1,1)));

    }


    @Test
    public void verMovimientosPosiblesAPartirDeElCasilleroDeFila5YColumna5Moviendome1Vez(){
        Tierra tierra = new Tierra();
        Coordenada unaCoordenada = new Coordenada(0,0);
        Goku goku = new Goku(tierra.obtenerCasillero(new Coordenada(1,0)),new GuerrerosZ());
        Vector<Coordenada> coordenadasPosibles =  tierra.coordenadasEnLineaRectaADistancia(unaCoordenada,1);
        assertEquals(2, coordenadasPosibles.size());
        assertTrue(coordenadasPosibles.contains(new Coordenada(0,1)));
        assertTrue(coordenadasPosibles.contains(new Coordenada(1,1)));

    }

}
