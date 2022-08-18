package mx.unam.tic.diplomado.agenda.modelo.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Catalogo<T extends Serializable> implements Serializable {

	protected Integer id;
	protected String nombre;
	protected String estatus;

	abstract Integer getId();

	public void setId(Integer id) {
		this.id = id;
	}

	abstract String getNombre();

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	abstract String getEstatus();

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

}
