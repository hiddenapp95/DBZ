package modelo.personajes;

import static org.junit.Assert.*;

import modelo.aspectos.Definitivo;
import modelo.aspectos.Perfecto;
import modelo.aspectos.SegundaForma;
import modelo.excepciones.CasilleroOcupado;
import modelo.excepciones.PersonajeNoEstaDebajoDelPorcDeVidaNecesario;
import modelo.juego.Casillero;

import org.junit.Test;

import modelo.excepciones.KiInsuficiente;
import modelo.excepciones.NoRealizoLosAtaquesEspecialesNecesarias;

public class FreezerTest {

	@Test
	public void testCrearAFreezerEnUnCasilleroYVerificarQueSeEncuentreEnElMismo() {
		Casillero unCasillero = new Casillero();
		Freezer unFreezer = new Freezer(unCasillero, new EnemigosDeLaTierra());
		assertTrue(unFreezer.obtenerCasillero() == unCasillero);
	}

	@Test
	public void testCrearAFreezerEnUnCasilleroYVerificarElCasilleroContieneAFreezer() {
		Casillero unCasillero = new Casillero();
		Freezer unFreezer = new Freezer(unCasillero, new EnemigosDeLaTierra());
		assertTrue(unCasillero.getPersonaje() == unFreezer);
	}

	@Test (expected = CasilleroOcupado.class)
	public void testCrearADosFreezersEnElMismoCasilleroYVerificarExcepcion() {
		Casillero unCasillero = new Casillero();
		Freezer unFreezer = new Freezer(unCasillero, new EnemigosDeLaTierra());
		Freezer otroFreezer = new Freezer(unCasillero, new EnemigosDeLaTierra());
	}

	@Test
	public void testFreezerDeberiaCrearseCon400PuntosDeVida() {

		Casillero unCasillero = new Casillero();
		Freezer unFreezer = new Freezer(unCasillero, new EnemigosDeLaTierra());
		assertTrue(unFreezer.obtenerPuntosDeVida() == 400);
	}
	
	@Test
	public void testFreezerDeberiaCrearseCon0KiInicial() {

		Casillero unCasillero = new Casillero();
		Freezer unFreezer = new Freezer(unCasillero, new EnemigosDeLaTierra());
		assertTrue(unFreezer.obtenerKi() == 0);
	}

	@Test
	public void testFreezerDeberiaCrearseConEstadoNormal() {

		Casillero unCasillero = new Casillero();
		Freezer unFreezer = new Freezer(unCasillero, new EnemigosDeLaTierra());
		assertTrue(unFreezer.obtenerNombreDeAspecto() == "NORMAL");
	}
	
	@Test
	public void testFreezerDeberiaCrearseConPoderDePelea20() {

		Casillero unCasillero = new Casillero();
		Freezer unFreezer = new Freezer(unCasillero, new EnemigosDeLaTierra());
		assertTrue(unFreezer.obtenerPoderDePelea() == 20);
	}
	
	@Test
	public void testFreezerDeberiaCrearseConDistaciaDeAtaque2() {

		Casillero unCasillero = new Casillero();
		Freezer unFreezer = new Freezer(unCasillero, new EnemigosDeLaTierra());
		assertTrue(unFreezer.obtenerDistanciaDeAtaque() == 2);
	}
	
	@Test
	public void testFreezerDeberiaCrearseConVelocidad4() {

		Casillero unCasillero = new Casillero();
		Freezer unFreezer = new Freezer(unCasillero, new EnemigosDeLaTierra());
		assertTrue(unFreezer.obtenerVelocidad() ==4);
	}

	@Test
	public void testCuandoFreezerSeTransformaASegundaFormaDeberiaTener40DePoderDePelea() throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario, NoRealizoLosAtaquesEspecialesNecesarias {

		Casillero unCasillero = new Casillero();
		Freezer unFreezer = new Freezer(unCasillero, new EnemigosDeLaTierra());
		unFreezer.incrementarKi(20);
		unFreezer.transformarse(new SegundaForma());
		assertTrue(unFreezer.obtenerPoderDePelea() ==40);
	}
	
	@Test
	public void testCuandoFreezerSeTransformaASegundaFormaDeberiaTener3DeDistanciaDeAtaque() throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario, NoRealizoLosAtaquesEspecialesNecesarias {

		Casillero unCasillero = new Casillero();
		Freezer unFreezer = new Freezer(unCasillero, new EnemigosDeLaTierra());
		unFreezer.incrementarKi(20);
		unFreezer.transformarse(new SegundaForma());
		assertTrue(unFreezer.obtenerDistanciaDeAtaque() ==3);
	}
	
	@Test
	public void testCuandoFreezerSeTransformaASegundaFormaDeberiaTener4DeVelocidad() throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario, NoRealizoLosAtaquesEspecialesNecesarias {

		Casillero unCasillero = new Casillero();
		Freezer unFreezer = new Freezer(unCasillero, new EnemigosDeLaTierra());
		unFreezer.incrementarKi(20);
		unFreezer.transformarse(new SegundaForma());
		assertTrue(unFreezer.obtenerVelocidad() ==4);
	}
	
	@Test
	public void testCuandoFreezerSeTransformaADefinitivoDeberiaTener50DePoderDePelea() throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario, NoRealizoLosAtaquesEspecialesNecesarias {

		Casillero unCasillero = new Casillero();
		Freezer unFreezer = new Freezer(unCasillero, new EnemigosDeLaTierra());
		unFreezer.incrementarKi(50);
		unFreezer.transformarse(new Definitivo());
		assertTrue(unFreezer.obtenerPoderDePelea() ==50);
	}
	
	@Test
	public void testCuandoFreezerSeTransformaADefinitivoDeberiaTener3DeDistanciaDeAtaque() throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario, NoRealizoLosAtaquesEspecialesNecesarias {

		Casillero unCasillero = new Casillero();
		Freezer unFreezer = new Freezer(unCasillero, new EnemigosDeLaTierra());
		unFreezer.incrementarKi(50);
		unFreezer.transformarse(new Definitivo());
		assertTrue(unFreezer.obtenerDistanciaDeAtaque() ==3);
	}
	
	@Test
	public void testCuandoFreezerSeTransformaADefinitivoDeberiaTener6DeVelocidad() throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario, NoRealizoLosAtaquesEspecialesNecesarias {

		Casillero unCasillero = new Casillero();
		Freezer unFreezer = new Freezer(unCasillero, new EnemigosDeLaTierra());
		unFreezer.incrementarKi(50);
		unFreezer.transformarse(new Definitivo());
		assertTrue(unFreezer.obtenerVelocidad() ==6);
	}
	
	
	@Test(expected = KiInsuficiente.class)
	public void testCuandoFreezerSeQuereTransformarPeroNoTieneKiSuficienteDeberiaTirarError() throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario, NoRealizoLosAtaquesEspecialesNecesarias {

		Casillero unCasillero = new Casillero();
		Freezer unFreezer = new Freezer(unCasillero, new EnemigosDeLaTierra());
		unFreezer.transformarse(new Definitivo());
		
	}
}
