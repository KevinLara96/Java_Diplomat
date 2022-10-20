package mx.unam.diplomado.data;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

public class Usuario {
	
	@NotBlank
	private String nombre;
	
	@NotBlank
	@Size(min = 5, max = 6)
	@Pattern(regexp = "^[a-zA-Z]\\w{5,6}$")
	private String password;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
