package modelo.personajes;

import static org.junit.Assert.*;

import modelo.aspectos.BooOriginal;
import modelo.aspectos.Fortalecido;
import modelo.aspectos.Protector;
import modelo.excepciones.CasilleroOcupado;
import modelo.excepciones.PersonajeNoEstaDebajoDelPorcDeVidaNecesario;
import modelo.juego.Casillero;

import org.junit.Test;

import modelo.excepciones.KiInsuficiente;
import modelo.excepciones.NoRealizoLosAtaquesEspecialesNecesarias;

public class PiccoloTest {

	@Test
	public void testCrearAPiccoloEnUnCasilleroYVerificarQueSeEncuentreEnElMismo() {
		Casillero unCasillero = new Casillero();
		Piccolo unPiccolo = new Piccolo(unCasillero,new GuerrerosZ());
		assertTrue(unPiccolo.obtenerCasillero() == unCasillero);
	}

	@Test
	public void testCrearAPiccoloEnUnCasilleroYVerificarElCasilleroContieneAPiccolo() {
		Casillero unCasillero = new Casillero();
		Piccolo unPiccolo = new Piccolo(unCasillero,new GuerrerosZ());
		assertTrue(unCasillero.getPersonaje() == unPiccolo);
	}

	@Test (expected = CasilleroOcupado.class)
	public void testCrearADosPiccolosEnElMismoCasilleroYVerificarExcepcion() {
		Casillero unCasillero = new Casillero();
		Piccolo unPiccolo = new Piccolo(unCasillero,new GuerrerosZ());
		Piccolo otroPiccolo = new Piccolo(unCasillero,new GuerrerosZ());
	}

	@Test
	public void testPiccoloDeberiaCrearseCon500PuntosDeVida() {

		Casillero unCasillero = new Casillero();
		Piccolo unPiccolo = new Piccolo(unCasillero,new GuerrerosZ());
		assertTrue(unPiccolo.obtenerPuntosDeVida() == 500);
	}
	
	@Test
	public void testPiccoloDeberiaCrearseCon0KiInicial() {

		Casillero unCasillero = new Casillero();
		Piccolo unPiccolo = new Piccolo(unCasillero,new GuerrerosZ());
		assertTrue(unPiccolo.obtenerKi() == 0);
	}

	@Test
	public void testPiccoloDeberiaCrearseConEstadoNormal() {

		Casillero unCasillero = new Casillero();
		Piccolo unPiccolo = new Piccolo(unCasillero,new GuerrerosZ());
		assertTrue(unPiccolo.obtenerNombreDeAspecto() == "NORMAL");
	}
	
	@Test
	public void testPiccoloDeberiaCrearseConPoderDePelea20() {

		Casillero unCasillero = new Casillero();
		Piccolo unPiccolo = new Piccolo(unCasillero,new GuerrerosZ());
		assertTrue(unPiccolo.obtenerPoderDePelea() == 20);
	}
	
	@Test
	public void testPiccoloDeberiaCrearseConDistaciaDeAtaque2() {

		Casillero unCasillero = new Casillero();
		Piccolo unPiccolo = new Piccolo(unCasillero,new GuerrerosZ());
		assertTrue(unPiccolo.obtenerDistanciaDeAtaque() == 2);
	}
	
	@Test
	public void testPiccoloDeberiaCrearseConVelocidad2() {

		Casillero unCasillero = new Casillero();
		Piccolo unPiccolo = new Piccolo(unCasillero,new GuerrerosZ());
		assertTrue(unPiccolo.obtenerVelocidad() ==2);
	}
	
	@Test
	public void testCuandoPiccoloSeTransformaAFortalecidoDeberiaTener40DePoderDePelea() throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario, NoRealizoLosAtaquesEspecialesNecesarias {

		Casillero unCasillero = new Casillero();
		Piccolo unPiccolo = new Piccolo(unCasillero,new GuerrerosZ());
		unPiccolo.incrementarKi(20);
		unPiccolo.transformarse(new Fortalecido());
		assertTrue(unPiccolo.obtenerPoderDePelea() ==40);
	}
	
