package unam.dgtic.diplomado.controlador.rest.agencia;

import java.io.Serializable;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import unam.dgtic.diplomado.modelo.beans.agencia.AgenciaBean;

@Named
@SessionScoped
public class RestAgencia implements Serializable {

    @EJB
    private AgenciaEJB agenciaEJB;
    private int idAgencia;

    public Iterable<AgenciaBean> getAgencias() {
        return agenciaEJB.getAgencias();
    }

    public AgenciaBean getAgencia(Integer idAgencia) {
        AgenciaBean tmp = agenciaEJB.getAgencia(idAgencia);
        this.idAgencia = tmp.getIdAgencia();
        return tmp;
    }

    public Boolean postAgencia(AgenciaBean agencia) {
        return agenciaEJB.postAgencia(agencia);
    }

    public void putAgencia(AgenciaBean agencia) {
        agenciaEJB.putAgencia(agencia);
    }

    public void deleteAgencia(Integer idAgencia) {
        agenciaEJB.deleteAgencia(idAgencia);
    }

    public int getIdAgencia() {
        return idAgencia;
    }

    public void setIdAgencia(int idAgencia) {
        this.idAgencia = idAgencia;
    }

    public void destroy() {
        agenciaEJB.destroy();
    }
}
