package modelo.juego;
import modelo.consumibles.Consumible;
import modelo.excepciones.CasilleroOcupado;
import modelo.excepciones.CasilleroVacio;
import modelo.excepciones.NoHayConsumibleEnElCasillero;
import modelo.personajes.Personaje;


public class Casillero {
    private Personaje personaje;
    private Consumible consumible;
    Coordenada coordenada;

    public Casillero(Coordenada coordenada){
        personaje = null;
        consumible = null;
        this.coordenada = coordenada;
    }
    public Casillero(){
        personaje = null;
        consumible = null;
        this.coordenada = null;
    }

    public void addCharacter(Personaje character){
        if(this.tienePersonaje())
            throw new CasilleroOcupado();
        if(this.tieneConsumible()) {
            character.agarrarConsumible(consumible);
            consumible = null;
        }
        this.personaje = character;
     }

     public void addConsumible(Consumible unConsumible){
        if(isEmpty())
            consumible = unConsumible;
     }

    public Personaje removeCharacter(){
        Personaje personaje = this.personaje;

        this.personaje = null;

        return personaje;
    }

    public Consumible removeConsumible(){
        Consumible consumible = this.consumible;
        consumible = null;

        return consumible;
    }

    public boolean tienePersonaje(){
        return this.personaje != null;
    }

    public boolean tieneConsumible() {return this.consumible != null;}

    public boolean isEmpty() {
        return (!tieneConsumible() && !tienePersonaje());
    }

    public Personaje getPersonaje(){
        if(!tienePersonaje()){
            throw new CasilleroVacio();
        }
        return this.personaje;
    }

    public Consumible getConsumible(){
        if(!tieneConsumible()){
            throw new NoHayConsumibleEnElCasillero();
        }
        return this.consumible;
    }

	public int obtenerDistancia(Casillero casillero) {
		return this.coordenada.distanciaA(casillero.obtenerCoordenada());
	}
	
	public Coordenada obtenerCoordenada() {
		return this.coordenada;
	}
	public boolean tienePersonajeParaAtacar(Personaje unPersonaje) {
		if(this.tienePersonaje()&& !unPersonaje.esCompanieroDe(this.personaje)) return true;
		return false;
	}

}
