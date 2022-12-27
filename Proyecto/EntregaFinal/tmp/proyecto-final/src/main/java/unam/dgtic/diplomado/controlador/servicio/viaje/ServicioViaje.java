package unam.dgtic.diplomado.controlador.servicio.viaje;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import unam.dgtic.diplomado.controlador.repositorio.viaje.RepositorioViaje;
import unam.dgtic.diplomado.modelo.entidades.viaje.ViajeEntity;

public class ServicioViaje implements RepositorioViaje {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("proyectofinal");
    private EntityManager em;

    public ServicioViaje() {
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<ViajeEntity> obtenerViajes() {
        em = emf.createEntityManager();

        try {
            Query query = em.createQuery("SELECT v from ViajeEntity v\n" +
                    "ORDER BY v.idViaje");

            return query.getResultList();

        } finally {
            em.close();
        }
    }

    @Override
    public ViajeEntity obtenerViaje(Integer idViaje) {
        em = emf.createEntityManager();

        try {
            ViajeEntity viajeEntity = em.find(ViajeEntity.class, idViaje);

            return viajeEntity;
        } finally {
            em.close();
        }
    }

    @Override
    public boolean guardarViaje(ViajeEntity viaje) throws Exception {
        em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(viaje);
            em.flush();
            em.getTransaction().commit();

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            em.close();
        }

        return true;
    }

    @Override
    public boolean eliminarViaje(Integer idViaje) throws Exception {
        em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            ViajeEntity viaje = em.find(ViajeEntity.class, idViaje);
            em.remove(viaje);
            em.flush();
            em.getTransaction().commit();

            if (viaje != null) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public boolean actualizarViaje(ViajeEntity viajeParam) throws Exception {
        em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.merge(viajeParam);
            em.flush();
            em.getTransaction().commit();

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            em.close();
        }

        return true;
    }
}
