package socket.control;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import socket.interfaz.Servidor;
import socket.modelo.Persona;

public class ClienteNuevo implements Runnable{

	private Socket cliente;
	private Servidor server;
	private ObjectInputStream in;
	private ArrayList<Socket> listaClientes;
	public ClienteNuevo(Socket cliente, Servidor server, ArrayList<Socket> listaClientes) {
		this.cliente = cliente;
		this.server = server;
		this.listaClientes = listaClientes;
	}

	public void run() {
		while(true) {
			try {
				in = new ObjectInputStream(cliente.getInputStream());
				Persona p = (Persona) in.readObject();
				server.getTxtMensajes().append("\n"+p.getNombre() +": "+p.getMensaje());
				for(Socket item:listaClientes) {
					if(!item.equals(cliente)) {
						ObjectOutputStream out = new ObjectOutputStream(item.getOutputStream());
						out.writeObject(p);
					}
				}
			} catch (IOException e) {
				
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
		}
	}

}
