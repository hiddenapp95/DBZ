package modelo.ataques;

import modelo.personajes.Personaje;

public class ConvertirEnChocolate extends Ataque{

	
	public static String NOMBRE = "CONVERTIR EN CHOCOLATE";
	public static int COSTO_KI = 30;
	public static int PORCENTAJE_AUMENTO_DE_PODER = 0;
	//INUTILIZA A UN PERSONAJE DURANTE 3 TURNOS
	
	public ConvertirEnChocolate() {
		super(NOMBRE,COSTO_KI,PORCENTAJE_AUMENTO_DE_PODER);
		// TODO Auto-generated constructor stub
	}
	
	public void realizar(Personaje unPersonaje, Personaje Personaje) {
		Personaje.inmovilizar();
	}
}
