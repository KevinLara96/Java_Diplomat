package dgtic.core.modelo;

import dgtic.core.excepciones.CreditosMenores;

public class Materia {
    private String nombre;
    private Integer creditos;

    public Materia(String nombre, Integer creditos) {
        super();
        this.nombre = nombre;
        this.creditos = creditos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        if (creditos < 0) {
            throw new CreditosMenores("No creditos negativos");
        } else {
            this.creditos = creditos;
        }
    }

    @Override
    public String toString() {
        return "Materia [nombre=" + nombre + ", creditos=" + creditos + "]";
    }
}