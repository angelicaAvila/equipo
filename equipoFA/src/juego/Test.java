package juego;

import java.io.IOException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import org.newdawn.easyogg.OggClip;
import juego.vista.Display;
import juego.vista.Game;

public class Test {

	public static void main(String args[]) {
		Game ventana = new Game(384,225,"JUEGO");
		ventana.start();
		try {
			Clip sonido = AudioSystem.getClip();
			sonido.open(AudioSystem.getAudioInputStream(Test.class.getResourceAsStream("/sounds/sonido3.wav")));
			sonido.loop(Clip.LOOP_CONTINUOUSLY);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			OggClip sonido = new OggClip(Test.class.getResourceAsStream("/sounds/sonido1.ogg"));
			sonido.loop();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
