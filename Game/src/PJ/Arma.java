package PJ;

public class Arma {
	private int da�o;
	
	public Arma () {
		setDa�o(0);
	}
	public Arma (int da�o) {
		this.setDa�o(da�o);
	}
	public int getDa�o() {
		return da�o;
	}
	public void setDa�o (int da�o) {
		this.da�o = da�o;
	}
	public Arma getMet () {
		return this;
	}
	
}