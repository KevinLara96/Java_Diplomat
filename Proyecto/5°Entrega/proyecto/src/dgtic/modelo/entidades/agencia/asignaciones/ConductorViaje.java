package dgtic.modelo.entidades.agencia.asignaciones;

import dgtic.modelo.entidades.agencia.Agencia;

public class ConductorViaje {
    private Integer idAsignacionViaje;
    private Integer idConductor;
    private Integer idViaje;
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
