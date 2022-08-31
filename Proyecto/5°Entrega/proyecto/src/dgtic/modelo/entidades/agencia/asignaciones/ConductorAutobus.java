package dgtic.modelo.entidades.agencia.asignaciones;

import dgtic.modelo.entidades.agencia.Agencia;

public class ConductorAutobus {
    private Integer idAsignacionAutobus;
    private Integer idConductor;
    private Integer idAutobus;
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
