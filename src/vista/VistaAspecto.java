package vista;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import modelo.aspectos.Aspecto;
import modelo.personajes.Personaje;

import java.awt.*;

/**
 * Created by marianoogimenez on 18/6/17.
 */
public class VistaAspecto extends HBox {

    private Image imagen;
    private String imgLocation = "vista/imagenes/";
    private  String filename;
    private Text costoKi;

    public VistaAspecto(Aspecto aspecto , Personaje personaje){
        this.getStyleClass().add("contenedor-aspecto");
        this.filename = personaje.getNombre() + "-" + aspecto.obtenerNombre()+ ".png";
        this.imagen = new Image(imgLocation + filename);
        String costoKi = Integer.toString(aspecto.obtenerCostoKi());
        this.costoKi = new Text(costoKi);
        this.costoKi.setFill(Color.WHITE);

        HBox contenedorCostoKi = new HBox();
        contenedorCostoKi.getStyleClass().add("containerCostoKi");
        contenedorCostoKi.getChildren().add(this.costoKi);

        if(aspecto.equals(personaje.obtenerAspecto())){
            this.getStyleClass().add("seleccionado");
            this.setDisable(true);
        }

        ImageView imgView = new ImageView(this.imagen);
        imgView.getStyleClass().add("imgAspecto");
        imgView.setFitHeight(45);
        imgView.setPreserveRatio(true);
        this.getChildren().addAll(imgView,contenedorCostoKi);
    }

}