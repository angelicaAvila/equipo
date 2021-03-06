package socket.interfaz;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.border.LineBorder;
import socket.control.GatoConexion;
import socket.control.GatoControlBotones;
import socket.control.GatoMatrizControl;
import socket.control.ServidorConexion;
import socket.modelo.Gatoxy;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class GatoServidor extends JFrame implements GatoInterfaz,Runnable{

	private JPanel contentPane;
	private JButton btnJuegoN;
	private JButton[] boton = new JButton[9];
	private JLabel senalTurno;
	private JPanel panel;
	private int m[]= new int[9];
	private ObjectOutputStream out;
	private DataOutputStream outD;
	private DataInputStream in;
	public Socket cliente;
	public ServerSocket servidor;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GatoServidor frame = new GatoServidor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} 
		});
	}
	
	public GatoServidor() throws IOException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GatoServidor.class.getResource("/imagen/servidor-icono-7515-32.png")));
		servidor = new ServerSocket(8000);
		init();
		Thread t = new Thread(this);
		t.start();
	}
	public void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("TicTacToe (Servidor)");
		setBounds(600, 100, 375, 416);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(32, 178, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		GatoMatrizControl gmc = new GatoMatrizControl(this);
		GatoControlBotones gcb = new GatoControlBotones(this);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 5, true));
		panel_2.setBackground(Color.GRAY);
		contentPane.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel labelTurno = new JLabel("TURNO");
		labelTurno.setForeground(Color.BLACK);
		labelTurno.setFont(new Font("Arial Black", Font.PLAIN, 30));
		panel_2.add(labelTurno);
		
		senalTurno = new JLabel("");
		senalTurno.setIcon(new ImageIcon(GatoServidor.class.getResource("/imagen/circulo-azul-icono-3849-48.png")));
		panel_2.add(senalTurno);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(32, 178, 170));
		panel_1.setBorder(new EmptyBorder(3, 12, 3, 12));
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(3, 3, 0, 0));
		Color colorBoton = new Color(211, 211, 211);
		for(int i = 0; i<9;i++) {
			boton[i]=new JButton("");
			boton[i].setBackground(colorBoton);
			boton[i].setActionCommand(Integer.toString(i));
			boton[i].addActionListener(gmc);
			panel_1.add(boton[i]);
		}

		
		panel = new JPanel();
		panel.setBackground(new Color(32, 178, 170));
		contentPane.add(panel, BorderLayout.SOUTH);
		
		btnJuegoN = new JButton("INICIAR");
		btnJuegoN.setForeground(Color.BLACK);
		btnJuegoN.setActionCommand("inicio");
		btnJuegoN.setBackground(new Color(100, 149, 237));
		btnJuegoN.addActionListener(gcb);
		
		btnJuegoN.setFont(new Font("Arial", Font.BOLD, 16));
		panel.add(btnJuegoN);
		
		JButton btnFin = new JButton("FINALIZAR");
		btnFin.setForeground(Color.BLACK);
		btnFin.setBackground(new Color(255, 0, 0));
		btnFin.setActionCommand("fin");
		btnFin.addActionListener(gcb);
		btnFin.setFont(new Font("Arial", Font.BOLD, 16));
		btnFin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					outD = new DataOutputStream(cliente.getOutputStream());
					outD.writeUTF("DESCONECTADO");
					cliente.close();
					servidor.close();
					System.exit(0);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		panel.add(btnFin);
		iniciar();
		
	}
	public void setIcono(int imagen, int n) {
		if(imagen == 1)
			boton[n].setIcon(new ImageIcon(GatoServidor.class.getResource("/imagen/circulo-azul-icono-3849-48.png")));
		else
			boton[n].setIcon(new ImageIcon(GatoServidor.class.getResource("/imagen/caja-roja-cerca-de-icono-3782-48.png")));
	}
	public void setSenalTurno(int imagen) {
		if(imagen == 1)
			senalTurno.setIcon(new ImageIcon(GatoServidor.class.getResource("/imagen/circulo-azul-icono-3849-48.png")));
		else 
			senalTurno.setIcon(new ImageIcon(GatoServidor.class.getResource("/imagen/caja-roja-cerca-de-icono-3782-48.png")));
	}
	public JButton getBtnJuegoN() {
		return btnJuegoN;
	}
	public void setBtnJuegoN(JButton btnJuegoN) {
		this.btnJuegoN = btnJuegoN;
	}
	public JButton getBoton(int n) {
		return boton[n];
	}
	public void setBoton(int n,JButton boton) {
		this.boton[n] = boton;
	}
	public void finalizar() {
		int action = JOptionPane.showConfirmDialog(contentPane, "Seguro que deseas salir?", "SALIDA", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,new ImageIcon(Gato.class.getResource("/imagen/dejar-de-amarillo-icono-6551-48.png")));
		if(action == JOptionPane.YES_OPTION) {
			try {
				outD = new DataOutputStream(cliente.getOutputStream());
				outD.writeUTF("DESCONECTADO");
				System.exit(0);
				cliente.close();
				servidor.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}		
	}	
	public int resultado() {
		
		if(m[0]==m[1]&&m[0]==m[2] || m[0]==m[3]&&m[0]==m[6] || m[0]==m[4]&& m[0]==m[8])
			return m[0];
		else if(m[1]==m[4]&&m[1]==m[7])
			return m[1];
		else if (m[2]==5&&m[2]==m[8] || m[2]==m[4]&& m[2]==m[6])
			return m[2];
		else if (m[3]==m[4] && m[3]==m[5])
			return m[3];
		else if(m[6]==m[7]&& m[6]==m[8])
			return m[6];
		else
			return -1;
	}
	public void run() {
		while(true) {
			try {
				cliente = servidor.accept();
				GatoConexion gc = new GatoConexion (this,cliente);
				ServidorConexion sc = new ServidorConexion (this,servidor);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}
	public void iniciar() {
		setSenalTurno(1);
		for(int i=0; i<9;i++) {
			boton[i].setIcon(null);
			boton[i].setEnabled(true);
			m[i]=0;
		}
		
	}

	public int getValor(int x) {
		return m[x];
	}
	public void setValor(int x,int valor) {
		m[x]=valor;
	}

	public void actualizar(int turno, int x ,int valor) {
		setSenalTurno(turno);
		m[x]=valor;
		setIcono(valor,x);
		boton[x].setDisabledIcon(boton[x].getIcon());
	}

	public void habilitarBotones(boolean sn) {
		for(int i = 0; i < 9; i++) {
			//if(getValor(i)==0)
			boton[i].setEnabled(sn);
		}
		
	}
	
	
}