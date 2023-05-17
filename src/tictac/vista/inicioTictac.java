package tictac.vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tictac.controlador.coordinador;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class inicioTictac extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	coordinador miCoordinador;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public inicioTictac() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JButton btn2jugadores = new JButton("2 jugadores");
		btn2jugadores.setBounds(41, 110, 89, 23);
		contentPane.add(btn2jugadores);
		
		btn2jugadores.addMouseListener(new MouseAdapter() {
			@Override public void mouseClicked(MouseEvent e) { btn2jugadores_mouseClicked(); }});
		
	}

	protected void btn2jugadores_mouseClicked() {
		miCoordinador.setvisible(  miCoordinador.setTicTac2jugadoresvisible() , true );
		this.setVisible(false);
		
		
	}

	public void setCoordinador(coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;	
	}
}
