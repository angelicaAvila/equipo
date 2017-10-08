package deporte.vista;

import java.awt.Component;

public interface EquipoFInterfaz {

	public Component getWriteObject();
	public Component getComponentShow();
	public void setFocusablePlay(boolean focus);
	public void setFocusablePause(boolean focus);
	public void setFocusableCancha(boolean focus);
	public void showCancha();
	
}
