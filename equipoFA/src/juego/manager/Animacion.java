package juego.manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.Timer;

public class Animacion {

	private BufferedImage [] frames;
	private int speed;
	private int index;
	private BufferedImage currentFrame;
	private Timer temporizador;
	
	public Animacion(int speed, BufferedImage[] frames) {
		this.speed = speed;
		this.frames = frames;
		index = 0;
		temporizador = new Timer (speed,new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
		temporizador.setRepeats(true);
	}
	
	public void update() {
		index ++ ;
		if (index >= frames.length)
			index = 0 ;
	}
	
	public BufferedImage currentFrame() {
		return frames [ index ];
	}
	
	public void start() {
		if(!temporizador.isRunning()) {
			index = 0;
			temporizador.start();
		}
	}
	
	public void stop() {
		if(temporizador.isRunning())
			temporizador.stop();
	}
}
