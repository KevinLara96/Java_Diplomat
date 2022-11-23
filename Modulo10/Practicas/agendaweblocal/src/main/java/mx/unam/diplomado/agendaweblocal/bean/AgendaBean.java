package mx.unam.diplomado.agendaweblocal.bean;

import jakarta.ejb.EJB;
import jakarta.enterprise.inject.Model;
import jakarta.enterprise.inject.Produces;
import mx.unam.diplomado.agendaweblocal.ejblocal.ContactoEJB;
import mx.unam.diplomado.agendaweblocal.vo.Contacto;

import java.util.List;

@Model
public class AgendaBean {
	
	@EJB(beanName = "contactobean", name = "contactobean")
	private ContactoEJB ejb;
	
	@Produces
	@Model
	public List<Contacto> cargaContactos() {
		return ejb.cargaContactos();
	}

}
