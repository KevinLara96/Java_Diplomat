package dgtic.modelo.entidades.agencia.asignaciones;

import javax.persistence.*;

import dgtic.modelo.entidades.agencia.Agencia;

@Entity
@Table(name = "conductor_autobus")
public class ConductorAutobus {
    private Integer idAsignacionAutobus;
    private Integer idConductor;
    private Integer idAutobus;
    private Agencia agencia;

    @Id
    @Column(name = "idAsignacionAutobus")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getIdAsignacionAutobus() {
        return idAsignacionAutobus;
    }

    public void setIdAsignacionAutobus(Integer idAsignacionAutobus) {
        this.idAsignacionAutobus = idAsignacionAutobus;
    }

    @Column(name = "idConductor")
    public Integer getIdConductor() {
        return idConductor;
    }

    public void setIdConductor(Integer idConductor) {
        this.idConductor = idConductor;
    }

    @Column(name = "idAutobus")
    public Integer getIdAutobus() {
        return idAutobus;
    }

    public void setIdAutobus(Integer idAutobus) {
        this.idAutobus = idAutobus;
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
