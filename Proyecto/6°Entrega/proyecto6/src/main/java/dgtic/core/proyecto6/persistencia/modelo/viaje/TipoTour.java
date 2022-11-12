package dgtic.core.proyecto6.persistencia.modelo.viaje;

public class TipoTour {

    private Integer idTipoTour;
    private Viaje viaje;
    private String tipoTour;

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

    public Viaje getViaje() {
        return viaje;
    }

    public void setViaje(Viaje viaje) {
        this.viaje = viaje;
    }

}
