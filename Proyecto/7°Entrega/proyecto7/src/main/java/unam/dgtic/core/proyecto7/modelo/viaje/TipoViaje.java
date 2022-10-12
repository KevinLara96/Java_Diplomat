package unam.dgtic.core.proyecto7.modelo.viaje;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tipoViaje")
public class TipoViaje {

    @Id
    private Integer idTipoViaje;

    @OneToOne(mappedBy = "tipoViaje")
    private Viaje viaje;

    private String tipoViaje;

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

}