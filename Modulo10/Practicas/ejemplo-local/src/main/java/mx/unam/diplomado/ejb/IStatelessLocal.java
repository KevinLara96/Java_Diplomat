package mx.unam.diplomado.ejb;

import java.util.Map;

import jakarta.ejb.Local;

@Local
public interface IStatelessLocal {

	Map<String, Object> saludar(String nombre);
	
}
