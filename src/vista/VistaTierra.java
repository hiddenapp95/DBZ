package vista;

import java.util.Vector;

import controlador.Accionar;
import controlador.CasilleroHandler;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import modelo.juego.Casillero;
import modelo.juego.Coordenada;
import modelo.juego.Juego;
import modelo.juego.Tierra;
import modelo.personajes.EnemigosDeLaTierra;
import modelo.personajes.Goku;
import modelo.personajes.Personaje;


/**
 * Created by marianoogimenez on 13/6/17.
 */
public class VistaTierra extends GridPane {
    private Tierra tierra;
    private Juego juego;
    private Accionar accionar;
    private VistaCasillero[][] vistaCasilleros;
    private VistaPrincipal vistaPrincipal;


    public VistaTierra(Tierra tierra,Juego juego, VistaPrincipal vistaPrincipal){
        this.tierra = tierra;
        this.juego = juego;
        this.vistaPrincipal = vistaPrincipal;
        this.setId("tablero");
        this.accionar = new Accionar(this.juego,vistaPrincipal);
        this.vistaCasilleros = new VistaCasillero[tierra.obtenerNumeroDeFilas()][tierra.obtenerNumeroDeColumnas()];
        this.dibujarCasilleros(vistaPrincipal);
        this.habilitarCasilleros(juego.obtenerPosicionDeMiembrosDelEquipoActual());
    }
    public void dibujarCasilleros(VistaPrincipal vistaPrincipal){
    	
        for(int fila = 0; fila<tierra.obtenerNumeroDeFilas() ; fila++){
            for(int columna = 0; columna<tierra.obtenerNumeroDeColumnas(); columna++){
                Coordenada coordenada = new Coordenada(fila,columna);
                Casillero casillero = tierra.obtenerCasillero(coordenada);
                VistaCasillero vistaCasillero = new VistaCasillero(casillero);
                CasilleroHandler casilleroHandler = new CasilleroHandler(this.juego,casillero,this.accionar,vistaPrincipal,this);
                vistaCasillero.setOnMouseClicked(casilleroHandler);
                this.add(vistaCasillero, columna, fila );
                this.vistaCasilleros[fila][columna] = vistaCasillero;
            }
        }
    }

    public VistaCasillero obtenerVistaCasillero(Coordenada unaCoordenada){
        return this.vistaCasilleros[unaCoordenada.getRow()][unaCoordenada.getCol()];
    }

	public void cambiarVistaMover(Vector<Casillero> casillerosMover) {
		
		for(Casillero casilleroMover : casillerosMover) {
			Coordenada coordenada = casilleroMover.obtenerCoordenada();
			this.vistaCasilleros[coordenada.getRow()][coordenada.getCol()].vistaMover();
		}
	}

	public void cambiarVistaAtaque(Vector<Casillero> casillerosAtaque) {
	
		for(Casillero casilleroAtaque : casillerosAtaque) {
			Coordenada coordenada = casilleroAtaque.obtenerCoordenada();
			this.vistaCasilleros[coordenada.getRow()][coordenada.getCol()].vistaAtaque();	
		}
		
	}
	public void vistaNormal() {
		 for(int fila = 0; fila<tierra.obtenerNumeroDeFilas() ; fila++){
	            for(int columna = 0; columna<tierra.obtenerNumeroDeColumnas(); columna++){
	            	 this.vistaCasilleros[fila][columna].vistaNormal();
	            }
		 }
		
	}
	public void actualizar() {
		for(int fila = 0; fila<tierra.obtenerNumeroDeFilas() ; fila++){
            for(int columna = 0; columna<tierra.obtenerNumeroDeColumnas(); columna++){
            	 this.vistaCasilleros[fila][columna].actualizar();
            }
	    }
	    this.habilitarCasilleros(juego.obtenerPosicionDeMiembrosDelEquipoActual());
        limpiarSeleccion();
	}

