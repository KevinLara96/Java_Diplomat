package unam.dgtic.diplomado.controlador.servicio.viaje;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import unam.dgtic.diplomado.controlador.repositorio.viaje.RepositorioTipoViajeAvion;
import unam.dgtic.diplomado.modelo.entidades.viaje.TipoViajeAvionEntity;

public class ServicioTipoViajeAvion implements RepositorioTipoViajeAvion {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("proyectofinal");
    private EntityManager em;

    public ServicioTipoViajeAvion() {
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<TipoViajeAvionEntity> obtenerTiposViajeAvion() {
        em = emf.createEntityManager();

        try {
            Query query = em.createQuery("SELECT tv from TipoViajeAvionEntity tv\n" +
                    "ORDER BY tv.idTipoViajeAvion");

            return query.getResultList();

        } finally {
            em.close();
        }
    }

    @Override
    public TipoViajeAvionEntity obtenerTipoViajeAvion(Integer idTipoViajeAvion) {
        em = emf.createEntityManager();

        try {
            return em.find(TipoViajeAvionEntity.class, idTipoViajeAvion);
        } finally {
            em.close();
        }
    }

    @Override
    public boolean guardarTipoViajeAvion(TipoViajeAvionEntity viaje) throws Exception {
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
    public boolean eliminarTipoViajeAvion(Integer idTipoViajeAvion) throws Exception {
        em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            TipoViajeAvionEntity tipoViajeAvion = em.find(TipoViajeAvionEntity.class, idTipoViajeAvion);
            em.remove(tipoViajeAvion);
            em.flush();
            em.getTransaction().commit();
            if (tipoViajeAvion != null) {
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
    public boolean actualizarTipoViajeAvion(TipoViajeAvionEntity viajeParam) throws Exception {
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