	@Test
	public void testCuandoPiccoloSeTransformaAFortalecidoDeberiaTener4DeDistanciaDeAtaque() throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario, NoRealizoLosAtaquesEspecialesNecesarias {

		Casillero unCasillero = new Casillero();
		Piccolo unPiccolo = new Piccolo(unCasillero,new GuerrerosZ());
		unPiccolo.incrementarKi(20);
		unPiccolo.transformarse(new Fortalecido());
		assertTrue(unPiccolo.obtenerDistanciaDeAtaque() ==4);
	}
	
	@Test
	public void testCuandoPiccoloSeTransformaAFortalecidoDeberiaTener3DeVelocidad() throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario, NoRealizoLosAtaquesEspecialesNecesarias {

		Casillero unCasillero = new Casillero();
		Piccolo unPiccolo = new Piccolo(unCasillero,new GuerrerosZ());
		unPiccolo.incrementarKi(20);
		unPiccolo.transformarse(new Fortalecido());
		assertTrue(unPiccolo.obtenerVelocidad() ==3);
	}
	
	@Test
	public void testCuandoPiccoloSeTransformaAProtectorDeberiaTener60DePoderDePelea() throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario , NoRealizoLosAtaquesEspecialesNecesarias{

		Casillero unCasillero = new Casillero();
		GuerrerosZ guerrerosZ =new GuerrerosZ();
		Goku unGoku = new Goku(unCasillero,guerrerosZ);
		Gohan unGohan = new Gohan(new Casillero(),guerrerosZ);
		Piccolo unPiccolo = new Piccolo(new Casillero(),guerrerosZ);
		unGohan.quitarVida(410);
		unPiccolo.transformarse(new Protector());
		assertTrue(unPiccolo.obtenerPoderDePelea() ==60);
	}
	
	@Test
	public void testCuandoPiccoloSeTransformaAProtectorDeberiaTener6DeDistanciaDeAtaque() throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario, NoRealizoLosAtaquesEspecialesNecesarias {

		Casillero unCasillero = new Casillero();
		GuerrerosZ guerrerosZ =new GuerrerosZ();
		Goku unGoku = new Goku(unCasillero,guerrerosZ);
		Gohan unGohan = new Gohan(new Casillero(),guerrerosZ);
		Piccolo unPiccolo = new Piccolo(new Casillero(),guerrerosZ);
		
		unGohan.quitarVida(410);
		unPiccolo.transformarse(new Protector());
		assertTrue(unPiccolo.obtenerDistanciaDeAtaque() ==6);
	}
	
	@Test
	public void testCuandoPiccoloSeTransformaAProtectorDeberiaTener4DeVelocidad() throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario, NoRealizoLosAtaquesEspecialesNecesarias {

		Casillero unCasillero = new Casillero();
		GuerrerosZ guerrerosZ =new GuerrerosZ();
		Goku unGoku = new Goku(unCasillero,guerrerosZ);
		Gohan unGohan = new Gohan(new Casillero(),guerrerosZ);
		Piccolo unPiccolo = new Piccolo(new Casillero(),guerrerosZ);
		unGohan.quitarVida(410);
		unPiccolo.transformarse(new Protector());
		assertTrue(unPiccolo.obtenerVelocidad() ==4);
	}
	
	
	@Test(expected = KiInsuficiente.class)
	public void testCuandoPiccoloSeQuereTransformarPeroNoTieneKiSuficienteDeberiaTirarError() throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario, NoRealizoLosAtaquesEspecialesNecesarias {

		Casillero unCasillero = new Casillero();
		Piccolo unPiccolo = new Piccolo(unCasillero, new GuerrerosZ());
		unPiccolo.transformarse(new Fortalecido());
		
	}
	

}
