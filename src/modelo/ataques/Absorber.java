package modelo.ataques;

public class Absorber extends Ataque{

	
	public static String NOMBRE = "ABSORBER";
	public static int COSTO_KI = 5;
	public static int PORCENTAJE_AUMENTO_DE_PODER = 0;
	//CELL AUMENTA SU VIDA LA MISMA CANTIDAD
	
	public Absorber() {
		super(NOMBRE,COSTO_KI,PORCENTAJE_AUMENTO_DE_PODER);
		// TODO Auto-generated constructor stub
	}
}
