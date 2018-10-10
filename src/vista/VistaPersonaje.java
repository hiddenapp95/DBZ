package vista;

import javafx.animation.FadeTransition;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.util.Duration;
import modelo.aspectos.Aspecto;
import modelo.excepciones.PersonajeNoEstaDebajoDelPorcDeVidaNecesario;
import modelo.personajes.Personaje;

import java.awt.*;

import static javafx.animation.Animation.INDEFINITE;

/**
 * Created by marianoogimenez on 17/6/17.
 */
public class VistaPersonaje extends VBox{
    private Image imagen;
    private String imgLocation = "vista/imagenes/";
    private  String fileName;
    private static final double ANCHO_VIDA = 0.36;
    private static final double PORCENTAJE_TITILAR = 20;

    public VistaPersonaje(Personaje personaje){
        this(personaje,"");
    }

    public VistaPersonaje(Personaje personaje,String imageFileName){
        this.getStyleClass().add("contenedor-personaje");
        fileName = (imageFileName == "") ? personaje.getNombre() + "-" + personaje.obtenerNombreDeAspecto()+ ".png" : imageFileName ;
        this.imagen = new Image(imgLocation + fileName);

        ImageView imgView = new ImageView(this.imagen);
        imgView.getStyleClass().add("imgPersonaje");
        imgView.setFitHeight(33);
        imgView.setPreserveRatio(true);
        this.getChildren().add(imgView);

        Pane lifeBar = new Pane();
        lifeBar.getStyleClass().add("lifeBar");
        lifeBar.setPrefWidth(personaje.obtenerPorcentajeDeVida()*ANCHO_VIDA);
        lifeBar.setMaxWidth(personaje.obtenerPorcentajeDeVida()*ANCHO_VIDA);
        Pane lifeBarContainer = new Pane(lifeBar);
        lifeBarContainer.getStyleClass().add("lifeBarContainer");

        this.getChildren().add(lifeBarContainer);
    }

    public void agregarEfectoTitilar(int duracion, int iteraciones, double transparency) throws PersonajeNoEstaDebajoDelPorcDeVidaNecesario {
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(duracion), this);
        fadeTransition.setFromValue(1.0);//transparencia inicial
        fadeTransition.setToValue(transparency);//transparencia maxima
        fadeTransition.setCycleCount((iteraciones != 0)? iteraciones:INDEFINITE);
        fadeTransition.setAutoReverse(true);
        fadeTransition.play();
    }
}
