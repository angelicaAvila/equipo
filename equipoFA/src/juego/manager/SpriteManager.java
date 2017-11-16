package juego.manager;

import java.awt.image.BufferedImage;

public class SpriteManager {

	private BufferedImage sprite;
	
	public SpriteManager(String path) {
		
		sprite = ImageManager.cargaImagen(path);
	}
	
	public BufferedImage subImagen (int x, int y, int w, int h) {
		return sprite.getSubimage(x,y,w,h);
	}
	
	

}
