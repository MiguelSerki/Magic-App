import java.util.TreeMap;

public class Mapas {

	private TreeMap<String, Integer> original;
	private TreeMap <Integer, String> codificado;
	private int i;
	
	public Mapas () {
		i = 0;
		setOriginal(new TreeMap <String, Integer>(){
	        {
	            for (char ch = 'a'; ch <= 'z'; ++ch) 
	                put(String.valueOf(ch), i);
	            i++;
	        }
	});
		setCodificado(new TreeMap <Integer, String>());
	}

	public TreeMap<String, Integer> getOriginal() {
		return original;
	}

	public void setOriginal(TreeMap<String, Integer> treeMap) {
		this.original = treeMap;
	}

	public TreeMap <Integer, String> getCodificado() {
		return codificado;
	}

	public void setCodificado(TreeMap <Integer, String> codificado) {
		this.codificado = codificado;
	}
}

