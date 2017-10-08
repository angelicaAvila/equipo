package deporte.vista;
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
import deporte.vista.panel.BalonFA;
import deporte.vista.panel.CanchaFA;
import deporte.Jugador;
import deporte.controlador.BotonesControl;
import deporte.vista.jDialog.ReglasDialog;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class EquipoF extends JFrame implements EquipoFInterfaz{

	Collection<deporte.Jugador> integrantes;
	private JPanel contentPane;
	private JPanel panelJuego ;
	private CanchaFA panelCancha;
	private JButton btnPlay ;
	private JButton btnPause;
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
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setIconImage(Toolkit.getDefaultToolkit().getImage(EquipoF.class.getResource("/imagen/deporte-futbol-icono-6585-16.png")));
	setTitle("JUEGO DE FUTBOL AMERICANO");
	int alto=java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
	int ancho=java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	int hv=470;
	int wv=610;
	int x= (ancho/2) - (wv/2);
	int y= (alto/2) - (hv/2);
	setBounds(x, y, wv, hv);
	setResizable(false);
	
	BotonesControl ctlBotones = new BotonesControl(this); 
	
	JMenuBar menuBar = new JMenuBar();
	setJMenuBar(menuBar);
	
	JMenu mnArchivo = new JMenu("Archivo");
	menuBar.add(mnArchivo);
	
	JMenuItem mntmNuevo = new JMenuItem("Nuevo");
	mntmNuevo.setIcon(new ImageIcon(EquipoF.class.getResource("/imagen/nuevo-icono-5549-16.png")));
	mnArchivo.add(mntmNuevo);
	
	JMenuItem mntmGuardar = new JMenuItem("Guardar");
	mntmGuardar.setActionCommand("save");
	mntmGuardar.addActionListener(ctlBotones);
	mntmGuardar.setIcon(new ImageIcon(EquipoF.class.getResource("/imagen/guardar-archivo-icono-6713-16.png")));
	mnArchivo.add(mntmGuardar);
	
	JMenuItem mntmAbrir = new JMenuItem("Abrir");
	mntmAbrir.setIcon(new ImageIcon(EquipoF.class.getResource("/imagen/abrir-el-archivo-icono-8886-16.png")));
	mntmAbrir.setActionCommand("open");
	mntmAbrir.addActionListener(ctlBotones);
	mnArchivo.add(mntmAbrir);
	
	JMenu mnAyuda = new JMenu("Ayuda");
	menuBar.add(mnAyuda);
	
	JMenuItem mntmAcercaDe = new JMenuItem("Acerca de ...");
	mntmAcercaDe.setActionCommand("acerca");
	mntmAcercaDe.addActionListener(ctlBotones);
	mntmAcercaDe.setIcon(new ImageIcon(EquipoF.class.getResource("/imagen/punto-de-interrogacion-icono-9434-16.png")));
	mnAyuda.add(mntmAcercaDe);

	JMenuItem mntmReglas = new JMenuItem("Reglas");
	mntmReglas.setActionCommand("reglas");
	mntmReglas.addActionListener(ctlBotones);
	
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
	
	btnPlay = new JButton("PLAY");
	btnPlay.setFont(new Font("Tahoma", Font.BOLD, 11));
	btnPlay.setActionCommand("play");
	btnPlay.addActionListener(ctlBotones);
	panelBotones.add(btnPlay);
	
	btnPause = new JButton("PAUSE");
	btnPause.setFont(new Font("Tahoma", Font.BOLD, 11));
	panelBotones.add(btnPause);
	
	panelJuego = new JPanel();
	contentPane.add(panelJuego, BorderLayout.CENTER);
	panelJuego.setLayout(new CardLayout(0, 0));
	
	BalonFA pnlPresentacion = new BalonFA();
	pnlPresentacion.setBackground(new Color(34, 139, 34));
	panelJuego.add(pnlPresentacion,"Balon");
	
	panelCancha = new CanchaFA();
	panelCancha.setBackground(new Color(144, 238, 144));
	panelJuego.add(panelCancha,"Cancha");

	}
	public Component getWriteObject() {
		return panelCancha;
	}
	
	public Component getComponentShow() {
		// TODO Auto-generated method stub
		return panelCancha;
	}
	
	public void setFocusablePlay(boolean focus) {
		btnPlay.setFocusable(focus);
		
	}
	
	public void setFocusablePause(boolean focus) {
		btnPause.setFocusable(focus);	
	}
	
	public void setFocusableCancha(boolean focus) {
		panelCancha.setFocusable(focus);
	}
	
	public void showCancha() {
		CardLayout c= (CardLayout)panelJuego.getLayout();
		c.show(panelJuego, "Cancha");
		
	}
}
