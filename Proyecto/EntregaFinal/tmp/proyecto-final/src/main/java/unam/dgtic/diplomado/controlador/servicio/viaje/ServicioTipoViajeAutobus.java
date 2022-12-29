package unam.dgtic.diplomado.controlador.servicio.viaje;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import unam.dgtic.diplomado.controlador.repositorio.viaje.RepositorioTipoViajeAutobus;
import unam.dgtic.diplomado.modelo.entidades.viaje.TipoViajeAutobusEntity;

public class ServicioTipoViajeAutobus implements RepositorioTipoViajeAutobus {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("proyectofinal");
    private EntityManager em;

    public ServicioTipoViajeAutobus() {
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<TipoViajeAutobusEntity> obtenerTiposViajeAutobus() {
        em = emf.createEntityManager();

        try {
            Query query = em.createQuery("SELECT tv from TipoViajeAutobusEntity tv\n" +
                    "ORDER BY tv.idTipoViajeAutobus");

            return query.getResultList();

        } finally {
            em.close();
        }
    }

    @Override
    public TipoViajeAutobusEntity obtenerTipoViajeAutobus(Integer idTipoViajeAutobus) {
        em = emf.createEntityManager();

        try {
            return em.find(TipoViajeAutobusEntity.class, idTipoViajeAutobus);
        } finally {
            em.close();
        }
    }

    @Override
    public boolean guardarTipoViajeAutobus(TipoViajeAutobusEntity viaje) throws Exception {
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
    public boolean eliminarTipoViajeAutobus(Integer idTipoViajeAutobus) throws Exception {
        em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            TipoViajeAutobusEntity tipoViajeAutobus = em.find(TipoViajeAutobusEntity.class, idTipoViajeAutobus);
            em.remove(tipoViajeAutobus);
            em.flush();
            em.getTransaction().commit();
            if (tipoViajeAutobus != null) {
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
    public boolean actualizarTipoViajeAutobus(TipoViajeAutobusEntity viajeParam) throws Exception {
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
