package deporte.vista;

import java.awt.Rectangle;
import java.io.IOException;

import javax.swing.JLabel;

public interface CanchaInterfaz {
	public int getJugadorX();
	public int getJugadorY();
	public Rectangle getCancha();
	public void actualizar(int x, int y) throws IOException;
	public JLabel getJugador();
}
