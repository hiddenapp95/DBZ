package modelo.ataques;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.aspectos.KaioKen;
import modelo.aspectos.SuperSayajin;
import modelo.excepciones.KiInsuficiente;
import modelo.excepciones.NoRealizoLosAtaquesEspecialesNecesarias;
import modelo.excepciones.PersonajeNoEstaDebajoDelPorcDeVidaNecesario;
import modelo.juego.Casillero;
import modelo.personajes.Cell;
import modelo.personajes.EnemigosDeLaTierra;
import modelo.personajes.Freezer;
import modelo.personajes.Gohan;
import modelo.personajes.Goku;
import modelo.personajes.GuerrerosZ;
import modelo.personajes.MajinBoo;
import modelo.personajes.Personaje;

public class AtaqueEspecialTest {

	@Test
	public void testUnAtaqueKamehamehaAOtroJugadorDeberiaSacarleElPoderdePeleaAumentadoUn50PorcDeVida() {
		Ataque unKamehameha = new Kamehameha();
		Goku unGoku = new Goku(new Casillero(),new GuerrerosZ());
		Cell unCell = new Cell(new Casillero(), new EnemigosDeLaTierra());
		unKamehameha.realizar(unGoku,unCell);
		assertTrue(unCell.obtenerPuntosDeVida() == 470);
	}
	
	@Test
	public void testUnAtaqueMakankosappoAOtroJugadorDeberiaSacarleElPoderdePeleaAumentadoUn25PorcDeVida() {
		Ataque unMakankosappo = new Makankosappo();
		Gohan unGohan = new Gohan(new Casillero(),new GuerrerosZ());
		Cell unCell = new Cell(new Casillero(), new EnemigosDeLaTierra());
		unMakankosappo.realizar(unGohan,unCell);
		assertTrue(unCell.obtenerPuntosDeVida() == 485);
	}

	@Test
	public void testUnAtaqueAbsorberAOtroJugadorDeberiaSacarleElPoderdePeleaAumentadoUn0PorcDeVida() {
		Ataque unAbsorber = new Absorber();
		Cell unCell = new Cell(new Casillero(), new EnemigosDeLaTierra());
		Gohan unGohan = new Gohan(new Casillero(),new GuerrerosZ());
		unAbsorber.realizar(unCell,unGohan);
		assertTrue(unGohan.obtenerPuntosDeVida() == 280);
	}
	
	@Test
	public void testUnAtaqueRayoMortalAOtroJugadorDeberiaSacarleElPoderdePeleaAumentadoUn50PorcDeVida() {
		Ataque unRayoMortal = new RayoMortal();
		Freezer unFreezer = new Freezer(new Casillero(), new EnemigosDeLaTierra());
		Gohan unGohan = new Gohan(new Casillero(),new GuerrerosZ());
		unRayoMortal.realizar(unFreezer,unGohan);
		assertTrue(unGohan.obtenerPuntosDeVida() == 270);
	}

	@Test
	public void testSiGokuHaceUnAtaqueBasicoAOtroPersonajeDeberiaSacarleElPoderdePeleaDeVida() {
		Goku unGoku = new Goku(new Casillero(),new GuerrerosZ());
		Cell unCell = new Cell(new Casillero(), new EnemigosDeLaTierra());
		unGoku.atacar(unCell);
		assertTrue(unCell.obtenerPuntosDeVida() == 480);
	}
	
	@Test
	public void testSiGokuTransformadoAKaioKenHaceUnKamehamehaAOtroPersonajeDeberiaSacarle60DeVida() throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario, NoRealizoLosAtaquesEspecialesNecesarias {
		Goku unGoku = new Goku(new Casillero(),new GuerrerosZ());
		Cell unCell = new Cell(new Casillero(), new EnemigosDeLaTierra());
		unGoku.incrementarKi(40);
		unGoku.transformarse(new KaioKen());
		unGoku.ataqueEspecial(unCell);
		assertTrue(unCell.obtenerPuntosDeVida() == 440);
	}
	
