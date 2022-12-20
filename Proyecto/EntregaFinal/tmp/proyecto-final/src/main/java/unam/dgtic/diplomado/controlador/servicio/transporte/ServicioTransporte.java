package unam.dgtic.diplomado.controlador.servicio.transporte;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import unam.dgtic.diplomado.controlador.repositorio.transporte.RepositorioTransporte;
import unam.dgtic.diplomado.modelo.beans.transporte.Transporte;

public class ServicioTransporte implements RepositorioTransporte {

    protected EntityManager em;

    public ServicioTransporte(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Iterable<Transporte> obtenerTransportes() {
        Query query = em.createQuery("SELECT t from Transporte t\n" +
                "ORDER BY t.idTransporte");

        return (Iterable<Transporte>) query.getResultList();
    }

    @Override
    public Transporte obtenerTransporte(Integer idTransporte) {
        return em.find(Transporte.class, idTransporte);
    }

    @Override
    public void guardarTransporte(Transporte transporte) throws Exception {
        em.getTransaction().begin();
        em.persist(transporte);
        em.flush();
        em.getTransaction().commit();
    }

    @Override
    public void eliminarTransporte(Integer idTransporte) {
        Transporte transporte = obtenerTransporte(idTransporte);
        if (transporte != null) {
            em.getTransaction().begin();
            em.remove(transporte);
            em.flush();
            em.getTransaction().commit();
        }
    }

    @Override
    public void actualizarTransporte(Transporte transporteParam) {
        Transporte transporte = obtenerTransporte(transporteParam.getIdTransporte());
        if (transporte != null) {
            em.getTransaction().begin();
            transporte = em.merge(transporteParam);
            em.flush();
            em.getTransaction().commit();
        }

    }
}
