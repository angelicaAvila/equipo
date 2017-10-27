package socket.control;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import socket.interfaz.Gato;
import socket.interfaz.GatoInterfaz;
import socket.modelo.Gatoxy;

public class GatoMatrizControl implements ActionListener{
	private GatoInterfaz gatoI;
	private Gatoxy gxy;
	public ObjectOutputStream out;
	public Socket cliente;
	int turno,valor,x; 
	
	public GatoMatrizControl(GatoInterfaz gatoI) {
		this.gatoI = gatoI;
		gxy = new Gatoxy(1,0,0, null);
	}
	
	public void actionPerformed(ActionEvent e) {
		turno = gxy.getTurno();
		valor = turno;
		String opc = e.getActionCommand();
		x = Integer.parseInt(opc);
		gxy.setTurno(turno==1?2:1);
		gatoI.actualizar(turno,x,valor,"ACTUALIZAR");
		int res = gatoI.resultado();
		if(res>0) {
			JOptionPane.showMessageDialog((Component) gatoI, "Ha ganado el jugador "+( res==1?"CLIENTE":"SERVIDOR"), "GANADOR", JOptionPane.OK_OPTION,new ImageIcon(Gato.class.getResource("/imagen/wizard1-icono-5752-48.png")));
			gatoI.getBtnJuegoN().doClick();
		}
	}
}
