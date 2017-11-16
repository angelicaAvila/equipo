package juego.manager;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageManager {

	public ImageManager() {
		
	}
	public static BufferedImage cargaImagen(String path) {
		try {
			return ImageIO.read(ImageManager.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
