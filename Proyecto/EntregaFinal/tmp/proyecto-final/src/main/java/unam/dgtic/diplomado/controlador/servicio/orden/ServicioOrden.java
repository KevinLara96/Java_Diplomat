package unam.dgtic.diplomado.controlador.servicio.orden;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import unam.dgtic.diplomado.controlador.repositorio.orden.RepositorioOrden;
import unam.dgtic.diplomado.modelo.entidades.orden.OrdenEntity;

public class ServicioOrden implements RepositorioOrden {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("proyectofinal");
    private EntityManager em;

    public ServicioOrden() {
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<OrdenEntity> obtenerOrdenes() {
        em = emf.createEntityManager();

        try {
            Query query = em.createQuery("SELECT o from OrdenEntity o\n" +
                    "ORDER BY o.idOrden");

            return query.getResultList();

        } finally {
            em.close();
        }
    }

    @Override
    public OrdenEntity obtenerOrden(Integer idOrden) {
        em = emf.createEntityManager();

        try {
            return em.find(OrdenEntity.class, idOrden);

        } finally {
            em.close();
        }
    }

    @Override
    public boolean guardarOrden(OrdenEntity orden) throws Exception {
        em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(orden);
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
    public boolean actualizarOrden(OrdenEntity ordenParam) throws Exception {
        em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.merge(ordenParam);
            em.flush();
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            em.close();
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    public Iterable<OrdenEntity> ordenJoinProducto(Integer idOrden) {
        Query query = em.createQuery("SELECT p from ProductoEntity p\n" +
                "JOIN OrdenProducto op on p.idProducto = op.idProducto\n" +
                "JOIN Orden o on o.idOrden = op.idOrden\n" +
                "WHERE o.idOrden = " + idOrden);
        return (Iterable<OrdenEntity>) query.getResultList();
    }
}
