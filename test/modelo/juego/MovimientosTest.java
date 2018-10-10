package modelo.juego;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import modelo.excepciones.CasilleroOcupado;
import modelo.excepciones.LaVelocidadNoAlcanzaParaMoverseEstaDistancia;
import modelo.personajes.Goku;
import modelo.personajes.GuerrerosZ;

/**
 * Created by Franco on 6/3/2017.
 */
public class MovimientosTest {

    // 1.1
	@Test
    public void testCrearUnPersonajeMoverloYVerificarSiSeEncuentraEnSuNuevaPosicionAcordeASuVelocidad() throws LaVelocidadNoAlcanzaParaMoverseEstaDistancia {
    	Tierra laTierra = new Tierra();
    	Coordenada unaCoordenada = new Coordenada(0,0);
    	Coordenada otraCoordenada = new Coordenada(0,2);
    	Goku unGoku = new Goku(laTierra.obtenerCasillero(unaCoordenada), new GuerrerosZ());
    	unGoku.moverseACasillero(laTierra.obtenerCasillero(otraCoordenada));
    	
    	assertEquals(laTierra.obtenerPersonaje(otraCoordenada).getNombre(), unGoku.getNombre());
    }
	
	@Test
    public void testCrearUnPersonajeEnFila0YColumna0YMoverloAFila1Columna1YVerSiEseCasilleroEstaOcupado() throws LaVelocidadNoAlcanzaParaMoverseEstaDistancia{

        Tierra laTierra = new Tierra();
        Coordenada unaCoordenada = new Coordenada(0,0);
        Coordenada otraCoordenada = new Coordenada(1,1);
        Goku unGoku = new Goku(laTierra.obtenerCasillero(unaCoordenada),new GuerrerosZ());
        unGoku.moverseACasillero(laTierra.obtenerCasillero(otraCoordenada));

        assertTrue(laTierra.obtenerCasillero(new Coordenada(1,1)).tienePersonaje());
    }

	//1.2
    @Test (expected = CasilleroOcupado.class)
    public void testCrearDosPersonajesYVerificarQueElSegundoNoSePuedeMoverAlMismoCasillero() throws LaVelocidadNoAlcanzaParaMoverseEstaDistancia{

        Tierra laTierra = new Tierra();
        Coordenada unaCoordenada = new Coordenada(0,0);
        Coordenada otraCoordenada = new Coordenada(0,1);

        Goku unGoku = new Goku(laTierra.obtenerCasillero(unaCoordenada),new GuerrerosZ());
        Goku otroGoku = new Goku(laTierra.obtenerCasillero(otraCoordenada),new GuerrerosZ());

        otroGoku.moverseACasillero(laTierra.obtenerCasillero(unaCoordenada));
    }

    // 1.2
    @Test (expected = CasilleroOcupado.class)
    public void testCrearDosPersonajesYMoverlosAFila1Columna1YVerificarQueNoSeMueveElSegundoQueIntenteMoverse() throws LaVelocidadNoAlcanzaParaMoverseEstaDistancia{

        Tierra laTierra = new Tierra();
        Coordenada unaCoordenada = new Coordenada(0,0);
        Coordenada otraCoordenada = new Coordenada(0,1);
        Coordenada unaTerceraCoordenada = new Coordenada(0,2);
        Goku unGoku = new Goku(laTierra.obtenerCasillero(unaCoordenada),new GuerrerosZ());
        Goku otroGoku = new Goku(laTierra.obtenerCasillero(otraCoordenada),new GuerrerosZ());

        unGoku.moverseACasillero(laTierra.obtenerCasillero(unaTerceraCoordenada));
        otroGoku.moverseACasillero(laTierra.obtenerCasillero(unaTerceraCoordenada));
    }

}
