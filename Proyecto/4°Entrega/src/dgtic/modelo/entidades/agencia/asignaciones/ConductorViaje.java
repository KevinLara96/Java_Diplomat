package dgtic.modelo.entidades.agencia.asignaciones;

import javax.persistence.*;

import dgtic.modelo.entidades.agencia.Agencia;

@Entity
@Table(name = "conductor_viaje")
public class ConductorViaje {
    private Integer idAsignacionViaje;
    private Integer idConductor;
    private Integer idViaje;
    private Agencia agencia;

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

    @ManyToOne(targetEntity = Agencia.class, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "idAgencia", nullable = false)
    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

}
