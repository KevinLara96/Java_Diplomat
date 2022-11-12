package dgtic.core.proyecto6.persistencia.modelo.agencia;

import java.util.HashSet;
import java.util.Set;

import dgtic.core.proyecto6.persistencia.modelo.viaje.Viaje;

public class Agencia {

    private Integer idAgencia;
    private String nombreAgencia;
    private String ubicacion;

    private Set<Viaje> destinos;

    public Agencia() {
    }

    public Agencia(Integer idAgencia, String nombre, String ubicacion) {
        this.idAgencia = idAgencia;
        this.nombreAgencia = nombre;
        this.ubicacion = ubicacion;
        this.destinos = new HashSet<>();
    }

    public Integer getIdAgencia() {
        return idAgencia;
    }

    public void setIdAgencia(Integer idAgencia) {
        this.idAgencia = idAgencia;
    }

    public String getNombreAgencia() {
        if (nombreAgencia == null || nombreAgencia.equals("")) {
            return "Agencia Vacía.";
        } else {
            return nombreAgencia;
        }
    }

    public void setNombreAgencia(String nombreAgencia) {
        this.nombreAgencia = nombreAgencia;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Set<Viaje> getDestinos() {
        return destinos;
    }

    public void setDestinos(Set<Viaje> destinos) {
        this.destinos = destinos;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((destinos == null) ? 0 : destinos.hashCode());
        result = prime * result + ((idAgencia == null) ? 0 : idAgencia.hashCode());
        result = prime * result + ((nombreAgencia == null) ? 0 : nombreAgencia.hashCode());
        result = prime * result + ((ubicacion == null) ? 0 : ubicacion.hashCode());
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
        Agencia other = (Agencia) obj;
        if (idAgencia == null) {
            if (other.idAgencia != null)
                return false;
        } else if (!idAgencia.equals(other.idAgencia))
            return false;
        if (nombreAgencia == null) {
            if (other.nombreAgencia != null)
                return false;
        } else if (!nombreAgencia.equals(other.nombreAgencia))
            return false;
        if (ubicacion == null) {
            if (other.ubicacion != null)
                return false;
        } else if (!ubicacion.equals(other.ubicacion))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("");
        str.append("\n\nAgencia ").append(nombreAgencia);
        str.append("\nUbicación: ").append(ubicacion);
        str.append("\n\ndestinos:\n").append(destinos);
        str.append("\n\n");
        return str.toString();
    }
}