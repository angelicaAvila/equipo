package deporte.controlador;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;

import deporte.modelo.FileManager;
import deporte.vista.EquipoFInterfaz;
import deporte.vista.jDialog.AboutDialog;
import deporte.vista.jDialog.ReglasDialog;

public class BotonesControl implements ActionListener {

	FileManager<Component> file;
	EquipoFInterfaz vista;
	public BotonesControl(EquipoFInterfaz vista) {
		this.vista=vista;
	}
	
	public void actionPerformed(ActionEvent e) {
		String type=e.getActionCommand();
		switch(type){
		case "save":
			JFileChooser seleccion= new JFileChooser();
			int code=seleccion.showSaveDialog(vista.getComponentShow());
			if(code==JFileChooser.APPROVE_OPTION){
				file=new FileManager<Component>(seleccion.getSelectedFile().getAbsolutePath());
				file.writeObject(vista.getWriteObject());
			}
			break;
		case "play":
			vista.showCancha();
			vista.setFocusablePlay(false);
			vista.setFocusablePause(false);
			vista.setFocusableCancha(true);
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
			/*JFileChooser doc= new JFileChooser();
			int codigo=doc.showOpenDialog(vista.getComponentShow());
			if(codigo==JFileChooser.APPROVE_OPTION){
				file=new FileManager<Component>(doc.getSelectedFile().getAbsolutePath());
				file.readObject();
			}*/
			break;
	}
		
	}
	
	

}
