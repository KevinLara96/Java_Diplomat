package mx.unam.tic.diplomado.agenda.servicios;

import java.util.List;

import mx.unam.tic.diplomado.agenda.modelo.dao.ContactoDAO;
import mx.unam.tic.diplomado.agenda.modelo.dao.ContactoDAOImpl;
import mx.unam.tic.diplomado.agenda.modelo.entidades.Contacto;

public class ServiciosContactosImpl implements ServiciosContactos {
	
	private static ServiciosContactosImpl instance;
	
	private ServiciosContactosImpl() {}
	
	public static ServiciosContactosImpl getInstance() {
		if (instance == null) {
			instance = new ServiciosContactosImpl();
		}
		return instance;
	}

	@Override
	public Contacto cargaContactoPorId(Integer id) {
		ContactoDAO contactoDAO = ContactoDAOImpl.getInstance();
		return contactoDAO.cargaContactoPorId(id);
	}
	
	@Override
	public Contacto cargaContactoPorIdNQ(Integer id) {
		ContactoDAO contactoDAO = ContactoDAOImpl.getInstance();
		return contactoDAO.cargaContactoPorIdNQ(id);
	}
	
	@Override
	public List<Contacto> cargaContactosPorTipo(Integer idTipoContacto) {
		ContactoDAO contactoDAO = ContactoDAOImpl.getInstance();
		return contactoDAO.cargaContactosPorTipo(idTipoContacto);
	}
	
	@Override
	public List<Contacto> cargaContactosPorMedioContacto(Integer idMedioContacto) {
		ContactoDAO contactoDAO = ContactoDAOImpl.getInstance();
		return contactoDAO.cargaContactosPorMedioContacto(idMedioContacto);
	}

	@Override
	public List<Contacto> cargaContactos() {
		ContactoDAO contactoDAO = ContactoDAOImpl.getInstance();
		return contactoDAO.cargaContactos();
	}
	
	@Override
	public List<Contacto> cargaContactosTodos() {
		ContactoDAO contactoDAO = ContactoDAOImpl.getInstance();
		return contactoDAO.cargaContactosTodos();
	}

	@Override
	public void guardaContacto(Contacto contacto) {
		ContactoDAO contactoDAO = ContactoDAOImpl.getInstance();
		contactoDAO.guardaContacto(contacto);
	}

	@Override
	public void actualizaContacto(Contacto contacto) {
		ContactoDAO contactoDAO = ContactoDAOImpl.getInstance();
		contactoDAO.actualizaContacto(contacto);
	}

	@Override
	public void eliminaContacto(Contacto contacto) {
		ContactoDAO contactoDAO = ContactoDAOImpl.getInstance();
		contactoDAO.eliminaContacto(contacto);
	}

}
