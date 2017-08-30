package PJ;

public class Armadura {
	private int cobertura;
	
	public Armadura () {
		setCobertura(0);
	}
	public Armadura (int cobertura) {
		this.setCobertura(cobertura);
	}
	public int getCobertura() {
		return cobertura;
	}
	public void setCobertura(int cobertura) {
		this.cobertura = cobertura;
	}
	public Armadura getMet () {
		return this;
	}
	
}
