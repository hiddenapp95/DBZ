package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import vista.DragonAlgoBall;


public class SalirJuego  implements  EventHandler<ActionEvent> {

	private DragonAlgoBall mainApp;
	
	public SalirJuego(DragonAlgoBall mainApp) {
		this.mainApp = mainApp;
	}
	
	@Override
	public void handle(ActionEvent actionEvent) {
		// TODO Auto-generated method stub
		
		this.mainApp.salir();

	}

}
