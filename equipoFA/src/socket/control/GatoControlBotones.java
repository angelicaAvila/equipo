package socket.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import socket.interfaz.AboutDialog;
import socket.interfaz.GatoInterfaz;
import socket.modelo.Gatoxy;

public class GatoControlBotones implements ActionListener{
	private GatoInterfaz gatoI;
	private Gatoxy gxy;
	Socket cliente;
	ObjectOutputStream out;
	public GatoControlBotones(GatoInterfaz gatoI) {
		this.gatoI = gatoI;
		this.gxy = gxy;
	}

	public void actionPerformed(ActionEvent e) {
		String op = e.getActionCommand();
		int m = 0;
		String mensaje = null;
		switch(op) {
		case "inicio" 	: 	gatoI.iniciar();
							mensaje = "INICIAR";
							break;
		case "acerca" : 	AboutDialog about = new AboutDialog("JUEGO GATO CLIENTE-SERVIDOR");
							about.setVisible(true);
							break;
		case "fin"		:	gatoI.finalizar();
							mensaje = "FINALIZAR";
							break; 
				
		}
		if(m==0) {
			try {
				out = new ObjectOutputStream(cliente.getOutputStream());
				Gatoxy pack = new Gatoxy(0,0,0,mensaje);
				out.writeObject(pack);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		
		}
	}	

}
