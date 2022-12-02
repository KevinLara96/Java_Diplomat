package unam.dgtic.diplomado.m1100base.modelo;

import java.util.Collection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import unam.dgtic.diplomado.m1100base.dominio.viaje.TipoViaje;

public class TipoViajeService {

    protected EntityManager em;

    public TipoViajeService(EntityManager em) {
        this.em = em;
    }

    public TipoViaje findTipoViaje(Integer idTipoViaje) {
        return em.find(TipoViaje.class, idTipoViaje);
    }

    @SuppressWarnings("unchecked")
    public Collection<TipoViaje> findAllTipoViajes() {
        Query query = em.createQuery("SELECT t FROM TipoViaje t");

        return (Collection<TipoViaje>) query.getResultList();
    }

    public TipoViaje createTipoViaje(Integer idTipoViaje, String strTipoViaje) {
        TipoViaje tipoViaje = new TipoViaje();
        tipoViaje.setIdTipoViaje(idTipoViaje);
        tipoViaje.setTipoViaje(strTipoViaje);

        em.getTransaction().begin();
        em.persist(tipoViaje);
        em.getTransaction().commit();

        return tipoViaje;
    }

    public void removeTipoViaje(Integer idTipoViaje) {
        TipoViaje tipoViaje = findTipoViaje(idTipoViaje);
        if (tipoViaje != null) {
            em.getTransaction().begin();
            em.remove(tipoViaje);
            em.getTransaction().commit();
        }
    }

    public TipoViaje cambiarTipoViaje(Integer idTipoViaje, String nuevoTipoViaje) {
        TipoViaje viaje = findTipoViaje(idTipoViaje);
        if (viaje != null) {
            em.getTransaction().begin();
            viaje.setTipoViaje(nuevoTipoViaje);
            em.getTransaction().commit();
        }
        return viaje;
    }
}