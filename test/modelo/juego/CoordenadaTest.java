package modelo.juego;

import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by marianoogimenez on 4/6/17.
 */
public class CoordenadaTest  {

    @Test
    public void crearCoordenadasYVerEstado(){
        Coordenada coordenada = new Coordenada(2,1);
        assertEquals(2, coordenada.getRow());
        assertEquals(1, coordenada.getCol());
    }

    @Test
    public void distanciaEntreColumna0Fila0YColumna3Fila3(){
        Coordenada unaCoordenada = new Coordenada(0,0);
        Coordenada otraCoordenada = new Coordenada(3,3);
        assertEquals(3, unaCoordenada.distanciaA(otraCoordenada));
    }

    @Test
    public void distanciaEntreColumna2Fila1YColumna3Fila0(){
        Coordenada unaCoordenada = new Coordenada(1,2);
        Coordenada otraCoordenada = new Coordenada(0,3);
        assertEquals(1, unaCoordenada.distanciaA(otraCoordenada));
    }

    @Test
    public void distanciaEntreColumna2Fila0YColumna2Fila7(){
        Coordenada unaCoordenada = new Coordenada(0,2);
        Coordenada otraCoordenada = new Coordenada(7,2);
        assertEquals(7, unaCoordenada.distanciaA(otraCoordenada));
    }

    @Test
    public void distanciaEntreColumna4Fila7YColumna2Fila7(){
        Coordenada unaCoordenada = new Coordenada(7,4);
        Coordenada otraCoordenada = new Coordenada(7,2);
        assertEquals(2, unaCoordenada.distanciaA(otraCoordenada));
    }

    @Test
    public void distanciaEntreColumna6Fila9YColumna0Fila3(){
        Coordenada unaCoordenada = new Coordenada(3,0);
        Coordenada otraCoordenada = new Coordenada(9,6);
        assertEquals(6, unaCoordenada.distanciaA(otraCoordenada));
    }

    @Test
    public void sumarCoordenadas(){
        Coordenada unaCoordenada = new Coordenada(3,0);
        Coordenada otraCoordenada = new Coordenada(9,6);
        assertEquals(12, unaCoordenada.sumar(otraCoordenada).getRow());
        assertEquals(6, unaCoordenada.sumar(otraCoordenada).getCol());
    }


    @Test
    public void sumarCoordenadasNegativas(){
        Coordenada unaCoordenada = new Coordenada(3,0);
        Coordenada otraCoordenada = new Coordenada(-8,6);
        unaCoordenada.sumar(otraCoordenada);
        assertEquals(-5, unaCoordenada.sumar(otraCoordenada).getRow());
        assertEquals(6, unaCoordenada.sumar(otraCoordenada).getCol());
    }


}
