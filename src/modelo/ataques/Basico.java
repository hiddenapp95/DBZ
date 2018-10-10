package modelo.ataques;

public class Basico extends Ataque{

	public static String NOMBRE = "BASICO";
	public static int COSTO_KI = 0;
	public static int PORCENTAJE_AUMENTO_DE_PODER = 0;
	//CELL AUMENTA SU VIDA LA MISMA CANTIDAD
	
	public Basico() {
		super(NOMBRE,COSTO_KI,PORCENTAJE_AUMENTO_DE_PODER);
	}
}
