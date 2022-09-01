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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((creditos == null) ? 0 : creditos.hashCode());
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Materia other = (Materia) obj;
        if (creditos == null) {
            if (other.creditos != null)
                return false;
        } else if (!creditos.equals(other.creditos))
            return false;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Materia [nombre=" + nombre + ", creditos=" + creditos + "]";
    }
}