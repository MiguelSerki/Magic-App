import java.util.Iterator;

public class MainTest {

	public static void main(String[] args) {
Mapas map = new Mapas();
Iterator it = map.getOriginal().keySet().iterator();
while(it.hasNext()){
	  String key = (String) it.next();
	  System.out.println("Clave: " + key + " -> Valor: " + map.getOriginal().get(key));
	}
	}

}
