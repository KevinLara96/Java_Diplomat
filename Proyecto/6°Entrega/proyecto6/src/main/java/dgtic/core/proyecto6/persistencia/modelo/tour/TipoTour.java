package dgtic.core.proyecto6.persistencia.modelo.tour;

public class TipoTour {

    private Integer idTipoTour;
    private String tipoTour;

    public TipoTour() {

    }

    public TipoTour(Integer idTipoTour, String tipoTour) {
        this.idTipoTour = idTipoTour;
        this.tipoTour = tipoTour;
    }

    public Integer getIdTipoTour() {
        return idTipoTour;
    }

    public void setIdTipoTour(Integer idTipoTour) {
        this.idTipoTour = idTipoTour;
    }

    public String getTipoTour() {
        return tipoTour;
    }

    public void setTipoTour(String tipoTour) {
        this.tipoTour = tipoTour;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idTipoTour == null) ? 0 : idTipoTour.hashCode());
        result = prime * result + ((tipoTour == null) ? 0 : tipoTour.hashCode());
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
        TipoTour other = (TipoTour) obj;
        if (idTipoTour == null) {
            if (other.idTipoTour != null)
                return false;
        } else if (!idTipoTour.equals(other.idTipoTour))
            return false;
        if (tipoTour == null) {
            if (other.tipoTour != null)
                return false;
        } else if (!tipoTour.equals(other.tipoTour))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "TipoTour [idTipoTour=" + idTipoTour + ", tipoTour=" + tipoTour + "]";
    }

}
