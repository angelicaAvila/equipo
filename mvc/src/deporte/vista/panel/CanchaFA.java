package deporte.vista.panel;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import clases.Balon;
import deporte.Jugador;
import deporte.controlador.JugadorControl;
import deporte.modelo.PaqueteDeDatos;
import deporte.vista.CanchaInterfaz;

public class CanchaFA extends JPanel implements CanchaInterfaz,Runnable{

	deporte.Jugador Sujeto;
	private JLabel jugador;
	private Rectangle cancha;
	private Socket cliente;
	private ObjectOutputStream out;
	
	
	public CanchaFA(Socket cliente) {
		this.cliente = cliente;
		setLayout(null);
		jugador = new JLabel();
		jugador.setIcon(new ImageIcon(Cancha.class.getResource("/imagen/deporte-futbol-icono-6585-16.png")));
		add(jugador);
		
		JugadorControl cntrl = new JugadorControl(this);
		addKeyListener(cntrl);
		
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		ImageIcon aux= new ImageIcon(Balon.class.getResource("/imagen/cancha2.jpg"));
		Image imagen= aux.getImage();
		int x=getWidth()/2 - imagen.getWidth(this)/2;
		int y=getHeight()/2-imagen.getHeight(this)/2;
		g.drawImage(imagen, x, y,this );
		
		
		cancha=new Rectangle(x, y, aux.getIconWidth(), aux.getIconHeight());
		if(jugador.getBounds().width==0){
			x=getWidth()/2 - 20;
			y=getHeight()/2-20;
			jugador.setBounds(x, y, 40, 40);
			Thread t=new Thread(this);
			t.start();
		}
		
		
	}
	
	public Rectangle getCancha(){
		return cancha;
	}
	
	public int getJugadorX() {
		return jugador.getX();
	}
	
	public int getJugadorY() {
		return jugador.getY();
	}

	public void actualizar(int x, int y) throws IOException{
			out = new ObjectOutputStream(cliente.getOutputStream());
			PaqueteDeDatos pack = new PaqueteDeDatos(x, y, "ACTUALIZAR");
			out.writeObject(pack);
			jugador.setBounds(x, y, 40, 40);
	}

	public void run() {
		JugadorControl control=new JugadorControl(this);
		addKeyListener(control);

	}

	@Override
	public JLabel getJugador() {
		return jugador;
	}

}