package unam.dgtic.diplomado.controlador.servicio.transporte;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import unam.dgtic.diplomado.controlador.repositorio.transporte.RepositorioTransporte;
import unam.dgtic.diplomado.modelo.entidades.transporte.TransporteEntity;

public class ServicioTransporte implements RepositorioTransporte {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("proyectofinal");
    private EntityManager em;

    public ServicioTransporte() {
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<TransporteEntity> obtenerTransportes() {
        em = emf.createEntityManager();

        try {

            Query query = em.createQuery("SELECT t from TransporteEntity t\n" +
                    "ORDER BY t.idTransporte");

            return query.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public TransporteEntity obtenerTransporte(Integer idTransporte) {
        em = emf.createEntityManager();

        try {
            TransporteEntity transporteEntity = em.find(TransporteEntity.class, idTransporte);

            return transporteEntity;
        } finally {
            em.close();
        }
    }

    @Override
    public boolean guardarTransporte(TransporteEntity transporte) throws Exception {
        em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(transporte);
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
    public boolean eliminarTransporte(Integer idTransporte) throws Exception {
        em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            TransporteEntity transporteEntity = em.find(TransporteEntity.class, idTransporte);
            em.remove(transporteEntity);
            em.flush();
            em.getTransaction().commit();

            if (transporteEntity != null) {
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
    public boolean actualizarTransporte(TransporteEntity transporteParam) throws Exception {
        em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.merge(transporteParam);
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
