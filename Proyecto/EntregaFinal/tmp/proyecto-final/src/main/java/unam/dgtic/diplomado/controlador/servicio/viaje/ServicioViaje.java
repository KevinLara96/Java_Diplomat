package unam.dgtic.diplomado.controlador.servicio.viaje;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import unam.dgtic.diplomado.controlador.repositorio.viaje.RepositorioViaje;
import unam.dgtic.diplomado.modelo.beans.viaje.Viaje;

public class ServicioViaje implements RepositorioViaje {

    protected EntityManager em;

    public ServicioViaje(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Iterable<Viaje> obtenerViajes() {
        Query query = em.createQuery("SELECT v from Viaje v\n" +
                "ORDER BY v.idViaje");

        return (Iterable<Viaje>) query.getResultList();
    }

    @Override
    public Viaje obtenerViaje(Integer idViaje) {
        return em.find(Viaje.class, idViaje);
    }

    @Override
    public void guardarViaje(Viaje viaje) throws Exception {
        em.getTransaction().begin();
        em.persist(viaje);
        em.flush();
        em.getTransaction().commit();
    }

    @Override
    public void eliminarViaje(Integer idViaje) {
        Viaje viaje = obtenerViaje(idViaje);
        if (viaje != null) {
            em.getTransaction().begin();
            em.remove(viaje);
            em.flush();
            em.getTransaction().commit();
        }
    }

    @Override
    public void actualizarViaje(Viaje viajeParam) {
        Viaje viaje = obtenerViaje(viajeParam.getIdViaje());
        if (viaje != null) {
            em.getTransaction().begin();
            viaje = em.merge(viajeParam);
            em.getTransaction().commit();
        }

    }
}
