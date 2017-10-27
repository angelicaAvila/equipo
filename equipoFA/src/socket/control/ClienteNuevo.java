package socket.control;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import socket.interfaz.Servidor;
import socket.modelo.Persona;

public class ClienteNuevo implements Runnable{

	private Socket cliente;
	private Servidor server;
	private ObjectInputStream in;
	public ClienteNuevo(Socket cliente, Servidor server) {
		this.cliente = cliente;
		this.server = server;
	}

	public void run() {
		try {
			in = new ObjectInputStream(cliente.getInputStream());
			Persona p = (Persona) in.readObject();
			server.getTxtMensajes().append("\n"+p.getNombre() +": "+p.getMensaje());
			
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}

}
