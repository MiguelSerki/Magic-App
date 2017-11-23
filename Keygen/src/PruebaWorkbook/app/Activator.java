package PruebaWorkbook.app;

public class Activator {

	private int activation;
	
	public Activator (int key) {
		
		activation = (key * 2 + key * 4) + (key -5) *2;
	}
	
	public int returnActivation() {
		return this.activation;
	}
}
