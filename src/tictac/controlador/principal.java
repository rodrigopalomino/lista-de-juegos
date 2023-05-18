package tictac.controlador;

import tictac.modelo.funciones1jugador;
import tictac.modelo.funciones2jugadores;
import tictac.vista.inicioTictac;
import tictac.vista.jugadores1;
import tictac.vista.jugadores2;

public class principal {

	public static void main(String[] args) {
		
		new principal().iniciar();

	}

	public void iniciar() {
		
		//instancio de clases
		inicioTictac inicioTictac = new inicioTictac();
		jugadores2 jugadores2 = new jugadores2();
		jugadores1 jugadores1 = new jugadores1();
		funciones2jugadores miCoordinador2 = new funciones2jugadores();
		funciones1jugador miCoordinador1 = new funciones1jugador();
		
		//relaciones entre clases
		inicioTictac.setCoordinador2(miCoordinador2);
		inicioTictac.setCoordinador1(miCoordinador1);
		
		jugadores2.setCoordinador2(miCoordinador2);
		jugadores1.setCoordinador1(miCoordinador1);
		
		
		
		//relaciones para juego de 2
		miCoordinador2.setInicioTicTac(inicioTictac);
		miCoordinador2.setJugadores2(jugadores2);
		
		//relaciones para juego de 1
		miCoordinador1.setInicioTicTac(inicioTictac);
		miCoordinador1.setJugadores1(jugadores1);

		
		miCoordinador2.setvisible(inicioTictac, true);	
	}
	
}
