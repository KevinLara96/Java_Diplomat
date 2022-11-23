package mx.unam.tic.diplomado.agenda.modelo.dao;

import mx.unam.tic.diplomado.agenda.modelo.entidades.Contacto;
import mx.unam.tic.diplomado.agenda.modelo.entidades.TipoContacto;

public class TipoContactoDAOImplHibernate extends GenericDAOImplHibernate<TipoContacto, Integer>
		implements TipoContactoDAO {
	
	@Override
	public Contacto cargaContactoPorId(Integer id) {
		return null;
	}

}
