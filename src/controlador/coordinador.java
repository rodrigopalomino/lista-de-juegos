package controlador;

import modelo.funcionesTictac2jugadores;
import vista.inicio;
import vista.inicioTictac;
import vista.tictac2jugadores;

public class coordinador {
	
	private inicio inicio;
	private inicioTictac inicioTictac;
	private tictac2jugadores ticTac2jugadores;
	
	private funcionesTictac2jugadores funcionesTictac2jugadores;
	
	
	public void setInicio(inicio inicio) {
		this.inicio=inicio;
		
	}

	public void setInicioTicTac(inicioTictac inicioTictac) {
		this.inicioTictac=inicioTictac;
		
	}

	public void setTicTac2Jugadores(tictac2jugadores ticTac2jugadores) {
		this.ticTac2jugadores=ticTac2jugadores;
		
	}

	public void setFuncionesTicTac2Jugadores(funcionesTictac2jugadores funcionesTictac2jugadores) {
		this.funcionesTictac2jugadores=funcionesTictac2jugadores;
		
	}

	public void setvisibleInicioTicTac() {
		inicioTictac.setVisible(true);
		
	}

	public void mostrarVentanaPrincipal() {
		inicio.setVisible(true);
		
	}

}
