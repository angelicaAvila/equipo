package deporte.controlador;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JFileChooser;

import deporte.modelo.FileManager;
import deporte.modelo.PaqueteDeDatos;
import deporte.vista.EquipoFInterfaz;
import deporte.vista.jDialog.AboutDialog;
import deporte.vista.jDialog.ReglasDialog;
import deporte.vista.panel.CanchaFA;

public class BotonesControl implements ActionListener {

	FileManager<Component> file;
	EquipoFInterfaz EqInt;
	CanchaFA canchaNew;
	CanchaFA canchaIni;
	Socket cliente;
	ObjectOutputStream out;
	
	public BotonesControl(EquipoFInterfaz EqInt,Socket cliente) {
		this.EqInt=EqInt;
		this.cliente = cliente;
	}
	
	public void actionPerformed(ActionEvent e) {
		String type=e.getActionCommand();
		switch(type){
		case "save":
			JFileChooser seleccion= new JFileChooser();
			int code=seleccion.showSaveDialog(EqInt.getComponentShow());
			if(code==JFileChooser.APPROVE_OPTION){
				file=new FileManager<Component>(seleccion.getSelectedFile().getAbsolutePath());
				file.writeObject(EqInt.getWriteObject());
			}
			break;
		case "play":
			EqInt.showCancha();
			EqInt.setFocusablePlay(false);
			EqInt.setFocusablePause(false);
			EqInt.setFocusableCancha(true);
			try {
				out = new ObjectOutputStream(cliente.getOutputStream());
				PaqueteDeDatos pack = new PaqueteDeDatos(0, 0, "PintarCancha");
				out.writeObject(pack);
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			
			break;
		case "acerca":
			AboutDialog about= new AboutDialog("PRACTICA: INTERFAZ JUEGO");
			about.setVisible(true);
			break;
		case "reglas":
			ReglasDialog reglas = new ReglasDialog();
			reglas.setVisible(true);
			break;
		case "open":
			//canchaIni = (CanchaFA) EqInt.getComponentShow();
			JFileChooser doc= new JFileChooser();
			int codigo=doc.showOpenDialog(EqInt.getComponentShow());
			if(codigo==JFileChooser.APPROVE_OPTION){
				file=new FileManager<Component>(doc.getSelectedFile().getAbsolutePath());
				canchaNew = (CanchaFA) file.readObject();
				try {
					EqInt.setComponentShow(canchaNew);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				//canchaNew.actualizar(canchaNew.getJugadorX(), canchaNew.getJugadorY());
			}
			break;
	}
		
	}

}
