package practicasPOOA;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;

public class gato extends JFrame {

	private JPanel contentPane;
	private int cambioLabel=0;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnJuegoN;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gato frame = new gato();
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
	public gato() {
		setTitle("TicTacToe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 375, 416);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		int [][] m = new int[3][3];
		m[0][0]=0; m[0][1]=0; m[0][2]=0;
		m[1][0]=0; m[1][1]=0; m[1][2]=0;
		m[2][0]=0; m[2][1]=0; m[2][2]=0;
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 5, true));
		panel_2.setBackground(Color.GRAY);
		contentPane.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel labelTurno = new JLabel("TURNO");
		labelTurno.setForeground(Color.BLACK);
		labelTurno.setFont(new Font("Arial Black", Font.PLAIN, 30));
		panel_2.add(labelTurno);
		
		JLabel senalTurno = new JLabel("");
		senalTurno.setIcon(new ImageIcon(gato.class.getResource("/practicasPOOA/caja-roja-cerca-de-icono-3782-48.png")));
		panel_2.add(senalTurno);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaption);
		panel_1.setBorder(new EmptyBorder(3, 12, 3, 12));
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(3, 3, 0, 0));
		
		
		JButton btn1 = new JButton("");
		btn1.setBackground(Color.LIGHT_GRAY);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btn1.setIcon(senalTurno.getIcon());
				btn1.setDisabledIcon(senalTurno.getIcon());
				if(cambioLabel==0)
				m[0][0] = 1;
				else
				m[0][0] = 2;
				if((m[0][1]==m[0][0]&&m[0][2]==m[0][0])||(m[1][0]==m[0][0]&&m[2][0]==m[0][0])||(m[1][1]==m[0][0]&&m[2][2]==m[0][0])) {
					JOptionPane.showMessageDialog(panel_1, "Felicidades jugador "+ m[0][0] + " ganaste", "GANADOR", JOptionPane.OK_OPTION,new ImageIcon(gato.class.getResource("/practicasPOOA/wizard1-icono-5752-48.png")));
					btnJuegoN.doClick();
				}
				else {	
					if(cambioLabel == 0) {
						senalTurno.setIcon(new ImageIcon(gato.class.getResource("/practicasPOOA/circulo-azul-icono-3849-48.png")));
						cambioLabel = 1;
				}
					else {
						senalTurno.setIcon(new ImageIcon(gato.class.getResource("/practicasPOOA/caja-roja-cerca-de-icono-3782-48.png")));
						cambioLabel = 0;
				}
					btn1.setEnabled(false);
				}
				
			}
				
		});
		panel_1.add(btn1);
		
		JButton btn2 = new JButton("");
		btn2.setBackground(Color.LIGHT_GRAY);
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn2.setIcon(senalTurno.getIcon());
				btn2.setDisabledIcon(senalTurno.getIcon());
				if(cambioLabel==0)
					m[0][1] = 1;
					else
					m[0][1] = 2;
				if((m[0][0]==m[0][1]&&m[0][2]==m[0][1])||(m[1][1]==m[0][1]&&m[2][1]==m[0][1])) {
					JOptionPane.showMessageDialog(panel_1, "Felicidades jugador "+ m[0][1] + " ganaste", "GANADOR", JOptionPane.OK_OPTION,new ImageIcon(gato.class.getResource("/practicasPOOA/wizard1-icono-5752-48.png")));
					btnJuegoN.doClick();
				}
				else {	
					if(cambioLabel == 0) {
						senalTurno.setIcon(new ImageIcon(gato.class.getResource("/practicasPOOA/circulo-azul-icono-3849-48.png")));
						cambioLabel = 1;
					}
					else {
						senalTurno.setIcon(new ImageIcon(gato.class.getResource("/practicasPOOA/caja-roja-cerca-de-icono-3782-48.png")));
						cambioLabel = 0;
					}
					btn2.setEnabled(false);
				}
			}
		});
		panel_1.add(btn2);
		
		JButton btn3 = new JButton("");
		btn3.setBackground(Color.LIGHT_GRAY);
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn3.setIcon(senalTurno.getIcon());
				btn3.setDisabledIcon(senalTurno.getIcon());
				if(cambioLabel==0)
					m[0][2] = 1;
					else
					m[0][2] = 2;
				if((m[0][1]==m[0][2]&&m[0][0]==m[0][2])||(m[1][2]==m[0][2]&&m[0][2]==m[2][2])||(m[2][0]==m[0][2]&&m[1][1]==m[0][2])) { 
					JOptionPane.showMessageDialog(panel_1, "Felicidades jugador "+ m[0][2] + " ganaste", "GANADOR", JOptionPane.OK_OPTION,new ImageIcon(gato.class.getResource("/practicasPOOA/wizard1-icono-5752-48.png")));
					btnJuegoN.doClick();
				}
				else {
					if(cambioLabel == 0) {
					senalTurno.setIcon(new ImageIcon(gato.class.getResource("/practicasPOOA/circulo-azul-icono-3849-48.png")));
						cambioLabel = 1;
					}
					else {
						senalTurno.setIcon(new ImageIcon(gato.class.getResource("/practicasPOOA/caja-roja-cerca-de-icono-3782-48.png")));
						cambioLabel = 0;
					}
	
					btn3.setEnabled(false);
				}
			}
		});
		panel_1.add(btn3);
		
		JButton btn4 = new JButton("");
		btn4.setBackground(Color.LIGHT_GRAY);
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn4.setIcon(senalTurno.getIcon());
				btn4.setDisabledIcon(senalTurno.getIcon());
				if(cambioLabel==0)
					m[1][0] = 1;
					else
					m[1][0] = 2;
				if((m[1][0]==m[0][0]&&m[1][0]==m[2][0])||(m[1][0]==m[1][1]&&m[1][2]==m[1][0])) {
					JOptionPane.showMessageDialog(panel_1, "Felicidades jugador "+ m[1][0] + " ganaste", "GANADOR", JOptionPane.OK_OPTION,new ImageIcon(gato.class.getResource("/practicasPOOA/wizard1-icono-5752-48.png")));
					btnJuegoN.doClick();
				}
				else {
					if(cambioLabel == 0) {
					senalTurno.setIcon(new ImageIcon(gato.class.getResource("/practicasPOOA/circulo-azul-icono-3849-48.png")));
						cambioLabel = 1;
					}
					else {
						senalTurno.setIcon(new ImageIcon(gato.class.getResource("/practicasPOOA/caja-roja-cerca-de-icono-3782-48.png")));
						cambioLabel = 0;
					}
					
					btn4.setEnabled(false);
				}
			}
		});
		panel_1.add(btn4);
		
		JButton btn5 = new JButton("");
		btn5.setBackground(Color.LIGHT_GRAY);
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn5.setIcon(senalTurno.getIcon());
				btn5.setDisabledIcon(senalTurno.getIcon());
				if(cambioLabel==0)
					m[1][1] = 1;
					else
					m[1][1] = 2;
				if((m[1][0]==m[1][1]&&m[1][2]==m[1][1])||(m[0][1]==m[1][1]&&m[2][1]==m[1][1])||(m[0][0]==m[1][1]&&m[1][1]==m[2][2])||(m[0][2]==m[1][1]&&m[1][1]==m[2][0])) { 
					JOptionPane.showMessageDialog(panel_1, "Felicidades jugador "+ m[1][1] + " ganaste", "GANADOR", JOptionPane.OK_OPTION,new ImageIcon(gato.class.getResource("/practicasPOOA/wizard1-icono-5752-48.png")));
					btnJuegoN.doClick();
				}
				else {
					if(cambioLabel == 0) {
					senalTurno.setIcon(new ImageIcon(gato.class.getResource("/practicasPOOA/circulo-azul-icono-3849-48.png")));
						cambioLabel = 1;
					}
					else {
						senalTurno.setIcon(new ImageIcon(gato.class.getResource("/practicasPOOA/caja-roja-cerca-de-icono-3782-48.png")));
						cambioLabel = 0;
					}
					btn5.setEnabled(false);
				}
			}
		});
		panel_1.add(btn5);
		
		JButton btn6 = new JButton("");
		btn6.setBackground(Color.LIGHT_GRAY);
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn6.setIcon(senalTurno.getIcon());
				btn6.setDisabledIcon(senalTurno.getIcon());
				if(cambioLabel==0)
					m[1][2] = 1;
					else
					m[1][2] = 2;
				if((m[0][2]==m[1][2]&&m[1][2]==m[2][2])||(m[1][0]==m[1][2]&&m[1][1]==m[1][2])) {
					JOptionPane.showMessageDialog(panel_1, "Felicidades jugador "+ m[1][2] + " ganaste", "GANADOR", JOptionPane.OK_OPTION,new ImageIcon(gato.class.getResource("/practicasPOOA/wizard1-icono-5752-48.png")));
					btnJuegoN.doClick();
				}
				else {
					if(cambioLabel == 0) {
					senalTurno.setIcon(new ImageIcon(gato.class.getResource("/practicasPOOA/circulo-azul-icono-3849-48.png")));
						cambioLabel = 1;
					}
					else {
						senalTurno.setIcon(new ImageIcon(gato.class.getResource("/practicasPOOA/caja-roja-cerca-de-icono-3782-48.png")));
						cambioLabel = 0;
					}
					btn6.setEnabled(false);
				}
			}
		});
		panel_1.add(btn6);
		
		JButton btn7 = new JButton("");
		btn7.setBackground(Color.LIGHT_GRAY);
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn7.setIcon(senalTurno.getIcon());
				btn7.setDisabledIcon(senalTurno.getIcon());
				if(cambioLabel==0)
					m[2][0] = 1;
					else
					m[2][0] = 2;
				if((m[2][0]==m[1][0]&&m[2][0]==m[0][0])||(m[2][1]==m[2][0]&&m[2][2]==m[2][0])||(m[2][0]==m[1][1]&&m[2][0]==m[0][2])) { 
					JOptionPane.showMessageDialog(panel_1, "Felicidades jugador "+ m[2][0] + " ganaste", "GANADOR", JOptionPane.OK_OPTION,new ImageIcon(gato.class.getResource("/practicasPOOA/wizard1-icono-5752-48.png")));
					btnJuegoN.doClick();
				}
				else {
					if(cambioLabel == 0) {
					senalTurno.setIcon(new ImageIcon(gato.class.getResource("/practicasPOOA/circulo-azul-icono-3849-48.png")));
						cambioLabel = 1;
					}
					else {
						senalTurno.setIcon(new ImageIcon(gato.class.getResource("/practicasPOOA/caja-roja-cerca-de-icono-3782-48.png")));
						cambioLabel = 0;
					}
					btn7.setEnabled(false);
				}
			}
		});
		panel_1.add(btn7);
		
		JButton btn8 = new JButton("");
		btn8.setBackground(Color.LIGHT_GRAY);
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn8.setIcon(senalTurno.getIcon());
				btn8.setDisabledIcon(senalTurno.getIcon());
				if(cambioLabel==0)
					m[2][1] = 1;
					else
					m[2][1] = 2;
				if((m[2][0]==m[2][1]&&m[2][2]==m[2][1])||(m[0][1]==m[2][1]&&m[2][1]==m[1][1])) { 
					JOptionPane.showMessageDialog(panel_1, "Felicidades jugador "+ m[2][1] + " ganaste", "GANADOR", JOptionPane.OK_OPTION,new ImageIcon(gato.class.getResource("/practicasPOOA/wizard1-icono-5752-48.png")));
					btnJuegoN.doClick();
				}
				else {
					if(cambioLabel == 0) {
						senalTurno.setIcon(new ImageIcon(gato.class.getResource("/practicasPOOA/circulo-azul-icono-3849-48.png")));
						cambioLabel = 1;
					}
					else {
						senalTurno.setIcon(new ImageIcon(gato.class.getResource("/practicasPOOA/caja-roja-cerca-de-icono-3782-48.png")));
						cambioLabel = 0;
					}
					btn8.setEnabled(false);
				}
					
			}
		});
		panel_1.add(btn8);
		
		JButton btn9 = new JButton("");
		btn9.setBackground(Color.LIGHT_GRAY);
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn9.setIcon(senalTurno.getIcon());
				btn9.setDisabledIcon(senalTurno.getIcon());
				if(cambioLabel==0)
					m[2][2] = 1;
					else
					m[2][2] = 2;
				if((m[2][2]==m[2][1]&&m[2][2]==m[2][0])||(m[0][2]==m[2][2]&&m[2][2]==m[1][2])||(m[0][0]==m[2][2]&&m[2][2]==m[1][1])) { 
					JOptionPane.showMessageDialog(panel_1, "Felicidades jugador "+ m[2][2] + " ganaste", "GANADOR", JOptionPane.OK_OPTION,new ImageIcon(gato.class.getResource("/practicasPOOA/wizard1-icono-5752-48.png")));
					btnJuegoN.doClick();
				}
				else {
					if(cambioLabel == 0) {
					senalTurno.setIcon(new ImageIcon(gato.class.getResource("/practicasPOOA/circulo-azul-icono-3849-48.png")));
						cambioLabel = 1;
					}
					else {
						senalTurno.setIcon(new ImageIcon(gato.class.getResource("/practicasPOOA/caja-roja-cerca-de-icono-3782-48.png")));
						cambioLabel = 0;
					}
					btn9.setEnabled(false);
				}
			}
		});
		panel_1.add(btn9);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		contentPane.add(panel, BorderLayout.SOUTH);
		
		btnJuegoN = new JButton("INICIAR");
		btnJuegoN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				senalTurno.setIcon(new ImageIcon(gato.class.getResource("/practicasPOOA/caja-roja-cerca-de-icono-3782-48.png")));
				cambioLabel=0;
				m[0][0]=0; m[0][1]=0; m[0][2]=0;
				m[1][0]=0; m[1][1]=0; m[1][2]=0;
				m[2][0]=0; m[2][1]=0; m[2][2]=0;
				btn1.setIcon(null);
				btn1.setEnabled(true);
				btn2.setIcon(null);
				btn2.setEnabled(true);
				btn3.setIcon(null);
				btn3.setEnabled(true);
				btn4.setIcon(null);
				btn4.setEnabled(true);
				btn5.setIcon(null);
				btn5.setEnabled(true);
				btn6.setIcon(null);
				btn6.setEnabled(true);
				btn7.setIcon(null);
				btn7.setEnabled(true);
				btn8.setIcon(null);
				btn8.setEnabled(true);
				btn9.setIcon(null);
				btn9.setEnabled(true);
			}
		});
		
		btnJuegoN.setFont(new Font("Arial", Font.PLAIN, 16));
		panel.add(btnJuegoN);
		
		JButton btnFin = new JButton("FINALIZAR");
		btnFin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int action = JOptionPane.showConfirmDialog(panel, "Seguro que deseas salir?","SALIDA",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
				if(action == JOptionPane.YES_OPTION)
					System.exit(0);
			}
		});
		btnFin.setFont(new Font("Arial", Font.PLAIN, 16));
		panel.add(btnFin);
		
	
	}
}
