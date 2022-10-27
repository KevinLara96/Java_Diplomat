package mx.unam.diplomado.modelo.entidades.agencia.asignaciones;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//import javax.persistence.Entity;

import mx.unam.diplomado.modelo.entidades.agencia.Agencia;

//@Entity
//@Table(name = "conductor_viaje")
public class ConductorViaje {

    @Id
    private Integer idAsignacionViaje;
    private Integer idConductor;
    private Integer idViaje;

    @ManyToOne
    @JoinColumn(name = "idAgencia")
    private Agencia agencia;

    public Integer getIdAsignacionViaje() {
        return idAsignacionViaje;
    }

    public void setIdAsignacionViaje(Integer idAsignacionViaje) {
        this.idAsignacionViaje = idAsignacionViaje;
    }

    public Integer getIdConductor() {
        return idConductor;
    }

    public void setIdConductor(Integer idConductor) {
        this.idConductor = idConductor;
    }

    public Integer getIdViaje() {
        return idViaje;
    }

    public void setIdViaje(Integer idViaje) {
        this.idViaje = idViaje;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

}
