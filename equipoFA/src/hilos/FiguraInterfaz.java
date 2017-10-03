package hilos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FiguraInterfaz extends JFrame {

	private JPanel contentPane;
	private Color c;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FiguraInterfaz frame = new FiguraInterfaz();
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
	public FiguraInterfaz() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelDatos = new JPanel();
		contentPane.add(panelDatos, BorderLayout.NORTH);
		
		JLabel Figura = new JLabel("FIGURA:");
		Figura.setFont(new Font("Arial", Font.PLAIN, 13));
		panelDatos.add(Figura);
		
		final JComboBox comboBoxFigura = new JComboBox();
		comboBoxFigura.setModel(new DefaultComboBoxModel(new String[] {"Cuadrado", "Circulo", "Triangulo"}));
		comboBoxFigura.setFont(new Font("Arial", Font.PLAIN, 13));
		panelDatos.add(comboBoxFigura);
		
		
		JLabel Tamanio = new JLabel("TAMA\u00D1O:");
		Tamanio.setFont(new Font("Arial", Font.PLAIN, 13));
		panelDatos.add(Tamanio);
		
		final JSpinner spinnerTamanio = new JSpinner();
		spinnerTamanio.setFont(new Font("Arial", Font.PLAIN, 13));
		panelDatos.add(spinnerTamanio);
		SpinnerNumberModel modelo = new SpinnerNumberModel(5, 5, 30, 1);
		spinnerTamanio.setModel(modelo);
		
		JLabel color = new JLabel("COLOR:");
		color.setFont(new Font("Arial", Font.PLAIN, 13));
		panelDatos.add(color);
		
		final JLabel testColor = new JLabel("    ");
		testColor.setFont(new Font("Arial", Font.PLAIN, 13));
		panelDatos.add(testColor);
		c = Color.blue;
		testColor.setBackground(Color.blue);
		testColor.setOpaque(true);
		
		JButton btnColor = new JButton("COLOR");
		btnColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				c = JColorChooser.showDialog(contentPane,"Seleccione Color", Color.blue);
				if(c!=null) {
					testColor.setBackground(c);
					testColor.setOpaque(true);
				}
			}
		});
		btnColor.setFont(new Font("Arial", Font.PLAIN, 13));
		panelDatos.add(btnColor);
		
		JButton btnAgregar = new JButton("AGREGAR");
		btnAgregar.setFont(new Font("Arial", Font.PLAIN, 13));
		panelDatos.add(btnAgregar);
		
		final PanelFig panelFiguras = new PanelFig();
		panelFiguras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Random rnd = new Random();
				int size = (Integer)spinnerTamanio.getValue();
				int x = e.getX();
				int y = e.getY();
				int dx = (int) (rnd.nextDouble() * (15-size) + 1);
				int dy = (int) (rnd.nextDouble() * (15-size) + 1);
				String forma = (String) comboBoxFigura.getSelectedItem();
				
				Figura f = new Figura(x, y, dx, dy, c, size, forma,panelFiguras);
				panelFiguras.addFigura(f);
			}
			
		});
	//	Thread t = new Thread(panelFiguras);
	//	t.start();
		contentPane.add(panelFiguras, BorderLayout.CENTER);
		
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Random rnd = new Random();
				int size = (Integer)spinnerTamanio.getValue();
				int x = (int) (rnd.nextDouble() * (panelFiguras.getWidth()-size) + 0);
				int y = (int) (rnd.nextDouble() * (panelFiguras.getHeight()-size) + 0);
				int dx = (int) (rnd.nextDouble() * (15-size) + 1);
				int dy = (int) (rnd.nextDouble() * (15-size) + 1);
				String forma = (String) comboBoxFigura.getSelectedItem();
				
				Figura f = new Figura(x, y, dx, dy, c, size, forma,panelFiguras);
				panelFiguras.addFigura(f);
				
			}
		});
	}

}
