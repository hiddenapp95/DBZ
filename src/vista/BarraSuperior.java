package vista;


import com.sun.javafx.font.freetype.HBGlyphLayout;
import controlador.AspectoHandler;
import controlador.SeleccionarAtaqueHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import modelo.aspectos.Aspecto;
import modelo.personajes.Personaje;

/**
 * Created by marianoogimenez on 15/6/17.
 */
public class BarraSuperior extends HBox {
    private VistaPrincipal vistaPrincipal;
    private BotonAtaque ataqueSeleccionado;
    private Personaje personaje;

    public BarraSuperior(VistaPrincipal vistaPrincipal){
        this.setId("barraSuperior");
        this.setAlignment(Pos.CENTER_LEFT);
        this.vistaPrincipal =  vistaPrincipal;

    }

    public void mostrarInfoPersonaje(Personaje personaje){
        this.personaje = personaje;
        this.getChildren().clear();
        HBox contenedorNombrePersonaje = new HBox();
        contenedorNombrePersonaje.setId("containerNombrePersonaje");

        Text nombrePersonaje = new Text(personaje.getNombre());
        nombrePersonaje.setFill(Color.WHITE);
        nombrePersonaje.setId("nombrePersonaje");
        contenedorNombrePersonaje.getChildren().add(nombrePersonaje);

        this.getChildren().add(contenedorNombrePersonaje);
        for (Aspecto aspecto: personaje.obtenerTransformaciones()) {
            VistaAspecto vistaAspecto = new VistaAspecto(aspecto, personaje);
            vistaAspecto.setOnMouseClicked(new AspectoHandler(aspecto, personaje, vistaPrincipal));
            this.getChildren().add(vistaAspecto);
        }

        VBox infoKi = new VBox();
        infoKi.setAlignment(Pos.CENTER_LEFT);
        infoKi.setSpacing(4);
        Text kiActual  = new Text("Ki: "+personaje.obtenerKi());
        Text vidaActual  = new Text("Vida: "+(personaje.obtenerPorcentajeDeVida())+"%");
        kiActual.setFill(Color.WHITE);
        vidaActual.setFill(Color.WHITE);
        infoKi.getChildren().addAll(kiActual,vidaActual);

        BotonAtaque botonAtaqueEspecial = new BotonAtaque(personaje.obtenerNombreAtaqueEspecial(),personaje.obtenerCostoAtaqueEspecial()+"");
        BotonAtaque botonAtaqueBasico = new BotonAtaque(personaje.obtenerNombreAtaqueBasico(),personaje.obtenerCostoAtaqueBasico()+"");
        seleccionarModoAtaque(botonAtaqueBasico);
        botonAtaqueBasico.setOnMouseClicked(new SeleccionarAtaqueHandler(botonAtaqueBasico,this));
        botonAtaqueEspecial.setOnMouseClicked(new SeleccionarAtaqueHandler(botonAtaqueEspecial,this));
        HBox contenedorAtaques = new HBox();
        contenedorAtaques.setId("contenedorAtaques");
        contenedorAtaques.getChildren().addAll(botonAtaqueBasico,botonAtaqueEspecial);

        this.getChildren().addAll(infoKi, contenedorAtaques);
        this.personaje = null;
    }

    public void mostrarMensaje(String mensaje){
        this.personaje = null;
        this.getChildren().clear();
        Text nuevoMensaje = new Text(mensaje);
        nuevoMensaje.setFill(Color.WHITE);
        this.setAlignment(Pos.CENTER);
        this.getChildren().add(nuevoMensaje);

    }

    public void seleccionarModoAtaque(BotonAtaque botonAtaque){
        if(ataqueSeleccionado!=null){
            ataqueSeleccionado.deseleccionar();
        }
        botonAtaque.seleccionar();
        this.ataqueSeleccionado = botonAtaque;
    }

    public void actualizar(){
        if(this.personaje!=null) {
            mostrarInfoPersonaje(personaje);
        } else {
            mostrarMensaje("Seleccione un personaje");
        }
    }

	public boolean ataqueNormalSeleccionado() {
		return this.ataqueSeleccionado.ataqueNormalSeleccionado();
	}

}
