package modelo.personajes;

import modelo.excepciones.LaVelocidadNoAlcanzaParaMoverseEstaDistancia;
import modelo.excepciones.YaSeRealizoUnMovimientoEnEsteTurno;
import modelo.juego.Casillero;
import modelo.juego.Coordenada;
import modelo.juego.Juego;

import static org.junit.Assert.assertTrue;

import org.junit.Test;


/**
 * Created by marianoogimenez on 10/6/17.
 */
public class TestEquipos {

    @Test
    public void crearGokuYVerQuePerteneceAEquipoGuerrerosZ(){
    	GuerrerosZ equipoGuerrerosZ = new GuerrerosZ();
        Casillero unCasillero = new Casillero();
        Goku goku = new Goku(unCasillero, equipoGuerrerosZ);
        assertTrue(equipoGuerrerosZ.contienePersonaje(goku));
    }

    @Test
    public void crearGokuYGohanYVerQueSonCompanieros(){
        Casillero casilleroGoku = new Casillero();
        Casillero casilleroGohan = new Casillero();
        GuerrerosZ equipoGuerrerosZ = new GuerrerosZ();
        Goku goku = new Goku(casilleroGoku, equipoGuerrerosZ);
        Gohan gohan = new Gohan(casilleroGohan, equipoGuerrerosZ);
        assertTrue(goku.esCompanieroDe(gohan));
    }


    @Test
    public void crearGokuYCellYVerQueNoSonCompanieros(){
        Casillero casilleroGoku = new Casillero();
        Casillero casilleroCell = new Casillero();
        Goku goku = new Goku(casilleroGoku, new GuerrerosZ());
        Cell cell = new Cell(casilleroCell, new EnemigosDeLaTierra());
        assertTrue(!goku.esCompanieroDe(cell));
    }
    
    @Test 
	public void testPerdioDeberiaDevolverTrueCuandoTodosLosPersonajesMueren() {
    	GuerrerosZ equipoGuerrerosZ = new GuerrerosZ();
        Goku goku = new Goku(new Casillero(), equipoGuerrerosZ);
        Gohan gohan = new Gohan(new Casillero(), equipoGuerrerosZ);
        Piccolo piccolo = new Piccolo(new Casillero(), equipoGuerrerosZ);
        goku.quitarVida(500);
        gohan.quitarVida(500);
        piccolo.quitarVida(500);
        assertTrue(equipoGuerrerosZ.perdio());
	}

}
