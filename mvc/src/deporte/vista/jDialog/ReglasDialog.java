package deporte.vista.jDialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class ReglasDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ReglasDialog dialog = new ReglasDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ReglasDialog() {
		setFont(new Font("Dialog", Font.BOLD, 12));
		setIconImage(Toolkit.getDefaultToolkit().getImage(ReglasDialog.class.getResource("/imagen/protocolo-jabber-icono-5655-16.png")));
		setTitle("REGLAS DEL JUEGO");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(204, 255, 204));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(6, 1, 0, 0));
		{
			JLabel lblR1 = new JLabel("REGLA 1.");
			lblR1.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblR1.setHorizontalAlignment(SwingConstants.LEFT);
			contentPanel.add(lblR1);
		}
		{
			JLabel lblR2 = new JLabel("REGLA 2.");
			lblR2.setFont(new Font("Tahoma", Font.BOLD, 11));
			contentPanel.add(lblR2);
		}
		{
			JLabel lblR3 = new JLabel("REGLA 3.");
			lblR3.setFont(new Font("Tahoma", Font.BOLD, 11));
			contentPanel.add(lblR3);
		}
		{
			JLabel lblR4 = new JLabel("REGLA 4.");
			lblR4.setFont(new Font("Tahoma", Font.BOLD, 11));
			contentPanel.add(lblR4);
		}
		{
			JLabel lblR5 = new JLabel("REGLA 5.");
			lblR5.setFont(new Font("Tahoma", Font.BOLD, 11));
			contentPanel.add(lblR5);
		}
		{
			JLabel lblR6 = new JLabel("REGLA 6.");
			lblR6.setFont(new Font("Tahoma", Font.BOLD, 11));
			contentPanel.add(lblR6);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(204, 255, 204));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setIcon(new ImageIcon(ReglasDialog.class.getResource("/imagen/aceptar-verde-ok-si-icono-8925-16.png")));
				okButton.setFont(new Font("Tahoma", Font.BOLD, 11));
				okButton.setBackground(new Color(0, 102, 255));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						dispose();
					}
				});
				buttonPane.add(okButton);
			}
		}
	}

}
