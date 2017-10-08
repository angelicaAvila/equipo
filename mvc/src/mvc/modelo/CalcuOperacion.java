package mvc.modelo;

public class CalcuOperacion {
	
	private double num1;
	private double num2;
	
	public CalcuOperacion() {
	}
	
	public CalcuOperacion(double num1, double num2) {
		super();
		this.num1 = num1;
		this.num2 = num2;
	}

	public double getNum1() {
		return num1;
	}

	public void setNum1(double num1) {
		this.num1 = num1;
	}

	public double getNum2() {
		return num2;
	}

	public void setNum2(double num2) {
		this.num2 = num2;
	}
	
	public double suma() {
		return num1+num2;
	}
	public double resta() {
		return num1-num2;
	}
	
	public double multiplicar() {
		return num1*num2;
	}
	public double dividir() {
		return num1/num2;
	}

}
