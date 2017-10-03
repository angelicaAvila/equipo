package hilos;

//import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;

import javax.swing.JPanel;

public class PanelFig extends JPanel /*implements Runnable*/{
	ArrayList<Figura> listaFiguras = new ArrayList<Figura>();
	/**
	 * Create the panel.
	 */
	public PanelFig() {

	}
	
	public void addFigura(Figura f) {
		listaFiguras.add(f);
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(Figura f: listaFiguras) {
			g.setColor(f.getColor());
			String tipoFigura = f.getForma();
			if(tipoFigura.equals("Cuadrado")) {
				g.fillRect(f.getX(), f.getY(), f.getSize(), f.getSize());
			}
			else if(tipoFigura.equals("Circulo")) {
				g.fillOval(f.getX(), f.getY(), f.getSize(), f.getSize());
			}
			else {
				Polygon p = new Polygon();
				p.addPoint(f.getX()+(f.getSize()/2),f.getY()-f.getSize());
				p.addPoint(f.getX(), f.getY());
				p.addPoint(f.getX()+f.getSize(), f.getY());
				g.fillPolygon(p);
			}
		}
	}

	//@Override
	/*public void run() {
		while (true) {
			for (Figura f: listaFiguras)
				f.mover(getHeight(),getWidth());
			repaint();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}*/
	
}
