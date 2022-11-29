package mx.unam.diplomado.agendafaces.vo;

public class TipoViaje {

    private Integer idTipoViaje;
    private String tipoViaje;

    public TipoViaje() {

    }

    public TipoViaje(Integer idTipoViaje, String tipoViaje) {
        this.idTipoViaje = idTipoViaje;
        this.tipoViaje = tipoViaje;
    }

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

    @Override
    public String toString() {
        return "TipoViaje [idTipoViaje=" + idTipoViaje + ", tipoViaje=" + tipoViaje + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
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
        TipoViaje other = (TipoViaje) obj;
        if (idTipoViaje == null) {
            if (other.idTipoViaje != null)
                return false;
        } else if (!idTipoViaje.equals(other.idTipoViaje))
            return false;
        return true;
    }

}
