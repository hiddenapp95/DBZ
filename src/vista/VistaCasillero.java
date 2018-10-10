package vista;
import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.scene.layout.*;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;
import modelo.consumibles.Consumible;
import modelo.excepciones.NoPuedeRealizarAccionEnEsteEstado;
import modelo.excepciones.PersonajeNoEstaDebajoDelPorcDeVidaNecesario;
import modelo.juego.Casillero;
import modelo.personajes.Personaje;

import static javafx.animation.Animation.INDEFINITE;

/**
 * Created by marianoogimenez on 13/6/17.
 */
public class VistaCasillero extends Pane {
    private static final double ANCHO_CASILLERO = 0.38;
    private static final int PORCENTAJE_TITILAR = 20 ;
    private VistaPersonaje vistaPersonaje;
    Casillero casillero;

    public VistaCasillero(Casillero casillero){
        this.getStyleClass().add("casillero");
        this.setDisable(true);
        this.casillero = casillero;
        dibujar();
    }

    private String getClassName(String string ){
        String className = string.toLowerCase();
        className = className.replaceAll("\\s", "-");
        return className;
    }

	public void vistaAtaque() {
		this.getStyleClass().add("ataque");
		this.setDisable(false);
	}

	public void vistaMover() {
		this.setDisable(false);
	}

	public void vistaNormal() {
        this.getStyleClass().removeAll("ataque");
		this.setDisable(true);
	}

    public VistaPersonaje getVistaPersonaje() {
        return vistaPersonaje;
    }

    private void dibujar(){
        this.setDisable(true);
        this.getStyleClass().add("casillero");
        BorderPane border = new BorderPane();
        if(casillero.tienePersonaje()){
            Personaje personaje = casillero.getPersonaje();
            vistaPersonaje = new VistaPersonaje(personaje);
            this.getStyleClass().add(getClassName(personaje.nombreDeEquipoAlQuePertenece()));
            try {
                personaje.puedeAccionar();
            }
            catch (NoPuedeRealizarAccionEnEsteEstado e){
                vistaPersonaje = new VistaPersonaje(personaje,"chocolate-bar.png");
            }
            border.setCenter(vistaPersonaje);

            try {
                personaje.estaEnMenosDePorcentaje(PORCENTAJE_TITILAR);
                vistaPersonaje.agregarEfectoTitilar(1000,0,0.3);
            } catch (PersonajeNoEstaDebajoDelPorcDeVidaNecesario personajeNoEstaDebajoDelPorcDeVidaNecesario) {

            }
        }

        if(casillero.tieneConsumible()){
            Consumible consumible = casillero.getConsumible();
            VistaConsumible vistaConsumible = new VistaConsumible(consumible);
            border.setCenter(vistaConsumible);
        }

        this.getChildren().add(border);

    }

	public void actualizar() {
        this.getStyleClass().clear();
		this.getChildren().clear();
		dibujar();
	}

}
