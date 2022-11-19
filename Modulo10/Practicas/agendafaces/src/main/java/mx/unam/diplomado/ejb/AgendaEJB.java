package mx.unam.diplomado.ejb;

import java.util.ArrayList;
import java.util.List;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import mx.unam.diplomado.agendafaces.vo.Contacto;

/**
 * Session Bean implementation class AgendaEJB
 */
@Stateless
public class AgendaEJB implements IAgendaEJBLocal {    
    
    public List<Contacto> cargaContactos() {
		List<Contacto> contactos = new ArrayList<Contacto>();
		for (int i = 0; i < 15; i++) {
			Contacto contacto = new Contacto();
			contacto.setNombre("Contacto " + i);
			contacto.setApellidos("Apellido " + i);
			contacto.setNumero("5512345" + i);
			contactos.add(contacto);
		}
		
		return contactos;
	}

}
