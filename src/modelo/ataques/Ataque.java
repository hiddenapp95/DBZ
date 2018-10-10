package modelo.ataques;

import modelo.consumibles.Consumible;
import modelo.personajes.Personaje;

public class Ataque {

		public String nombre;
		public int costoKi;
		public double aumentoDePoder;
		
		public Ataque(String nombre, int costoKi, int aumentoDePoder) {
			this.nombre = nombre;
			this.costoKi = costoKi;
			this.aumentoDePoder = aumentoDePoder;
		}

		public String obtenerNombre(){
			return nombre;
		}
		public void realizar(Personaje unPersonaje, Personaje otroPersonaje) {
			double poderConAumento = unPersonaje.obtenerPoderDePelea() + ((unPersonaje.obtenerPoderDePelea()) * (this.aumentoDePoder /100));

			if(unPersonaje.obtenerPoderDePelea() < otroPersonaje.obtenerPoderDePelea()){
			    poderConAumento*=0.8; //Reduce el daño un 20%
            }

            if(!unPersonaje.obtenerEsferasDelDragon().isEmpty()){
				for(Consumible esfera : unPersonaje.obtenerEsferasDelDragon()){
					esfera.usar();
				}
				poderConAumento *= 1.25;
			}

			otroPersonaje.quitarVida(poderConAumento);
		}

		public int obtenerCostoKi() {
			// TODO Auto-generated method stub
			return this.costoKi;
		}

}
