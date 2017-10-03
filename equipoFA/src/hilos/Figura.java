package hilos;

import java.awt.Color;
import java.awt.Component;

public class Figura implements Runnable{

	private int x;
	private int y;
	private int dx;
	private int dy;
	private Color color;
	private int size;
	private String forma;
	private Component componente;
	
	public Figura(int x, int y, int dx, int dy, Color color, int size,String forma,Component componente) {
		super();
		this.x = x;
		this.y = y;
		this.dx = dx;
		this.dy = dy;
		this.color = color;
		this.size = size;
		this.forma=forma;
		this.componente = componente;
		Thread t = new Thread(this);
		t.start();
	}
	
	public Figura() {
		
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public int getDy() {
		return dy;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public void mover(int alto,int ancho) {
		x+=dx;
		y+=dy;
		if(x>=(ancho-size)) {
			x=ancho-size;
			dx=-dx;
		}
		if(x<=0+size) {
			//x=0;
			dx=-dx;
		}
		if(y>=(alto-size)) {
			y=alto-size;
			dy=-dy;
		}
		if(y<=0) {
			y=0;
			dy=-dy;
		}
	}

	public String getForma() {
		return forma;
	}

	public void setForma(String forma) {
		this.forma = forma;
	}
	
	public void run() {
		while (true) {
			mover(componente.getHeight(),componente.getWidth());
			componente.repaint();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
