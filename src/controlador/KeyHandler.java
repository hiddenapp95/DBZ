package controlador;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import modelo.juego.Juego;
import vista.VistaPrincipal;

/**
 * Created by marianoogimenez on 18/6/17.
 */
public class KeyHandler  implements EventHandler<KeyEvent> {

    private  Juego juego;
    private VistaPrincipal vistaPrincipal;

    public KeyHandler(VistaPrincipal vistaPrincipal, Juego juego){
        this.juego = juego;
        this.vistaPrincipal = vistaPrincipal;
    }

    @Override
    public void handle(KeyEvent event) {
        switch (event.getCode()) {
            case SPACE: juego.pasarTurno();

        }

    }
}
