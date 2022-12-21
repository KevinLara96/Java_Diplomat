package unam.dgtic.diplomado.controlador.servicio.agencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import unam.dgtic.diplomado.controlador.repositorio.agencia.RepositorioAgencia;
import unam.dgtic.diplomado.modelo.beans.agencia.AgenciaBean;
import unam.dgtic.diplomado.modelo.entidades.agencia.Agencia;

public class ServicioAgencia implements RepositorioAgencia {

    protected EntityManager em;

    public ServicioAgencia() {

    }

    public ServicioAgencia(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Iterable<Agencia> obtenerAgencias() {
        Query query = em.createQuery("SELECT a from AgenciaBean a\n" +
                "ORDER BY a.idAgencia");

        return (Iterable<Agencia>) query.getResultList();
    }

    @Override
    public AgenciaBean obtenerAgencia(Integer idAgencia) {
        return em.find(AgenciaBean.class, idAgencia);
    }

    @Override
    public void guardarAgencia(AgenciaBean agencia) throws Exception {
        em.getTransaction().begin();
        em.persist(agencia);
        em.flush();
        em.getTransaction().commit();
    }

    @Override
    public void eliminarAgencia(Integer idAgencia) {
        AgenciaBean agencia = obtenerAgencia(idAgencia);
        if (agencia != null) {
            em.getTransaction().begin();
            em.remove(agencia);
            em.flush();
            em.getTransaction().commit();
        }

    }

    @Override
    public void actualizarAgencia(AgenciaBean agenciaParam) {
        AgenciaBean agencia = obtenerAgencia(agenciaParam.getIdAgencia());

        if (agencia != null) {
            em.getTransaction().begin();
            agencia = em.merge(agenciaParam);
            em.flush();
            em.getTransaction().commit();
        }
    }
}
