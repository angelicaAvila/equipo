package clases;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import java.awt.FlowLayout;

import javax.swing.JPasswordField;
import javax.swing.JCheckBox;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class formulario extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JPasswordField txtPass;
	private JRadioButton btnHombre;
	private JRadioButton btnMujer;
	private JCheckBox botonDeAcuerdo;
	private JPanel panelDatos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					formulario frame = new formulario();
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
	public formulario() {
		setTitle("FORMULARIO");
		setBackground(Color.BLACK);
		setFont(new Font("Arial Narrow", Font.BOLD, 14));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelBotones = new JPanel();
		contentPane.add(panelBotones, BorderLayout.SOUTH);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cadena = "El usuario "+ txtNombre.getText()+ " esta de acuerdo";
				if(txtNombre.getText().isEmpty() || txtPass.getText().isEmpty()){
					JOptionPane.showMessageDialog(panelDatos, "Se deben llenar los datos nombre y password","CONFIRMACION",JOptionPane.ERROR_MESSAGE);
				}else if(botonDeAcuerdo.isSelected())
					JOptionPane.showMessageDialog(panelDatos, cadena,"CONFIRMACION",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		panelBotones.add(btnEnviar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNombre.setText("");
				txtPass.setText("");
				btnMujer.setSelected(false);
				btnHombre.setSelected(true);
				botonDeAcuerdo.setSelected(false);
			}
		});
		
		panelBotones.add(btnLimpiar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int action = JOptionPane.showConfirmDialog(panelDatos, "Seguro que deseas salir?","SALIDA",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
				if(action == JOptionPane.YES_OPTION){
					System.exit(0);
				}
			}
		});
		panelBotones.add(btnSalir);
		
		panelDatos = new JPanel();
		contentPane.add(panelDatos, BorderLayout.CENTER);
		panelDatos.setLayout(new GridLayout(4, 2, 0, 0));
		
		JLabel lblNombre = new JLabel("Nombre:");
		panelDatos.add(lblNombre);
		
		txtNombre = new JTextField();
		panelDatos.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblPas = new JLabel("Password:");
		panelDatos.add(lblPas);
		
		txtPass = new JPasswordField();
		panelDatos.add(txtPass);
		
		JLabel lblGenero = new JLabel("Genero:");
		panelDatos.add(lblGenero);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		panelDatos.add(panel);
		
		btnMujer = new JRadioButton("FEMENINO");
		panel.add(btnMujer);
		
		btnHombre = new JRadioButton("MASCULINO");
		btnHombre.setSelected(true);
		panel.add(btnHombre);
		
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(btnMujer);
		grupo.add(btnHombre);
		
		JLabel lblNewLabel = new JLabel("Estas de acuerdo con los terminos?");
		panelDatos.add(lblNewLabel);
		
		botonDeAcuerdo = new JCheckBox("");
		panelDatos.add(botonDeAcuerdo);
	}

}
