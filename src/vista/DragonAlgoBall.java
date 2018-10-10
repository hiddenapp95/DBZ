package vista; /**
 * Created by marianoogimenez on 13/6/17.
 */


import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;
import modelo.juego.Juego;
import modelo.personajes.Equipo;

import java.io.File;


public class DragonAlgoBall extends Application {
    private Stage stage;
    private  Juego juego;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage){
        this.stage = stage;
        stage.setTitle("Dragon AlgoBall");
        Application.setUserAgentStylesheet(getClass().getResource("css/main.css").toExternalForm());
        this.mostrarPantallaDeInicio();
    }

    public void comenzarJuego(){
        juego = new Juego();
        VistaPrincipal vistaPrincipal = new VistaPrincipal(this,juego);
        final Group group = new Group(vistaPrincipal);
        setearScene(group);
        stage.setFullScreen(true);
    }

    private void setearScene(Group group){
        Scene scene = new Scene(group,960, 600);
        scaleScene(group,scene);
        stage.setScene(scene);

    }

    public void mostrarPantallaDeInicio(){
        VistaInicial vistaInicial = new VistaInicial(this);
        final Group group = new Group(vistaInicial);
        setearScene(group);
        stage.show();

    }

    public void pantallaFinDeJuego(Equipo ganador){
        VistaInicial vistaInicial = new VistaInicial(this);
        vistaInicial.mostrarEquipoGanador(ganador);
        final Group group = new Group(vistaInicial);
        setearScene(group);


    }

    public void scaleScene(Group group, Scene scene){
        Scale scale = new Scale();
        final double initWidth = scene.getWidth();
        final double initHeight = scene.getHeight();
        scale.xProperty().bind(scene.widthProperty().divide(initWidth));
        scale.yProperty().bind(scene.heightProperty().divide(initHeight));
        scale.setPivotX(0);
        scale.setPivotY(0);
        group.getTransforms().addAll(scale);
    }

	public void salir(){
        this.stage.close();
    }





}
