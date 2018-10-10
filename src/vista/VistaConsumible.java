package vista;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import modelo.consumibles.Consumible;
import modelo.personajes.Personaje;

/**
 * Created by Franco on 6/18/2017.
 */
public class VistaConsumible extends HBox{
    private Image imagen;
    private String imgLocation = "vista/imagenes/";
    private  String filename;

    public VistaConsumible(Consumible consumible){
        this.getStyleClass().add("contenedor-consumible");
        this.filename = consumible.obtenerNombre() + ".png";
        this.imagen = new Image(imgLocation + filename);

        ImageView imgView = new ImageView(this.imagen);
        imgView.getStyleClass().add("imgConsumible");
        imgView.setFitHeight(33);
        imgView.setPreserveRatio(true);
        this.getChildren().add(imgView);
    }
}
