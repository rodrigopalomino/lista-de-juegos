package tictac.controlador;

import tictac.modelo.coordinador;
import tictac.vista.inicioTictac;
import tictac.vista.jugadores2;

public class principal {

	public static void main(String[] args) {
		
		new principal().iniciar();

	}

	public void iniciar() {
		
		//instancio de clases
		inicioTictac inicioTictac = new inicioTictac();
		jugadores2 jugadores2 = new jugadores2();
		coordinador miCoordinador = new coordinador();
		
		//relaciones entre clases
		inicioTictac.setCoordinador(miCoordinador);
		jugadores2.setCoordinador(miCoordinador);
		
		//relaciones a miCoordinador
		miCoordinador.setInicioTicTac(inicioTictac);
		miCoordinador.setJugadores2(jugadores2);

		
		miCoordinador.setvisible(inicioTictac, true);	
	}
	
}
