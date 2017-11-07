package deporte.controlador;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import deporte.modelo.PaqueteDeDatos;
import deporte.vista.CanchaInterfaz;
import deporte.vista.EquipoFInterfaz;

public class ClienteConexion implements Runnable{

	private Socket cliente;
	private ObjectInputStream input;
	private Thread t;
	private EquipoFInterfaz EqInt;
	private CanchaInterfaz canchaI;
	private boolean activo;
	public ClienteConexion(EquipoFInterfaz EqInt,Socket cliente,CanchaInterfaz canchaI) {
		this.cliente = cliente;
		this.EqInt = EqInt;
		this.canchaI = canchaI;
		activo = true;
		t = new Thread(this);
		t.start();
	}

	public void run() {
		while(activo) {
			try {
				input = new ObjectInputStream(cliente.getInputStream());
				System.out.println("CC - Esperando Mensaje");
				PaqueteDeDatos pack = (PaqueteDeDatos) input.readObject();
				String tipo = pack.getTipo();
				if(tipo.equals("ACTUALIZAR")) {
					System.out.println("CC - LLEGO MENSAJE DE ACTUALIZAR");
					canchaI.getJugador().setBounds(pack.getX(), pack.getY(), 40, 40);
				}
				else {
					System.out.println("CC - LLEGO MENSAJE DE INICIAR");
					EqInt.showCancha();
					EqInt.setFocusablePlay(false);
					EqInt.setFocusablePause(false);
					EqInt.setFocusableCancha(true);
				}
			} catch (IOException e) {
				activo = false;
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				activo = false;
				e.printStackTrace();
			}
		}
	}

}
