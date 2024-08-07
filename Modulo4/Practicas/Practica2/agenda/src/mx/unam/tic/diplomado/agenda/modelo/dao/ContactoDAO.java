package mx.unam.tic.diplomado.agenda.modelo.dao;

import java.util.List;

import mx.unam.tic.diplomado.agenda.modelo.entidades.Contacto;
import mx.unam.tic.diplomado.agenda.modelo.entidades.ContactoMedio;
import mx.unam.tic.diplomado.agenda.modelo.entidades.MedioContacto;

public interface ContactoDAO {

	Contacto cargaContactoPorId(Integer id);

	List<Contacto> cargaContactos();

	void guardaContacto(Contacto contacto);

	void actualizaContacto(Contacto contacto);

	void eliminaContacto(Contacto contacto);
	
	List<ContactoMedio> cargaContactosMedio(MedioContacto medioContacto);
}
