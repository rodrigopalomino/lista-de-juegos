package tictac.controlador;

import inicio.inicio;
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
		
		//inicio
		inicio inicio = new inicio();
		
		//inicio del juego
		inicioTictac inicioTictac = new inicioTictac();
		
		
		jugadores2 jugadores2 = new jugadores2();
		funciones2jugadores miCoordinador2 = new funciones2jugadores();
		
		jugadores1 jugadores1 = new jugadores1();
		funciones1jugador miCoordinador1 = new funciones1jugador();
		
		//relaciones entre clases
		inicioTictac.setCoordinador2(miCoordinador2);
		inicioTictac.setCoordinador1(miCoordinador1);
		
		jugadores2.setCoordinador2(miCoordinador2);
		jugadores1.setCoordinador1(miCoordinador1);
		
		inicio.setCoordinador1(miCoordinador1);
		
		
		//relaciones para juego de 2
		miCoordinador2.setInicioTicTac(inicioTictac);
		miCoordinador2.setJugadores2(jugadores2);
		
		//relaciones para juego de 1
		miCoordinador1.setInicioTicTac(inicioTictac);
		miCoordinador1.setJugadores1(jugadores1);
		miCoordinador1.setInicio(inicio);

		
		miCoordinador2.setvisible(inicioTictac, true);	
	}
	
}