	@Test 
	public void testSiGokuTransformadoASuperSayajinHaceUnKamehamehaAOtroPersonajeDeberiaSacarle90DeVida() throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario, NoRealizoLosAtaquesEspecialesNecesarias {
		Goku unGoku = new Goku(new Casillero(),new GuerrerosZ());
		Cell unCell = new Cell(new Casillero(), new EnemigosDeLaTierra());
		unGoku.incrementarKi(70);
		unGoku.transformarse(new SuperSayajin());
		unGoku.ataqueEspecial(unCell);
		assertTrue(unCell.obtenerPuntosDeVida() == 410);
	}
	
	@Test (expected = KiInsuficiente.class)
	public void testGokuNoPuedeHacerUnKamehamehaSiTieneMenosDe20Ki() throws KiInsuficiente {
		Goku unGoku = new Goku(new Casillero(),new GuerrerosZ());
		Freezer unFreezer = new Freezer(new Casillero(), new EnemigosDeLaTierra());
		unGoku.ataqueEspecial(unFreezer);
	}
	
	@Test (expected = KiInsuficiente.class)
	public void testGohanNoPuedeHacerUnMakankosappoSiTieneMenos10Ki() throws KiInsuficiente {
		Gohan unGohan = new Gohan(new Casillero(),new GuerrerosZ());
		Freezer unFreezer = new Freezer(new Casillero(), new EnemigosDeLaTierra());

		unGohan.ataqueEspecial(unFreezer);
	}

	@Test (expected = KiInsuficiente.class)
	public void testCellNoPuedeAbsorberSiTieneMenos5Ki() throws KiInsuficiente {
		Cell unCell = new Cell(new Casillero(), new EnemigosDeLaTierra());
		Gohan unGohan = new Gohan(new Casillero(),new GuerrerosZ());
		unCell.ataqueEspecial(unGohan);
	}
	
	@Test (expected = KiInsuficiente.class)
	public void testFreezerNoPuedeHacerUnAtaqueRayoMortalSiTieneMenosDe20Ki() throws KiInsuficiente {
		Freezer unFreezer = new Freezer(new Casillero(), new EnemigosDeLaTierra());
		Gohan unGohan = new Gohan(new Casillero(),new GuerrerosZ());
		unFreezer.ataqueEspecial(unGohan);
	}

	@Test 
	public void testGokuPuedeHacerUnKamehamehaSiTiene20Ki() throws KiInsuficiente {
		Goku unGoku = new Goku(new Casillero(),new GuerrerosZ());
		Freezer unFreezer = new Freezer(new Casillero(), new EnemigosDeLaTierra());
		unGoku.incrementarKi(20);
		unGoku.ataqueEspecial(unFreezer);
		assertTrue(unFreezer.obtenerPuntosDeVida() == 370);
	}
	
	@Test 
	public void testGohanPuedeHacerUnMakankosappoSiTiene10Ki() throws KiInsuficiente {
		Gohan unGohan = new Gohan(new Casillero(),new GuerrerosZ());
		Freezer unFreezer = new Freezer(new Casillero(), new EnemigosDeLaTierra());
		unGohan.incrementarKi(10);
		unGohan.ataqueEspecial(unFreezer);
		assertTrue(unFreezer.obtenerPuntosDeVida() == 385);
	}

	@Test 
	public void testCellPuedeAbsorberSiTiene5Ki() throws KiInsuficiente {
		Cell unCell = new Cell(new Casillero(), new EnemigosDeLaTierra());
		Gohan unGohan = new Gohan(new Casillero(),new GuerrerosZ());
		unCell.incrementarKi(5);
		unCell.ataqueEspecial(unGohan);
		assertTrue(unGohan.obtenerPuntosDeVida() == 280);
	}
	
