package unam.dgtic.diplomado.controlador.rest.agencia;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import unam.dgtic.diplomado.controlador.servicio.agencia.ServicioAgencia;
import unam.dgtic.diplomado.modelo.beans.agencia.AgenciaBean;

@Stateless
public class AgenciaEJB {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("proyectofinal");
    private EntityManager em = emf.createEntityManager();
    private ServicioAgencia servicioAgencia = new ServicioAgencia(em);

    public Iterable<AgenciaBean> getAgencias() {
        return servicioAgencia.obtenerAgencias();
    }

    public AgenciaBean getAgencia(Integer idAgencia) {
        return servicioAgencia.obtenerAgencia(idAgencia);
    }

    public boolean postAgencia(AgenciaBean agencia) {
        try {
            servicioAgencia.guardarAgencia(agencia);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void putAgencia(AgenciaBean agencia) {
        servicioAgencia.actualizarAgencia(agencia);
    }

    public void deleteAgencia(Integer idAgencia) {
        servicioAgencia.eliminarAgencia(idAgencia);
    }

    public void destroy() {
        this.em.close();
    }
}
