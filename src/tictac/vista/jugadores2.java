package tictac.vista;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tictac.modelo.coordinador;

import javax.swing.JLabel;

public class jugadores2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JLabel lblPlayer;
	public JButton btnReset;
	public JButton btnCerrar;
	public JLabel lblTurno;
	public JButton btnRegresar;
	coordinador miCoordinador;


	public jugadores2() {
		
		iniciarComponentes();
		
	}


	private void iniciarComponentes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		
		miCoordinador = new coordinador();
		miCoordinador.setJugadores2(this);
		miCoordinador.generarBotones();
		
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
		btnReset.setBounds(303, 250, 89, 23);
		//btnReset.setVisible(false);
		contentPane.add(btnReset);
		
		btnCerrar = new JButton("cerrar");
		btnCerrar.setBounds(414, 250, 89, 23);
		btnCerrar.setVisible(false);
		contentPane.add(btnCerrar);
		
		btnRegresar = new JButton("regresar");
		btnRegresar.setBounds(358, 298, 89, 23);
		contentPane.add(btnRegresar);
	
		
		
		btnReset.addMouseListener(new MouseAdapter() {
			@Override public void mouseClicked(MouseEvent e) { miCoordinador.reiniciar(1,1); }});
		
		
		}


	public void setCoordinador(coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
		
	}
}
