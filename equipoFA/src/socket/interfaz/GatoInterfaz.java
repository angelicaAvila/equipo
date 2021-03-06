package socket.interfaz;

import java.io.IOException;

import javax.swing.JButton;

import socket.modelo.Gatoxy;

public interface GatoInterfaz {

	public void setIcono(int label,int n);
	public void setSenalTurno(int imagen) ;
	public JButton getBtnJuegoN();
	public JButton getBoton(int n);
	public void setBoton(int n,JButton boton);
	public void finalizar();
	public void iniciar();
	public void actualizar(int x,int valor, int j);
	public int resultado();
	public void setValor(int x,int valor);
	public int getValor(int x);
	public void habilitarBotones(boolean sn);

}
