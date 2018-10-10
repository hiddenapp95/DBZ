package vista;

import controlador.KeyHandler;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.*;
import javafx.util.Duration;
import modelo.excepciones.AunNoHayEquipoGanador;
import modelo.juego.Casillero;
import modelo.juego.Juego;
import modelo.juego.Tierra;
import modelo.juego.Turno;
import modelo.personajes.Equipo;
import modelo.personajes.Personaje;


public class VistaPrincipal extends GridPane{
	private DragonAlgoBall appJuego;
    private VistaTierra vistaTierra;
    private VistaTurno vistaTurno;
    private BarraSuperior vistaBarraSuperior;

    private Tierra tierra;
    private Juego juego;
    private Turno turno;


    public VistaPrincipal(DragonAlgoBall appJuego, Juego juego){
        this.setId("contenedorPrincipal");
        this.appJuego = appJuego;
        this.juego = juego;
        this.tierra = juego.obtenerTierra();
        this.turno = juego.obtenerTurno();
        this.vistaTurno = new VistaTurno(turno,this);
        this.vistaTierra = new VistaTierra(tierra,juego,this);
        this.vistaBarraSuperior = new BarraSuperior(this);
        this.insertarElementos();
        this.setOnKeyPressed(new KeyHandler(this,juego));
        this.mostrarMensaje("Seleccione un personaje");
    }

    private void insertarElementos(){
        this.add(vistaBarraSuperior,1,0,1,1);
        this.add(vistaTurno, 2,0,1,2);
        this.add(vistaTierra,1,1,1,1);
    }

	public void actualizar() {
		this.vistaTurno.actualizar();
		this.vistaTierra.actualizar();
		this.vistaBarraSuperior.actualizar();

		Equipo equipoGanador;
		try {
			equipoGanador = this.juego.equipoGanador();
		}catch (AunNoHayEquipoGanador e) {
			return;
		}
		appJuego.pantallaFinDeJuego(equipoGanador);
	}

	public void mostrarMensaje(String mensaje){
        this.vistaBarraSuperior.mostrarMensaje(mensaje);
    }

    public void mostrarInfoPersonaje(Personaje personaje){
	    this.vistaBarraSuperior.mostrarInfoPersonaje(personaje);
    }

	public boolean ataqueNormalSeleccionado() {
		// TODO Auto-generated method stub
		return this.vistaBarraSuperior.ataqueNormalSeleccionado();
	}

	public void limpiarSeleccion() {
		this.vistaTierra.limpiarSeleccion();
	}

    public void mostrarTransicionDeMovimiento(Casillero primerCasilleroSeleccionado, Casillero casillero) {
        this.vistaTierra.mostrarTransicionDeMovimiento(primerCasilleroSeleccionado,casillero);
    }

    public void mostrarTransicionDeAtaqueBasico(Personaje agresor, Casillero destino) {
        this.vistaTierra.mostrarTransicionDeAtaqueBasico(agresor,destino);
    }

    public void mostrarTransicionDeAtaqueEspecial(Personaje agresor, Casillero destino){
        this.vistaTierra.mostrarTransicionDeAtaqueEspecial(agresor,destino);
    }
}
