package unam.dgtic.diplomado.modelo.entidades.viaje;

public class TipoViajeAutobus {

    private Integer idTipoViajeAutobus;
    private String tipoViajeAutobus;

    public TipoViajeAutobus() {
    }

    public TipoViajeAutobus(Integer idTipoViajeAutobus, String tipoViajeAutobus) {
        this.idTipoViajeAutobus = idTipoViajeAutobus;
        this.tipoViajeAutobus = tipoViajeAutobus;
    }

    public Integer getIdTipoViaje() {
        return idTipoViajeAutobus;
    }

    public void setIdTipoViaje(Integer idTipoViajeAutobus) {
        this.idTipoViajeAutobus = idTipoViajeAutobus;
    }

    public String getTipoViaje() {
        return tipoViajeAutobus;
    }

    public void setTipoViaje(String tipoViajeAutobus) {
        this.tipoViajeAutobus = tipoViajeAutobus;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idTipoViajeAutobus == null) ? 0 : idTipoViajeAutobus.hashCode());
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
        TipoViajeAutobus other = (TipoViajeAutobus) obj;
        if (idTipoViajeAutobus == null) {
            if (other.idTipoViajeAutobus != null)
                return false;
        } else if (!idTipoViajeAutobus.equals(other.idTipoViajeAutobus))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "TipoViaje [idTipoViajeAutobus=" + idTipoViajeAutobus + ", tipoViajeAutobus=" + tipoViajeAutobus + "]";
    }

}
