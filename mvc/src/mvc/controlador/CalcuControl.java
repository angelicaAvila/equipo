package mvc.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mvc.modelo.CalcuOperacion;
import mvc.vista.CalcuInterface;

public class CalcuControl implements ActionListener{

	private CalcuOperacion modelo;
	private CalcuInterface vista;
	
	public CalcuControl(CalcuOperacion modelo, CalcuInterface vista) {
		super();
		this.modelo = modelo;
		this.vista = vista;
	}

	public void actionPerformed(ActionEvent e) {
		String accion = e.getActionCommand();
		double numUno = vista.getNumUno();
		double numDos = vista.getNumDos();
		modelo.setNum1(numUno);
		modelo.setNum2(numDos);
		double resultado = 0;
		
		switch(accion) {
		case "suma" 			:	resultado = modelo.suma(); 
								 	break;
		case "resta" 			:	resultado = modelo.resta();
									break;
		case "multiplicacion" 	:	resultado = modelo.multiplicar();
									break;
		case "division"			:	resultado = modelo.dividir();
									break;
		}
		vista.setResultado(resultado);
	}
	

}
