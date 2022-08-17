package mx.unam.tic.diplomado.agenda.servicios;

import java.util.List;

import mx.unam.tic.diplomado.agenda.modelo.entidades.Contacto;

public interface ServiciosContactos {

	Contacto cargaContactoPorId(Integer id);
	
	Contacto cargaContactoPorIdNQ(Integer id);

	List<Contacto> cargaContactos();
	
	List<Contacto> cargaContactosTodos();
	
	List<Contacto> cargaContactosPorTipo(Integer idTipoContacto);
	
	List<Contacto> cargaContactosPorMedioContacto(Integer idMedioContacto);

	void guardaContacto(Contacto contacto);

	void actualizaContacto(Contacto contacto);

	void eliminaContacto(Contacto contacto);

}
