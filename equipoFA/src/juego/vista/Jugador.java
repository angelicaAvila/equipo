package juego.vista;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import juego.manager.Animacion;
import juego.manager.ImageManager;
import juego.manager.Recursos;

public class Jugador {

	private int x;
	private int y;
	private int dx;
	private int dy;
	private BufferedImage imagen;
	private Game juego;
	private Animacion jugadorL;
	private Animacion jugadorR;
	
	public Jugador(Game juego,int x, int y) {
		super();
		this.juego = juego;
		this.x = x;
		this.y = y;
		dx = 1;
		dy = 1;
		imagen = Recursos.jugador;
		jugadorL = new Animacion(500,Recursos.jugadorLeft);
		jugadorR = new Animacion(500,Recursos.jugadorRight);
	}

	public Jugador() {
		// TODO Auto-generated constructor stub
	}
	
	public void update() {
		if(juego.getKm().isRight()) {
			if(x<=juego.getAncho()-200) 
				x+=dx;
			jugadorL.stop();
			jugadorR.start();
			
		}
			
		else if(juego.getKm().isLeft()) {
			if(x>=0) 
				x-=dx;	
			jugadorR.stop();
			jugadorL.start();
			
		}
	}
	
	public void render(Graphics g) {
		g.drawImage(currentFrame(), x, y, null);
	//	g.dispose();
	}
	
	public BufferedImage currentFrame() {
		if(juego.getKm().isRight()) {
			return jugadorR.currentFrame();
		}
		else if(juego.getKm().isLeft()) {
			return jugadorL.currentFrame();
		}
		return Recursos.jugador;
	}
}
