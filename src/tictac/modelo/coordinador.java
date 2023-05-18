	package tictac.modelo;
	
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import tictac.vista.inicioTictac;
import tictac.vista.jugadores2;
	
	public class coordinador {
		

		//iniciando variables
		private inicioTictac inicioTictac;
		private jugadores2 jugadores2;
		private int cont;
		private boolean player1 = true;
		JButton[][] botones;
		
		
		
		
		//This
		public void setInicioTicTac(inicioTictac inicioTictac) {
			this.inicioTictac=inicioTictac;
			
		}
	
		public void setJugadores2(jugadores2 jugadores2) {
			this.jugadores2=jugadores2;
			
		}
	

		//get
		public inicioTictac getInicioTicTac() {
			
			return inicioTictac;
			
		}
	
		public jugadores2 getJugadores2() {
			
			return jugadores2;
			
		}	

	
		//Funciones
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
					getJugadores2().getContentPane().add(btn);
				}
			}
	
			
		}
		
		public void reiniciar(int i, int y) {

	    }

		protected void btn_mouseClicked(JButton btn, int i, int y) {
			
			if( btn.getText().isEmpty() ) {
				if(player1) {
					btn.setText("x");
					cont++;
		            getJugadores2().lblPlayer.setText("Player 2");
		            player1  = false;
				}else {
		            btn.setText("o");
		            cont++;
		            getJugadores2().lblPlayer.setText("Player 1");
		            player1 = true;
				}
			}
			
			
			if( verificarGanador(i,y) ) {
				
				if( getJugadores2().lblPlayer.getText().equals("Player 1") ) {
					getJugadores2().lblPlayer.setText("Player 2");
				}  
				if( getJugadores2().lblPlayer.getText().equals("Player 2") ) {
					getJugadores2().lblPlayer.setText("Player 1");
				} 
				
				getJugadores2().lblTurno.setText("Ganador");
				getJugadores2().btnCerrar.setVisible(true);
				getJugadores2().btnReset.setVisible(true);
			}else if (cont==9) {
				getJugadores2().lblTurno.setText("empate");
				
			}
			
			
		}
		
		
		private boolean verificarGanador(int i, int y) {
			String simbolo = (!player1) ? "x" : "o";
			

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



		




		
		
		
		
	
	}//fin
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
