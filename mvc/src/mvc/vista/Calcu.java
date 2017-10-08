package mvc.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mvc.controlador.CalcuControl;
import mvc.modelo.CalcuOperacion;

import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Calcu extends JFrame implements CalcuInterface{

	private JPanel contentPane;
	private JTextField txtNuno;
	private JTextField txtNdos;
	private JTextField txtResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calcu frame = new Calcu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Calcu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelBotones = new JPanel();
		panelBotones.setBackground(new Color(0, 153, 255));
		contentPane.add(panelBotones, BorderLayout.SOUTH);
		
		JButton btnSuma = new JButton("SUMA");
		btnSuma.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSuma.setBackground(new Color(255, 0, 0));
		panelBotones.add(btnSuma);
		
		JButton btnResta = new JButton("RESTA");
		btnResta.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnResta.setBackground(new Color(255, 153, 0));
		panelBotones.add(btnResta);
		
		JButton btnMultiplicar = new JButton("MULTIPLICACION");
		btnMultiplicar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnMultiplicar.setBackground(new Color(255, 204, 0));
		panelBotones.add(btnMultiplicar);
		
		JButton btnDividir = new JButton("DIVISION");
		btnDividir.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDividir.setBackground(new Color(0, 204, 51));
		panelBotones.add(btnDividir);
		
		JPanel panelDatos = new JPanel();
		panelDatos.setBackground(new Color(204, 204, 255));
		contentPane.add(panelDatos, BorderLayout.CENTER);
		panelDatos.setLayout(new GridLayout(3, 2, 0, 0));
		
		JLabel lblNumUno = new JLabel("NUMERO 1:");
		lblNumUno.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNumUno.setHorizontalAlignment(SwingConstants.CENTER);
		panelDatos.add(lblNumUno);
		
		txtNuno = new JTextField();
		txtNuno.setHorizontalAlignment(SwingConstants.CENTER);
		txtNuno.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelDatos.add(txtNuno);
		txtNuno.setColumns(10);
		
		JLabel lblNumero = new JLabel("NUMERO 2:");
		lblNumero.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNumero.setHorizontalAlignment(SwingConstants.CENTER);
		panelDatos.add(lblNumero);
		
		txtNdos = new JTextField();
		txtNdos.setHorizontalAlignment(SwingConstants.CENTER);
		txtNdos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelDatos.add(txtNdos);
		txtNdos.setColumns(10);
		
		JLabel lblResultado = new JLabel("NUMERO 3:");
		lblResultado.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		panelDatos.add(lblResultado);
		
		txtResultado = new JTextField();
		txtResultado.setHorizontalAlignment(SwingConstants.CENTER);
		txtResultado.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtResultado.setEditable(false);
		panelDatos.add(txtResultado);
		txtResultado.setColumns(10);
		
		CalcuOperacion modelo = new CalcuOperacion();
		CalcuControl cntrl = new CalcuControl(modelo,this);
		
		btnSuma.setActionCommand("suma");
		btnSuma.addActionListener(cntrl);
		
		btnResta.setActionCommand("resta");
		btnResta.addActionListener(cntrl);
		
		btnMultiplicar.setActionCommand("multiplicacion");
		btnMultiplicar.addActionListener(cntrl);
		
		btnDividir.setActionCommand("division");
		btnDividir.addActionListener(cntrl);
	}
	
	public double num;
	@Override
	public double getNumUno() {
		if(txtNuno.getText().compareTo("")==0)
			num = 0;
		else
			num = Double.parseDouble(txtNuno.getText());
		return num ;
	}

	@Override
	public double getNumDos() {
		if(txtNdos.getText().compareTo("")==0)
			num = 0;
		else
			num = Double.parseDouble(txtNdos.getText());
		return num ;
	}

	@Override
	public void setResultado(double resultado) {
		txtResultado.setText(String.valueOf(resultado));
	}

}
