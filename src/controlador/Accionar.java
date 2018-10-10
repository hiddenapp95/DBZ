package controlador;

import modelo.excepciones.AtaqueFueraDeRango;
import modelo.excepciones.KiInsuficiente;
import modelo.excepciones.LaVelocidadNoAlcanzaParaMoverseEstaDistancia;
import modelo.excepciones.MovimientoInvalido;
import modelo.excepciones.NoPuedeRealizarAccionEnEsteEstado;
import modelo.excepciones.PersonajesDeUnMismoEquipoNoPuedenAtacarse;
import modelo.excepciones.PrimerCasilleroRecienSeleccionado;
import modelo.excepciones.YaSeRealizoUnAtaqueEnEsteTurno;
import modelo.excepciones.YaSeRealizoUnMovimientoEnEsteTurno;
import modelo.juego.Casillero;
import modelo.juego.Juego;
import modelo.personajes.Personaje;
import vista.VistaPrincipal;

public class Accionar {

	private Juego juego;
	private  VistaPrincipal vistaPrincipal;
	private Casillero primerCasilleroSeleccionado = null;

	public Accionar(Juego juego, VistaPrincipal vistaPrincipal) {
		this.juego = juego;
		this.vistaPrincipal = vistaPrincipal;
	}

	public void accionarSobreCasillero(Casillero casillero){
		// TODO Auto-generated method stub

		this.primerCasilleroVacio();
		if (this.cancelarSeleccion(casillero))
			return;

		if (casillero.tienePersonaje()) {

			try {
			    Personaje agresor = primerCasilleroSeleccionado.getPersonaje();
			    Personaje victima = casillero.getPersonaje();
				//this.juego.ataqueBasico(agresor, victima);
			    this.realizarAtaque(agresor,victima);
			} catch (YaSeRealizoUnAtaqueEnEsteTurno e) {
				vistaPrincipal.mostrarMensaje(e.getMessage());
			}  catch (PersonajesDeUnMismoEquipoNoPuedenAtacarse e) {
				
				throw new PrimerCasilleroRecienSeleccionado();
			}catch (NoPuedeRealizarAccionEnEsteEstado e) {
				vistaPrincipal.mostrarMensaje(e.getMessage());
			}catch (KiInsuficiente e) {
				vistaPrincipal.mostrarMensaje(e.getMessage());
			}catch (AtaqueFueraDeRango e) {
				vistaPrincipal.mostrarMensaje(e.getMessage());
			}
			this.limpiarAccionar();
		} else {
			try {
				this.juego.mover(this.primerCasilleroSeleccionado.getPersonaje(), casillero);
				this.vistaPrincipal.mostrarTransicionDeMovimiento(this.primerCasilleroSeleccionado,casillero);
			} catch (YaSeRealizoUnMovimientoEnEsteTurno e) {
				vistaPrincipal.mostrarMensaje(e.getMessage());
			} catch (LaVelocidadNoAlcanzaParaMoverseEstaDistancia e) {
				vistaPrincipal.mostrarMensaje(e.getMessage());
			}catch (NoPuedeRealizarAccionEnEsteEstado e) {
				vistaPrincipal.mostrarMensaje(e.getMessage());
			}catch (MovimientoInvalido e) {
				vistaPrincipal.mostrarMensaje(e.getMessage());
			}finally{
				this.limpiarAccionar();
			}

		}

	}

	private void realizarAtaque(Personaje agresor, Personaje victima) throws YaSeRealizoUnAtaqueEnEsteTurno, KiInsuficiente {
		Casillero destino = victima.obtenerCasillero();
		if(this.vistaPrincipal.ataqueNormalSeleccionado()) {
			this.juego.ataqueBasico(agresor, victima);
			vistaPrincipal.mostrarMensaje(agresor.getNombre() + " REALIZO ATAQUE "+agresor.obtenerNombreAtaqueBasico()+" A " + victima.getNombre());
			this.vistaPrincipal.mostrarTransicionDeAtaqueBasico(agresor,destino);
		}else {
			this.juego.ataqueEspecial(agresor, victima);
			vistaPrincipal.mostrarMensaje(agresor.getNombre() + " REALIZO ATAQUE  "+agresor.obtenerNombreAtaqueEspecial()+" A " + victima.getNombre());
			this.vistaPrincipal.mostrarTransicionDeAtaqueEspecial(agresor,destino);
		}
	}

	private boolean cancelarSeleccion(Casillero casillero) {
		if (this.primerCasilleroSeleccionado.obtenerCoordenada().equals(casillero.obtenerCoordenada())) {
			this.limpiarAccionar();
			return true;
		}
		return false;
	}

	public void agregarPrimerCasillero(Casillero casillero) {
		Personaje unPersonaje = juego.obtenerTierra().obtenerPersonaje(casillero.obtenerCoordenada());
		unPersonaje.puedeAccionar();
		String equipoActual = juego.obtenerTurno().nombreEquipoActual();
		String equipoPersonaje = unPersonaje.nombreDeEquipoAlQuePertenece();
		if (equipoPersonaje.equals(equipoActual)) {
		    vistaPrincipal.mostrarInfoPersonaje(unPersonaje);
			this.primerCasilleroSeleccionado = casillero;
		}
	}

	public void limpiarAccionar() {
	    this.primerCasilleroSeleccionado = null;
	}

	public void primerCasilleroVacio() {
		if (primerCasilleroSeleccionado == null)
			throw new PrimerCasilleroRecienSeleccionado();
	}


}
