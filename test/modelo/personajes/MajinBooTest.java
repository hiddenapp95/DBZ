package modelo.personajes;

import static org.junit.Assert.*;

import modelo.aspectos.BooMalo;
import modelo.aspectos.BooOriginal;
import modelo.aspectos.SuperSayajin;
import modelo.excepciones.CasilleroOcupado;
import modelo.excepciones.PersonajeNoEstaDebajoDelPorcDeVidaNecesario;
import modelo.juego.Casillero;

import org.junit.Test;

import modelo.excepciones.KiInsuficiente;
import modelo.excepciones.NoRealizoLosAtaquesEspecialesNecesarias;

public class MajinBooTest {

	@Test
	public void testCrearAMajinBooEnUnCasilleroYVerificarQueSeEncuentreEnElMismo() {
		Casillero unCasillero = new Casillero();
		MajinBoo unMajinBoo = new MajinBoo(unCasillero, new EnemigosDeLaTierra());
		assertTrue(unMajinBoo.obtenerCasillero() == unCasillero);
	}

	@Test
	public void testCrearAMajinBooEnUnCasilleroYVerificarElCasilleroContieneAMajinBoo() {
		Casillero unCasillero = new Casillero();
		MajinBoo unMajinBoo = new MajinBoo(unCasillero, new EnemigosDeLaTierra());
		assertTrue(unCasillero.getPersonaje() == unMajinBoo);
	}

	@Test (expected = CasilleroOcupado.class)
	public void testCrearADosMajinBoosEnElMismoCasilleroYVerificarExcepcion() {
		Casillero unCasillero = new Casillero();
		MajinBoo unMajinBoo = new MajinBoo(unCasillero, new EnemigosDeLaTierra());
		MajinBoo otroMajinBoo = new MajinBoo(unCasillero, new EnemigosDeLaTierra());
	}

	@Test
	public void testMajinBooDeberiaCrearseCon300PuntosDeVida() {

		Casillero unCasillero = new Casillero();
		MajinBoo unMajinBoo = new MajinBoo(unCasillero, new EnemigosDeLaTierra());
		assertTrue(unMajinBoo.obtenerPuntosDeVida() == 300);
	}
	
	@Test
	public void testMajinBooDeberiaCrearseCon0KiInicial() {

		Casillero unCasillero = new Casillero();
		MajinBoo unMajinBoo = new MajinBoo(unCasillero, new EnemigosDeLaTierra());
		assertTrue(unMajinBoo.obtenerKi() == 0);
	}

	@Test
	public void testMajinBooDeberiaCrearseConEstadoNormal() {

		Casillero unCasillero = new Casillero();
		MajinBoo unMajinBoo = new MajinBoo(unCasillero, new EnemigosDeLaTierra());
		assertTrue(unMajinBoo.obtenerNombreDeAspecto() == "NORMAL");
	}
	
	@Test
	public void testMajinBooDeberiaCrearseConPoderDePelea30() {

		Casillero unCasillero = new Casillero();
		MajinBoo unMajinBoo = new MajinBoo(unCasillero, new EnemigosDeLaTierra());
		assertTrue(unMajinBoo.obtenerPoderDePelea() == 30);
	}
	
	@Test
	public void testMajinBooDeberiaCrearseConDistaciaDeAtaque2() {

		Casillero unCasillero = new Casillero();
		MajinBoo unMajinBoo = new MajinBoo(unCasillero, new EnemigosDeLaTierra());
		assertTrue(unMajinBoo.obtenerDistanciaDeAtaque() == 2);
	}
	
	@Test
	public void testMajinBooDeberiaCrearseConVelocidad2() {

		Casillero unCasillero = new Casillero();
		MajinBoo unMajinBoo = new MajinBoo(unCasillero, new EnemigosDeLaTierra());
		assertTrue(unMajinBoo.obtenerVelocidad() ==2);
	}
	@Test
	public void testCuandoMajinBooSeTransformaABooMaloDeberiaTener50DePoderDePelea() throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario, NoRealizoLosAtaquesEspecialesNecesarias {

		Casillero unCasillero = new Casillero();
		MajinBoo unMajinBoo = new MajinBoo(unCasillero, new EnemigosDeLaTierra());
		unMajinBoo.incrementarKi(20);
		unMajinBoo.transformarse(new BooMalo());
		assertTrue(unMajinBoo.obtenerPoderDePelea() ==50);
	}
	
	@Test
	public void testCuandoMajinBooSeTransformaABooMaloDeberiaTener2DeDistanciaDeAtaque() throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario, NoRealizoLosAtaquesEspecialesNecesarias {

		Casillero unCasillero = new Casillero();
		MajinBoo unMajinBoo = new MajinBoo(unCasillero, new EnemigosDeLaTierra());
		unMajinBoo.incrementarKi(20);
		unMajinBoo.transformarse(new BooMalo());
		assertTrue(unMajinBoo.obtenerDistanciaDeAtaque() ==2);
	}
	
	@Test
	public void testCuandoMajinBooSeTransformaABooMaloDeberiaTener3DeVelocidad() throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario, NoRealizoLosAtaquesEspecialesNecesarias {

		Casillero unCasillero = new Casillero();
		MajinBoo unMajinBoo = new MajinBoo(unCasillero, new EnemigosDeLaTierra());
		unMajinBoo.incrementarKi(20);
		unMajinBoo.transformarse(new BooMalo());
		assertTrue(unMajinBoo.obtenerVelocidad() ==3);
	}
	
	@Test
	public void testCuandoMajinBooSeTransformaABooOriginalDeberiaTener60DePoderDePelea() throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario, NoRealizoLosAtaquesEspecialesNecesarias {

		Casillero unCasillero = new Casillero();
		MajinBoo unMajinBoo = new MajinBoo(unCasillero, new EnemigosDeLaTierra());
		unMajinBoo.incrementarKi(50);
		unMajinBoo.transformarse(new BooOriginal());
		assertTrue(unMajinBoo.obtenerPoderDePelea() ==60);
	}
	
	@Test
	public void testCuandoMajinBooSeTransformaABooOriginalDeberiaTener3DeDistanciaDeAtaque() throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario, NoRealizoLosAtaquesEspecialesNecesarias {

		Casillero unCasillero = new Casillero();
		MajinBoo unMajinBoo = new MajinBoo(unCasillero, new EnemigosDeLaTierra());
		unMajinBoo.incrementarKi(50);
		unMajinBoo.transformarse(new BooOriginal());
		assertTrue(unMajinBoo.obtenerDistanciaDeAtaque() ==3);
	}
	
	@Test
	public void testCuandoMajinBooSeTransformaABooOriginalDeberiaTener4DeVelocidad() throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario, NoRealizoLosAtaquesEspecialesNecesarias {

		Casillero unCasillero = new Casillero();
		MajinBoo unMajinBoo = new MajinBoo(unCasillero, new EnemigosDeLaTierra());
		unMajinBoo.incrementarKi(50);
		unMajinBoo.transformarse(new BooOriginal());
		assertTrue(unMajinBoo.obtenerVelocidad() ==4);
	}
	
	
	@Test(expected = KiInsuficiente.class)
	public void testCuandoMajinBooSeQuereTransformarPeroNoTieneKiSuficienteDeberiaTirarError() throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario, NoRealizoLosAtaquesEspecialesNecesarias {

		Casillero unCasillero = new Casillero();
		MajinBoo unMajinBoo = new MajinBoo(unCasillero, new EnemigosDeLaTierra());
		unMajinBoo.transformarse(new BooOriginal());
		
	}

}
