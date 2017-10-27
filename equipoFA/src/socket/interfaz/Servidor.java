package socket.interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
//import java.io.DataInputStream;
import java.io.IOException;
//import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import socket.control.ClienteNuevo;
import socket.modelo.Persona;

import javax.swing.JTextArea;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Servidor extends JFrame implements Runnable{

	private JPanel contentPane;
	private JTextArea txtMensajes;
	private JTextField txtMsg;
	private Socket cliente;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Servidor frame = new Servidor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Servidor() {
		setTitle("SERVIDOR");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Servidor.class.getResource("/imagen/servidor-icono-7515-32.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		txtMensajes = new JTextArea();
		contentPane.add(txtMensajes, BorderLayout.CENTER);
		
		JPanel panelMsg = new JPanel();
		contentPane.add(panelMsg, BorderLayout.SOUTH);
		panelMsg.setLayout(new BoxLayout(panelMsg, BoxLayout.X_AXIS));
		
		txtMsg = new JTextField();
		panelMsg.add(txtMsg);
		txtMsg.setColumns(25);
		
		JButton btnEnviar = new JButton("ENVIAR");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ObjectOutputStream out = new ObjectOutputStream(cliente.getOutputStream());
					String name = "Servidor";
					String mensaje = txtMsg.getText();
					Persona p = new Persona(name, mensaje);
					out.writeObject(p);
					txtMensajes.append("\nServidor: "+mensaje);
					txtMsg.setText("");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		panelMsg.add(btnEnviar);
		
		Thread t = new Thread(this);
		t.start();
	}

	public JTextArea getTxtMensajes() {
		return txtMensajes;
	}

	public void setTxtMensajes(JTextArea txtMensajes) {
		this.txtMensajes = txtMensajes;
	}

	public void run() {
		try {
			ServerSocket servidor = new ServerSocket(8000);
			while(true) {
				cliente =  servidor.accept();
				ClienteNuevo cn = new ClienteNuevo(cliente,this);
				Thread t = new Thread(cn);
				t.start();
				//DataInputStream input = new DataInputStream (cliente.getInputStream());
				//String mensaje = input.readUTF();
				//txtMensajes.append("\n"+mensaje);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
