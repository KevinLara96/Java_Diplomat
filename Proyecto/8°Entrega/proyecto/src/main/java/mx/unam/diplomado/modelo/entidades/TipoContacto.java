package mx.unam.diplomado.modelo.entidades;

import java.util.Objects;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //definir la entidad
@Table(name = "c_tipo_contacto") //indicar el nombre de la tabla que representa
public class TipoContacto {
	
	private Integer id;
	private String nombre;
	private String estatus;
	
	@Id //indicar que la propiedad es una llave
	@Column(name = "id_tipo_contacto") //descripcion de la columna
	@GeneratedValue(strategy = GenerationType.IDENTITY) //estrategia de manejo de llave
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "vc_nombre", length = 50)
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Column(name = "vc_estatus", length = 50)
	public String getEstatus() {
		return estatus;
	}
	
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	
	

	@Override
	public String toString() {
		return "TipoContacto [id=" + id + ", nombre=" + nombre + ", estatus=" + estatus + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(estatus, id, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoContacto other = (TipoContacto) obj;
		return Objects.equals(estatus, other.estatus) && Objects.equals(id, other.id)
				&& Objects.equals(nombre, other.nombre);
	}
	
	

}
