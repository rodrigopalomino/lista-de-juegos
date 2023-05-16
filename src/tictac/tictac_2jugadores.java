package tictac;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class tictac_2jugadores extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JButton[][] botones;
	boolean player1;
	int cont;
	private JLabel lblPlayer;


	public tictac_2jugadores() {
		
		iniciarComponentes();
		
	}


	private void iniciarComponentes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("tictac");
		lblNewLabel.setBounds(74, 29, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblTurno = new JLabel("turno");
		lblTurno.setBounds(387, 85, 46, 14);
		contentPane.add(lblTurno);
		
		lblPlayer = new JLabel("Player 1");
		lblPlayer.setBounds(387, 163, 46, 14);
		contentPane.add(lblPlayer);
		player1=true;
		botones = new JButton[3][3];
		cont=0;
		
		for( int i=0; i<3; i++ ) {
			for( int y=0; y<3; y++ ) {
				final int finalI = i;
				final int finalY = y;
				JButton btn = new JButton();
				botones[i][y] = btn;
				btn.addMouseListener(new MouseAdapter() {
					@Override public void mouseClicked(MouseEvent e) { btn_mouseClicked(btn, finalI, finalY); }});
				btn.setBounds( (finalI+1)*70, (finalY+1)*70,50,50);
				getContentPane().add(btn);
				
			}
		}
		
	}



	protected void btn_mouseClicked(JButton btn, int i, int y) {
	

	    if (btn.getText().isEmpty()) {
	        if (player1==true) {
	            btn.setText("x");
	            cont++;
	            lblPlayer.setText("Player 2");
	            player1 = false;
	        } else {
	            btn.setText("o");
	            cont++;
	            lblPlayer.setText("Player 1");
	            player1 = true;
	        }
	    }

	    if(verificarGanador(i, y)) {
        	JOptionPane.showMessageDialog(this, (player1) ? "player2" : "player1" + " ha ganado!");
	    }
	    else if(cont==9) {
	    	JOptionPane.showMessageDialog(this,"Empate");
	    }
		
		

	}

	public boolean verificarGanador(int i, int y) {
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
}
