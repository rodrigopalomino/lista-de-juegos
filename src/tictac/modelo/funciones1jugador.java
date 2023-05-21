package tictac.modelo;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;

import inicio.inicio;
import tictac.vista.inicioTictac;
import tictac.vista.jugadores1;
import tictac.vista.jugadores2;

public class funciones1jugador {

	private inicioTictac inicioTictac;
	private jugadores1 jugadores1;
	private inicio inicio;
	
	private int cont;
	private boolean player1 = true;
	boolean game_over=false;
	JButton[][] botones;
	JButton btnReset;


	
	public void setInicioTicTac(inicioTictac inicioTictac) {
		this.inicioTictac=inicioTictac;
		
	}
	
	public inicioTictac getInicioTictac(inicioTictac inicioTictac) {
		return inicioTictac;
	}
	

	public void setJugadores1(jugadores1 jugadores1) {
		this.jugadores1=jugadores1;
		
	}
	
	public jugadores1 getJugadores1() {
		return jugadores1;
	}
	
	public void setInicio(inicio inicio) {
		this.inicio=inicio;
		
	}
	
	public inicio getInicio(inicio inicio) {
		return inicio;
	}
	

	public void setvisible( JFrame jframe, Boolean visible ) {
		jframe.setVisible(visible);
		
	}
	
	
	public void generarBotones() {
		
		botones = new JButton[3][3];
		
		for( int i=0; i<3; i++ ) {
			for( int y=0; y<3; y++ ) {
				final int finalI = i;
				final int finalY = y;
				JButton btn = new JButton();
				botones[i][y] = btn;
				btn.addMouseListener(new MouseAdapter() {
					@Override public void mouseClicked(MouseEvent e) { 
						btn_mouseClicked(btn, finalI, finalY); }});
				btn.setBounds( (i+1)*70, ((y+1)*70)+30,50,50);
				getJugadores1().getContentPane().add(btn);
			}
		}
		
		btnReset = new JButton("reset");
		btnReset.setBounds(300, 230, 90, 25);
		getJugadores1().getContentPane().add(btnReset);
		btnReset.addMouseListener(new MouseAdapter() {
			@Override public void mouseClicked(MouseEvent e) { reiniciar(); }});

	}
		
	protected void btn_mouseClicked(JButton btn, int finalI, int finalY) {
		Random rm = new Random(3);
		
		
		if( !game_over ) {
			//turno jugador 1
			btn.setText("x");
			
			if(verificarGanador(finalI, finalY, "x")){
				getJugadores1().lblTurno.setText("ganador 1");
			}
			
			boolean bot=true;
		
			while( bot ) {
				int n1 = rm.nextInt(3);
				int n2 = rm.nextInt(3);
				if(botones[n1][n2].getText().isEmpty()) {
					botones[n1][n2].setText("o");
					bot=false;
					if( ganadorBot("o") ) {
						getJugadores1().lblTurno.setText("ganador bot");
						game_over=true;
					}
				}
				
			}
			
			
			
		}else {
			System.out.print("perdiste");
			
		}
		
	}

	private boolean ganadorBot(String simbolo) {
		//{0,0}{0,1}{0,2}
		//{1,0}{1,1}{1,2}
		//{2,0}{2,1}{2,2}
		
		
		if (botones[0][0].getText().equals(simbolo) && 
	       	botones[0][1].getText().equals(simbolo) &&
	       	botones[0][2].getText().equals(simbolo)) {
	        	return true;
	    }
		if (botones[1][0].getText().equals(simbolo) && 
		    botones[1][1].getText().equals(simbolo) &&
		    botones[1][2].getText().equals(simbolo)) {
		        	return true;
		}
		if (botones[2][0].getText().equals(simbolo) && 
		    botones[2][1].getText().equals(simbolo) &&
		    botones[2][2].getText().equals(simbolo)) {
		        	return true;
		}
		
		if (botones[0][0].getText().equals(simbolo) && 
		    botones[1][0].getText().equals(simbolo) &&
		    botones[2][0].getText().equals(simbolo)) {
		        	return true;
		}
		if (botones[0][1].getText().equals(simbolo) && 
			botones[1][1].getText().equals(simbolo) &&
			botones[2][1].getText().equals(simbolo)) {
			        	return true;
		}
		if (botones[0][2].getText().equals(simbolo) && 
			botones[1][2].getText().equals(simbolo) &&
			botones[2][2].getText().equals(simbolo)) {
			        	return true;
		}
		if (botones[0][0].getText().equals(simbolo) && 
				botones[1][1].getText().equals(simbolo) &&
				botones[2][2].getText().equals(simbolo)) {
				        	return true;
		}
		if (botones[2][0].getText().equals(simbolo) && 
				botones[1][1].getText().equals(simbolo) &&
				botones[0][2].getText().equals(simbolo)) {
				        	return true;
		}
		
	
		
		return false;
	}

	private boolean verificarGanador(int i, int y, String simbolo) {
		
		

        if (botones[i][0].getText().equals(simbolo) && 
       		botones[i][1].getText().equals(simbolo) &&
       		botones[i][2].getText().equals(simbolo)) {
            return true;
        }


        if (botones[0][y].getText().equals(simbolo) &&
        	botones[1][y].getText().equals(simbolo) &&
        	botones[2][y].getText().equals(simbolo)) {
            return true;
        }


        if (i == y && 
       		botones[0][0].getText().equals(simbolo) &&
       		botones[1][1].getText().equals(simbolo) &&
       		botones[2][2].getText().equals(simbolo)) {
            return true;
        }
        
        if (botones[0][2].getText().equals(simbolo) &&
    		botones[1][1].getText().equals(simbolo) &&
       		botones[2][0].getText().equals(simbolo)) {
                return true;
            }
        
		return false;
	}

	public void reiniciar() {
		for (int i = 0; i < 3; i++) {
			for (int y = 0; y < 3; y++) {
				botones[i][y].setText("");
			}
		}
		cont = 0;
		player1 = true;
		getJugadores1().lblTurno.setText("Turno");

	}

	public void regresar() {
		//falta aca
		//getInicio
		
	}

	

}
