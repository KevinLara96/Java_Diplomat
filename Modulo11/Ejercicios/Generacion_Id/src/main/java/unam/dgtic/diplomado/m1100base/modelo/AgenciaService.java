package unam.dgtic.diplomado.m1100base.modelo;

import java.util.Collection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import unam.dgtic.diplomado.m1100base.dominio.agencia.Agencia;

public class AgenciaService {

    protected EntityManager em;

    public AgenciaService(EntityManager em) {
        this.em = em;
    }

    public Agencia findAgencia(Integer idAgencia) {
        return em.find(Agencia.class, idAgencia);
    }

    @SuppressWarnings("unchecked")
    public Collection<Agencia> findAllAgencias() {
        Query query = em.createQuery("SELECT a FROM Agencia a");

        return (Collection<Agencia>) query.getResultList();
    }

    public Agencia createAgencia(Integer idAgencia, String nombreAgencia, String ubicacion) {
        Agencia agencia = new Agencia();
        agencia.setIdAgencia(idAgencia);
        agencia.setNombreAgencia(nombreAgencia);
        agencia.setUbicacion(ubicacion);

        em.getTransaction().begin();
        em.persist(agencia);
        em.getTransaction().commit();

        return agencia;
    }

    public void removeAgencia(Integer idAgencia) {
        Agencia agencia = findAgencia(idAgencia);
        if (agencia != null) {
            em.getTransaction().begin();
            em.remove(agencia);
            em.getTransaction().commit();
        }
    }

    public Agencia cambiarNombreAgencia(Integer idAgencia, String nuevoNombreAgencia) {
        Agencia agencia = findAgencia(idAgencia);
        if (agencia != null) {
            em.getTransaction().begin();
            agencia.setNombreAgencia(nuevoNombreAgencia);
            em.getTransaction().commit();
        }
        return agencia;
    }
}