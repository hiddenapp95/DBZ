package modelo.consumibles;

import modelo.excepciones.LaVelocidadNoAlcanzaParaMoverseEstaDistancia;
import modelo.juego.Casillero;
import modelo.juego.Coordenada;
import modelo.juego.Tierra;
import modelo.personajes.EnemigosDeLaTierra;
import modelo.personajes.Freezer;
import modelo.personajes.Goku;
import modelo.personajes.GuerrerosZ;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Franco on 6/17/2017.
 */
public class SemillaDeErmitanioTest {

    @Test
    public void testPosicionarUnaSemillaDeErmitanioEnElMapaYVerificarQueEseCasilleroTieneUnConsumible() {
        Tierra tierra = new Tierra();
        Coordenada unaCoordenada = new Coordenada(1,1);
        tierra.obtenerCasillero(unaCoordenada).addConsumible(new SemillaDelErmitanio());
        assertTrue(tierra.obtenerCasillero(unaCoordenada).tieneConsumible());
    }

    @Test
    public void testUnPersonajeAgarraUnaSemillaDeErmitanioYVerificarQueTieneConsumibles() throws LaVelocidadNoAlcanzaParaMoverseEstaDistancia {
        Tierra tierra = new Tierra();
        Coordenada unaCoordenada = new Coordenada(1,1);
        Coordenada otraCoordenada = new Coordenada(0,0);
        tierra.obtenerCasillero(unaCoordenada).addConsumible(new SemillaDelErmitanio());
        Goku unGoku = new Goku(tierra.obtenerCasillero(otraCoordenada), new GuerrerosZ());
        assertTrue(unGoku.obtenerConsumibles().isEmpty());
        unGoku.moverseACasillero(tierra.obtenerCasillero(unaCoordenada));
        assertTrue(!unGoku.obtenerConsumibles().isEmpty());
    }

    @Test
    public void testUnPersonajeAgarraUnaSemillaDeErmitanioYVerificarQueElCasilleroYaNoTieneConsumibles() throws LaVelocidadNoAlcanzaParaMoverseEstaDistancia {
        Tierra tierra = new Tierra();
        Coordenada unaCoordenada = new Coordenada(1,1);
        Coordenada otraCoordenada = new Coordenada(0,0);
        tierra.obtenerCasillero(unaCoordenada).addConsumible(new SemillaDelErmitanio());
        Goku unGoku = new Goku(tierra.obtenerCasillero(otraCoordenada), new GuerrerosZ());
        assertTrue(tierra.obtenerCasillero(unaCoordenada).tieneConsumible());
        unGoku.moverseACasillero(tierra.obtenerCasillero(unaCoordenada));
        assertTrue(!tierra.obtenerCasillero(unaCoordenada).tieneConsumible());
    }

    @Test
    public void testVerificarQueLaSemillaDeErmitanioAumentaPuntosDeVida() throws LaVelocidadNoAlcanzaParaMoverseEstaDistancia {
        Tierra tierra = new Tierra();
        Coordenada unaCoordenada = new Coordenada(1,1);
        Coordenada otraCoordenada = new Coordenada(0,0);
        Coordenada unaTercerCoordenada = new Coordenada(0,1);
        tierra.obtenerCasillero(unaCoordenada).addConsumible(new SemillaDelErmitanio());
        Goku unGoku = new Goku(tierra.obtenerCasillero(otraCoordenada), new GuerrerosZ());
        Freezer unFreezer = new Freezer(tierra.obtenerCasillero(unaTercerCoordenada), new EnemigosDeLaTierra());
        unFreezer.atacar(unGoku);
        assertTrue(480 == unGoku.obtenerPuntosDeVida());
        unGoku.moverseACasillero(tierra.obtenerCasillero(unaCoordenada));
        assertTrue(500 == unGoku.obtenerPuntosDeVida());
    }
}
