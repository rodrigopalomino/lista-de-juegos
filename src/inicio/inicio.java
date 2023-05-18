package inicio;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tictac.controlador.principal;
import tictac.modelo.funciones2jugadores;

import javax.swing.JLabel;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class inicio extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	funciones2jugadores miCoordinador;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inicio frame = new inicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public inicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblInicio = new JLabel("Lista de  juegos nuevo 199: ");
		lblInicio.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblInicio.setBounds(43, 21, 187, 30);
		contentPane.add(lblInicio);
		
		JLabel lblNewLabel = new JLabel("- 3 en raya -->");
		lblNewLabel.setBounds(43, 77, 100, 21);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("entrar");
		btnNewButton.setBounds(128, 76, 89, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override public void mouseClicked(MouseEvent e) { btn_3enRaya(); }});
		
	}

	public void setCoordinador(funciones2jugadores miCoordinador) {
		this.miCoordinador=miCoordinador;
	}
	
	protected void btn_3enRaya() {
		principal miPricipal = new principal();
		miPricipal.iniciar();
		this.setVisible(false);
		

	}

	
}












