package practicasPOOA;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.ImageIcon;

public class gato extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gato frame = new gato();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public gato() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnJuegoN = new JButton("INICIAR");
		panel.add(btnJuegoN);
		
		JButton btnFin = new JButton("FINALIZAR");
		panel.add(btnFin);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.NORTH);
		
		JLabel labelTurno = new JLabel("TURNO");
		panel_2.add(labelTurno);
		
		JLabel lblNewLabel = new JLabel("[                   ]");
		panel_2.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(3, 12, 3, 12));
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(3, 3, 0, 0));
		
		JButton btnNewButton_1 = new JButton("New button");
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_4 = new JButton("New button");
		panel_1.add(btnNewButton_4);
		
		JButton btnNewButton_3 = new JButton("New button");
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton = new JButton("New button");
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_6 = new JButton("New button");
		panel_1.add(btnNewButton_6);
		
		JButton btnNewButton_5 = new JButton("New button");
		panel_1.add(btnNewButton_5);
		
		JButton btnNewButton_7 = new JButton("New button");
		panel_1.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("New button");
		panel_1.add(btnNewButton_8);
	}

}
