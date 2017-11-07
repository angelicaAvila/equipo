package deporte.vista;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import deporte.controlador.ClienteConexion;
import deporte.vista.panel.BalonFA;
import deporte.vista.panel.CanchaFA;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EquipoServidor  extends JFrame implements EquipoFInterfaz,Runnable{


	Collection<deporte.Jugador> integrantes;
	private JPanel contentPane;
	private JPanel panelJuego ;
	private CanchaFA panelCancha;
	private ServerSocket servidor;
	private Socket cliente;
	private JPanel panelBoton;
	private JButton btnDesconectar;
	private DataOutputStream out;
	private boolean activo;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EquipoServidor frame = new EquipoServidor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();				}
			}
		});
	}
	
	public EquipoServidor() throws IOException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(EquipoServidor.class.getResource("/imagen/servidor-icono-7515-32.png")));
		servidor = new ServerSocket(8000); 
		activo = true;
		init();
		Thread t = new Thread(this);
		t.start();
		
	}
	
	public void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("JUEGO DE FUTBOL AMERICANO (Servidor)");
		int alto=java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
		int ancho=java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
		int hv=470;
		int wv=610;
		int x= (ancho/2) - (wv/2);
		int y= (alto/2) - (hv/2);
		setBounds(x, y, wv, hv);
		setResizable(false);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panelJuego = new JPanel();
		contentPane.add(panelJuego, BorderLayout.CENTER);
		panelJuego.setLayout(new CardLayout(0, 0));
		
		BalonFA pnlPresentacion = new BalonFA();
		pnlPresentacion.setBackground(new Color(34, 139, 34));
		panelJuego.add(pnlPresentacion,"Balon");
		
		panelCancha = new CanchaFA(cliente);
		panelCancha.setBackground(new Color(144, 238, 144));
		panelJuego.add(panelCancha,"Cancha");
		
		panelBoton = new JPanel();
		panelBoton.setBackground(new Color(135, 206, 250));
		contentPane.add(panelBoton, BorderLayout.NORTH);
		
		btnDesconectar = new JButton("DESCONECTAR");
		btnDesconectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					out = new DataOutputStream(cliente.getOutputStream());
					out.writeUTF("DESCONECTADO");
					activo = false;
					cliente.close();
					servidor.close();
					//System.exit(0);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		btnDesconectar.setBackground(new Color(255, 0, 0));
		btnDesconectar.setForeground(new Color(0, 0, 0));
		panelBoton.add(btnDesconectar);
	}

	public Component getWriteObject() {
		return panelCancha;
	}
	
	public Component getComponentShow() {
		return panelCancha;
	}
	
	public void setFocusablePlay(boolean focus) {
		//btnPlay.setFocusable(focus);
		
	}
	
	public void setFocusablePause(boolean focus) {
		//btnPause.setFocusable(focus);	
	}
	
	public void setFocusableCancha(boolean focus) {
		panelCancha.setFocusable(focus);
	}
	
	public void showCancha() {
		CardLayout c= (CardLayout)panelJuego.getLayout();
		c.show(panelJuego, "Cancha");
		
	}

	public void setComponentShow(CanchaFA cancha) throws IOException {
			panelCancha.actualizar(cancha.getJugadorX(), cancha.getJugadorY());
		
		
	}

	public void run() {
		while(activo) {
			try {
				System.out.println("Servidor : Esperando cliente");
				cliente = servidor.accept();
				System.out.println("Servidor : CLIENTE ACEPTADO");
				ClienteConexion cc = new ClienteConexion (this,cliente, panelCancha);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
