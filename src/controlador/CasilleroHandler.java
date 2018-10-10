package controlador;

import java.util.Vector;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import modelo.excepciones.CasilleroVacio;
import modelo.excepciones.NoPuedeRealizarAccionEnEsteEstado;
import modelo.excepciones.PrimerCasilleroRecienSeleccionado;
import modelo.juego.Casillero;
import modelo.juego.Juego;
import vista.VistaPrincipal;
import vista.VistaTierra;

public class CasilleroHandler implements EventHandler<MouseEvent> {

	    private  Casillero casillero;
	    private  Juego juego;
	    private VistaTierra vistaTierra;
	    private Accionar accionar;
	    private VistaPrincipal vistaPrincipal;

	    public CasilleroHandler(Juego juego, Casillero casillero,Accionar accionar,VistaPrincipal vistaPrincipal,VistaTierra vistaTierra) {
	        this.casillero = casillero;
	        this.juego = juego;
	        this.vistaTierra = vistaTierra;
	        this.accionar = accionar;
	        this.vistaPrincipal = vistaPrincipal;
	    }

	    @Override
	    public void handle(MouseEvent event)  {
	    	try {
	    		this.accionar.accionarSobreCasillero(casillero);
	    	}catch (PrimerCasilleroRecienSeleccionado e){
	    		try {
	    			vistaTierra.vistaNormal();
					vistaTierra.habilitarCasilleros(juego.obtenerPosicionDeMiembrosDelEquipoActual());
	    			this.accionar.agregarPrimerCasillero(casillero);

	    			try {
	    				Vector<Casillero> casillerosMover = this.juego.casillerosALosQuePuedeMoverse(this.casillero.obtenerCoordenada());
	    				vistaTierra.cambiarVistaMover(casillerosMover);
	    				Vector<Casillero> casillerosAtaque = this.juego.casillerosALosQuePuedeAtacar(this.casillero.obtenerCoordenada());
	    				vistaTierra.cambiarVistaAtaque(casillerosAtaque);
	    			}catch(CasilleroVacio e1) {
	    				this.accionar.limpiarAccionar();
	    				vistaTierra.vistaNormal();
	    			}
	    			return;

	    		}catch(NoPuedeRealizarAccionEnEsteEstado e2) {
					vistaPrincipal.mostrarMensaje(e2.getMessage());
	    		}
	    	}
	    	vistaTierra.vistaNormal();
			vistaTierra.habilitarCasilleros(juego.obtenerPosicionDeMiembrosDelEquipoActual());
	    	
	    }

}


