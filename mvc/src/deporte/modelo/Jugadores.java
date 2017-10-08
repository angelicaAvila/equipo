package deporte.modelo;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Jugadores {

	private int x;
	private int y;
	
	
	public Jugadores(int x, int y) {
		super();
		this.x = x;
		this.y = y;
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

	public Jugadores mover(Rectangle r,boolean left, boolean right, boolean up, boolean down){
		double xCancha=r.getX();
		double yCancha=r.getY();
		double widthCancha=r.getWidth();
		double heightCancha=r.getHeight();
		
		if(left && getX()>(xCancha+10)){
			setX(getX()-5);
		}
		if(right && getX()<(widthCancha-10)){
			setX(getX()+5);
		}
		if(up && getY()>(yCancha+10)){
			setY(getY()-5);
		}
		if(down && getY()<(heightCancha-15)){
			setY(getY()+5);
		}
		
		return this;
	}
	
}