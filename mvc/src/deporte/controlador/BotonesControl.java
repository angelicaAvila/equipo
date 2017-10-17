package deporte.controlador;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;

import deporte.modelo.FileManager;
import deporte.vista.EquipoFInterfaz;
import deporte.vista.jDialog.AboutDialog;
import deporte.vista.jDialog.ReglasDialog;
import deporte.vista.panel.CanchaFA;

public class BotonesControl implements ActionListener {

	FileManager<Component> file;
	EquipoFInterfaz EqInt;
	CanchaFA canchaNew;
	CanchaFA canchaIni;
	public BotonesControl(EquipoFInterfaz EqInt) {
		this.EqInt=EqInt;
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
				EqInt.setComponentShow(canchaNew);
				//canchaNew.actualizar(canchaNew.getJugadorX(), canchaNew.getJugadorY());
			}
			break;
	}
		
	}

}
