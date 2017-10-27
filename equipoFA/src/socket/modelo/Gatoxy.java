package socket.modelo;

import java.io.Serializable;

public class Gatoxy implements Serializable{
	private int turno;
	private int n; 
	private int m;
	private String tipo;
	
	public Gatoxy(int turno,int m,int n,String tipo) {
		this.n = n;
		this.m = m;
		this.tipo=tipo;	
		this.turno=turno; 
	}
	
	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
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
