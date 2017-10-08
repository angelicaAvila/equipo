package deporte.vista;

import java.awt.Rectangle;

public interface CanchaInterfaz {
	public int getJugadorX();
	public int getJugadorY();
	public Rectangle getCancha();
	public void actualizar(int x, int y);
}
