package clases;


import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Cancha extends JPanel {

	/**
	 * Create the panel.
	 */
	public Cancha() {

	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image imagen = new ImageIcon(Balon.class.getResource("/imagen/cancha.jpg")).getImage();
		int x = getWidth()/2 - imagen.getWidth(this)/2;
		int y = getHeight()/2 - imagen.getHeight(this)/2;
		g.drawImage(imagen, x, y, this);
		
	}

}