	@Test 
	public void testFreezerPuedeHacerUnAtaqueRayoMortalSiTiene20Ki() throws KiInsuficiente {
		Freezer unFreezer = new Freezer(new Casillero(), new EnemigosDeLaTierra());
		Gohan unGohan = new Gohan(new Casillero(),new GuerrerosZ());
		unFreezer.incrementarKi(20);
		unFreezer.ataqueEspecial(unGohan);
		assertTrue(unGohan.obtenerPuntosDeVida() == 270);
	}
	
	@Test
	public void cuandoGokuTieneMenosDel30PorCientoDeVidaSuPoderDeAtaqueAumentaUn20PorCiento(){
	    Personaje goku = new Goku(new Casillero(),new GuerrerosZ());
	    assertEquals(20, goku.obtenerPoderDePelea(),0.01);
	    goku.quitarVida(350);
	    assertEquals(20, goku.obtenerPoderDePelea(),0.01);
	    goku.quitarVida(10);
	    assertEquals(24, goku.obtenerPoderDePelea(),0.01);
	}
	
	
	@Test 
	public void testCuandoCellUsaElAbsorverSuVidaDebeAumentarLaCantidadDeDano() throws KiInsuficiente {
		Cell unCell = new Cell(new Casillero(), new EnemigosDeLaTierra());
		Gohan unGohan = new Gohan(new Casillero(),new GuerrerosZ());
		unCell.incrementarKi(5);
		unCell.ataqueEspecial(unGohan);
		assertTrue(unCell.obtenerPuntosDeVida() == 500);
	}
	
	@Test (expected = KiInsuficiente.class)
	public void testMajinBooNoPuedeUsarElAtaqueEspecialSiNoTiene30Ki() throws KiInsuficiente {
		MajinBoo unMajinBoo = new MajinBoo(new Casillero(), new EnemigosDeLaTierra());
		Gohan unGohan = new Gohan(new Casillero(),new GuerrerosZ());
		
		unMajinBoo.ataqueEspecial(unGohan);
	}
	@Test 
	public void testConvertirEnChocolateDeberiaInmovilizarAlPersonaje() throws KiInsuficiente {
		MajinBoo unMajinBoo = new MajinBoo(new Casillero(), new EnemigosDeLaTierra());
		Gohan unGohan = new Gohan(new Casillero(),new GuerrerosZ());
		unMajinBoo.incrementarKi(30);
		unMajinBoo.ataqueEspecial(unGohan);
		assertTrue(unGohan.obtenerEstadoActual() == "INMOVILIZADO");
	}
	
	@Test 
	public void testPersonajeDeberiaDesinmovilizarseLuegoDe6Turnos() throws KiInsuficiente {
		MajinBoo unMajinBoo = new MajinBoo(new Casillero(), new EnemigosDeLaTierra());
		Gohan unGohan = new Gohan(new Casillero(),new GuerrerosZ());
		unMajinBoo.incrementarKi(30);
		unMajinBoo.ataqueEspecial(unGohan);
		unGohan.pasarTurno();
		unGohan.pasarTurno();
		unGohan.pasarTurno();
		unGohan.pasarTurno();
		unGohan.pasarTurno();
		unGohan.pasarTurno();
		assertTrue(unGohan.obtenerEstadoActual() == "VIVO");
	}
	@Test 
	public void testPersonajeInmovilizarseNoDeberiaAumentarKiCuandoPasaTurno() throws KiInsuficiente {
		MajinBoo unMajinBoo = new MajinBoo(new Casillero(), new EnemigosDeLaTierra());
		Gohan unGohan = new Gohan(new Casillero(),new GuerrerosZ());
		unMajinBoo.incrementarKi(30);
		unMajinBoo.ataqueEspecial(unGohan);
		unGohan.pasarTurno();	
		assertTrue(unGohan.obtenerKi()==0);
	}
	
}
