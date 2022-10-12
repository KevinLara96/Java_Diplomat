package unam.dgtic.core.proyecto7.modelo.viaje;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tipoTour")
public class TipoTour {

    @Id
    private Integer idTipoTour;

    @OneToOne(mappedBy = "tipoTour")
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

}
