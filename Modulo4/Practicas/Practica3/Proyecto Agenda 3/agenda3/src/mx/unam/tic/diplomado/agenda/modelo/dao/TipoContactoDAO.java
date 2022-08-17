package mx.unam.tic.diplomado.agenda.modelo.dao;


import mx.unam.tic.diplomado.agenda.modelo.entidades.Contacto;
import mx.unam.tic.diplomado.agenda.modelo.entidades.TipoContacto;

public interface TipoContactoDAO extends GenericDAO<TipoContacto, Integer> {
	
	Contacto cargaContactoPorId(Integer id);

}
