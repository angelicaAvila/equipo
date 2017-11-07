package socket.modelo;

import java.io.Serializable;

public class Gatoxy implements Serializable{
	private int turno;
	private int n; 
	private int x;
	private String tipo;
	
	public Gatoxy(int turno,int x,int n,String tipo) {
		this.n = n;
		this.x = x;
		this.tipo=tipo;	
		this.turno=turno; 
	}
	
	public int getN() {
		return n; 
	}

	public void setN(int n) {
		this.n = n;
	}

	public int getX() {
		return x;
	}

	public void setX(int m) {
		this.x = m;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public int getTurno() {
		return turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}
	
}
