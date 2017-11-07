package deporte.vista;
import java.util.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import deporte.vista.panel.BalonFA;
import deporte.vista.panel.CanchaFA;
import deporte.controlador.BotonesControl;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class EquipoF extends JFrame implements EquipoFInterfaz, Runnable{

	Collection<deporte.Jugador> integrantes;
	private JPanel contentPane;
	private JPanel panelJuego ;
	private CanchaFA panelCancha;
	private JButton btnPlay ;
	private JButton btnPause;
	private Socket cliente;
	private DataInputStream in;
	
	
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
	
	public EquipoF() throws IOException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(EquipoF.class.getResource("/imagen/deporte-futbol-icono-6585-16.png")));
		cliente = new Socket("127.0.0.1",8000);
		init();
		Thread t = new Thread(this);
		t.start();
	}

	public void init() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setTitle("JUEGO DE FUTBOL AMERICANO (Cliente) ");
	int alto=java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
	int ancho=java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	int hv=470;
	int wv=610;
	int x= (ancho/2) - (wv/2);
	int y= (alto/2) - (hv/2);
	setBounds(x, y, wv, hv);
	setResizable(false);
	
	BotonesControl ctlBotones = new BotonesControl(this,cliente); 
	
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
	
	panelCancha = new CanchaFA(cliente);
	panelCancha.setBackground(new Color(144, 238, 144));
	panelJuego.add(panelCancha,"Cancha");

}
	
	public Component getWriteObject() {
		return panelCancha;
	}
	
	public Component getComponentShow() {
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

	public void setComponentShow(CanchaFA cancha) {
		try {
			panelCancha.actualizar(cancha.getJugadorX(), cancha.getJugadorY());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void run() {
		try {
			in = new DataInputStream(cliente.getInputStream());
			System.out.println("CLIENTE: Esperando mensaje");
			String mensaje = in.readUTF();
			if(mensaje.equals("DESCONECTADO")) {
				System.out.println("CLIENTE: DESCONECTANDO");
				JOptionPane.showMessageDialog(this, "EL SERVIDOR SE HA DESCONECTADO","CIERRE DE SESION",JOptionPane.INFORMATION_MESSAGE);
				cliente.close();
				System.exit(0);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
