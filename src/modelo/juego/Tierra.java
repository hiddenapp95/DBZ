package modelo.juego;

import modelo.excepciones.*;
import modelo.personajes.Personaje;

import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Franco on 6/3/2017.
 */
public class Tierra{

    private int rows = 11;
    private int columns = 17;

    public Casillero[][] casilleros = new Casillero[rows][columns];

    public Tierra(){

        super();

        for(int i = 0; i<rows ; i++){
            for(int j = 0; j<columns; j++){
                Casillero casillero = new Casillero(new Coordenada(i,j));
                casilleros[i][j] = casillero;
            }
        }
    }


    public Casillero obtenerCasillero(Coordenada coordenada){
        int row = coordenada.getRow();
        int column = coordenada.getCol();

        if(!contieneCoordenadas(coordenada)){
            throw  new CoordinatesNotInTierra("No existe ese espacio en esta Tierra");
        }
        return casilleros[row][column];
    }

    public Personaje obtenerPersonaje(Coordenada coordenada){
        Casillero casillero = obtenerCasillero(coordenada);
        return casillero.getPersonaje();
    }

    boolean contieneCoordenadas(Coordenada coordenada){
        return (coordenada.getRow() < rows-1 &&  coordenada.getCol() < columns-1  && coordenada.getRow() >= 0 &&  coordenada.getCol() >= 0);
    }

    public boolean coordenadasEstanEnRadio(Coordenada coordenadaA, Coordenada coordenadaB, int radius){
        if(!contieneCoordenadas(coordenadaA)|| !contieneCoordenadas(coordenadaB)){
            throw new CoordinatesNotInTierra();
        }
        Vector<Casillero> coordenadasEnRadio = espaciosEnRadio(coordenadaA, radius);
        return coordenadasEnRadio.contains(obtenerCasillero(coordenadaB));
    }


    public Vector<Coordenada> coordenadasEnLineaRectaADistancia(Coordenada unaCoordenada, int distancia){
        Vector<Coordenada> coordenadas = new Vector<Coordenada>();
        Coordenada[] direccionesPosibles = {
                new Coordenada(0,1), new Coordenada(0,-1),
                new Coordenada(1,1), new Coordenada(1,-1),
                new Coordenada(-1,1), new Coordenada(-1,-1),
                new Coordenada(1,0), new Coordenada(-1,0)
        };

        int coordenadaRow = unaCoordenada.getRow();
        int coordenadaCol = unaCoordenada.getCol();

        for(Coordenada direccion : direccionesPosibles){
            Coordenada coordenadaActual = new Coordenada(coordenadaRow,coordenadaCol);
            int cantRestanteDeMovimientos = distancia;
            coordenadaActual = coordenadaActual.sumar(direccion);
            while(this.contieneCoordenadas(coordenadaActual) && !(this.obtenerCasillero(coordenadaActual).tienePersonaje()) && cantRestanteDeMovimientos > 0){
              coordenadas.addElement(coordenadaActual);
              coordenadaActual = coordenadaActual.sumar(direccion);
              cantRestanteDeMovimientos -= 1;
            }
        }
        return coordenadas;
    }

    public Vector<Casillero> casillerosEnLineaRectaADistancia(Coordenada unaCoordenada, int distancia){
        Vector<Coordenada> coordenadas = coordenadasEnLineaRectaADistancia(unaCoordenada,distancia);
        Vector<Casillero> casilleros = new Vector<Casillero>();
        for(Coordenada coordenada : coordenadas){
            casilleros.add(obtenerCasillero(coordenada));
        }
        return casilleros;
    }



    public Vector<Casillero> espaciosEnRadio(Coordenada coordenada, int radius){
        Vector<Casillero> spacesInRadius = new Vector<Casillero>();
        int centerRow = coordenada.getRow();
        int centerColumn = coordenada.getCol();

        int topRow = centerRow - radius;
        int bottomRow = centerRow + radius;
        int leftColumn = centerColumn - radius;
        int rightColumn = centerColumn + radius;
  
        for(int row = topRow ; row <= bottomRow; row++){
            for(int column = leftColumn ; column <= rightColumn; column++) {
                try{
                    if(column == centerColumn && row == centerRow){
                        continue;
                    }
                    Coordenada spaceCoordenada = new Coordenada(row,column);
                    spacesInRadius.add(obtenerCasillero(spaceCoordenada));

                }catch (CoordinatesNotInTierra e){
                    continue;
                }
            }

        }
       
        return spacesInRadius;
    }
    
    public int obtenerNumeroDeColumnas(){
    	return columns-1;
    }

    public int obtenerNumeroDeFilas() { return rows-1;}

    public int numeroDeColumnaRandom(){ return ThreadLocalRandom.current().nextInt(0, columns-1);}

    public int getLastRow() { return rows-2;}
    
    public Vector<Casillero> espaciosOcupadosEnRadio(Coordenada coordenada, int radius){
    	Vector<Casillero> espaciosOcupados = new Vector<Casillero>(); 
    	Vector<Casillero> espaciosEnRadio= this.espaciosEnRadio(coordenada, radius);
    	for(Casillero casillero :espaciosEnRadio) {
    		if(casillero.tienePersonajeParaAtacar(this.obtenerPersonaje(coordenada))){
    			espaciosOcupados.add(casillero);
    		}	
    	}
    	return espaciosOcupados;
    }

    public int numeroDeFilaRandom(){ return ThreadLocalRandom.current().nextInt(0, rows-1);}

    public int getLastColumn() {
        return columns-2;
    }


	public void puedoMoverPersonajeACasillero(Personaje personajeAMover, Casillero unCasillero) {
		Vector<Coordenada> coordenadasValidas = this.coordenadasEnLineaRectaADistancia(
				personajeAMover.obtenerCoordenada(), personajeAMover.obtenerVelocidad());

		if (!(coordenadasValidas.contains(unCasillero.obtenerCoordenada()))) {
			throw new MovimientoInvalido();
		}
		
	}
}
