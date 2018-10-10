package modelo.personajes;

import static org.junit.Assert.*;

import modelo.aspectos.SuperSayajinFase1;
import modelo.aspectos.SuperSayajinFase2;
import modelo.excepciones.CasilleroOcupado;
import modelo.excepciones.PersonajeNoEstaDebajoDelPorcDeVidaNecesario;
import modelo.juego.Casillero;

import org.junit.Test;

import modelo.excepciones.KiInsuficiente;
import modelo.excepciones.NoRealizoLosAtaquesEspecialesNecesarias;

public class GohanTest {

	@Test
	public void testCrearAGohanEnUnCasilleroYVerificarQueSeEncuentreEnElMismo() {
		Casillero unCasillero = new Casillero();
		Gohan unGohan = new Gohan(unCasillero,new GuerrerosZ());
		assertTrue(unGohan.obtenerCasillero() == unCasillero);
	}

	@Test
	public void testCrearAGohanEnUnCasilleroYVerificarElCasilleroContieneACell() {
		Casillero unCasillero = new Casillero();
		Gohan unGohan = new Gohan(unCasillero,new GuerrerosZ());
		assertTrue(unCasillero.getPersonaje() == unGohan);
	}

	@Test (expected = CasilleroOcupado.class)
	public void testCrearADosGohansEnElMismoCasilleroYVerificarExcepcion() {
		Casillero unCasillero = new Casillero();
		Gohan unGohan = new Gohan(unCasillero,new GuerrerosZ());
		Gohan otroGohan = new Gohan(unCasillero,new GuerrerosZ());
	}

	@Test
	public void testGohanDeberiaCrearseCon300PuntosDeVida() {

		Casillero unCasillero = new Casillero();
		Gohan unGohan = new Gohan(unCasillero,new GuerrerosZ());
		assertTrue(unGohan.obtenerPuntosDeVida() == 300);
	}
	
	@Test
	public void testGohanDeberiaCrearseCon0KiInicial() {

		Casillero unCasillero = new Casillero();
		Gohan unGohan = new Gohan(unCasillero,new GuerrerosZ());
		assertTrue(unGohan.obtenerKi() == 0);
	}

	@Test
	public void testGohanDeberiaCrearseConEstadoNormal() {

		Casillero unCasillero = new Casillero();
		Gohan unGohan = new Gohan(unCasillero,new GuerrerosZ());
		assertTrue(unGohan.obtenerNombreDeAspecto() == "NORMAL");
	}
	
	@Test
	public void testGohanDeberiaCrearseConPoderDePelea15() {

		Casillero unCasillero = new Casillero();
		Gohan unGohan = new Gohan(unCasillero,new GuerrerosZ());
		assertTrue(unGohan.obtenerPoderDePelea() == 15);
	}
	
	@Test
	public void testGohanDeberiaCrearseConDistaciaDeAtaque2() {

		Casillero unCasillero = new Casillero();
		Gohan unGohan = new Gohan(unCasillero,new GuerrerosZ());
		assertTrue(unGohan.obtenerDistanciaDeAtaque() == 2);
	}
	
	@Test
	public void testGohanDeberiaCrearseConVelocidad2() {

		Casillero unCasillero = new Casillero();
		Gohan unGohan = new Gohan(unCasillero,new GuerrerosZ());
		assertTrue(unGohan.obtenerVelocidad() ==2);
	}
	
	@Test
	public void testCuandoGohanSeTransformaASuperSayajinFase1DeberiaTener30DePoderDePelea() throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario, NoRealizoLosAtaquesEspecialesNecesarias {

		Casillero unCasillero = new Casillero();
		Gohan unGohan = new Gohan(unCasillero,new GuerrerosZ());
		unGohan.incrementarKi(10);
		unGohan.transformarse(new SuperSayajinFase1());
		assertTrue(unGohan.obtenerPoderDePelea() ==30);
	}
	
