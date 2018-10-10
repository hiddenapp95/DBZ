package modelo.juego;

import java.util.Comparator;

import static java.lang.Math.abs;
import static java.lang.Math.max;


public class Coordenada {
    int row;
    int col;

    public Coordenada(int row, int col){
        this.row = row;
        this.col = col;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public int distanciaA(Coordenada unaCoordenada){
        return max(abs(unaCoordenada.getRow() - row),abs(unaCoordenada.getCol() - col) );
    }

    public Coordenada sumar(Coordenada otraCoordenada){
        return new Coordenada(this.row + otraCoordenada.getRow(),this.col + otraCoordenada.getCol());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordenada that = (Coordenada) o;

        if (row != that.row) return false;
        return col == that.col;
    }

    @Override
    public int hashCode() {
        int result = row;
        result = 31 * result + col;
        return result;
    }

	@Override
	public String toString() {
		return "Coordenada [row=" + row + ", col=" + col + "]";
	}
    
}