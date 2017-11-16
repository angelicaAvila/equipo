package socket.control;

import java.awt.Component;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import socket.interfaz.Gato;
import socket.interfaz.GatoInterfaz;
import socket.modelo.Gatoxy;

public class ServidorConexion implements Runnable{

	public Socket cliente;
	public ObjectInputStream in;
	public Thread t;
	public GatoInterfaz gatoI;
	public ServerSocket servidor;
	public DataOutputStream outD;
	public boolean activo;
	
	public ServidorConexion(GatoInterfaz gatoI,ServerSocket servidor) {
		this.servidor = servidor;
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
				System.out.println("sc = "+ tipo);
				if(tipo.equals("ACTUALIZAR")) {
					gatoI.setValor(datos.getX(), datos.getN());
					gatoI.setIcono(datos.getX(),datos.getTurno());
					gatoI.getBoton(datos.getX()).setDisabledIcon(gatoI.getBoton(datos.getX()).getIcon());
					gatoI.getBoton(datos.getX()).setEnabled(false);
					gatoI.setSenalTurno(datos.getTurno());
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
				else if(tipo.equals("FINALIZAR")) {
					try {
						outD = new DataOutputStream(cliente.getOutputStream());
						outD.writeUTF("DESCONECTADO");
						System.exit(0);
						cliente.close();
					} catch (IOException e) {
						activo = false;
						e.printStackTrace();
					}
				}
			} catch (Exception e) {
				activo = false;
				e.printStackTrace();
			}
		}
		
	}

}
