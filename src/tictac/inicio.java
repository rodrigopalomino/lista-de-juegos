package tictac;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class inicio extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btn1jugador;
	private JButton btn2jugador;
	public tictac_2jugadores tictac2jugadores = new tictac_2jugadores();


	public inicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("tic tac");
		lblNewLabel.setBounds(53, 28, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Numero de Jugadores :\r\n");
		lblNewLabel_1.setBounds(39, 84, 130, 23);
		contentPane.add(lblNewLabel_1);
		
		btn1jugador = new JButton("1 jugador");
		btn1jugador.setBounds(39, 122, 89, 23);
		contentPane.add(btn1jugador);
		
		btn2jugador = new JButton("2 jugadores");
		btn2jugador.setBounds(39, 159, 89, 23);
		contentPane.add(btn2jugador);
		
		btn2jugador.addMouseListener(new MouseAdapter() {
			@Override public void mouseClicked(MouseEvent e) { btn2jugadores_mouseClicked(); }});
	}

	protected void btn2jugadores_mouseClicked() {
		this.setVisible(false);
		tictac2jugadores.setVisible(true);
		
		
	}

}













