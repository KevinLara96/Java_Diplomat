package mx.unam.tic.diplomado.agenda.modelo.entidades;


import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "c_tipo_contacto")
//@DiscriminatorValue("TC")
public class TipoContacto extends Catalogo<Integer>  {
	
	private String columnaExtra;
	
	@Column(name = "vc_extra")
	public String getColumnaExtra() {
		return columnaExtra;
	}

	public void setColumnaExtra(String columnaExtra) {
		this.columnaExtra = columnaExtra;
	}

	public TipoContacto() {
		super();
	}
	
	@Id	
	@Column(name = "id_tipo_contacto")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Override
	public Integer getId() {
		return id;
	}
	
	@Column(name = "vc_nombre", length = 50)
	public String getNombre() {
		return nombre;
	}
	
	@Column(name = "vc_estatus", length = 50)
	public String getEstatus() {
		return estatus;
	}

	@Override
	public String toString() {
		return "TipoContacto [id=" + id + ", nombre=" + nombre + ", estatus=" + estatus + ", getId()=" + getId()
				+ ", getNombre()=" + getNombre() + ", getEstatus()=" + getEstatus() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
