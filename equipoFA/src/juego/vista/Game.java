package juego.vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import juego.manager.ImageManager;
import juego.manager.KeyManager;
import juego.manager.Recursos;

public class Game implements Runnable{

	private Display ventana;
	private int ancho;
	private int alto;
	private String titulo;
	private boolean activo;
	private Thread t;
	private BufferStrategy bs;
	private Graphics g;
	private KeyManager km;
	private Escenario escenario;
	private Jugador jugador;
	

	public Game(int ancho, int alto, String titulo) {
		super();
		this.ancho = ancho;
		this.alto = alto;
		this.titulo = titulo;
		km = new KeyManager();
	}
	
	public void init() {
		ventana = new Display (ancho, alto, titulo);
		ventana.getCanvas().addKeyListener(km);
		ventana.getCanvas().setFocusable(true);
		Recursos.init();
		escenario = new Escenario(this);
		jugador = new Jugador (this,0,160);
	}

	public synchronized void start() {
		if(activo)
			return;
		activo = true;
		t = new Thread (this);
		t.start();
	}
	
	public synchronized void stop() {
		if(!activo)
			return;
		activo = false;
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public KeyManager getKm() {
		return km;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public void update() {
		jugador.update();
		escenario.update();
	}
	
	public void render() {
		bs = ventana.getCanvas().getBufferStrategy();
		if (bs == null) {
			ventana.getCanvas().createBufferStrategy(3);
			return;
		}
		g=bs.getDrawGraphics(); 
		g.clearRect(0, 0, ancho, alto); 
		//PINTAR ELEMENTOS
		escenario.render(g);
		jugador.render(g);
		//FIN DE PINTADO
		bs.show();
		g.dispose();
	}
	
	public void run() {
		init();// INICIALIZAR JUEGO
		int fps = 60;
		double nanoPorFrame = 1000000000/fps;
		long nuevo;
		long pasado = System.nanoTime();
		double delta = 0;
		while(activo) {
			nuevo = System.nanoTime();
			delta+=(nuevo-pasado)/nanoPorFrame;
			pasado = nuevo;
			if(delta >= 1) {
				update();//actualizacion de logica
				render();//repintado	
				delta --;
			}
		}	
	}


}
