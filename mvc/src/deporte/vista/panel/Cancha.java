package deporte.vista.panel;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import deporte.controlador.JugadorControl;
import deporte.vista.CanchaInterfaz;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Cancha extends JPanel implements CanchaInterfaz{

	private JLabel jugador;
	
	public Cancha() {
		setLayout(null);
		jugador = new JLabel();
		jugador.setIcon(new ImageIcon(Cancha.class.getResource("/imagen/deporte-futbol-icono-6585-16.png")));
		jugador.setBounds(15, 15, 16, 16);
		add(jugador);
		JugadorControl cntrl = new JugadorControl(this);
		addKeyListener(cntrl);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image imagen = new ImageIcon(Balon.class.getResource("/imagen/cancha.jpg")).getImage();
		int x = getWidth()/2 - imagen.getWidth(this)/2;
		int y = getHeight()/2 - imagen.getHeight(this)/2;
		g.drawImage(imagen, x, y, this);
		
	}

	public int getJugadorX() {
		return jugador.getX();
	}

	public int getJugadorY() {
		return jugador.getY();
	}
	public Rectangle getCancha() {
		// TODO Auto-generated method stub
		return null;
	}

	public void actualizar(int x, int y) {
		// TODO Auto-generated method stub
		
	}

}
