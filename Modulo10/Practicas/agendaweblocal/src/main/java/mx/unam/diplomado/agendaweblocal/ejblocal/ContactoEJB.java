package mx.unam.diplomado.agendaweblocal.ejblocal;

import java.util.ArrayList;
import java.util.List;

import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import mx.unam.diplomado.agendaweblocal.vo.Contacto;

@Stateless(name = "contactobean")
public class ContactoEJB {

	public List<Contacto> cargaContactos() {
		List<Contacto> contactos = new ArrayList<Contacto>();
		for (int i = 0; i < 5; i++) {
			Contacto contacto = new Contacto();
			contacto.setNombre("Contacto " + i);
			contacto.setApellidos("Apellido " + i);
			contacto.setNumero("5512345" + i);
			contactos.add(contacto);
		}
		
		return contactos;
	}
	
}
