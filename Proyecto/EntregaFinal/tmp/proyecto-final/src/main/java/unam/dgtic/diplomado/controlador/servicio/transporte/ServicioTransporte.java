package unam.dgtic.diplomado.controlador.servicio.transporte;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import unam.dgtic.diplomado.controlador.repositorio.transporte.RepositorioTransporte;
import unam.dgtic.diplomado.modelo.beans.transporte.TransporteBean;

public class ServicioTransporte implements RepositorioTransporte {

    protected EntityManager em;

    public ServicioTransporte(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Iterable<TransporteBean> obtenerTransportes() {
        Query query = em.createQuery("SELECT t from Transporte t\n" +
                "ORDER BY t.idTransporte");

        return (Iterable<TransporteBean>) query.getResultList();
    }

    @Override
    public TransporteBean obtenerTransporte(Integer idTransporte) {
        return em.find(TransporteBean.class, idTransporte);
    }

    @Override
    public void guardarTransporte(TransporteBean transporte) throws Exception {
        em.getTransaction().begin();
        em.persist(transporte);
        em.flush();
        em.getTransaction().commit();
    }

    @Override
    public void eliminarTransporte(Integer idTransporte) {
        TransporteBean transporte = obtenerTransporte(idTransporte);
        if (transporte != null) {
            em.getTransaction().begin();
            em.remove(transporte);
            em.flush();
            em.getTransaction().commit();
        }
    }

    @Override
    public void actualizarTransporte(TransporteBean transporteParam) {
        TransporteBean transporte = obtenerTransporte(transporteParam.getIdTransporte());
        if (transporte != null) {
            em.getTransaction().begin();
            transporte = em.merge(transporteParam);
            em.flush();
            em.getTransaction().commit();
        }

    }
}
