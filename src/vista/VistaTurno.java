package vista;
import controlador.PasarTurnoHandler;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import modelo.juego.Juego;
import modelo.juego.Turno;


/**
 * Created by marianoogimenez on 15/6/17.
 */
public class VistaTurno extends GridPane {
    private String nombreEquipoActual;
    private int ataquesRestantes, movimientosRestantes, cantidadDeEsferas;
    private Turno turno;
    private Juego juego;
    private Text textNombreEquipoActual;
    private Text textCantidadDeEsferas;
    private Text textMovimientosRestantes;
    private Text textAtaquesRestantes;
    private VistaPrincipal vistaPrincipal;

    public VistaTurno(Turno turno, VistaPrincipal vistaPrincipal){
        this.setId("barraDerecha");
        this.turno = turno;
        this.movimientosRestantes = turno.movimientosRestantes();
        this.ataquesRestantes = turno.ataquesRestantes();
        this.nombreEquipoActual = turno.nombreEquipoActual();
        this.cantidadDeEsferas = turno.cantidadDeEsferasDelDragonEquipoActual();
        this.vistaPrincipal = vistaPrincipal;
        dibujar();

    }

    private void dibujar(){
        textNombreEquipoActual = createText(turno.nombreEquipoActual());
        textNombreEquipoActual.setId("nombreEquipo");
        textCantidadDeEsferas = createText("Esferas del dragon: "+cantidadDeEsferas);
        textMovimientosRestantes = createText("Movimientos restantes: " + movimientosRestantes);
        textAtaquesRestantes = createText("Ataques restantes: "+ ataquesRestantes);


        VBox infoContainer = new VBox();
        infoContainer.setId("infoContainer");

        VBox containerNombreEquipo = new VBox();
        containerNombreEquipo.setId("containerNombreEquipo");

        containerNombreEquipo.getChildren().add(textNombreEquipoActual);
        infoContainer.getChildren().addAll(containerNombreEquipo, textCantidadDeEsferas, textMovimientosRestantes, textAtaquesRestantes);


        Pane espacioVacio = new Pane();
        espacioVacio.setId("espacioVacioBarraDerecha");

        Button botonPasarTurno = new Button("Pasar turno ");
        botonPasarTurno.setId("pasar-turno");

        PasarTurnoHandler pasarTurnoHandler = new PasarTurnoHandler(this.turno, vistaPrincipal);
        botonPasarTurno.setOnAction(pasarTurnoHandler);


        ColumnConstraints col0 = new ColumnConstraints(26);
        ColumnConstraints col1 = new ColumnConstraints(130);
        ColumnConstraints col2 = new ColumnConstraints(26);

        this.getColumnConstraints().addAll(col0,col1,col2);

        this.add(infoContainer,1,1,1,1);
        this.add(espacioVacio, 1,2,1,1 );
        this.add(botonPasarTurno, 1,3,1,1);
    }

    private Text createText(String text){
        Text newText = new Text(text);
        newText.setWrappingWidth(130);
        newText.setFill(Color.WHITE);
        newText.getStyleClass().add("texto");
        return newText;
    }

    public void actualizar() {
        //this.vistaPrincipal.limpiarSeleccion();
        this.movimientosRestantes = turno.movimientosRestantes();
          this.ataquesRestantes = turno.ataquesRestantes();
          this.nombreEquipoActual = turno.nombreEquipoActual();
          this.cantidadDeEsferas = turno.cantidadDeEsferasDelDragonEquipoActual();
          this.textNombreEquipoActual.setText(turno.nombreEquipoActual());
          this.textCantidadDeEsferas.setText("Esferas del dragon: "+cantidadDeEsferas);
          this.textMovimientosRestantes.setText("Movimientos restantes: " + movimientosRestantes);
          this.textAtaquesRestantes.setText("Ataques restantes: "+ ataquesRestantes);
    }

}
