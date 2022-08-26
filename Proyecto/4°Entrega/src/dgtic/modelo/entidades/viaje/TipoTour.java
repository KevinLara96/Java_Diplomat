package dgtic.modelo.entidades.viaje;

import javax.persistence.*;

@Entity
@Table(name = "tipoTour")
public class TipoTour {
    private Integer idTipoTour;
    private String tipoTour;

    @Id
    @Column(name = "idTipoTour")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getIdTipoTour() {
        return idTipoTour;
    }

    public void setIdTipoTour(Integer idTipoTour) {
        this.idTipoTour = idTipoTour;
    }

    @Column(name = "tipoTour")
    public String getTipoTour() {
        return tipoTour;
    }

    public void setTipoTour(String tipoTour) {
        this.tipoTour = tipoTour;
    }

}
