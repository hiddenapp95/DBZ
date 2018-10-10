package vista;

import com.sun.javafx.font.freetype.HBGlyphLayout;
import controlador.ComenzarJuego;
import controlador.SalirJuego;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import modelo.personajes.Equipo;

/**
 * Created by marianoogimenez on 19/6/17.
 */
public class VistaInicial extends StackPane {
    private DragonAlgoBall mainApp;
    private ImageView logo;

    public VistaInicial(DragonAlgoBall mainApp){
        this.mainApp = mainApp;
        this.setId("vistaInicial");
        VBox centerBox = new VBox();
        centerBox.setSpacing(40);
        HBox contenedorDeTitulo = new HBox();
        HBox contenedorDeBotones = new HBox();

        Image imgLogo = new Image("vista/imagenes/logo.png");
        logo = new ImageView(imgLogo);

        logo.getStyleClass().add("imgLogo");
        logo.setFitWidth(400);
        logo.setPreserveRatio(true);

        contenedorDeTitulo.getChildren().add(logo);
        Button botonComenzarJuego = new Button("Comenzar juego");
        botonComenzarJuego.setId("pasar-turno");
        botonComenzarJuego.setOnAction(new ComenzarJuego(mainApp));

        Button botonSalir = new Button("Salir");
        botonSalir.setId("pasar-turno");
        botonSalir.setOnAction(new SalirJuego(mainApp));
        contenedorDeBotones.setSpacing(90);
        contenedorDeBotones.getChildren().addAll(botonComenzarJuego, botonSalir);
        centerBox.getChildren().addAll(contenedorDeTitulo, contenedorDeBotones);
        centerBox.setId("centerBox");

        this.getChildren().add(centerBox);

    }


    public void mostrarEquipoGanador(Equipo equipo){
        Image imgLogo = new Image("vista/imagenes/"+equipo.nombreDelEquipo()+".png");
        this.logo.setImage(imgLogo);
    }


}
