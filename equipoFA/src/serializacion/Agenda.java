package serializacion;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JTextField;

import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.Font;


public class Agenda extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtEdad;
	private JTextField txtCorreo;
	private JTextField txtTelefono;
	private DefaultListModel<Persona> modelo;
	private int i;
	private Persona n;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Agenda frame = new Agenda();
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
	@SuppressWarnings("unchecked")
	public Agenda() {
		setFont(new Font("Arial", Font.BOLD, 14));
		setForeground(new Color(0, 0, 128));
		setTitle("AGENDA TELEFONICA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JPanel panelDatos = new JPanel();
		panelDatos.setForeground(new Color(0, 0, 0));
		panelDatos.setBackground(Color.LIGHT_GRAY);
		panelDatos.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255), 3, true), "DATOS", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panelDatos);
		panelDatos.setLayout(new BorderLayout(0, 0));
		
		JPanel panelCentro = new JPanel();
		panelCentro.setBorder(new LineBorder(new Color(65, 105, 225), 2));
		panelDatos.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(5, 2, 0, 0));
		
		JLabel lblNombre = new JLabel("NOMBRE:");
		lblNombre.setFont(new Font("Arial", Font.BOLD, 12));
		panelCentro.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Arial", Font.PLAIN, 12));
		panelCentro.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblEdad = new JLabel("EDAD:");
		lblEdad.setFont(new Font("Arial", Font.BOLD, 12));
		panelCentro.add(lblEdad);
		
		txtEdad = new JTextField();
		txtEdad.setFont(new Font("Arial", Font.PLAIN, 12));
		panelCentro.add(txtEdad);
		txtEdad.setColumns(10);
		
		JLabel lblTelefono = new JLabel("TELEFONO:");
		lblTelefono.setFont(new Font("Arial", Font.BOLD, 12));
		panelCentro.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setFont(new Font("Arial", Font.PLAIN, 12));
		panelCentro.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JLabel lblCorreo = new JLabel("CORREO:");
		lblCorreo.setFont(new Font("Arial", Font.BOLD, 12));
		panelCentro.add(lblCorreo);
		
		txtCorreo = new JTextField();
		txtCorreo.setFont(new Font("Arial", Font.PLAIN, 12));
		panelCentro.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		JLabel lblGenero = new JLabel("GENERO:");
		lblGenero.setFont(new Font("Arial", Font.BOLD, 12));
		panelCentro.add(lblGenero);
		
		JPanel panelGenero = new JPanel();
		panelCentro.add(panelGenero);
		
		ButtonGroup Group = new ButtonGroup();
		
		JRadioButton rdbtnHombre = new JRadioButton("HOMBRE");
		rdbtnHombre.setBackground(new Color(173, 216, 230));
		rdbtnHombre.setFont(new Font("Arial", Font.PLAIN, 12));
		rdbtnHombre.setSelected(true);
		Group.add(rdbtnHombre);
		panelGenero.add(rdbtnHombre);
		
		JRadioButton rdbtnMujer = new JRadioButton("MUJER");
		rdbtnMujer.setBackground(new Color(255, 192, 203));
		rdbtnMujer.setFont(new Font("Arial", Font.PLAIN, 12));
		Group.add(rdbtnMujer);
		panelGenero.add(rdbtnMujer);
		
		JPanel panelBotones = new JPanel();
		panelBotones.setBorder(new LineBorder(new Color(65, 105, 225), 2, true));
		panelDatos.add(panelBotones, BorderLayout.SOUTH);
		
		JButton btnNuevo = new JButton("NUEVO");
		btnNuevo.setBackground(new Color(30, 144, 255));
		panelBotones.add(btnNuevo);
		
		JButton btnAgregar = new JButton("AGREGAR");
		btnAgregar.setBackground(new Color(30, 144, 255));
		panelBotones.add(btnAgregar);
		
		JButton btnEditar = new JButton("EDITAR");
		btnEditar.setBackground(new Color(50, 205, 50));
		panelBotones.add(btnEditar);
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBackground(new Color(255, 0, 0));
		panelBotones.add(btnEliminar);
		
		JPanel panelContactos = new JPanel();
		panelContactos.setBackground(Color.LIGHT_GRAY);
		panelContactos.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255), 3, true), "CONTACTOS", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panelContactos);
		panelContactos.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panelContactos.add(scrollPane);
		
		JList list = new JList();
		list.setBorder(new LineBorder(new Color(30, 144, 255), 2, true));
		list.setBackground(new Color(240, 248, 255));
		scrollPane.setViewportView(list);
		
		modelo = new DefaultListModel<Persona>();
		try {
			FileInputStream file = new FileInputStream("contactos.txt");
			ObjectInputStream ois = new ObjectInputStream(file);
			modelo = (DefaultListModel<Persona>)ois.readObject();
			file.close();
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		list.setModel(modelo);
		
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombre = txtNombre.getText();
				if(nombre.isEmpty())
					nombre = "Sin nombre";
				int edad = 0;
				Genero genero = rdbtnHombre.isSelected()?Genero.HOMBRE:Genero.MUJER ;
				String telefono = txtTelefono.getText();
				String correo = txtCorreo.getText();
				try {
					edad = Integer.parseInt(txtEdad.getText());
					Persona p = new Persona(nombre, edad, genero, telefono, correo);
					modelo.addElement(p);
					}catch(NumberFormatException e) {
						JOptionPane.showMessageDialog(panelContactos, "El campo edad solo puede contener numeros", "ERROR DE FORMATO", JOptionPane.ERROR_MESSAGE);
					}
				try{
					FileOutputStream file = new FileOutputStream("contactos.txt");
					ObjectOutputStream oos = new ObjectOutputStream(file);
					oos.writeObject(modelo);
					file.close();
					oos.close();
				}catch (FileNotFoundException e){
					e.printStackTrace();
				} catch(IOException e){
					e.printStackTrace();
				}
				
			}
		});
		
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtCorreo.setText("");
				txtEdad.setText("");
				txtNombre.setText("");
				txtTelefono.setText("");
				rdbtnHombre.setSelected(true);
			}
		});
		
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
					i = list.getSelectedIndex();
					txtCorreo.setText(modelo.get(i).getCorreo());
					txtTelefono.setText(modelo.get(i).getTelefono());
					txtNombre.setText(modelo.get(i).getNombre());
					txtEdad.setText(Integer.toString(modelo.get(i).getEdad()));
					if((modelo.get(i).getGenero().compareTo(Genero.HOMBRE))==0)
						rdbtnHombre.setSelected(true);
					else
						rdbtnMujer.setSelected(true);
			}
		});
		
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombre = txtNombre.getText();
				int edad = Integer.parseInt(txtEdad.getText());
				Genero genero = rdbtnHombre.isSelected()?Genero.HOMBRE:Genero.MUJER ;
				String telefono = txtTelefono.getText();
				String correo = txtCorreo.getText();
				Persona p = new Persona(nombre, edad, genero, telefono, correo);
				modelo.set(i, p);
				try{
					FileOutputStream file = new FileOutputStream("contactos.txt");
					ObjectOutputStream oos = new ObjectOutputStream(file);
					oos.writeObject(modelo);
					file.close();
					oos.close();
				}catch (FileNotFoundException e){
					e.printStackTrace();
				} catch(IOException e){
					e.printStackTrace();
				}
			}
		});
		
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modelo.remove(i);
				try{
					FileOutputStream file = new FileOutputStream("contactos.txt");
					ObjectOutputStream oos = new ObjectOutputStream(file);
					oos.writeObject(modelo);
					file.close();
					oos.close();
				}catch (FileNotFoundException e){
					e.printStackTrace();
				} catch(IOException e){
					e.printStackTrace();
				}
			}
		});
		
	}

}
