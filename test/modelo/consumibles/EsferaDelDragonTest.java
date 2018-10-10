package modelo.consumibles;

import modelo.excepciones.LaVelocidadNoAlcanzaParaMoverseEstaDistancia;
import modelo.juego.Coordenada;
import modelo.juego.Tierra;
import modelo.personajes.Cell;
import modelo.personajes.EnemigosDeLaTierra;
import modelo.personajes.Goku;
import modelo.personajes.GuerrerosZ;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Franco on 6/17/2017.
 */
public class EsferaDelDragonTest {
    @Test
    public void testPosicionarUnaEsferaDelDragonEnElMapaYVerificarQueEseCasilleroTieneUnConsumible() {
        Tierra tierra = new Tierra();
        Coordenada unaCoordenada = new Coordenada(1,1);
        tierra.obtenerCasillero(unaCoordenada).addConsumible(new EsferaDelDragon());
        assertTrue(tierra.obtenerCasillero(unaCoordenada).tieneConsumible());
    }

    @Test
    public void testUnPersonajeAgarraUnaEsferaDelDragonYVerificarQueTieneConsumibles() throws LaVelocidadNoAlcanzaParaMoverseEstaDistancia {
        Tierra tierra = new Tierra();
        Coordenada unaCoordenada = new Coordenada(1,1);
        Coordenada otraCoordenada = new Coordenada(0,0);
        tierra.obtenerCasillero(unaCoordenada).addConsumible(new EsferaDelDragon());
        Goku unGoku = new Goku(tierra.obtenerCasillero(otraCoordenada), new GuerrerosZ());
        assertTrue(unGoku.obtenerConsumibles().isEmpty());
        unGoku.moverseACasillero(tierra.obtenerCasillero(unaCoordenada));
        assertTrue(!unGoku.obtenerConsumibles().isEmpty());
    }

    @Test
    public void testUnPersonajeAgarraUnaEsferaDelDragonYVerificarQueElCasilleroYaNoTieneConsumibles() throws LaVelocidadNoAlcanzaParaMoverseEstaDistancia {
        Tierra tierra = new Tierra();
        Coordenada unaCoordenada = new Coordenada(1,1);
        Coordenada otraCoordenada = new Coordenada(0,0);
        tierra.obtenerCasillero(unaCoordenada).addConsumible(new EsferaDelDragon());
        Goku unGoku = new Goku(tierra.obtenerCasillero(otraCoordenada), new GuerrerosZ());
        assertTrue(tierra.obtenerCasillero(unaCoordenada).tieneConsumible());
        unGoku.moverseACasillero(tierra.obtenerCasillero(unaCoordenada));
        assertTrue(!tierra.obtenerCasillero(unaCoordenada).tieneConsumible());
    }

    @Test
    public void testVerificarQueLaEsferaDelDragonAumentaElDanioDeUnGokuAumento25PorcientoAlAtacar() throws LaVelocidadNoAlcanzaParaMoverseEstaDistancia {
        Tierra tierra = new Tierra();
        Coordenada unaCoordenada = new Coordenada(1,1);
        Coordenada otraCoordenada = new Coordenada(0,0);
        Coordenada unTercerCasillero = new Coordenada(1,2);
        tierra.obtenerCasillero(unaCoordenada).addConsumible(new EsferaDelDragon());
        Goku unGoku = new Goku(tierra.obtenerCasillero(otraCoordenada), new GuerrerosZ());
        Cell unCell = new Cell(tierra.obtenerCasillero(unTercerCasillero), new EnemigosDeLaTierra());
        unGoku.moverseACasillero(tierra.obtenerCasillero(unaCoordenada));
        unGoku.atacar(unCell);
        assertTrue(unCell.obtenerPuntosDeVida() == 475);
    }

    @Test
    public void testVerificarQueLaEsferaDelDragonDesApareceDelPersonajeAlAtacarDosVeces() throws LaVelocidadNoAlcanzaParaMoverseEstaDistancia {
        Tierra tierra = new Tierra();
        Coordenada unaCoordenada = new Coordenada(1,1);
        Coordenada otraCoordenada = new Coordenada(0,0);
        Coordenada unTercerCasillero = new Coordenada(1,2);
        tierra.obtenerCasillero(unaCoordenada).addConsumible(new EsferaDelDragon());
        Goku unGoku = new Goku(tierra.obtenerCasillero(otraCoordenada), new GuerrerosZ());
        Cell unCell = new Cell(tierra.obtenerCasillero(unTercerCasillero), new EnemigosDeLaTierra());
        unGoku.moverseACasillero(tierra.obtenerCasillero(unaCoordenada));
        unGoku.atacar(unCell);
        unGoku.pasarTurno();
        assertTrue(!unGoku.obtenerConsumibles().isEmpty());
        unGoku.atacar(unCell);
        unGoku.pasarTurno();
        assertTrue(unGoku.obtenerConsumibles().isEmpty());
    }

    @Test
    public void testVerificarQueLaEsferaDelDragonDesApareceDelPersonajeAlAtacarDosVecesYSuEfectoSeRevierte() throws LaVelocidadNoAlcanzaParaMoverseEstaDistancia {
        Tierra tierra = new Tierra();
        Coordenada unaCoordenada = new Coordenada(1,1);
        Coordenada otraCoordenada = new Coordenada(0,0);
        Coordenada unTercerCasillero = new Coordenada(1,2);
        tierra.obtenerCasillero(unaCoordenada).addConsumible(new EsferaDelDragon());
        Goku unGoku = new Goku(tierra.obtenerCasillero(otraCoordenada), new GuerrerosZ());
        Cell unCell = new Cell(tierra.obtenerCasillero(unTercerCasillero), new EnemigosDeLaTierra());
        unGoku.moverseACasillero(tierra.obtenerCasillero(unaCoordenada));
        unGoku.atacar(unCell);
        assertTrue(unCell.obtenerPuntosDeVida() == 475);
        unGoku.pasarTurno();
        assertTrue(!unGoku.obtenerConsumibles().isEmpty());
        unGoku.atacar(unCell);
        assertTrue(unCell.obtenerPuntosDeVida() == 450);
        unGoku.pasarTurno();
        unGoku.atacar(unCell);
        assertTrue(unGoku.obtenerConsumibles().isEmpty());
        assertTrue(unCell.obtenerPuntosDeVida() == 430);
    }
}
