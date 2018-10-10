package controlador;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import modelo.aspectos.Aspecto;
import modelo.personajes.Personaje;
import vista.BarraSuperior;
import vista.BotonAtaque;
import vista.VistaPrincipal;

/**
 * Created by marianoogimenez on 19/6/17.
 */
public class SeleccionarAtaqueHandler implements EventHandler<MouseEvent> {

    private BarraSuperior barraSuperior;
    private BotonAtaque botonAtaque;


    public SeleccionarAtaqueHandler(BotonAtaque botonAtaque, BarraSuperior vistaBarraSuperior) {

        this.barraSuperior = vistaBarraSuperior;
        this.botonAtaque = botonAtaque;
    }

    @Override
    public void handle(MouseEvent event)  {
        try{
            barraSuperior.seleccionarModoAtaque(botonAtaque);
        }catch (Exception e){
            barraSuperior.actualizar();
        }

    }

}