package mx.unam.tic.diplomado.agenda.modelo.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "c_medio_contacto")
public class MedioContacto extends Catalogo<Integer> {
	
	@Id
	@Column(name = "id_medio_contacto")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	
	@Column(name = "vc_nombre", length = 50)
	@Override
	public String getNombre() {
		return nombre;
	}
	
	@Column(name = "vc_estatus", length = 50)
	public String getEstatus() {
		return estatus;
	}

	@Override
	public String toString() {
		return "MedioContacto [id=" + id + ", nombre=" + nombre + ", estatus=" + estatus + ", getId()=" + getId()
				+ ", getNombre()=" + getNombre() + ", getEstatus()=" + getEstatus() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
