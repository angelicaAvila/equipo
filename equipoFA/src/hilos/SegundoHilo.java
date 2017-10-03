package hilos;

public class SegundoHilo implements Runnable{

	private String name;
	
	public SegundoHilo(String name) {
		this.name = name;
	}
	
	public void run() {
		for(int i =0; i<10; i++) {
			System.out.println(name+"-"+i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
