package modelo.juego;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import modelo.aspectos.KaioKen;
import modelo.ataques.Ataque;
import modelo.ataques.Basico;
import modelo.excepciones.AtaqueFueraDeRango;
import modelo.excepciones.CasilleroOcupado;
import modelo.excepciones.KiInsuficiente;
import modelo.excepciones.LaVelocidadNoAlcanzaParaMoverseEstaDistancia;

import modelo.excepciones.MovimientoInvalido;
import modelo.excepciones.NoRealizoLosAtaquesEspecialesNecesarias;

import modelo.excepciones.PersonajeNoEstaDebajoDelPorcDeVidaNecesario;
import modelo.excepciones.YaSeRealizoUnAtaqueEnEsteTurno;
import modelo.excepciones.YaSeRealizoUnMovimientoEnEsteTurno;
import modelo.personajes.Cell;
import modelo.personajes.EnemigosDeLaTierra;
import modelo.personajes.Freezer;
import modelo.personajes.Gohan;
import modelo.personajes.Goku;
import modelo.personajes.GuerrerosZ;
import modelo.personajes.MajinBoo;
import modelo.personajes.Personaje;
import modelo.personajes.Piccolo;

public class PrimeraEntregaTests {

	@Test
	public void testCrearUnPersonajeMoverloYVerificarSiSeEncuentraEnSuNuevaPosicionAcordeASuVelocidad()
			throws LaVelocidadNoAlcanzaParaMoverseEstaDistancia {
		Tierra laTierra = new Tierra();
		Coordenada unaCoordenada = new Coordenada(0, 0);
		Coordenada otraCoordenada = new Coordenada(0, 2);
		Goku unGoku = new Goku(laTierra.obtenerCasillero(unaCoordenada), new GuerrerosZ());
		unGoku.moverseACasillero(laTierra.obtenerCasillero(otraCoordenada));

		assertEquals(laTierra.obtenerPersonaje(otraCoordenada).getNombre(), unGoku.getNombre());
	}

	@Test(expected = CasilleroOcupado.class)
	public void testCrearDosPersonajesYVerificarQueElSegundoNoSePuedeMoverAlMismoCasillero()
			throws LaVelocidadNoAlcanzaParaMoverseEstaDistancia {

		Tierra laTierra = new Tierra();
		Coordenada unaCoordenada = new Coordenada(0, 0);
		Coordenada otraCoordenada = new Coordenada(0, 1);

		Goku unGoku = new Goku(laTierra.obtenerCasillero(unaCoordenada), new GuerrerosZ());
		Goku otroGoku = new Goku(laTierra.obtenerCasillero(otraCoordenada), new GuerrerosZ());

		otroGoku.moverseACasillero(laTierra.obtenerCasillero(unaCoordenada));
	}

//	@Test(expected = MovimientoInvalido.class)
//	public void testCuandoSeQuiereMoverAUnPersonajeYExisteOtroEnElMedioDeSuCaminoDeberiaArrojarExcepcion()
//			throws YaSeRealizoUnMovimientoEnEsteTurno, LaVelocidadNoAlcanzaParaMoverseEstaDistancia {
//		Juego unJuego = new Juego();
//		// Esta validacion se hace a traves de la clase juego, por eso en este
//		// test no alcanza solo con crear la tierra y ubicar los personajes
//		//unJuego.mover(new Coordenada(0, 0), new Coordenada(0, 2));
//	}

	@Test
	public void testSeUbicaUnPersonajeSeLoTransformaYSePideQueSeMuevaYSeVerificaQueSuNuevaPosicionSeaAcorde()
			throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario, NoRealizoLosAtaquesEspecialesNecesarias,
			LaVelocidadNoAlcanzaParaMoverseEstaDistancia {
		Tierra laTierra = new Tierra();
		Coordenada unaCoordenada = new Coordenada(0, 0);
		// Cuando pasa a kaioken, goku pasa de velocidad 2 a 3, por lo que este
		// movimiento deberia ser posible
		Coordenada otraCoordenada = new Coordenada(0, 3);
		Goku unGoku = new Goku(laTierra.obtenerCasillero(unaCoordenada), new GuerrerosZ());
		// //Le sumo 20 de ki
		for (int i = 0; i < 4; i++) {
			unGoku.pasarTurno();
		}
		unGoku.transformarse(new KaioKen());

		unGoku.moverseACasillero(laTierra.obtenerCasillero(otraCoordenada));
		assertEquals(laTierra.obtenerPersonaje(otraCoordenada).getNombre(), unGoku.getNombre());
	}

