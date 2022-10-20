package mx.unam.diplomado.data;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class Producto implements Serializable {
	
	//@JsonIgnore
	private Integer id;
	
	private String nombre;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
