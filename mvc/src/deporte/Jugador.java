package deporte;
import Package.Persona;
import deporte.vista.EquipoF;
import deporte.vista.panel.CanchaFA;

public class Jugador extends Persona {

	/**
	 * En Kilos
	 */
	public float Peso = 0;
	/**
	 * En metros
	 */
	public float estatura = 0;
	public int numero;
	Entrenador dirije;
	EquipoF formadoPor;
	CanchaFA Lugar;

}