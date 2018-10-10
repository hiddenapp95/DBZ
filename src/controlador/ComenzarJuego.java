package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import vista.DragonAlgoBall;
import vista.VistaPrincipal;

/**
 * Created by marianoogimenez on 19/6/17.
 */
public class ComenzarJuego implements EventHandler<ActionEvent> {

        private DragonAlgoBall appJuego;


        public ComenzarJuego(DragonAlgoBall appJuego) {
            this.appJuego = appJuego;
        }

        @Override
        public void handle(ActionEvent actionEvent) {
            this.appJuego.comenzarJuego();
        }

    }