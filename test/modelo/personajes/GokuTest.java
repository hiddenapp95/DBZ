package modelo.personajes;
import static org.junit.Assert.assertTrue;

import modelo.aspectos.KaioKen;
import modelo.aspectos.SuperSayajin;
import modelo.aspectos.SuperSayajinFase2;
import modelo.excepciones.CasilleroOcupado;
import modelo.excepciones.PersonajeNoEstaDebajoDelPorcDeVidaNecesario;
import modelo.juego.Casillero;

import org.junit.Test;

import modelo.excepciones.KiInsuficiente;
import modelo.excepciones.NoRealizoLosAtaquesEspecialesNecesarias;

public class GokuTest {

	@Test
	public void testCrearGokuEnUnCasilleroYVerificarQueSeEncuentreEnElMismo() {
		Casillero unCasillero = new Casillero();
		Goku unGoku = new Goku(unCasillero,new GuerrerosZ());
		assertTrue(unGoku.obtenerCasillero() == unCasillero);
	}

	@Test
	public void testCrearAGokuEnUnCasilleroYVerificarElCasilleroContieneAGoku() {
		Casillero unCasillero = new Casillero();
		Goku unGoku = new Goku(unCasillero,new GuerrerosZ());
		assertTrue(unCasillero.getPersonaje() == unGoku);
	}

	@Test (expected = CasilleroOcupado.class)
	public void testCrearADosGokusEnElMismoCasilleroYVerificarExcepcion() {
		Casillero unCasillero = new Casillero();
		Goku unGoku = new Goku(unCasillero,new GuerrerosZ());
		Goku otroGoku = new Goku(unCasillero,new GuerrerosZ());
	}

	@Test
	public void testGokuDeberiaCrearseCon500PuntosDeVida() {

		Casillero unCasillero = new Casillero();
		Goku unGoku = new Goku(unCasillero,new GuerrerosZ());
		assertTrue(unGoku.obtenerPuntosDeVida() == 500);
	}
	
	@Test
	public void testGokuDeberiaCrearseCon0KiInicial() {

		Casillero unCasillero = new Casillero();
		Goku unGoku = new Goku(unCasillero,new GuerrerosZ());
		assertTrue(unGoku.obtenerKi() == 0);
	}

	@Test
	public void testGokuDeberiaCrearseConEstadoNormal() {

		Casillero unCasillero = new Casillero();
		Goku unGoku = new Goku(unCasillero,new GuerrerosZ());
		assertTrue(unGoku.obtenerNombreDeAspecto() == "NORMAL");
	}
	
	@Test
	public void testGokuDeberiaCrearseConPoderDePelea20() {

		Casillero unCasillero = new Casillero();
		Goku unGoku = new Goku(unCasillero,new GuerrerosZ());
		assertTrue(unGoku.obtenerPoderDePelea() == 20);
	}
	
	@Test
	public void testGokuDeberiaCrearseConDistaciaDeAtaque2() {

		Casillero unCasillero = new Casillero();
		Goku unGoku = new Goku(unCasillero,new GuerrerosZ());
		assertTrue(unGoku.obtenerDistanciaDeAtaque() == 2);
	}
	
	@Test
	public void testGokuDeberiaCrearseConVelocidad2() {

		Casillero unCasillero = new Casillero();
		Goku unGoku = new Goku(unCasillero,new GuerrerosZ());
		assertTrue(unGoku.obtenerVelocidad() ==2);
	}
	
	@Test
	public void testCuandoGokuSeTransformaAKaioKenDeberiaTener40DePoderDePelea() throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario, NoRealizoLosAtaquesEspecialesNecesarias {

		Casillero unCasillero = new Casillero();
		Goku unGoku = new Goku(unCasillero,new GuerrerosZ());
		unGoku.incrementarKi(20);
		unGoku.transformarse(new KaioKen());
		assertTrue(unGoku.obtenerPoderDePelea() ==40);
	}
	
	@Test
	public void testCuandoGokuSeTransformaAKaioKenDeberiaTener4DeDistanciaDeAtaque() throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario, NoRealizoLosAtaquesEspecialesNecesarias {

		Casillero unCasillero = new Casillero();
		Goku unGoku = new Goku(unCasillero,new GuerrerosZ());
		unGoku.incrementarKi(20);
		unGoku.transformarse(new KaioKen());
		assertTrue(unGoku.obtenerDistanciaDeAtaque() ==4);
	}
	
	@Test
	public void testCuandoGokuSeTransformaAKaioKenDeberiaTener3DeVelocidad() throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario, NoRealizoLosAtaquesEspecialesNecesarias {

		Casillero unCasillero = new Casillero();
		Goku unGoku = new Goku(unCasillero,new GuerrerosZ());
		unGoku.incrementarKi(20);
		unGoku.transformarse(new KaioKen());
		assertTrue(unGoku.obtenerVelocidad() ==3);
	}
	
	@Test
	public void testCuandoGokuSeTransformaASuperSayajinDeberiaTener60DePoderDePelea() throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario, NoRealizoLosAtaquesEspecialesNecesarias {

		Casillero unCasillero = new Casillero();
		Goku unGoku = new Goku(unCasillero,new GuerrerosZ());
		unGoku.incrementarKi(50);
		unGoku.transformarse(new SuperSayajin());
		assertTrue(unGoku.obtenerPoderDePelea() ==60);
	}
	
	@Test
	public void testCuandoGokuSeTransformaASuperSayajinDeberiaTener4DeDistanciaDeAtaque() throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario, NoRealizoLosAtaquesEspecialesNecesarias {

		Casillero unCasillero = new Casillero();
		Goku unGoku = new Goku(unCasillero,new GuerrerosZ());
		unGoku.incrementarKi(50);
		unGoku.transformarse(new SuperSayajin());
		assertTrue(unGoku.obtenerDistanciaDeAtaque() ==4);
	}
	
	@Test
	public void testCuandoGokuSeTransformaASuperSayajinDeberiaTener5DeVelocidad() throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario, NoRealizoLosAtaquesEspecialesNecesarias {

		Casillero unCasillero = new Casillero();
		Goku unGoku = new Goku(unCasillero,new GuerrerosZ());
		unGoku.incrementarKi(50);
		unGoku.transformarse(new SuperSayajin());
		assertTrue(unGoku.obtenerVelocidad() ==5);
	}
	
	
	@Test(expected = KiInsuficiente.class)
	public void testCuandoGokuSeQuereTransformarPeroNoTieneKiSuficienteDeberiaTirarError() throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario, NoRealizoLosAtaquesEspecialesNecesarias {

		Casillero unCasillero = new Casillero();
		Goku unGoku = new Goku(unCasillero,new GuerrerosZ());
		unGoku.transformarse(new SuperSayajin());
		
	}
}
