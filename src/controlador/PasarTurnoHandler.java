package controlador;

import java.util.Vector;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.juego.Casillero;
import modelo.juego.Juego;
import modelo.juego.Turno;
import vista.VistaPrincipal;
import vista.VistaTierra;
import vista.VistaTurno;

public class PasarTurnoHandler  implements EventHandler<ActionEvent> {

  
    private Turno turno;
    private VistaPrincipal vistaPrincipal;
  

    public PasarTurnoHandler(Turno turno, VistaPrincipal vistaPrincipal) {
    	this.vistaPrincipal = vistaPrincipal;
        this.turno = turno;
     
    }

    @Override
    public void handle(ActionEvent actionEvent) {
    	this.turno.cambiarTurno();
    	this.vistaPrincipal.actualizar();
    	this.vistaPrincipal.mostrarMensaje("Seleccione un personaje");
    	
    }
}
