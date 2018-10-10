package modelo.ataques;

import static org.junit.Assert.*;


import modelo.excepciones.PersonajesDeUnMismoEquipoNoPuedenAtacarse;
import modelo.personajes.*;
import modelo.juego.Casillero;

import org.junit.Test;

import modelo.excepciones.PersonajeNoEstaDebajoDelPorcDeVidaNecesario;
import modelo.aspectos.KaioKen;
import modelo.aspectos.SuperSayajin;
import modelo.excepciones.KiInsuficiente;
import modelo.excepciones.NoRealizoLosAtaquesEspecialesNecesarias;

public class AtaqueBasicoTest {

	@Test
	public void testUnAtaqueBasicoAOtroJugadorDeberiaSacarleElPoderdePeleaDeVida() {
		Ataque unAtaqueBasico = new Basico();
		Casillero unCasillero = new Casillero();
		Goku unGoku = new Goku(new Casillero(),new GuerrerosZ());
		Cell cell = new Cell(unCasillero, new EnemigosDeLaTierra());
		unAtaqueBasico.realizar(unGoku,cell);
		assertTrue(cell.obtenerPuntosDeVida() == 480);
	}

	@Test
	public void testSiGokuHaceUnAtaqueBasicoAOtroPersonajeDeberiaSacarleElPoderdePeleaDeVida() {
		Goku unGoku = new Goku(new Casillero(),new GuerrerosZ());
		Cell unCell = new Cell(new Casillero(), new EnemigosDeLaTierra());
		unGoku.atacar(unCell);
		assertTrue(unCell.obtenerPuntosDeVida() == 480);
	}

	@Test
	public void testSiGokuTransformadoAKaioKenHaceUnAtaqueBasicoAOtroPersonajeDeberiaSacarle40DeVida() throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario, NoRealizoLosAtaquesEspecialesNecesarias {

		Goku unGoku = new Goku(new Casillero(),new GuerrerosZ());
		Cell unCell = new Cell(new Casillero(), new EnemigosDeLaTierra());
		unGoku.incrementarKi(20);
		unGoku.transformarse(new KaioKen());
		unGoku.atacar(unCell);
		assertTrue(unCell.obtenerPuntosDeVida() == 460);
	}
	
	@Test
	public void testSiGokuTransformadoASuperSayajinHaceUnAtaqueBasicoAOtroPersonajeDeberiaSacarle60DeVida() throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario, NoRealizoLosAtaquesEspecialesNecesarias {
		Goku unGoku = new Goku(new Casillero(),new GuerrerosZ());
		Cell unCell = new Cell(new Casillero(), new EnemigosDeLaTierra());
		unGoku.incrementarKi(50);
		unGoku.transformarse(new SuperSayajin());
		unGoku.atacar(unCell);
		assertTrue(unCell.obtenerPuntosDeVida() == 440);
	}

	@Test
	public void testSiGokuAtacaAUnPersonajeDeMayorPoderDePeleaSeReduceElDanio20PorCiento() throws KiInsuficiente {
		Personaje goku = new Goku(new Casillero(),new GuerrerosZ());
		Personaje majinBoo = new MajinBoo(new Casillero(), new EnemigosDeLaTierra());
		goku.incrementarKi(50);
		goku.atacar(majinBoo);
		assertTrue(majinBoo.obtenerPuntosDeVida()==284);
	}

	@Test (expected = PersonajesDeUnMismoEquipoNoPuedenAtacarse.class)
	public void testGokuNoPuedeAtacarAGohanPorqueEsSuCompaniero() throws KiInsuficiente {
		GuerrerosZ equipoGuerrerosZ = new GuerrerosZ();
		Personaje goku = new Goku(new Casillero(),equipoGuerrerosZ);
		Personaje gohan = new Gohan(new Casillero(),equipoGuerrerosZ);
		goku.incrementarKi(50);
		goku.atacar(gohan);
	}

}
