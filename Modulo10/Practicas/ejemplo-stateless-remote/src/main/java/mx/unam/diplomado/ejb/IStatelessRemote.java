package mx.unam.diplomado.ejb;

import java.util.Map;

import jakarta.ejb.Remote;

@Remote
public interface IStatelessRemote {

	Map<String, Object> saludar(String nombre);
	
}
