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
	Socket cliente;
	ObjectOutputStream out;
	public GatoControlBotones(GatoInterfaz gatoI) {
		this.gatoI = gatoI;
	}

	public void actionPerformed(ActionEvent e) {
		String op = e.getActionCommand();
		switch(op) {
		case "inicio" 	: 	gatoI.iniciar();
							break;
		case "acerca" : 	AboutDialog about = new AboutDialog("JUEGO GATO CLIENTE-SERVIDOR");
							about.setVisible(true);
							break;
		case "fin"		:	gatoI.finalizar();
							break;
				
		}
	}

}
