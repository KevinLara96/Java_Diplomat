package mx.unam.tic.diplomado.agenda.servicios;

import java.io.Serializable;
import java.util.List;

import mx.unam.tic.diplomado.agenda.modelo.dao.MedioContactoDAOImplHibernate;
import mx.unam.tic.diplomado.agenda.modelo.dao.MedioContactoDAO;
import mx.unam.tic.diplomado.agenda.modelo.dao.TipoContactoDAO;
import mx.unam.tic.diplomado.agenda.modelo.dao.TipoContactoDAOImplHibernate;
import mx.unam.tic.diplomado.agenda.modelo.entidades.MedioContacto;
import mx.unam.tic.diplomado.agenda.modelo.entidades.TipoContacto;

public class ServiciosCatalogosImpl implements ServiciosCatalogos {

	private static ServiciosCatalogosImpl instance;

	private ServiciosCatalogosImpl() {

	}

	public static ServiciosCatalogosImpl getInstance() {
		if (instance == null) {
			instance = new ServiciosCatalogosImpl();
		}
		return instance;
	}

	@Override
	public TipoContacto cargaTipoContactoPorId(Integer id) {
		TipoContactoDAO dao = new TipoContactoDAOImplHibernate();
		return dao.get(id);
	}

	@Override
	public List<TipoContacto> cargaTiposContacto() {
		TipoContactoDAO dao = new TipoContactoDAOImplHibernate();
		return dao.findAll();
	}

	@Override
	public List<MedioContacto> cargaMediosContacto() {
		MedioContactoDAO dao = new MedioContactoDAOImplHibernate();
		return dao.findAll();
	}

	@Override
	public MedioContacto cargaMedioContactoPorId(Integer id) {
		MedioContactoDAO dao = new MedioContactoDAOImplHibernate();
		return dao.get(id);
	}

}
