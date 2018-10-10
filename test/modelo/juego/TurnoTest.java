package modelo.juego;

import modelo.excepciones.NoRealizoLosAtaquesEspecialesNecesarias;
import modelo.excepciones.YaSeRealizoUnAtaqueEnEsteTurno;
import modelo.excepciones.YaSeRealizoUnMovimientoEnEsteTurno;
import modelo.personajes.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by marianoogimenez on 10/6/17.
 */
public class TurnoTest {



    @Test  (expected = YaSeRealizoUnAtaqueEnEsteTurno.class)
    public void unJugadorNoPuedeHacerMasDe1AtaquePorTurno() throws YaSeRealizoUnAtaqueEnEsteTurno{
    	Turno unTurno = new Turno(new GuerrerosZ(),new EnemigosDeLaTierra(), new Tierra());
    	unTurno.nuevoAtaque();
    	unTurno.nuevoAtaque();
    }
    
    @Test  (expected = YaSeRealizoUnMovimientoEnEsteTurno.class)
    public void unJugadorNoPuedeHacerMasDe1MovimientoPorTurno() throws YaSeRealizoUnMovimientoEnEsteTurno{
    	Turno unTurno = new Turno(new GuerrerosZ(),new EnemigosDeLaTierra(), new Tierra());
    	unTurno.nuevoMovimiento();
    	unTurno.nuevoMovimiento();

    }
    
}
