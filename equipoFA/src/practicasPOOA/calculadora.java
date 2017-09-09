package practicasPOOA;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
//import javax.swing.DropMode;
import java.awt.Color;
//import javax.swing.border.CompoundBorder;
import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import javax.swing.ImageIcon;
//import java.awt.event.KeyAdapter;
//import java.awt.event.KeyEvent;

public class calculadora extends JFrame {

	private JPanel contentPane;
	private JTextField pantalla;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final JToggleButton btnSigno;
	private float reg = 0.000f;
	private float regD = 0.000f;
	String cantidad = "0";
	String signo = "-";
	int opcion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calculadora frame = new calculadora();
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
	public calculadora() {
		setTitle("CALCULADORA");
		setForeground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.LIGHT_GRAY);
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.GRAY);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBorder(new EmptyBorder(3, 6, 3, 8));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(4, 3, 0, 0));
		
	
		JButton btnSiete = new JButton("7");
		btnSiete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pantalla.setText(pantalla.getText() + "7");
				cantidad = pantalla.getText();
			}
		});
		btnSiete.setForeground(Color.WHITE);
		btnSiete.setFont(new Font("Arial", Font.PLAIN, 20));
		btnSiete.setBackground(new Color(0, 128, 128));
		panel.add(btnSiete);
		
		JButton btnOcho = new JButton("8");
		btnOcho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			pantalla.setText(pantalla.getText() + "8");
			cantidad = pantalla.getText();
			}
		});
		btnOcho.setForeground(Color.WHITE);
		btnOcho.setFont(new Font("Arial", Font.PLAIN, 20));
		btnOcho.setBackground(new Color(0, 128, 128));
		panel.add(btnOcho);
		
		JButton btnNueve = new JButton("9");
		btnNueve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pantalla.setText(pantalla.getText() + "9");
				cantidad = pantalla.getText();
			}
		});
		btnNueve.setForeground(Color.WHITE);
		btnNueve.setFont(new Font("Arial", Font.PLAIN, 20));
		btnNueve.setBackground(new Color(0, 128, 128));
		panel.add(btnNueve);
		
		JButton btnCuatro = new JButton("4");
		btnCuatro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pantalla.setText(pantalla.getText() + "4");
				cantidad = pantalla.getText();
			}
		});
		btnCuatro.setForeground(Color.WHITE);
		btnCuatro.setFont(new Font("Arial", Font.PLAIN, 20));
		btnCuatro.setBackground(new Color(0, 128, 128));
		panel.add(btnCuatro);
		
		JButton btnCinco = new JButton("5");
		btnCinco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pantalla.setText(pantalla.getText() + "5");
				cantidad = pantalla.getText();
			}
		});
		btnCinco.setForeground(Color.WHITE);
		btnCinco.setFont(new Font("Arial", Font.PLAIN, 20));
		btnCinco.setBackground(new Color(0, 128, 128));
		panel.add(btnCinco);
		
		JButton btnSeis = new JButton("6");
		btnSeis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pantalla.setText(pantalla.getText() + "6");
				cantidad = pantalla.getText();
			}
		});
		btnSeis.setForeground(Color.WHITE);
		btnSeis.setFont(new Font("Arial", Font.PLAIN, 20));
		btnSeis.setBackground(new Color(0, 128, 128));
		panel.add(btnSeis);
		
		JButton btnUno = new JButton("1");
		btnUno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pantalla.setText(pantalla.getText() + "1");
				cantidad = pantalla.getText();
			}
		});
		btnUno.setForeground(Color.WHITE);
		btnUno.setFont(new Font("Arial", Font.PLAIN, 20));
		btnUno.setBackground(new Color(0, 128, 128));
		panel.add(btnUno);
		
		JButton btnDos = new JButton("2");
		btnDos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pantalla.setText(pantalla.getText() + "2");
				cantidad = pantalla.getText();
			}
		});
		btnDos.setForeground(Color.WHITE);
		btnDos.setFont(new Font("Arial", Font.PLAIN, 20));
		btnDos.setBackground(new Color(0, 128, 128));
		panel.add(btnDos);
		
		JButton btnTres = new JButton("3");
		btnTres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pantalla.setText(pantalla.getText() + "3");
				cantidad = pantalla.getText();
			}
		});
		btnTres.setForeground(Color.WHITE);
		btnTres.setFont(new Font("Arial", Font.PLAIN, 20));
		btnTres.setBackground(new Color(0, 128, 128));
		panel.add(btnTres);
		
		JButton btnPunto = new JButton(".");
		btnPunto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cantidad.concat(".");
				pantalla.setText(pantalla.getText() + ".");
			}
		});
		btnPunto.setForeground(Color.WHITE);
		btnPunto.setFont(new Font("Arial", Font.PLAIN, 20));
		btnPunto.setBackground(new Color(0, 128, 128));
		panel.add(btnPunto);
		
		JButton btnCero = new JButton("0");
		btnCero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cantidad.concat("0");
				pantalla.setText(pantalla.getText() + "0");
			}
		});
		btnCero.setForeground(Color.WHITE);
		btnCero.setFont(new Font("Arial", Font.PLAIN, 20));
		btnCero.setBackground(new Color(0, 128, 128));
		panel.add(btnCero);
		
		JButton btnIgual = new JButton("=");
		btnIgual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(reg == 0) {
					reg = Float.parseFloat(cantidad);
				}
				else {
					regD = Float.parseFloat(cantidad); 
					switch(opcion) {
						case 1 : 	reg = reg+regD;
									break;
						case 2 :	reg = reg-regD;
									break;
						case 3 :	reg = reg*regD;
									break;
						case 4 :	reg = reg/regD;
									break;
						default:	reg = reg;
									break;
					}
				}
				
				pantalla.setText(Float.toString(reg));
			}
		});
		btnIgual.setForeground(Color.WHITE);
		btnIgual.setFont(new Font("Arial", Font.PLAIN, 20));
		btnIgual.setBackground(new Color(0, 128, 128));
		panel.add(btnIgual);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.LIGHT_GRAY);
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBorder(new EmptyBorder(3, 8, 3, 6));
		contentPane.add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btnDivision = new JButton("/");
		btnDivision.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reg = reg + Float.parseFloat(cantidad);
				cantidad=null;
				opcion = 4;
				pantalla.setText("");
			}
		});
		buttonGroup.add(btnDivision);
		btnDivision.setBackground(new Color(32, 178, 170));
		btnDivision.setForeground(Color.WHITE);
		btnDivision.setFont(new Font("Arial", Font.PLAIN, 20));
		panel_1.add(btnDivision);
		
		JButton btnBorrar = new JButton("CE");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pantalla.setText("");
				reg = 0.00f;
				regD = 0.00f; 
				cantidad = "0";
				btnSigno.setSelected(false);
				
			}
		});
		btnBorrar.setBackground(new Color(32, 178, 170));
		btnBorrar.setForeground(Color.WHITE);
		btnBorrar.setFont(new Font("Arial", Font.PLAIN, 20));
		panel_1.add(btnBorrar);
		
		JButton btnMultiplicacion = new JButton("x");
		btnMultiplicacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reg = reg + Float.parseFloat(cantidad);
				cantidad=null;
				opcion = 3;
				pantalla.setText("");
			}
		});
		buttonGroup.add(btnMultiplicacion);
		btnMultiplicacion.setBackground(new Color(32, 178, 170));
		btnMultiplicacion.setForeground(Color.WHITE);
		btnMultiplicacion.setFont(new Font("Arial", Font.PLAIN, 20));
		panel_1.add(btnMultiplicacion);
		
		JButton btnRaiz = new JButton("");
		btnRaiz.setIcon(new ImageIcon(calculadora.class.getResource("/practicasPOOA/160a5b4ac79375bd4c5e13c0f3a95f73.png")));
		btnRaiz.setBackground(new Color(32, 178, 170));
		btnRaiz.setForeground(Color.WHITE);
		btnRaiz.setFont(new Font("Arial", Font.PLAIN, 20));
		btnRaiz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(reg==0) 
					reg = Float.parseFloat(cantidad);
					reg = (float) Math.sqrt(reg);
				pantalla.setText(Float.toString(reg));
			}
		});
		panel_1.add(btnRaiz);
		
		JButton btnResta = new JButton("-");
		btnResta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reg = reg + Float.parseFloat(cantidad);
				cantidad=null;
				opcion = 2;
				pantalla.setText("");;
				
			}
		});
		buttonGroup.add(btnResta);
		btnResta.setBackground(new Color(32, 178, 170));
		btnResta.setForeground(Color.WHITE);
		btnResta.setFont(new Font("Arial", Font.PLAIN, 20));
		panel_1.add(btnResta);
		
		JButton btnCuadrado = new JButton("^2");
		btnCuadrado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(reg==0) 
					reg = Float.parseFloat(cantidad);
					reg = reg*reg;
				pantalla.setText(Float.toString(reg));
				
			}
		});
		btnCuadrado.setBackground(new Color(32, 178, 170));
		btnCuadrado.setForeground(Color.WHITE);
		btnCuadrado.setFont(new Font("Arial", Font.PLAIN, 20));
		panel_1.add(btnCuadrado);
		
		JButton btnSuma = new JButton("+");
		btnSuma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//pantalla.setText(pantalla.getText() + "+");
				reg = reg + Float.parseFloat(cantidad);
				cantidad=null;
				opcion = 1;
				pantalla.setText("");
			}
		});
		buttonGroup.add(btnSuma);
		btnSuma.setBackground(new Color(32, 178, 170));
		btnSuma.setForeground(Color.WHITE);
		btnSuma.setFont(new Font("Arial", Font.PLAIN, 20));
		panel_1.add(btnSuma);
		
		btnSigno = new JToggleButton("-/+");
		btnSigno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnSigno.isSelected() == true) {
					pantalla.setText("-" + pantalla.getText());
					cantidad = pantalla.getText();
					pantalla.setText(cantidad);
				}
				else {
					pantalla.setText(pantalla.getText().substring(1));
					cantidad = pantalla.getText();
				}
					
			}
		});
		btnSigno.setBackground(new Color(32, 178, 170));
		btnSigno.setForeground(new Color(255, 255, 255));
		btnSigno.setFont(new Font("Arial", Font.PLAIN, 20));
		panel_1.add(btnSigno);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel_2, BorderLayout.NORTH);
		
		pantalla = new JTextField();
		pantalla.setFont(new Font("Arial", Font.PLAIN, 24));
		panel_2.add(pantalla);
		pantalla.setColumns(20);
		
		 
	}

}