	@Test
	public void testIntegracionUbicandoTresPersonajesDeCadaEquipoEnElTablero() {
		Tierra laTierra = new Tierra();

		Coordenada coordenadaPersonajeUno = new Coordenada(0, 0);
		Coordenada coordenadaPersonajeDos = new Coordenada(0, 1);
		Coordenada coordenadaPersonajeTres = new Coordenada(1, 0);
		Coordenada coordenadaPersonajeCuatro = new Coordenada(laTierra.getLastRow(), laTierra.getLastColumn());
		Coordenada coordenadaPersonajeCinco = new Coordenada(laTierra.getLastRow() - 1, laTierra.getLastColumn());
		Coordenada coordenadaPersonajeSeis = new Coordenada(laTierra.getLastRow(), laTierra.getLastColumn() - 1);

		Goku goku = new Goku(laTierra.obtenerCasillero(coordenadaPersonajeUno), new GuerrerosZ());
		Gohan gohan = new Gohan(laTierra.obtenerCasillero(coordenadaPersonajeDos), new GuerrerosZ());
		Piccolo piccolo = new Piccolo(laTierra.obtenerCasillero(coordenadaPersonajeTres), new GuerrerosZ());
		Cell cell = new Cell(laTierra.obtenerCasillero(coordenadaPersonajeCuatro), new EnemigosDeLaTierra());
		MajinBoo majinBoo = new MajinBoo(laTierra.obtenerCasillero(coordenadaPersonajeCinco), new EnemigosDeLaTierra());
		Freezer freezer = new Freezer(laTierra.obtenerCasillero(coordenadaPersonajeSeis), new EnemigosDeLaTierra());

		assertEquals(laTierra.obtenerPersonaje(coordenadaPersonajeUno).getNombre(), goku.getNombre());
		assertEquals(laTierra.obtenerPersonaje(coordenadaPersonajeDos).getNombre(), gohan.getNombre());
		assertEquals(laTierra.obtenerPersonaje(coordenadaPersonajeTres).getNombre(), piccolo.getNombre());
		assertEquals(laTierra.obtenerPersonaje(coordenadaPersonajeCuatro).getNombre(), cell.getNombre());
		assertEquals(laTierra.obtenerPersonaje(coordenadaPersonajeCinco).getNombre(), majinBoo.getNombre());
		assertEquals(laTierra.obtenerPersonaje(coordenadaPersonajeSeis).getNombre(), freezer.getNombre());

	}

	@Test(expected = AtaqueFueraDeRango.class)
	public void testUbicarUnGuerreroZYUnEnemigoDeLaTierraAtacarYCuandoSeAtacanSiEstaFueraDeRangoTiraExcepcion()
			throws YaSeRealizoUnMovimientoEnEsteTurno, LaVelocidadNoAlcanzaParaMoverseEstaDistancia,
			YaSeRealizoUnAtaqueEnEsteTurno {
		// Necesito usar la clase juego ya que esta validacion tambien se hace
		// en dicha clase
		Juego unJuego = new Juego();
		Coordenada coordenadasGohan = new Coordenada(0, 1);
		Coordenada coordenadasMajinBoo = new Coordenada(8, 15);
		Personaje unGohan = unJuego.obtenerTierra().obtenerPersonaje(coordenadasGohan);
		Personaje unMajinBoo = unJuego.obtenerTierra().obtenerPersonaje(coordenadasMajinBoo);

		// Gohan ataca a majin boo y esta fuera de rango
		unJuego.ataqueBasico(unGohan, unMajinBoo);
	}

	@Test
	public void testAtacoAOtroJugadorDeEquipoContrarioConAtaqueBasicoYVerificoLosDanios() {
		Ataque unAtaqueBasico = new Basico();
		Casillero unCasillero = new Casillero();
		Casillero otroCasillero = new Casillero();
		Gohan unGohan = new Gohan(unCasillero, new GuerrerosZ());
		MajinBoo unMajinBoo = new MajinBoo(otroCasillero, new EnemigosDeLaTierra());
		unAtaqueBasico.realizar(unMajinBoo, unGohan);
		assertTrue(unGohan.obtenerPuntosDeVida() == 270);
	}

}
