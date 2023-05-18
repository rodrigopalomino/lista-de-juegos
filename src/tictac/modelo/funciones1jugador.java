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
	//iniciando variables
	private int cont;
	private boolean player1 = true;
	JButton[][] botones;
	JButton btnReset;

	public void setInicioTicTac(inicioTictac inicioTictac) {
		this.inicioTictac=inicioTictac;
		
	}

	public void setJugadores1(jugadores1 jugadores1) {
		this.jugadores1=jugadores1;
		
	}
	
	public jugadores1 getJugadores1() {
		return jugadores1;
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
				btn.setBounds( (i+1)*70, (y+1)*70,50,50);
				getJugadores1().getContentPane().add(btn);
			}
		}
		
		btnReset = new JButton("reset");
		btnReset.setBounds(303, 250, 89, 23);
		//btnReset.setVisible(false);
		getJugadores1().getContentPane().add(btnReset);
		btnReset.addMouseListener(new MouseAdapter() {
			@Override public void mouseClicked(MouseEvent e) { reiniciar(); }});

		
	}
		

	protected void btn_mouseClicked(JButton btn, int i, int y) {
		
		if(verificarGanadorPlayer(i, y)) {
	    	getJugadores1().lblPlayer.setText("ganador");
	    }
		
		btn.setText("x");
	    cont++;
	    player1 = false;
	    getJugadores1().lblPlayer.setText("Player 2");
	    
	    if(verificarGanadorPlayer(i, y)) {
	    	getJugadores1().lblPlayer.setText("ganador player");
	    }
	    
	    
	    /*
	    if( verificarGanador(i,y) ) {
			
			if( getJugadores1().lblPlayer.getText().equals("Player 1") ) {
				getJugadores1().lblPlayer.setText("Player 2");
			}  
			if( getJugadores1().lblPlayer.getText().equals("Player 2") ) {
				getJugadores1().lblPlayer.setText("Player 1");
			} 
			
			getJugadores1().lblTurno.setText("Ganador");
			getJugadores1().btnCerrar.setVisible(true);
			btnReset.setVisible(true);
		} else if (cont==9) {
			getJugadores1().lblTurno.setText("empate");
			
		}
	    */
	    Random random = new Random();
	    while (true) {
	        int n1 = random.nextInt(3);
	        int n2 = random.nextInt(3);

	        if (botones[n1][n2].getText().isEmpty()) {
	            botones[n1][n2].setText("o");
	            cont++;
	            getJugadores1().lblPlayer.setText("Player 1");
	            player1 = true;
	            break;
	        }
	    

	    }
		if(verificarGanadorBot(i, y)) {
			getJugadores1().lblPlayer.setText("ganador bot");
		}

		
	}
	
	
	private boolean verificarGanadorPlayer(int i, int y) {
		String simbolo = "x";
		

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
	
	private boolean verificarGanadorBot(int i, int y) {
		String simbolo = "o";
		

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
		getJugadores1().setVisible(false);
		inicio inicio = new inicio();
		inicio.setVisible(true);
		
	}

	
	

}
