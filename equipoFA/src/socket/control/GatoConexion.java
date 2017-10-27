package socket.control;

import java.awt.Component;
import java.io.ObjectInputStream;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import socket.interfaz.Gato;
import socket.interfaz.GatoInterfaz;
import socket.modelo.Gatoxy;

public class GatoConexion implements Runnable{

	public Socket cliente;
	public ObjectInputStream in;
	public Thread t;
	public GatoInterfaz gatoI;
	
	public GatoConexion(GatoInterfaz gatoI,Socket cliente) {
		this.cliente = cliente;
		this.gatoI = gatoI;
		t = new Thread(this);
		t.start();
	} 

	public void run() {
		while(true) {
			try {
				in = new ObjectInputStream(cliente.getInputStream());
				Gatoxy datos = (Gatoxy) in.readObject();
				String tipo = datos.getTipo();
				if(tipo.equals("ACTUALIZAR")) {
					gatoI.setValor(datos.getM(), datos.getN());
					gatoI.setIcono(datos.getM(),datos.getTurno());
					gatoI.getBoton(datos.getM()).setDisabledIcon(gatoI.getBoton(datos.getM()).getIcon());
					gatoI.getBoton(datos.getM()).setEnabled(false);
					gatoI.setSenalTurno((datos.getTurno())==1?2:1);
					int res = gatoI.resultado();
					if(res>0) {
						JOptionPane.showMessageDialog((Component) gatoI, "Ha ganado el jugador"+( res==1?"cliente":"servidor"), "GANADOR", JOptionPane.OK_OPTION,new ImageIcon(Gato.class.getResource("/imagen/wizard1-icono-5752-48.png")));
						gatoI.getBtnJuegoN().doClick();
					}
				}
				else if(tipo.equals("INICIAR")) {
					gatoI.setSenalTurno(1);
					for(int i=0; i<9;i++) {
						gatoI.getBoton(i).setIcon(null);
						gatoI.getBoton(i).setEnabled(true);
						gatoI.setValor(i,0);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
