package controlador;

import modelo.funcionesTictac2jugadores;
import vista.inicio;
import vista.inicioTictac;
import vista.tictac2jugadores;

public class principal {

	public static void main(String[] args) {
		
		new principal().iniciar();

	}

	private void iniciar() {
		
		//instancio de clases
		inicio inicio = new inicio();
		inicioTictac inicioTictac = new inicioTictac();
		tictac2jugadores ticTac2jugadores = new tictac2jugadores();
		
		funcionesTictac2jugadores funcionesTictac2jugadores = new funcionesTictac2jugadores();
		
		coordinador miCoordinador = new coordinador();
		
		//relaciones entre clases
		inicio.setCoordinador(miCoordinador);
		inicioTictac.setCoordinador(miCoordinador);
		ticTac2jugadores.setCoordinador(miCoordinador);
		funcionesTictac2jugadores.setCoordinador(miCoordinador);
		
		//relaciones a miCoordinador
		miCoordinador.setInicio(inicio);
		miCoordinador.setInicioTicTac(inicioTictac);
		miCoordinador.setTicTac2Jugadores(ticTac2jugadores);
		miCoordinador.setFuncionesTicTac2Jugadores(funcionesTictac2jugadores);
		
		miCoordinador.mostrarVentanaPrincipal();		
	}
	
}
