package modelo.personajes;

import static org.junit.Assert.*;

import modelo.aspectos.Perfecto;
import modelo.aspectos.SemiPerfecto;
import modelo.excepciones.CasilleroOcupado;
import modelo.excepciones.PersonajeNoEstaDebajoDelPorcDeVidaNecesario;
import modelo.juego.Casillero;

import org.junit.Test;

import modelo.excepciones.KiInsuficiente;
import modelo.excepciones.NoRealizoLosAtaquesEspecialesNecesarias;

public class CellTest {

	@Test
	public void testCrearACellEnUnCasilleroYVerificarQueSeEncuentreEnElMismo() {
		Casillero unCasillero = new Casillero();
		Cell unCell = new Cell(unCasillero, new EnemigosDeLaTierra());
		assertTrue(unCell.obtenerCasillero() == unCasillero);
	}

	@Test
	public void testCrearACellEnUnCasilleroYVerificarElCasilleroContieneACell() {
		Casillero unCasillero = new Casillero();
		Cell unCell = new Cell(unCasillero, new EnemigosDeLaTierra());
		assertTrue(unCasillero.getPersonaje() == unCell);
	}

	@Test (expected = CasilleroOcupado.class)
	public void testCrearADosCellsEnElMismoCasilleroYVerificarExcepcion() {
		Casillero unCasillero = new Casillero();
		Cell unCell = new Cell(unCasillero, new EnemigosDeLaTierra());
		Cell otroCell = new Cell(unCasillero, new EnemigosDeLaTierra());
	}

	@Test
	public void testCellDeberiaCrearseCon500PuntosDeVida() {
		Casillero unCasillero = new Casillero();
		Cell unCell = new Cell(unCasillero, new EnemigosDeLaTierra());
		assertTrue(unCell.obtenerPuntosDeVida() == 500);
	}
	
	@Test
	public void testCellDeberiaCrearseCon0KiInicial() {
		Casillero unCasillero = new Casillero();
		Cell unCell = new Cell(unCasillero, new EnemigosDeLaTierra());
		assertTrue(unCell.obtenerKi() == 0);
	}

	@Test
	public void testCellDeberiaCrearseConEstadoNormal() {
		Casillero unCasillero = new Casillero();
		Cell unCell = new Cell(unCasillero, new EnemigosDeLaTierra());
		assertTrue(unCell.obtenerNombreDeAspecto() == "NORMAL");
	}
	
	@Test
	public void testCellDeberiaCrearseConPoderDePelea20() {
		Casillero unCasillero = new Casillero();
		Cell unCell = new Cell(unCasillero, new EnemigosDeLaTierra());
		assertTrue(unCell.obtenerPoderDePelea() == 20);
	}
	
	@Test
	public void testCellDeberiaCrearseConDistaciaDeAtaque3() {
		Casillero unCasillero = new Casillero();
		Cell unCell = new Cell(unCasillero, new EnemigosDeLaTierra());
		assertTrue(unCell.obtenerDistanciaDeAtaque() == 3);
	}
	
	@Test
	public void testCellDeberiaCrearseConVelocidad2() {
		Casillero unCasillero = new Casillero();
		Cell unCell = new Cell(unCasillero, new EnemigosDeLaTierra());
		assertTrue(unCell.obtenerVelocidad() ==2);
	}
	
	@Test
	public void testCuandoCellSeTransformaASemiPerfectoDeberiaTener40DePoderDePelea() throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario, NoRealizoLosAtaquesEspecialesNecesarias {
		Casillero unCasillero = new Casillero();
		Cell unCell = new Cell(unCasillero, new EnemigosDeLaTierra());
		Gohan unGohan = new Gohan(new Casillero(),new GuerrerosZ());
		unCell.incrementarKi(20);
		unCell.ataqueEspecial(unGohan);
		unCell.ataqueEspecial(unGohan);
		unCell.ataqueEspecial(unGohan);
		unCell.ataqueEspecial(unGohan);
		
		unCell.transformarse(new SemiPerfecto());
		assertTrue(unCell.obtenerPoderDePelea() ==40);
	}
	
	@Test
	public void testCuandoCellSeTransformaASemiPerfectoDeberiaTener4DeDistanciaDeAtaque() throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario, NoRealizoLosAtaquesEspecialesNecesarias {
		Casillero unCasillero = new Casillero();
		Cell unCell = new Cell(unCasillero, new EnemigosDeLaTierra());
		Gohan unGohan = new Gohan(new Casillero(),new GuerrerosZ());
		unCell.incrementarKi(20);
		unCell.ataqueEspecial(unGohan);
		unCell.ataqueEspecial(unGohan);
		unCell.ataqueEspecial(unGohan);
		unCell.ataqueEspecial(unGohan);
		
		unCell.transformarse(new SemiPerfecto());
		assertTrue(unCell.obtenerDistanciaDeAtaque() ==4);
	}
	
	@Test
	public void testCuandoCellSeTransformaASemiPerfectoDeberiaTener3DeVelocidad() throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario, NoRealizoLosAtaquesEspecialesNecesarias {
		Casillero unCasillero = new Casillero();
		Cell unCell = new Cell(unCasillero, new EnemigosDeLaTierra());
		Gohan unGohan = new Gohan(new Casillero(),new GuerrerosZ());
		unCell.incrementarKi(20);
		unCell.ataqueEspecial(unGohan);
		unCell.ataqueEspecial(unGohan);
		unCell.ataqueEspecial(unGohan);
		unCell.ataqueEspecial(unGohan);
		
		unCell.transformarse(new SemiPerfecto());
		assertTrue(unCell.obtenerVelocidad() ==3);
	}
	
	@Test
	public void testCuandoCellSeTransformaAPerfectoDeberiaTener80DePoderDePelea() throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario, NoRealizoLosAtaquesEspecialesNecesarias {
		Casillero unCasillero = new Casillero();
		Cell unCell = new Cell(unCasillero, new EnemigosDeLaTierra());
		Gohan unGohan = new Gohan(new Casillero(),new GuerrerosZ());
		unCell.incrementarKi(40);
		for(int i=0;i<8;i++) {
		unCell.ataqueEspecial(unGohan);
		}
		
		unCell.transformarse(new Perfecto());
		assertTrue(unCell.obtenerPoderDePelea() ==80);
	}
	
	@Test
	public void testCuandoCellSeTransformaAPerfectoDeberiaTener4DeDistanciaDeAtaque() throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario, NoRealizoLosAtaquesEspecialesNecesarias {
		Casillero unCasillero = new Casillero();
		Cell unCell = new Cell(unCasillero, new EnemigosDeLaTierra());
		Gohan unGohan = new Gohan(new Casillero(),new GuerrerosZ());
		unCell.incrementarKi(40);
		for(int i=0;i<8;i++) {
		unCell.ataqueEspecial(unGohan);
		}
		unCell.transformarse(new Perfecto());
		assertTrue(unCell.obtenerDistanciaDeAtaque() ==4);
	}
	
	@Test
	public void testCuandoCellSeTransformaAPerfectoDeberiaTener4DeVelocidad() throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario, NoRealizoLosAtaquesEspecialesNecesarias {
		Casillero unCasillero = new Casillero();
		Cell unCell = new Cell(unCasillero, new EnemigosDeLaTierra());
		Gohan unGohan = new Gohan(new Casillero(),new GuerrerosZ());
		unCell.incrementarKi(40);
		for(int i=0;i<8;i++) {
		unCell.ataqueEspecial(unGohan);
		}
		unCell.transformarse(new Perfecto());
		assertTrue(unCell.obtenerVelocidad() ==4);
	}

}
