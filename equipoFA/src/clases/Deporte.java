package clases;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Deporte extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deporte frame = new Deporte();
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
	public Deporte() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
		int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
		int hv = 300;
		int wv = 450;
		int x = ancho/2 - wv/2;
		int y = alto/2 - hv/2;
		setBounds(x, y, wv, hv);
		//setResizable(false);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmNuevo = new JMenuItem("Nuevo");
		mnArchivo.add(mntmNuevo);
		
		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mnArchivo.add(mntmGuardar);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de ...");
		mntmAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AboutDialog about = new AboutDialog("Clase interfaz deporte");
				about.setVisible(true);
			}
		});
		mnAyuda.add(mntmAcercaDe);
		
		JMenuItem mntmReglas = new JMenuItem("Reglas");
		mnAyuda.add(mntmReglas);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelBotones = new JPanel();
		contentPane.add(panelBotones, BorderLayout.NORTH);
		
		JButton btnPlay = new JButton("PLAY");
		panelBotones.add(btnPlay);
		
		JButton btnPause = new JButton("PAUSE");
		panelBotones.add(btnPause);
		
		JPanel panelJuego = new JPanel();
		contentPane.add(panelJuego, BorderLayout.CENTER);
		panelJuego.setLayout(new CardLayout(0, 0));
		
		Balon pnlPresentacion = new Balon();
		panelJuego.add(pnlPresentacion,"Balon");
		
		Cancha panelCancha = new Cancha();
		panelJuego.add(panelCancha,"Cancha");
		
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout c = (CardLayout) panelJuego.getLayout();
				//c.next(panelJuego);
				c.show(panelJuego, "Cancha");
			}
		});
	}

}
