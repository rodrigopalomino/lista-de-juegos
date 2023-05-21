package tictac.vista;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tictac.modelo.funciones2jugadores;

import javax.swing.JLabel;

public class jugadores2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JLabel lblPlayer;
	public JButton btnCerrar;
	public JLabel lblTurno;
	public JButton btnRegresar;
	funciones2jugadores miCoordinador2;


	public jugadores2() {
		
		iniciarComponentes();
		
	}


	private void iniciarComponentes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		
		miCoordinador2 = new funciones2jugadores();
		miCoordinador2.setJugadores2(this);
		miCoordinador2.generarBotones();
		
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
		miCoordinador2.regresar();
	}


	public void setCoordinador2(funciones2jugadores miCoordinador2) {
		this.miCoordinador2=miCoordinador2;
	}
}
