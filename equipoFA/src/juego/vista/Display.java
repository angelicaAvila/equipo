package juego.vista;

import java.awt.Canvas;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import java.awt.Toolkit;

public class Display extends JFrame{
	
	private int ancho;
	private int alto;
	private String titulo;
	private Canvas canvas;
	
	public Display(int ancho, int alto, String titulo) throws HeadlessException {
		super();
		this.ancho = ancho;
		this.alto = alto;
		this.titulo = titulo;
		init();
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Canvas getCanvas() {
		return canvas;
	}

	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}

	public void init() {
		setSize(ancho, alto);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Display.class.getResource("/imagen/los-jugadores-jovenes-icono-6231-32.png")));
		setTitle(titulo);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		
		canvas = new Canvas();
		canvas.setSize(ancho, alto);
		add(canvas);
		pack();
	}

}
