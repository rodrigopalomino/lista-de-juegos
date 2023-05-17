package tictac.controlador;

import javax.swing.JFrame;

import tictac.modelo.funcionesTictac2jugadores;
import tictac.vista.inicio;
import tictac.vista.inicioTictac;
import tictac.vista.tictac2jugadores;

public class coordinador {
	//para inicio, inicioTictac
	private inicio inicio;
	private inicioTictac inicioTictac;
	public tictac2jugadores ticTac2jugadores;
	
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

	public void setVisibleTicTac2Jugadores() {
		ticTac2jugadores.setVisible(true);
		
	}

	public void setvisible( JFrame jframe, Boolean visible ) {
		jframe.setVisible(visible);
		
	}
	
	public JFrame setTicTac2jugadoresvisible() {
		return ticTac2jugadores;
		
	}

	public JFrame setInicioTictacVisible() {
		// TODO Auto-generated method stub
		return inicioTictac;
	}

}

















