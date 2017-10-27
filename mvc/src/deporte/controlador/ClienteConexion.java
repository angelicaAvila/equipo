package deporte.controlador;

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
	public ClienteConexion(EquipoFInterfaz EqInt,Socket cliente,CanchaInterfaz canchaI) {
		this.cliente = cliente;
		this.EqInt = EqInt;
		this.canchaI = canchaI;
		t = new Thread(this);
		t.start();
	}

	public void run() {
		while(true) {
			try {
				input = new ObjectInputStream(cliente.getInputStream());
				PaqueteDeDatos pack = (PaqueteDeDatos) input.readObject();
				String tipo = pack.getTipo();
				if(tipo.equals("ACTUALIZAR")) {
					canchaI.getJugador().setBounds(pack.getX(), pack.getY(), 40, 40);
				}
				else {
					EqInt.showCancha();
					EqInt.setFocusablePlay(false);
					EqInt.setFocusablePause(false);
					EqInt.setFocusableCancha(true);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
