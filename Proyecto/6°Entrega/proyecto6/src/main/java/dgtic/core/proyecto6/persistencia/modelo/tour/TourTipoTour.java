package dgtic.core.proyecto6.persistencia.modelo.tour;

public class TourTipoTour {

    private Integer idTour;
    private Integer idTipoTour;

    public TourTipoTour() {

    }

    public TourTipoTour(Integer idTour, Integer idTipoTour) {
        this.idTour = idTour;
        this.idTipoTour = idTipoTour;
    }

    public Integer getIdTour() {
        return idTour;
    }

    public void setIdTour(Integer idTour) {
        this.idTour = idTour;
    }

    public Integer getIdTipoTour() {
        return idTipoTour;
    }

    public void setIdTipoTour(Integer idTipoTour) {
        this.idTipoTour = idTipoTour;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idTour == null) ? 0 : idTour.hashCode());
        result = prime * result + ((idTipoTour == null) ? 0 : idTipoTour.hashCode());
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
        TourTipoTour other = (TourTipoTour) obj;
        if (idTour == null) {
            if (other.idTour != null)
                return false;
        } else if (!idTour.equals(other.idTour))
            return false;
        if (idTipoTour == null) {
            if (other.idTipoTour != null)
                return false;
        } else if (!idTipoTour.equals(other.idTipoTour))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "TourTipoTour [idTour=" + idTour + ", idTipoTour=" + idTipoTour + "]";
    }

}
