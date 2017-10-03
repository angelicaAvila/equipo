package hilos;

public class Test19sept {

	public static void main(String[] args) {
		PrimerHilo hilo1 = new PrimerHilo();
		hilo1.setName("Angie");
		hilo1.start();
		
		PrimerHilo hilo2 = new PrimerHilo();
		hilo2.setName("Jorge");
		hilo2.start();
		hilo2.setPriority(Thread.MAX_PRIORITY);
		
		SegundoHilo hiloRunn = new SegundoHilo("Yoda");  //MEJOR IMPLEMENTACION
		Thread hilo3 = new Thread(hiloRunn);
		hilo3.start();
	}
}
