package mx.unam.tic.diplomado.agenda.servicios;

import java.util.List;

import mx.unam.tic.diplomado.agenda.modelo.dao.ContactoDAO;
import mx.unam.tic.diplomado.agenda.modelo.dao.ContactoDAOImplHibernate;
import mx.unam.tic.diplomado.agenda.modelo.entidades.Contacto;

public class ServiciosContactosImpl implements ServiciosContactos {
	
	private static ServiciosContactosImpl instance;

	private ServiciosContactosImpl() {

	}

	public static ServiciosContactosImpl getInstance() {
		if (instance == null) {
			instance = new ServiciosContactosImpl();
		}
		return instance;
	}
	
	public Contacto cargaContactoPorId(Integer id) {
		return null;
	}
	
	public Contacto cargaContactoPorIdNQ(Integer id) {
		return null;
	}

	public List<Contacto> cargaContactos() {
		ContactoDAO dao = new ContactoDAOImplHibernate();
		return dao.findAll();
	}
	
	public List<Contacto> cargaContactosTodos() {
		return null;
	}

	public void guardaContacto(Contacto contacto) {
		
	}

	public void actualizaContacto(Contacto contacto) {
		
	}

	public void eliminaContacto(Contacto contacto) {
		
	}

}
