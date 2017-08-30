package PJ;

public class Personaje {
	private int vida;
	private int da�o;
	private int cobertura;
	private Arma arma;
	private Armadura armadura;

	// constructor
	public Personaje() {
		vida = 10;
		da�o = 0;
		arma = null;
		armadura = null;
		this.setDa�oYArmadura();
	}

	public Personaje(int vida, int da�o, Arma arma, Armadura armadura) {
		this.vida = vida;
		this.da�o = da�o;
		this.arma = arma;
		this.armadura = armadura;
		this.setDa�oYArmadura();
	}

	// getters y setters
	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getDa�o() {
		return da�o;
	}

	public void setDa�o(int da�o) {
		this.da�o = da�o;
	}

	public Arma getArma() {
		return arma;
	}

	public void setArma(Arma arma) {
		this.arma = arma;
	}

	public Armadura getArmadura() {
		return armadura;
	}

	public void setArmadura(Armadura armadura) {
		this.armadura = armadura;
	}

	public int getCobertura() {
		return cobertura;
	}

	public void setCobertura(int cobertura) {
		this.cobertura = cobertura;
	}

	// otros metodos
	
	public void setDa�oYArmadura() {
		this.da�o = da�o + this.getArma().getDa�o();
		this.cobertura = cobertura + this.getArmadura().getCobertura();
	}

	public Personaje getMe() {
		return this;

	}

}