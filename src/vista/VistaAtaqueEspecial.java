package vista;

import javafx.animation.FadeTransition;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;
import modelo.ataques.Ataque;
import modelo.excepciones.PersonajeNoEstaDebajoDelPorcDeVidaNecesario;
import modelo.juego.Coordenada;
import modelo.personajes.Personaje;

import static javafx.animation.Animation.INDEFINITE;

/**
 * Created by Franco on 8/5/2017.
 */
public class VistaAtaqueEspecial extends Pane {
    private String imgLocation = "vista/imagenes/";

    public VistaAtaqueEspecial(String attackName){
        //this.getStyleClass().add("contenedor-personaje");
        //final Rectangle rectangle = new Rectangle(36, 36);
        //rectangle.setArcHeight(15);
        //rectangle.setArcWidth(15);
        //rectangle.setFill(Color.DARKBLUE);

        this.getStyleClass().add("contenedor-personaje");

        ImageView imgView = new ImageView(imgLocation + attackName.replace(" ","-") + ".gif");
        imgView.getStyleClass().add("imgPersonaje");
        imgView.setFitHeight(40);
        imgView.setFitWidth(40);
        imgView.setPreserveRatio(true);
        this.getChildren().add(imgView);

        //this.getChildren().add(rectangle);
    }

}
