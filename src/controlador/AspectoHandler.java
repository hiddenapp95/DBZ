package controlador;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import modelo.aspectos.Aspecto;
import modelo.juego.Casillero;
import modelo.juego.Juego;
import modelo.personajes.Personaje;
import vista.VistaPrincipal;
import vista.VistaTierra;

import java.util.Vector;

/**
 * Created by marianoogimenez on 18/6/17.
 */
public class AspectoHandler implements EventHandler<MouseEvent> {

    private VistaPrincipal vistaPrincipal;
    private Personaje personaje;
    private Aspecto aspecto;

    public AspectoHandler(Aspecto aspecto, Personaje personaje, VistaPrincipal vistaPrincipal) {

        this.vistaPrincipal = vistaPrincipal;
        this.personaje = personaje;
        this.aspecto = aspecto;
    }

    @Override
    public void handle(MouseEvent event)  {
        try{
            personaje.transformarse(aspecto);
        }catch (Exception e){
            vistaPrincipal.mostrarMensaje(e.getMessage());    
        }
        vistaPrincipal.actualizar();
        vistaPrincipal.limpiarSeleccion();
    }

}
