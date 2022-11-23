package mx.unam.diplomado.agendaweblocal.ejblocal;

import jakarta.ejb.Local;
import mx.unam.diplomado.agendaweblocal.vo.Contacto;

import java.util.List;

@Local
public interface IContactoEJBLocal {

	List<Contacto> cargaContactos();
	
}
