package tictac.vista;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tictac.controlador.coordinador;
import tictac.modelo.funcionesTictac2jugadores;

import javax.swing.JLabel;

public class tictac2jugadores extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JButton[][] botones;
	public boolean player1;
	public int cont;
	public JLabel lblPlayer;
	public JButton btnReset;
	public JButton btnCerrar;
	public JLabel lblTurno;
	public JButton btnRegresar;
	coordinador miCoordinador;
	inicio inicio = new inicio();
	funcionesTictac2jugadores funcion = new funcionesTictac2jugadores();


	public tictac2jugadores() {
		
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
		
		lblTurno = new JLabel("turno");
		lblTurno.setBounds(387, 85, 46, 14);
		contentPane.add(lblTurno);
		
		lblPlayer = new JLabel("Player 1");
		lblPlayer.setBounds(387, 163, 46, 14);
		contentPane.add(lblPlayer);
		
		btnReset = new JButton("reset");
		btnReset.addMouseListener(new MouseAdapter() {
			@Override public void mouseClicked(MouseEvent e) {}});
		btnReset.setBounds(303, 250, 89, 23);
		btnReset.setVisible(false);
		contentPane.add(btnReset);
		
		btnCerrar = new JButton("cerrar");
		btnCerrar.setBounds(414, 250, 89, 23);
		btnCerrar.setVisible(false);
		contentPane.add(btnCerrar);
		
		btnRegresar = new JButton("regresar");
		btnRegresar.setBounds(358, 298, 89, 23);
		contentPane.add(btnRegresar);
		
		player1=true;
		botones = new JButton[3][3];
		cont=0;
		
		btnCerrar.addMouseListener(new MouseAdapter() {
			@Override public void mouseClicked(MouseEvent e) { btnCerrar_mouseClicked(); }});
		
		btnRegresar.addMouseListener(new MouseAdapter() {
			@Override public void mouseClicked(MouseEvent e) { btnRegresar_mouseClicked(); }});
		
		btnReset.addMouseListener(new MouseAdapter() {
			@Override public void mouseClicked(MouseEvent e) { btnReset_mouseClicked(); }});
		
		
		
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



	protected void btnReset_mouseClicked() {
		
		
		cont = 0;
		player1=true;
		
		lblTurno.setText("Turno");
		for( int i=0; i<3; i++ ) {
			for( int y=0; y<3; y++) {
				botones[i][y].setText("");
			}
		}
		
	}


	protected void btnRegresar_mouseClicked() {
		inicio.setVisible(true);
		this.setVisible(false);
		
	}


	protected void btnCerrar_mouseClicked() {
		System.exit(0);
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
	    	
	    	if( lblPlayer.getText().equals("Player 1") ){
	    		lblPlayer.setText("Player 2");
	    	}
	    	if( lblPlayer.getText().equals("Player 2") ){
	    		lblPlayer.setText("Player 1");
	    	}
        	lblTurno.setText("Ganador");
        	btnCerrar.setVisible(true);
        	btnReset.setVisible(true);
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


	public void setCoordinador(coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
		
	}
}
