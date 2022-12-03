package unam.dgtic.diplomado.m1100base.dominio.cliente;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Cliente {

    @Column(name = "nombre")
    private String nombre;

    public Cliente() {
    }

    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Cliente [nombre=" + nombre + "]";
    }

}
