package clases;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

public class AboutDialog extends JDialog {

	private static final String String = null;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AboutDialog dialog = new AboutDialog(String);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AboutDialog(String cad) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(204, 255, 204));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon(AboutDialog.class.getResource("/imagen/uabc2.png")));
			contentPanel.add(label, BorderLayout.WEST);
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(204, 255, 204));
			contentPanel.add(panel, BorderLayout.EAST);
			panel.setLayout(new GridLayout(6, 1, 0, 0));
			{
				JLabel labelUABC = new JLabel("UNIVERSIDAD AUTONOMA DE BAJA CALIFORNIA");
				labelUABC.setForeground(new Color(0, 100, 0));
				labelUABC.setHorizontalAlignment(SwingConstants.CENTER);
				labelUABC.setFont(new Font("Tahoma", Font.BOLD, 11));
				panel.add(labelUABC);
			}
			{
				JLabel labelFcqi = new JLabel("FACULTAD DE CIENCIAS QUIMICAS E INGENIERIA");
				labelFcqi.setForeground(new Color(0, 0, 139));
				labelFcqi.setHorizontalAlignment(SwingConstants.CENTER);
				labelFcqi.setFont(new Font("Tahoma", Font.BOLD, 11));
				panel.add(labelFcqi);
			}
			{
				JLabel LabelIC = new JLabel("INGENIERIA EN COMPUTACI\u00D3N");
				LabelIC.setForeground(new Color(0, 0, 139));
				LabelIC.setFont(new Font("Tahoma", Font.BOLD, 11));
				LabelIC.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(LabelIC);
			}
			{
				JLabel lblProgramacinOrientadaA = new JLabel("PROGRAMACI\u00D3N ORIENTADA A OBJETOS AVANZADA");
				lblProgramacinOrientadaA.setForeground(new Color(0, 0, 139));
				lblProgramacinOrientadaA.setFont(new Font("Tahoma", Font.BOLD, 10));
				panel.add(lblProgramacinOrientadaA);
			}
			{
				JLabel lblAngelicaJazminAvila = new JLabel("ANGELICA JAZMIN AVILA HUIZAR");
				lblAngelicaJazminAvila.setForeground(new Color(30, 144, 255));
				lblAngelicaJazminAvila.setHorizontalAlignment(SwingConstants.CENTER);
				lblAngelicaJazminAvila.setFont(new Font("Tahoma", Font.BOLD, 12));
				panel.add(lblAngelicaJazminAvila);
			}
			{
				JLabel lblPracticaInterfaz = new JLabel(cad);
				lblPracticaInterfaz.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblPracticaInterfaz.setForeground(new Color(0, 0, 139));
				lblPracticaInterfaz.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(lblPracticaInterfaz);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(204, 255, 204));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setFont(new Font("Tahoma", Font.BOLD, 11));
				cancelButton.setBackground(new Color(255, 0, 0));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