	@Test
	public void testCuandoGohanSeTransformaASuperSayajinFase1DeberiaTener2DeDistanciaDeAtaque() throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario, NoRealizoLosAtaquesEspecialesNecesarias {

		Casillero unCasillero = new Casillero();
		Gohan unGohan = new Gohan(unCasillero,new GuerrerosZ());
		unGohan.incrementarKi(10);
		unGohan.transformarse(new SuperSayajinFase1());
		assertTrue(unGohan.obtenerDistanciaDeAtaque() ==2);
	}
	
	@Test
	public void testCuandoGohanSeTransformaASuperSayajinFase1DeberiaTener2DeVelocidad() throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario , NoRealizoLosAtaquesEspecialesNecesarias{

		Casillero unCasillero = new Casillero();
		Gohan unGohan = new Gohan(unCasillero,new GuerrerosZ());
		unGohan.incrementarKi(10);
		unGohan.transformarse(new SuperSayajinFase1());
		assertTrue(unGohan.obtenerVelocidad() ==2);
	}
	
	@Test
	public void testCuandoGohanSeTransformaASuperSayajinFase2DeberiaTener100DePoderDePelea() throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario , NoRealizoLosAtaquesEspecialesNecesarias{

		Casillero unCasillero = new Casillero();
		GuerrerosZ guerrerosZ =new GuerrerosZ();
		Goku unGoku = new Goku(unCasillero,guerrerosZ);
		Gohan unGohan = new Gohan(new Casillero(),guerrerosZ);
		Piccolo unPiccolo = new Piccolo(new Casillero(),guerrerosZ);
		unGoku.quitarVida(410);
		unPiccolo.quitarVida(410);
		unGohan.incrementarKi(30);
		unGohan.transformarse(new SuperSayajinFase2());
		assertTrue(unGohan.obtenerPoderDePelea() ==100);
	}
	
	@Test
	public void testCuandoGohanSeTransformaASuperSayajinFase2DeberiaTener4DeDistanciaDeAtaque() throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario , NoRealizoLosAtaquesEspecialesNecesarias{

		Casillero unCasillero = new Casillero();
		GuerrerosZ guerrerosZ =new GuerrerosZ();
		Goku unGoku = new Goku(unCasillero,guerrerosZ);
		Gohan unGohan = new Gohan(new Casillero(),guerrerosZ);
		Piccolo unPiccolo = new Piccolo(new Casillero(),guerrerosZ);

		unGoku.quitarVida(410);
		unPiccolo.quitarVida(410);
		unGohan.incrementarKi(30);
		unGohan.transformarse(new SuperSayajinFase2());
		assertTrue(unGohan.obtenerDistanciaDeAtaque() ==4);
	}
	
	@Test
	public void testCuandoGohanSeTransformaASuperSayajinFase2DeberiaTener3DeVelocidad() throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario, NoRealizoLosAtaquesEspecialesNecesarias {

		Casillero unCasillero = new Casillero();
		GuerrerosZ guerrerosZ =new GuerrerosZ();
		Goku unGoku = new Goku(unCasillero,guerrerosZ);
		Gohan unGohan = new Gohan(new Casillero(),guerrerosZ);
		Piccolo unPiccolo = new Piccolo(new Casillero(),guerrerosZ);
		
		unGoku.quitarVida(410);
		unPiccolo.quitarVida(410);
		unGohan.incrementarKi(30);
		unGohan.transformarse(new SuperSayajinFase2());
		assertTrue(unGohan.obtenerVelocidad() ==3);
	}
	
	
	@Test(expected = KiInsuficiente.class)
	public void testCuandoGohanSeQuereTransformarPeroNoTieneKiSuficienteDeberiaTirarError() throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario, NoRealizoLosAtaquesEspecialesNecesarias {

		Casillero unCasillero = new Casillero();
		Gohan unGohan = new Gohan(unCasillero,new GuerrerosZ());
		unGohan.transformarse(new SuperSayajinFase1());
	}

}
