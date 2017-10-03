import java.util.*;

/**
 * Clase Principal de la Interfaz
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.AboutDialog;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class EquipoF extends JFrame {

	Collection<Jugador> integrantes;
	private int anchoV;
	private int altoV;
	private int x;
	private int y;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EquipoF frame = new EquipoF();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

public EquipoF() {
	setIconImage(Toolkit.getDefaultToolkit().getImage(EquipoF.class.getResource("/imagen/deporte-futbol-icono-6585-16.png")));
	setTitle("JUEGO DE FUTBOL AMERICANO");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
	int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	anchoV = 570;
	altoV = 400;
	x = ancho/2 - anchoV/2;
	y = alto/2 - altoV/2;

	setBounds(x, y, anchoV, altoV);
	
	JMenuBar menuBar = new JMenuBar();
	setJMenuBar(menuBar);
	
	JMenu mnArchivo = new JMenu("Archivo");
	menuBar.add(mnArchivo);
	
	JMenuItem mntmNuevo = new JMenuItem("Nuevo");
	mntmNuevo.setIcon(new ImageIcon(EquipoF.class.getResource("/imagen/nuevo-icono-5549-16.png")));
	mnArchivo.add(mntmNuevo);
	
	JMenuItem mntmGuardar = new JMenuItem("Guardar");
	mntmGuardar.setIcon(new ImageIcon(EquipoF.class.getResource("/imagen/guardar-archivo-icono-6713-16.png")));
	mnArchivo.add(mntmGuardar);
	
	JMenu mnAyuda = new JMenu("Ayuda");
	menuBar.add(mnAyuda);
	
	JMenuItem mntmAcercaDe = new JMenuItem("Acerca de ...");
	mntmAcercaDe.setIcon(new ImageIcon(EquipoF.class.getResource("/imagen/punto-de-interrogacion-icono-9434-16.png")));
	mntmAcercaDe.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			AboutDialog about = new AboutDialog("PRACTICA: INTERFAZ JUEGO");
			about.setVisible(true);
		}
	});
	mnAyuda.add(mntmAcercaDe);
	
	JMenuItem mntmReglas = new JMenuItem("Reglas");
	mntmReglas.setIcon(new ImageIcon(EquipoF.class.getResource("/imagen/protocolo-jabber-icono-5655-16.png")));
	mnAyuda.add(mntmReglas);
	contentPane = new JPanel();
	contentPane.setBackground(Color.BLUE);
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(new BorderLayout(0, 0));
	
	JPanel panelBotones = new JPanel();
	panelBotones.setBackground(new Color(175, 238, 238));
	contentPane.add(panelBotones, BorderLayout.NORTH);
	
	JButton btnPlay = new JButton("PLAY");
	btnPlay.setFont(new Font("Tahoma", Font.BOLD, 11));
	panelBotones.add(btnPlay);
	
	JButton btnPause = new JButton("PAUSE");
	btnPause.setFont(new Font("Tahoma", Font.BOLD, 11));
	panelBotones.add(btnPause);
	
	JPanel panelJuego = new JPanel();
	contentPane.add(panelJuego, BorderLayout.CENTER);
	panelJuego.setLayout(new CardLayout(0, 0));
	
	BalonFA pnlPresentacion = new BalonFA();
	pnlPresentacion.setBackground(new Color(34, 139, 34));
	panelJuego.add(pnlPresentacion,"Balon");
	
	CanchaFA panelCancha = new CanchaFA();
	panelCancha.setBackground(new Color(144, 238, 144));
	panelJuego.add(panelCancha,"Cancha");
	
	btnPlay.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			CardLayout c = (CardLayout) panelJuego.getLayout();
			c.show(panelJuego, "Cancha");
		}
	});
	}
	
}
