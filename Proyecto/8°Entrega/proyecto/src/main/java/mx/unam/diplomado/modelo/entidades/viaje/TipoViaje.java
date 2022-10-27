package mx.unam.diplomado.modelo.entidades.viaje;

import javax.persistence.Id;
import javax.persistence.OneToOne;
//import javax.persistence.Table;
//import javax.persistence.Entity;

//@Entity
//@Table(name = "tipoViaje")
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