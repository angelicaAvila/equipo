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
	public boolean activo;
	
	public GatoConexion(GatoInterfaz gatoI,Socket cliente) {
		this.cliente = cliente;
		this.gatoI = gatoI;
		activo = true;
		t = new Thread(this);
		t.start();
	} 

	public void run() {
		while(activo) {
			try {
				in = new ObjectInputStream(cliente.getInputStream());
				Gatoxy datos = (Gatoxy) in.readObject();
				String tipo = datos.getTipo();
				System.out.println("gc = "+ tipo);
				if(tipo.equals("ACTUALIZAR")) {
					gatoI.setValor(datos.getX(), datos.getN());
					gatoI.setIcono(datos.getX(),datos.getN());
					gatoI.getBoton(datos.getX()).setDisabledIcon(gatoI.getBoton(datos.getX()).getIcon());
					gatoI.getBoton(datos.getX()).setEnabled(false);
					gatoI.setSenalTurno((datos.getTurno())==1?2:1);
					gatoI.habilitarBotones(true);
					int res = gatoI.resultado();
					if(res>0) {
						JOptionPane.showMessageDialog((Component) gatoI, "Ha ganado el jugador: "+( res==1?"CLIENTE":"SERVIDOR"), "GANADOR", JOptionPane.OK_OPTION,new ImageIcon(Gato.class.getResource("/imagen/wizard1-icono-5752-48.png")));
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
				activo = false;
			}
		}
		
	}

}
