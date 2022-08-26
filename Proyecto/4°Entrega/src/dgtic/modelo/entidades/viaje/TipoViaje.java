package dgtic.modelo.entidades.viaje;

import javax.persistence.*;

@Entity
@Table(name = "tipoViaje")
public class TipoViaje {
    private Integer idTipoViaje;
    private String tipoViaje;

    @Id
    @Column(name = "idTipoViaje")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getIdTipoViaje() {
        return idTipoViaje;
    }

    public void setIdTipoViaje(Integer idTipoViaje) {
        this.idTipoViaje = idTipoViaje;
    }

    @Column(name = "tipoViaje")
    public String getTipoViaje() {
        return tipoViaje;
    }

    public void setTipoViaje(String tipoViaje) {
        this.tipoViaje = tipoViaje;
    }

}
