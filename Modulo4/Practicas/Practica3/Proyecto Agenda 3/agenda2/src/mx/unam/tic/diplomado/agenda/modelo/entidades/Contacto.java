package mx.unam.tic.diplomado.agenda.modelo.entidades;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "t_contacto")
@NamedQueries(
		{@NamedQuery(name = "contactosAll", query = "FROM Contacto"),
		@NamedQuery(name = "contactoById", query = "SELECT c FROM Contacto c WHERE c.id = :id")})
public class Contacto {
	
	private Integer id;
	private String nombre;
	private String apellidos;
	private Integer edad;
	private String direccion;
	private TipoContacto tipoContacto;
	private Set<ContactoMedio> contactosMedios;
	
	@Id
	@Column(name = "id_contacto")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	@Column(name = "vc_apellidos", length = 200)
	public String getApellidos() {
		return apellidos;
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	@Column(name = "vi_edad")
	public Integer getEdad() {
		return edad;
	}
	
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	
	@Column(name = "vc_direccion")
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	@ManyToOne(targetEntity = TipoContacto.class, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_tipo_contacto", nullable = false)
	@Fetch(FetchMode.JOIN)
	public TipoContacto getTipoContacto() {
		return tipoContacto;
	}
	
	public void setTipoContacto(TipoContacto tipoContacto) {
		this.tipoContacto = tipoContacto;
	}
	
	@OneToMany(mappedBy = "contacto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@Fetch(FetchMode.JOIN)
	public Set<ContactoMedio> getContactosMedios() {
		return contactosMedios;
	}
	
	public void setContactosMedios(Set<ContactoMedio> contactosMedios) {
		this.contactosMedios = contactosMedios;
	}
	
	

}
