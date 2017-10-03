package clases;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class panel1 extends JPanel {

	/**
	 * Create the panel.
	 */
	public panel1() {
		
		setBackground(new Color(200, 0, 25));
		setBorder(new EmptyBorder(10, 10, 10, 10));
	}

	public void paintComponent(Graphics g){
		//g.setColor(Color.blue);
		int x = 5;
		int y = 5;
		while(true){
			g.fillRect(x,y,30,20);
			x++;
		}
	}
}
