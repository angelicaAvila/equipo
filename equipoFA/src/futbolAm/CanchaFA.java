package futbolAm;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import clases.Balon;

public class CanchaFA extends JPanel {

	Jugador Sujeto;
	private int ancho;
	private int largo;

	
	public CanchaFA() {

	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image imagen = new ImageIcon(Balon.class.getResource("/imagen/cancha2.jpg")).getImage();
		ancho = getWidth()/2 - imagen.getWidth(this)/2;
		largo = getHeight()/2 - imagen.getHeight(this)/2;
		g.drawImage(imagen, ancho, largo, this);
		
		
	}
}