    public void habilitarCasilleros(Vector <Casillero> casilleros){
        for(Casillero casilleroMover : casilleros) {
            Coordenada coordenada = casilleroMover.obtenerCoordenada();
            this.vistaCasilleros[coordenada.getRow()][coordenada.getCol()].setDisable(false);
        }
    }
	public void limpiarSeleccion() {
		this.accionar.limpiarAccionar();
	}

    public void mostrarTransicionDeAtaqueBasico(Personaje agresor, Casillero destino) {
        VistaCasillero unaVistaCasillero = this.obtenerVistaCasillero(agresor.obtenerCoordenada());
        transicionDeMovimiento(unaVistaCasillero.getVistaPersonaje(),agresor.obtenerCasillero(),destino,500,true);
    }

    public void mostrarTransicionDeAtaqueEspecial(Personaje agresor, Casillero destino) {
        VistaAtaqueEspecial ataque = new VistaAtaqueEspecial(agresor.obtenerNombreAtaqueEspecial());
        this.vistaCasilleros[agresor.obtenerCoordenada().getRow()][agresor.obtenerCoordenada().getCol()].getChildren().add(ataque);
        boolean isLifeStealing = agresor.obtenerNombreAtaqueEspecial() == "ABSORBER" ? true:false;
        transicionDeAtaque(ataque,agresor.obtenerCasillero(),destino,1000,isLifeStealing,false);
    }

    public void mostrarTransicionDeMovimiento(Casillero origen, Casillero destino) {
        VistaCasillero unaVistaCasillero = this.obtenerVistaCasillero(origen.obtenerCoordenada());
        transicionDeMovimiento(unaVistaCasillero.getVistaPersonaje(),origen,destino,1000,false);
    }

    public void transicionDeMovimiento(Node vista, Casillero origen, Casillero destino, int milliSeconds, boolean isReverse){
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(milliSeconds), vista);
        translateTransition.setFromX(0);
        translateTransition.setFromY(0);
        translateTransition.setToX(40*(destino.obtenerCoordenada().getCol() - origen.obtenerCoordenada().getCol()));
        translateTransition.setToY(40*(destino.obtenerCoordenada().getRow() - origen.obtenerCoordenada().getRow()));
        translateTransition.setCycleCount((isReverse)? 2:1);
        translateTransition.setAutoReverse(isReverse);
        translateTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                vistaPrincipal.actualizar();
            }
        });
        vista.toFront();
        translateTransition.play();
        vista.toBack();
    }

    public void transicionDeAtaque(Node vista, Casillero origen, Casillero destino, int milliSeconds, boolean isReverse,boolean rotate){
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(milliSeconds), vista);
        translateTransition.setFromX(0);
        translateTransition.setFromY(0);
        translateTransition.setToX(40*(destino.obtenerCoordenada().getCol() - origen.obtenerCoordenada().getCol()));
        translateTransition.setToY(40*(destino.obtenerCoordenada().getRow() - origen.obtenerCoordenada().getRow()));
        translateTransition.setCycleCount(isReverse? 2:1);
        translateTransition.setAutoReverse(isReverse);

        FadeTransition fadeTransition =
                new FadeTransition(Duration.millis(isReverse? milliSeconds:milliSeconds+500), vista);
        fadeTransition.setFromValue(1.0f);
        fadeTransition.setToValue(0f);
        fadeTransition.setCycleCount(isReverse? 2:1);
        fadeTransition.setAutoReverse(isReverse);
        RotateTransition rotateTransition =
                new RotateTransition(Duration.millis((rotate)? milliSeconds:(double)0), vista);
        rotateTransition.setByAngle(180f);
        rotateTransition.setCycleCount(isReverse? 2:1);
        rotateTransition.setAutoReverse(true);

        ParallelTransition parallelTransition = new ParallelTransition();
        parallelTransition.getChildren().addAll(
                fadeTransition,
                translateTransition
                //rotateTransition
        );
        parallelTransition.setCycleCount(1);
        parallelTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                vistaPrincipal.actualizar();
            }
        });

        parallelTransition.play();
    }
}
