package deporte.vista;

import java.awt.Component;

import deporte.vista.panel.CanchaFA;

public interface EquipoFInterfaz {

	public Component getWriteObject();
	public Component getComponentShow();
	public void setComponentShow(CanchaFA cancha);
	public void setFocusablePlay(boolean focus);
	public void setFocusablePause(boolean focus);
	public void setFocusableCancha(boolean focus);
	public void showCancha();
	
}
