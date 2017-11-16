package juego.manager;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyManager extends KeyAdapter {

	private boolean [] keys;
	private boolean left;
	private boolean right;
	
	public KeyManager() {
		keys = new boolean[256];
	}
	public void update() {
		left = keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_RIGHT];
	}
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()]=true;
		update();
	}
	public void keyReleased(KeyEvent e ) {
		keys[e.getKeyCode()]=false;
		update();
	}
	public boolean[] getKeys() {
		return keys;
	}
	public boolean isLeft() {
		return left;
	}
	public boolean isRight() {
		return right;
	}

}
