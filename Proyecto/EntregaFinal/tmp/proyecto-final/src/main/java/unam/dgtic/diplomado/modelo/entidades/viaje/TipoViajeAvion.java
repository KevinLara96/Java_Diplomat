package unam.dgtic.diplomado.modelo.entidades.viaje;

public class TipoViajeAvion {

    private Integer idTipoViajeAvion;
    private String tipoViajeAvion;

    public TipoViajeAvion() {
    }

    public TipoViajeAvion(Integer idTipoViajeAvion, String tipoViajeAvion) {
        this.idTipoViajeAvion = idTipoViajeAvion;
        this.tipoViajeAvion = tipoViajeAvion;
    }

    public Integer getIdTipoViaje() {
        return idTipoViajeAvion;
    }

    public void setIdTipoViaje(Integer idTipoViajeAvion) {
        this.idTipoViajeAvion = idTipoViajeAvion;
    }

    public String getTipoViaje() {
        return tipoViajeAvion;
    }

    public void setTipoViaje(String tipoViajeAvion) {
        this.tipoViajeAvion = tipoViajeAvion;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idTipoViajeAvion == null) ? 0 : idTipoViajeAvion.hashCode());
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
        TipoViajeAvion other = (TipoViajeAvion) obj;
        if (idTipoViajeAvion == null) {
            if (other.idTipoViajeAvion != null)
                return false;
        } else if (!idTipoViajeAvion.equals(other.idTipoViajeAvion))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "TipoViaje [idTipoViajeAvion=" + idTipoViajeAvion + ", tipoViajeAvion=" + tipoViajeAvion + "]";
    }

}
