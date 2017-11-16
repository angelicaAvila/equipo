package juego.vista;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import juego.manager.ImageManager;
import juego.manager.Recursos;

public class Escenario {

	private BufferedImage fondo;
	private BufferedImage piso; 
	private BufferedImage pisoD;
	private int x;
	private Game game;
	
	public Escenario(Game game) {
		this.game = game;
		fondo = Recursos.fondo;
		piso = Recursos.piso;
		pisoD = Recursos.piso;
		x = 0;
	}
	
	public void update() {
		if(game.getKm().isRight()) {
			x--;
			if(x<=-piso.getWidth()) {
				x=0;
			}
		}
		else if(game.getKm().isLeft()) {
			if(x>=5)
				x++;
		}
	}
	
	public void render(Graphics g) {
		g.drawImage(fondo, 0, 0, null);
		g.drawImage(piso, x, 0, null);
		g.drawImage(pisoD, x+piso.getWidth(), 0, null);
	}
	
	public Escenario getEscenario() {
		return this;
	}

}
