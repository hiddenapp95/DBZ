package modelo.consumibles;

import modelo.excepciones.LaVelocidadNoAlcanzaParaMoverseEstaDistancia;
import modelo.juego.Coordenada;
import modelo.juego.Tierra;
import modelo.personajes.Goku;
import modelo.personajes.GuerrerosZ;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Franco on 6/17/2017.
 */
public class NubeVoladoraTest {
    @Test
    public void testPosicionarUnaNubeVoladoraEnElMapaYVerificarQueEseCasilleroTieneUnConsumible() {
        Tierra tierra = new Tierra();
        Coordenada unaCoordenada = new Coordenada(1,1);
        tierra.obtenerCasillero(unaCoordenada).addConsumible(new NubeVoladora());
        assertTrue(tierra.obtenerCasillero(unaCoordenada).tieneConsumible());
    }

    @Test
    public void testUnPersonajeAgarraUnaNubeVoladoraYVerificarQueTieneConsumibles() throws LaVelocidadNoAlcanzaParaMoverseEstaDistancia {
        Tierra tierra = new Tierra();
        Coordenada unaCoordenada = new Coordenada(1,1);
        Coordenada otraCoordenada = new Coordenada(0,0);
        tierra.obtenerCasillero(unaCoordenada).addConsumible(new NubeVoladora());
        Goku unGoku = new Goku(tierra.obtenerCasillero(otraCoordenada), new GuerrerosZ());
        assertTrue(unGoku.obtenerConsumibles().isEmpty());
        unGoku.moverseACasillero(tierra.obtenerCasillero(unaCoordenada));
        assertTrue(!unGoku.obtenerConsumibles().isEmpty());
    }

    @Test
    public void testUnPersonajeAgarraUnaNubeVoladoraYVerificarQueElCasilleroYaNoTieneConsumibles() throws LaVelocidadNoAlcanzaParaMoverseEstaDistancia {
        Tierra tierra = new Tierra();
        Coordenada unaCoordenada = new Coordenada(1,1);
        Coordenada otraCoordenada = new Coordenada(0,0);
        tierra.obtenerCasillero(unaCoordenada).addConsumible(new NubeVoladora());
        Goku unGoku = new Goku(tierra.obtenerCasillero(otraCoordenada), new GuerrerosZ());
        assertTrue(tierra.obtenerCasillero(unaCoordenada).tieneConsumible());
        unGoku.moverseACasillero(tierra.obtenerCasillero(unaCoordenada));
        assertTrue(!tierra.obtenerCasillero(unaCoordenada).tieneConsumible());
    }

    @Test
    public void testVerificarQueLaNubeVoladoraAumentaLaVelocidadDeUnGoku() throws LaVelocidadNoAlcanzaParaMoverseEstaDistancia {
        Tierra tierra = new Tierra();
        Coordenada unaCoordenada = new Coordenada(1,1);
        Coordenada otraCoordenada = new Coordenada(0,0);
        tierra.obtenerCasillero(unaCoordenada).addConsumible(new NubeVoladora());
        Goku unGoku = new Goku(tierra.obtenerCasillero(otraCoordenada), new GuerrerosZ());
        assertTrue( 2 == unGoku.obtenerVelocidad());
        unGoku.moverseACasillero(tierra.obtenerCasillero(unaCoordenada));
        assertTrue(4 == unGoku.obtenerVelocidad());
    }

    @Test
    public void testVerificarQueLaNubeVoladoraAumentaLaVelocidadDeUnGokuPorDosTurnosYLuegoSeRevierteSuEfecto() throws LaVelocidadNoAlcanzaParaMoverseEstaDistancia {
        Tierra tierra = new Tierra();
        Coordenada unaCoordenada = new Coordenada(1,1);
        Coordenada otraCoordenada = new Coordenada(0,0);
        tierra.obtenerCasillero(unaCoordenada).addConsumible(new NubeVoladora());
        Goku unGoku = new Goku(tierra.obtenerCasillero(otraCoordenada), new GuerrerosZ());
        assertTrue( 2 == unGoku.obtenerVelocidad());
        unGoku.moverseACasillero(tierra.obtenerCasillero(unaCoordenada));
        unGoku.pasarTurno();
        assertTrue(4 == unGoku.obtenerVelocidad());
        unGoku.pasarTurno();
        assertTrue(4 == unGoku.obtenerVelocidad());
        unGoku.pasarTurno();
        assertTrue(2 == unGoku.obtenerVelocidad());
    }
}
