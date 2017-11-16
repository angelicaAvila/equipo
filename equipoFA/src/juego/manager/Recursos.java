package juego.manager;

import java.awt.image.BufferedImage;

public class Recursos {

	public static BufferedImage fondo;
	public static BufferedImage piso;
	public static BufferedImage jugador;
	public static BufferedImage [] jugadorLeft;
	public static BufferedImage [] jugadorRight;
	
	public static void init() {
		fondo = ImageManager.cargaImagen("/imagen/country-platform-back.png");
		piso = ImageManager.cargaImagen("/imagen/country-platform-tiles-example.png");
		SpriteManager sm = new SpriteManager("/imagen/test.png");
		jugador = sm.subImagen(0, 0, 32, 32);
		jugadorLeft = new BufferedImage[3];
		jugadorRight = new BufferedImage[3];
		
		jugadorLeft [0] = sm.subImagen(0, 32, 32, 32);
		jugadorLeft [1] = sm.subImagen(32, 32, 32, 32);
		jugadorLeft [2] = sm.subImagen(64, 32, 32, 32);
		
		jugadorRight [0] = sm.subImagen(0, 64, 32, 32);
		jugadorRight [1] = sm.subImagen(32, 64, 32, 32);
		jugadorRight [2] = sm.subImagen(64, 64, 32, 32);
	}
	
}
