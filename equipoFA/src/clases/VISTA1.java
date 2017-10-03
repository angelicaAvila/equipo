package clases;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JSlider;
import javax.swing.JScrollBar;
import javax.swing.JProgressBar;
import javax.swing.JMenuBar;

public class VISTA1 extends JFrame {

	private JPanel contentPane;
	private JTextField txtHola;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VISTA1 frame = new VISTA1();
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
	public VISTA1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("primera interfaz");
		contentPane = new panel1();
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Este si");
		btnNewButton.setBounds(97, 15, 63, 23);
		btnNewButton.setToolTipText("CLICK");
		btnNewButton.setBackground(SystemColor.windowText);
		btnNewButton.setForeground(UIManager.getColor("Button.select"));
		
		/////////////////////////////////
		btnNewButton.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							txtHola.setText("SE REALIZO UNA ACCION");
					}
				}
		);
		contentPane.setLayout(null);
		
		////////////////////////
		contentPane.add(btnNewButton);
		
		txtHola = new JTextField();
		txtHola.setBounds(165, 16, 86, 20);
		txtHola.setText("Hola");
		contentPane.add(txtHola);
		btnNewButton.addActionListener(new Accion(txtHola));
		txtHola.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Este no");
		btnNewButton_3.setBounds(256, 15, 69, 23);
		btnNewButton_3.setEnabled(false);
		contentPane.add(btnNewButton_3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(97, 118, 237, 20);
		contentPane.add(passwordField);
		
		JSlider slider = new JSlider();
		slider.setBounds(100, 43, 200, 23);
		contentPane.add(slider);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(305, 44, 29, 20);
		contentPane.add(spinner);
	}
}

class Accion implements ActionListener
{
	JTextField test;
	public Accion(JTextField test){
		this.test=test;
	}
	public void actionPerformed(ActionEvent e) {
		test.setText("Se realizo una accion");
	}
	
}