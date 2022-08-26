package dgtic.modelo.entidades.agencia.asignaciones;

import javax.persistence.*;

@Entity
@Table(name = "conductor_viaje")
public class ConductorViaje {
    private Integer idAsignacionViaje;
    private Integer idConductor;
    private Integer idViaje;

    @Id
    @Column(name = "idAsignacionViaje")
    public Integer getIdAsignacionViaje() {
        return idAsignacionViaje;
    }

    public void setIdAsignacionViaje(Integer idAsignacionViaje) {
        this.idAsignacionViaje = idAsignacionViaje;
    }

    @Column(name = "idConductor")
    public Integer getIdConductor() {
        return idConductor;
    }

    public void setIdConductor(Integer idConductor) {
        this.idConductor = idConductor;
    }

    @Column(name = "idViaje")
    public Integer getIdViaje() {
        return idViaje;
    }

    public void setIdViaje(Integer idViaje) {
        this.idViaje = idViaje;
    }

}
