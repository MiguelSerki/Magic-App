
public class Mensaje {

	private int id;
	private String texto;
	private int recepcion;
	private int enviado;
	private Prioridad prioridad;
	
	
	public Mensaje() {
		
	}
	public Mensaje (int id, String texto, int recepcion, int enviado, Prioridad prioridad) {
		this.id = id;
		this.texto = texto;
		this.recepcion = recepcion;
		this.enviado = enviado;
		this.prioridad = prioridad;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTexto() {
		return texto;
	}


	public void setTexto(String texto) {
		this.texto = texto;
	}


	public int getRecepcion() {
		return recepcion;
	}


	public void setRecepcion(int recepcion) {
		this.recepcion = recepcion;
	}


	public int getEnviado() {
		return enviado;
	}


	public void setEnviado(int enviado) {
		this.enviado = enviado;
	}


	public Prioridad getPrioridad() {
		return prioridad;
	}


	public void setPrioridad(Prioridad prioridad) {
		this.prioridad = prioridad;
	}
}
