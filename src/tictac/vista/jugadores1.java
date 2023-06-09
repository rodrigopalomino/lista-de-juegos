package tictac.vista;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tictac.modelo.funciones1jugador;
import tictac.modelo.funciones2jugadores;

import javax.swing.JLabel;
import java.awt.Font;

public class jugadores1 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JLabel lblPlayer;
	public JButton btnCerrar;
	public JLabel lblTurno;
	public JButton btnRegresar;
	funciones1jugador miCoordinador1;


	public jugadores1() {
		
		iniciarComponentes();
		
	}


	private void iniciarComponentes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		
		miCoordinador1 = new funciones1jugador();
		miCoordinador1.setJugadores1(this);
		miCoordinador1.generarBotones();
		
		JLabel lblTitulo = new JLabel("Tictac Toe");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblTitulo.setBounds(105, 30, 140, 45);
		contentPane.add(lblTitulo);
		
		lblTurno = new JLabel("turno");
		lblTurno.setBounds(387, 85, 46, 14);
		contentPane.add(lblTurno);
		
		lblPlayer = new JLabel("Player 1");
		lblPlayer.setBounds(387, 163, 46, 14);
		contentPane.add(lblPlayer);

		
		btnCerrar = new JButton("cerrar");
		btnCerrar.setBounds(415, 230, 90, 25);
		contentPane.add(btnCerrar);
		
		btnRegresar = new JButton("regresar");
		btnRegresar.setBounds(360, 270, 90, 25);
		contentPane.add(btnRegresar);
	
		btnCerrar.addMouseListener(new MouseAdapter() {
			@Override public void mouseClicked(MouseEvent e) { System.exit(0); }});
		btnRegresar.addMouseListener(new MouseAdapter() {
			@Override public void mouseClicked(MouseEvent e) { btnRegresar_mouseClicked(); }});
		
		}
	
	protected void btnRegresar_mouseClicked() {
		miCoordinador1.regresar();
	}


	public void setCoordinador1(funciones1jugador miCoordinador1) {
		this.miCoordinador1=miCoordinador1;
	}
}
