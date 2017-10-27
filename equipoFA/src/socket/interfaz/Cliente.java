package socket.interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import socket.control.ClienteControl;
import socket.modelo.Persona;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Font;

public class Cliente extends JFrame implements Runnable{

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtMensaje;
	private JTextArea txtMensajes;
	private Socket cliente;
	private ObjectInputStream in;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cliente frame = new Cliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Cliente() {
		setTitle("CHAT");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Cliente.class.getResource("/imagen/chat-de-google-talk-icono-7305-32.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 224, 208));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelDatos = new JPanel();
		panelDatos.setBackground(new Color(250, 128, 114));
		contentPane.add(panelDatos, BorderLayout.NORTH);
		panelDatos.setLayout(new BoxLayout(panelDatos, BoxLayout.X_AXIS));
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombre.setBackground(new Color(220, 20, 60));
		panelDatos.add(lblNombre);
		
		txtNombre = new JTextField();
		panelDatos.add(txtNombre);
		txtNombre.setColumns(20);
		
		JPanel panelEscribir = new JPanel();
		contentPane.add(panelEscribir, BorderLayout.SOUTH);
		panelEscribir.setLayout(new BoxLayout(panelEscribir, BoxLayout.X_AXIS));
		
		txtMensaje = new JTextField();
		panelEscribir.add(txtMensaje);
		txtMensaje.setColumns(35);
		
		JButton btnEnviar = new JButton("ENVIAR");
		try {
			cliente = new Socket("127.0.0.1",8000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		btnEnviar.addActionListener(new ClienteControl(this,cliente));
		btnEnviar.setBackground(Color.GREEN);
		panelEscribir.add(btnEnviar);
		
		txtMensajes = new JTextArea();
		txtMensajes.setBackground(new Color(248, 248, 255));
		txtMensajes.setForeground(new Color(0, 0, 128));
		contentPane.add(txtMensajes, BorderLayout.CENTER);
		
		Thread t = new Thread(this);
		t.start();
	}

	public JTextArea getTxtMensajes() {
		return txtMensajes;
	}

	public void setTxtMensajes(JTextArea txtMensajes) {
		this.txtMensajes = txtMensajes;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField getTxtMensaje() {
		return txtMensaje;
	}

	public void setTxtMensaje(JTextField txtMensaje) {
		this.txtMensaje = txtMensaje;
	}

	public void run() {
		while(true) {
			try {
				in = new ObjectInputStream(cliente.getInputStream());
				Persona p = (Persona) in.readObject();
				txtMensajes.append("\n" + p.getNombre() + ": "+p.getMensaje());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
