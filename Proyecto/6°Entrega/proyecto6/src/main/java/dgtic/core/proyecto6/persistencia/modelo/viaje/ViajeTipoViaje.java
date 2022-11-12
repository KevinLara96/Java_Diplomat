package dgtic.core.proyecto6.persistencia.modelo.viaje;

public class ViajeTipoViaje {

    private Integer idViaje;
    private Integer idTipoViaje;

    public ViajeTipoViaje() {

    }

    public ViajeTipoViaje(Integer idViaje, Integer idTipoViaje) {
        this.idViaje = idViaje;
        this.idTipoViaje = idTipoViaje;
    }

    public Integer getIdViaje() {
        return idViaje;
    }

    public void setIdViaje(Integer idViaje) {
        this.idViaje = idViaje;
    }

    public Integer getIdTipoViaje() {
        return idTipoViaje;
    }

    public void setIdTipoViaje(Integer idTipoViaje) {
        this.idTipoViaje = idTipoViaje;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idViaje == null) ? 0 : idViaje.hashCode());
        result = prime * result + ((idTipoViaje == null) ? 0 : idTipoViaje.hashCode());
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
        ViajeTipoViaje other = (ViajeTipoViaje) obj;
        if (idViaje == null) {
            if (other.idViaje != null)
                return false;
        } else if (!idViaje.equals(other.idViaje))
            return false;
        if (idTipoViaje == null) {
            if (other.idTipoViaje != null)
                return false;
        } else if (!idTipoViaje.equals(other.idTipoViaje))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ViajeTipoViaje [idViaje=" + idViaje + ", idTipoViaje=" + idTipoViaje + "]";
    }

}
