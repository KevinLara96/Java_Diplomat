package dgtic.core.proyecto6.persistencia.modelo.viaje;

import java.util.List;

public class TipoViaje {

    private Integer idTipoViaje;
    private String tipoViaje;

    private List<Viaje> viajes;

    public Integer getIdTipoViaje() {
        return idTipoViaje;
    }

    public void setIdTipoViaje(Integer idTipoViaje) {
        this.idTipoViaje = idTipoViaje;
    }

    public String getTipoViaje() {
        return tipoViaje;
    }

    public void setTipoViaje(String tipoViaje) {
        this.tipoViaje = tipoViaje;
    }

    public List<Viaje> getViajes() {
        return viajes;
    }

    public void setViajes(List<Viaje> viajes) {
        this.viajes = viajes;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idTipoViaje == null) ? 0 : idTipoViaje.hashCode());
        result = prime * result + ((tipoViaje == null) ? 0 : tipoViaje.hashCode());
        result = prime * result + ((viajes == null) ? 0 : viajes.hashCode());
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
        TipoViaje other = (TipoViaje) obj;
        if (idTipoViaje == null) {
            if (other.idTipoViaje != null)
                return false;
        } else if (!idTipoViaje.equals(other.idTipoViaje))
            return false;
        if (tipoViaje == null) {
            if (other.tipoViaje != null)
                return false;
        } else if (!tipoViaje.equals(other.tipoViaje))
            return false;
        if (viajes == null) {
            if (other.viajes != null)
                return false;
        } else if (!viajes.equals(other.viajes))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "TipoViaje [idTipoViaje=" + idTipoViaje + ", tipoViaje=" + tipoViaje + ", viajes=" + viajes + "]";
    }

}