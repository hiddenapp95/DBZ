package modelo.juego;

import modelo.excepciones.PersonajeNoEstaDebajoDelPorcDeVidaNecesario;
import modelo.aspectos.KaioKen;
import modelo.aspectos.Perfecto;
import modelo.aspectos.Protector;
import modelo.aspectos.SemiPerfecto;
import modelo.aspectos.SuperSayajin;
import modelo.aspectos.SuperSayajinFase2;
import modelo.excepciones.KiInsuficiente;
import modelo.excepciones.LaVelocidadNoAlcanzaParaMoverseEstaDistancia;
import modelo.excepciones.NoRealizoLosAtaquesEspecialesNecesarias;
import modelo.personajes.Cell;
import modelo.personajes.EnemigosDeLaTierra;
import modelo.personajes.Gohan;
import modelo.personajes.Goku;
import modelo.personajes.GuerrerosZ;
import modelo.personajes.Piccolo;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Franco on 6/4/2017.
 */
public class TransformacionesTest {
    @Test (expected = KiInsuficiente.class)
    public void CrearAGokuYVerificarQueNoSePuedeTransformar() throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario, NoRealizoLosAtaquesEspecialesNecesarias {
        Casillero unCasillero = new Casillero();
        Goku goku = new Goku(unCasillero,new GuerrerosZ());
        goku.transformarse(new KaioKen());
    }

    @Test
    public void CrearUnGokuIncrementarle20PuntosDeKiYVerQueSePuedeTransformar() throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario, NoRealizoLosAtaquesEspecialesNecesarias {
        Casillero unCasillero = new Casillero();
        Goku goku = new Goku(unCasillero,new GuerrerosZ());
        goku.increaseKi(20);
        goku.transformarse(new KaioKen());
        assertTrue(goku.obtenerNombreDeAspecto() == "KAIO KEN");
    }

    @Test
    public void CrearUnGokuTransformarloYMoverloDeLugar() throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario, NoRealizoLosAtaquesEspecialesNecesarias, LaVelocidadNoAlcanzaParaMoverseEstaDistancia {

        Tierra laTierra = new Tierra();
        Coordenada unaCoordenada = new Coordenada(0,0);
        Coordenada otraCoordenada = new Coordenada(1,1);
        Goku goku = new Goku(laTierra.obtenerCasillero(unaCoordenada),new GuerrerosZ());

        goku.increaseKi(20);
        goku.transformarse(new KaioKen());

        goku.moverseACasillero(laTierra.obtenerCasillero(otraCoordenada));
        assertTrue(laTierra.obtenerCasillero(otraCoordenada).tienePersonaje());
    }
    
	
	@Test(expected = PersonajeNoEstaDebajoDelPorcDeVidaNecesario.class)
	public void testGohanNoSePuedeTransformarASuperSayajinCuandoSuEquipoNoEstaDebajoDel20PorcdeVida() throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario, NoRealizoLosAtaquesEspecialesNecesarias {

		Casillero unCasillero = new Casillero();
		GuerrerosZ guerrerosZ =new GuerrerosZ();
		Goku unGoku = new Goku(unCasillero,guerrerosZ);
		Gohan unGohan = new Gohan(new Casillero(),guerrerosZ);
		Piccolo unPiccolo = new Piccolo(new Casillero(),guerrerosZ);

		unGohan.incrementarKi(30);
		unGohan.transformarse(new SuperSayajinFase2());
	}
	
	 @Test (expected = PersonajeNoEstaDebajoDelPorcDeVidaNecesario.class)
	    public void obtenerPorcentajeDeVidaDeberiaLanzarErrorSiElPorcentajeDeVidaEsMenor() throws PersonajeNoEstaDebajoDelPorcDeVidaNecesario{
	        Goku goku = new Goku(new Casillero(),new GuerrerosZ());
	        goku.quitarVida(250);
	        goku.estaEnMenosDePorcentaje(20);
	    }
	 
	 @Test
		public void testGohanSePuedeTransformarASuperSayajinCuandoSuEquipoEstaDebajoDel20PorcdeVida() throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario, NoRealizoLosAtaquesEspecialesNecesarias {

			Casillero unCasillero = new Casillero();
			GuerrerosZ guerrerosZ =new GuerrerosZ();
			Goku unGoku = new Goku(unCasillero,guerrerosZ);
			Gohan unGohan = new Gohan(new Casillero(),guerrerosZ);
			Piccolo unPiccolo = new Piccolo(new Casillero(),guerrerosZ);
			
			unGoku.quitarVida(410);
			unPiccolo.quitarVida(410);
			unGohan.incrementarKi(30);
			unGohan.transformarse(new SuperSayajinFase2());
			assertTrue(unGohan.obtenerNombreDeAspecto()=="SUPER SAYAJIN FASE 2");
		}
		
	 @Test
		public void testPiccolosePuedeTransformarAProtectorCuandoGohanEstaDebajoDel20PorcdeVida() throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario, NoRealizoLosAtaquesEspecialesNecesarias {

			Casillero unCasillero = new Casillero();
			GuerrerosZ guerrerosZ =new GuerrerosZ();
			Goku unGoku = new Goku(unCasillero,guerrerosZ);
			Gohan unGohan = new Gohan(new Casillero(),guerrerosZ);
			Piccolo unPiccolo = new Piccolo(new Casillero(),guerrerosZ);
			
			unGohan.quitarVida(410);
			unPiccolo.transformarse(new Protector());
			assertTrue(unPiccolo.obtenerNombreDeAspecto()=="PROTECTOR");
		}
	 @Test (expected = PersonajeNoEstaDebajoDelPorcDeVidaNecesario.class)
		public void testPiccolosNoePuedeTransformarAProtectorSiGohanNoEstaDebajoDel20PorcdeVida() throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario, NoRealizoLosAtaquesEspecialesNecesarias {

			Casillero unCasillero = new Casillero();
			GuerrerosZ guerrerosZ =new GuerrerosZ();
			Goku unGoku = new Goku(unCasillero,guerrerosZ);
			Gohan unGohan = new Gohan(new Casillero(),guerrerosZ);
			Piccolo unPiccolo = new Piccolo(new Casillero(),guerrerosZ);
			
			unPiccolo.transformarse(new Protector());
		}
	 
	 @Test (expected = NoRealizoLosAtaquesEspecialesNecesarias.class)
		public void testCellNoSePuedeTransformarASemiPerfectoCuandoSiRealizoMenosDe4Absorciones() throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario, NoRealizoLosAtaquesEspecialesNecesarias {

			Casillero unCasillero = new Casillero();
			Cell unCell = new Cell(unCasillero, new EnemigosDeLaTierra());
			
			unCell.transformarse(new SemiPerfecto());
		}
	 
	 @Test (expected = NoRealizoLosAtaquesEspecialesNecesarias.class)
		public void testCellNoSePuedeTransformarAPerfectoCuandoSiRealizoMenosDe8Absorciones() throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario, NoRealizoLosAtaquesEspecialesNecesarias {

			Casillero unCasillero = new Casillero();
			Cell unCell = new Cell(unCasillero, new EnemigosDeLaTierra());
			
			unCell.transformarse(new Perfecto());
		}

}
