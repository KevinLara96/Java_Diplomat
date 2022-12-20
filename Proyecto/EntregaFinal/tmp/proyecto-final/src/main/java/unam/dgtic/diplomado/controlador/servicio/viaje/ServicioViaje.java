package unam.dgtic.diplomado.controlador.servicio.viaje;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import unam.dgtic.diplomado.controlador.repositorio.viaje.RepositorioViaje;
import unam.dgtic.diplomado.modelo.beans.viaje.ViajeBean;

public class ServicioViaje implements RepositorioViaje {

    protected EntityManager em;

    public ServicioViaje(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Iterable<ViajeBean> obtenerViajes() {
        Query query = em.createQuery("SELECT v from Viaje v\n" +
                "ORDER BY v.idViaje");

        return (Iterable<ViajeBean>) query.getResultList();
    }

    @Override
    public ViajeBean obtenerViaje(Integer idViaje) {
        return em.find(ViajeBean.class, idViaje);
    }

    @Override
    public void guardarViaje(ViajeBean viaje) throws Exception {
        em.getTransaction().begin();
        em.persist(viaje);
        em.flush();
        em.getTransaction().commit();
    }

    @Override
    public void eliminarViaje(Integer idViaje) {
        ViajeBean viaje = obtenerViaje(idViaje);
        if (viaje != null) {
            em.getTransaction().begin();
            em.remove(viaje);
            em.flush();
            em.getTransaction().commit();
        }
    }

    @Override
    public void actualizarViaje(ViajeBean viajeParam) {
        ViajeBean viaje = obtenerViaje(viajeParam.getIdViaje());
        if (viaje != null) {
            em.getTransaction().begin();
            viaje = em.merge(viajeParam);
            em.getTransaction().commit();
        }

    }
}
