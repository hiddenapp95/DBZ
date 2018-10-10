package modelo.juego;

import org.junit.Test;

import modelo.excepciones.AunNoHayEquipoGanador;
import modelo.excepciones.LaVelocidadNoAlcanzaParaMoverseEstaDistancia;
import modelo.excepciones.MovimientoInvalido;
import modelo.excepciones.YaSeRealizoUnMovimientoEnEsteTurno;
import modelo.personajes.Personaje;

public class JuegoTest {

	@Test(expected = MovimientoInvalido.class)
	public void testMoverUnJugadorAUnaCoordenadaMasAlejadaDeSuPosibleVelocidadDeberiaLanzarError()
			throws YaSeRealizoUnMovimientoEnEsteTurno, LaVelocidadNoAlcanzaParaMoverseEstaDistancia {
		Juego unJuego = new Juego();
		Coordenada coordenadasGohan = new Coordenada(0, 1);
		Coordenada coordenadasAMoverse = new Coordenada(0, 4);
		Personaje unGohan = unJuego.obtenerTierra().obtenerPersonaje(coordenadasGohan);

		unJuego.mover(unGohan, new Casillero(coordenadasAMoverse));

	}

	// 1.3
	@Test(expected = MovimientoInvalido.class)
	public void testCuandoSeQuiereMoverAUnPersonajeYExisteOtroEnElMedioDeSuCaminoDeberiaArrojarExcepcion()
			throws YaSeRealizoUnMovimientoEnEsteTurno, LaVelocidadNoAlcanzaParaMoverseEstaDistancia {
		Juego unJuego = new Juego();
		Coordenada coordenadasGoku = new Coordenada(0, 0);
		Coordenada coordenadasAMoverse = new Coordenada(0, 2);
		Personaje unGoku = unJuego.obtenerTierra().obtenerPersonaje(coordenadasGoku);

		unJuego.mover(unGoku, new Casillero(coordenadasAMoverse));
	}

	@Test(expected = AunNoHayEquipoGanador.class)
	public void testEquipoGanadorDeberiaLanzarErrorSiTodaviaNoHayUnGanador() throws AunNoHayEquipoGanador {
		Juego unJuego = new Juego();
		unJuego.equipoGanador();

	}

}
