package tictac.vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tictac.modelo.funciones1jugador;
import tictac.modelo.funciones2jugadores;

import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class inicioTictac extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	funciones2jugadores miCoordinador2;
	funciones1jugador miCoordinador1;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public inicioTictac() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 320, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblTitulo = new JLabel("Tictac Toe");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblTitulo.setBounds(85, 30, 140, 45);
		contentPane.add(lblTitulo);
		
		JButton btn2jugadores = new JButton("2 player");
		btn2jugadores.setBounds(100, 145, 90, 23);
		contentPane.add(btn2jugadores);
		
		JButton btn1jugadores = new JButton("1 player");
		btn1jugadores.setBounds(100, 110, 90, 23);
		contentPane.add(btn1jugadores);
		
		JButton btnRegresar = new JButton("regresar");
		btnRegresar.setBounds(100, 180, 90, 23);
		contentPane.add(btnRegresar);
		
		btn2jugadores.addMouseListener(new MouseAdapter() {
			@Override public void mouseClicked(MouseEvent e) { btn2jugadores_mouseClicked(); }});
		
		btn1jugadores.addMouseListener(new MouseAdapter() {
			@Override public void mouseClicked(MouseEvent e) { btn1jugadores_mouseClicked(); }});
		
		btnRegresar.addMouseListener(new MouseAdapter() {
			@Override public void mouseClicked(MouseEvent e) { btnRegresar_mouseClicked(); }});
	}

	protected void btnRegresar_mouseClicked() {
		miCoordinador1.setvisible( miCoordinador1.getInicio(), true);
		this.setVisible(false);
		
	}

	protected void btn1jugadores_mouseClicked() {
		miCoordinador1.setvisible(  miCoordinador1.getJugadores1() , true );
		this.setVisible(false);
		
	}

	protected void btn2jugadores_mouseClicked() {
		miCoordinador2.setvisible(  miCoordinador2.getJugadores2() , true );
		this.setVisible(false);
		
		
	}

	public void setCoordinador2(funciones2jugadores miCoordinador2) {
		this.miCoordinador2=miCoordinador2;	
	}

	public void setCoordinador1(funciones1jugador miCoordinador1) {
		this.miCoordinador1=miCoordinador1;
		
	}
}
