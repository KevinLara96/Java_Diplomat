package unam.dgtic.diplomado.controlador.servicio.agencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import unam.dgtic.diplomado.controlador.repositorio.agencia.RepositorioAgencia;
import unam.dgtic.diplomado.modelo.entidades.agencia.Agencia;

public class ServicioAgencia implements RepositorioAgencia {

    protected EntityManager em;

    public ServicioAgencia(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Iterable<Agencia> obtenerAgencias() {
        Query query = em.createQuery("SELECT a from Agencia a\n" +
                "ORDER BY a.idAgencia");

        return (Iterable<Agencia>) query.getResultList();
    }

    @Override
    public Agencia obtenerAgencia(Integer idAgencia) {
        return em.find(Agencia.class, idAgencia);
    }

    @Override
    public void guardarAgencia(Agencia agencia) throws Exception {
        em.getTransaction().begin();
        em.persist(agencia);
        em.flush();
        em.getTransaction().commit();
    }

    @Override
    public void eliminarAgencia(Integer idAgencia) {
        Agencia agencia = obtenerAgencia(idAgencia);
        if (agencia != null) {
            em.getTransaction().begin();
            em.remove(agencia);
            em.flush();
            em.getTransaction().commit();
        }

    }

    @Override
    public void actualizarAgencia(Agencia agenciaParam) {
        Agencia agencia = obtenerAgencia(agenciaParam.getIdAgencia());

        if (agencia != null) {
            em.getTransaction().begin();
            agencia = em.merge(agenciaParam);
            em.flush();
            em.getTransaction().commit();
        }
    }
}
