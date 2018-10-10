package vista;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 * Created by marianoogimenez on 19/6/17.
 */
public class BotonAtaque extends VBox {
    private  String nombreAtaque;

    public BotonAtaque(String nombreAtaque, String costoKi){
        this.getStyleClass().addAll("contenedorAtaque");
        VBox contenedorCostoKi = new VBox();
        contenedorCostoKi.getStyleClass().addAll("containerCostoKi");

        Text tNombreAtaque = crearTexto(nombreAtaque);
        Text tCostoAtaque = crearTexto(costoKi);
        tNombreAtaque.setWrappingWidth(90);
        contenedorCostoKi.getChildren().add(tCostoAtaque);
        this.getChildren().addAll(tNombreAtaque,contenedorCostoKi);
        this.nombreAtaque = nombreAtaque;
    }

    private Text crearTexto(String string){
        Text nuevoTexto = new Text(string);
        nuevoTexto.setTextAlignment(TextAlignment.CENTER);
        nuevoTexto.setFill(Color.WHITE);
        return nuevoTexto;
    }

    private String getNombreAtaque(){
        return nombreAtaque;
    }

    public void seleccionar(){
        this.getStyleClass().addAll("seleccionado");
    }

    public void deseleccionar(){
        this.getStyleClass().removeAll("seleccionado");
    }

	public boolean ataqueNormalSeleccionado() {
		// TODO Auto-generated method stub
		return (this.nombreAtaque=="BASICO");
	}
}
