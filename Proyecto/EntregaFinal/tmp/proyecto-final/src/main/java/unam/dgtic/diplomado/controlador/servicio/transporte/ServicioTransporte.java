package unam.dgtic.diplomado.controlador.servicio.transporte;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import unam.dgtic.diplomado.controlador.repositorio.transporte.RepositorioTransporte;
import unam.dgtic.diplomado.modelo.entidades.transporte.TransporteEntity;

public class ServicioTransporte implements RepositorioTransporte {

    protected EntityManager em;

    public ServicioTransporte(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Iterable<TransporteEntity> obtenerTransportes() {
        Query query = em.createQuery("SELECT t from Transporte t\n" +
                "ORDER BY t.idTransporte");

        return (Iterable<TransporteEntity>) query.getResultList();
    }

    @Override
    public TransporteEntity obtenerTransporte(Integer idTransporte) {
        return em.find(TransporteEntity.class, idTransporte);
    }

    @Override
    public void guardarTransporte(TransporteEntity transporte) throws Exception {
        em.getTransaction().begin();
        em.persist(transporte);
        em.flush();
        em.getTransaction().commit();
    }

    @Override
    public void eliminarTransporte(Integer idTransporte) {
        TransporteEntity transporte = obtenerTransporte(idTransporte);
        if (transporte != null) {
            em.getTransaction().begin();
            em.remove(transporte);
            em.flush();
            em.getTransaction().commit();
        }
    }

    @Override
    public void actualizarTransporte(TransporteEntity transporteParam) {
        TransporteEntity transporte = obtenerTransporte(transporteParam.getIdTransporte());
        if (transporte != null) {
            em.getTransaction().begin();
            transporte = em.merge(transporteParam);
            em.flush();
            em.getTransaction().commit();
        }

    }
}
