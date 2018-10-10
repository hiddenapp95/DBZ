package modelo.aspectos;

import modelo.excepciones.KiInsuficiente;
import modelo.excepciones.NoRealizoLosAtaquesEspecialesNecesarias;
import modelo.excepciones.PersonajeNoEstaDebajoDelPorcDeVidaNecesario;
import modelo.personajes.Personaje;

public class Aspecto {

	private String nombre;
	private int poderDePelea;
	private int distanciaDeAtaque;
	private int velocidad;
	private int costoKi;

	public Aspecto(String nombre, int poderDePelea, int distanciaDeAtaque, int velocidad, int costoKi) {
		this.nombre = nombre;
		this.poderDePelea = poderDePelea;
		this.distanciaDeAtaque = distanciaDeAtaque;
		this.velocidad = velocidad;
		this.costoKi = costoKi;
	}

	public String obtenerNombre() {
		return this.nombre;
	}

	public int obtenerPoderDePelea() {
		return this.poderDePelea;
	}

	public int obtenerDistanciaDeAtaque() {
		return this.distanciaDeAtaque;
	}

	public int obtenerVelocidad() {
		return this.velocidad;
	}

	public int obtenerCostoKi() {
		return costoKi;
	}

	public void transformarse(Personaje personaje)
			throws KiInsuficiente, PersonajeNoEstaDebajoDelPorcDeVidaNecesario, NoRealizoLosAtaquesEspecialesNecesarias {
		personaje.usarKi(this.obtenerCostoKi());
		personaje.cambiarDeAspecto(this);
	}

	public void aumentarVelocidad(int aumentoDeVelocidad) {
		velocidad += aumentoDeVelocidad;
	}

	public void disminuirVelocidad(int velocidadARestar) {
		velocidad -= velocidadARestar;
	}

	public void aumentarPoderDePelea(int aumentoDePoder) {
		poderDePelea += aumentoDePoder;
	}

	public void disminuirPoderDePelea(int poderARestar) {
		poderDePelea -= poderARestar;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Aspecto)) return false;

		Aspecto aspecto = (Aspecto) o;

		if (poderDePelea != aspecto.poderDePelea) return false;
		if (distanciaDeAtaque != aspecto.distanciaDeAtaque) return false;
		if (velocidad != aspecto.velocidad) return false;
		if (costoKi != aspecto.costoKi) return false;
		return nombre.equals(aspecto.nombre);
	}

	@Override
	public int hashCode() {
		int result = nombre.hashCode();
		result = 31 * result + poderDePelea;
		result = 31 * result + distanciaDeAtaque;
		result = 31 * result + velocidad;
		result = 31 * result + costoKi;
		return result;
	}
}
