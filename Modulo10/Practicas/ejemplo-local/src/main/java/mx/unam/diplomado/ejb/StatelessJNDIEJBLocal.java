package mx.unam.diplomado.ejb;

import java.util.HashMap;
import java.util.Map;
import jakarta.ejb.Stateless;

@Stateless
public class StatelessJNDIEJBLocal implements IStatelessLocal {
	
	private Integer contador = 0;

    public Map<String, Object> saludar(String nombre) {
    	Map<String, Object> datos = new HashMap<>();    	
    	datos.put("contador", contador++);
    	datos.put("saludo", "Hola que tal " + nombre);
        System.out.println("imprimiendo dentro del ejb con instancia: " + this);
        return datos;
    }
}
