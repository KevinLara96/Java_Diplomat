package mx.unam.diplomado.modelo.entidades.agencia.asignaciones;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.Entity;
//import javax.persistence.Table;

import mx.unam.diplomado.modelo.entidades.agencia.Agencia;

//@Entity
//@Table(name = "conductor_autobus")
public class ConductorAutobus {

    @Id
    private Integer idAsignacionAutobus;
    private Integer idConductor;
    private Integer idAutobus;

    @ManyToOne
    @JoinColumn(name = "idAgencia")
    private Agencia agencia;

    public Integer getIdAsignacionAutobus() {
        return idAsignacionAutobus;
    }

    public void setIdAsignacionAutobus(Integer idAsignacionAutobus) {
        this.idAsignacionAutobus = idAsignacionAutobus;
    }

    public Integer getIdConductor() {
        return idConductor;
    }

    public void setIdConductor(Integer idConductor) {
        this.idConductor = idConductor;
    }

    public Integer getIdAutobus() {
        return idAutobus;
    }

    public void setIdAutobus(Integer idAutobus) {
        this.idAutobus = idAutobus;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

}
