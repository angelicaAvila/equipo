package socket.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import socket.interfaz.Cliente;
import socket.modelo.Persona;

public class ClienteControl  implements ActionListener{
	
	private Cliente cliente;
	private Socket puente;

	public ClienteControl(Cliente cliente,Socket puente) {
		this.cliente = cliente;
		this.puente = puente;
	}

	public void actionPerformed(ActionEvent e) {
		//String host = "127.0.0.1";
		//int port = 8000;
		try {
			//Socket s = new Socket(host,port);
			ObjectOutputStream salir = new ObjectOutputStream(puente.getOutputStream());
			Persona p = new Persona(cliente.getTxtNombre().getText(),cliente.getTxtMensaje().getText());
			salir.writeObject(p);
			cliente.getTxtMensajes().append("\n Yo: "+ cliente.getTxtMensaje().getText());
			cliente.getTxtMensaje().setText("");
			//salir.close();
			//DataOutputStream salida = new DataOutputStream(s.getOutputStream());
			//String mensaje = cliente.getTxtMensaje().getText();
			//salida.writeUTF(mensaje);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		
	}

}
