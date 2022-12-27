package unam.dgtic.diplomado.controlador.servicio.producto;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import unam.dgtic.diplomado.controlador.repositorio.producto.RepositorioProducto;
import unam.dgtic.diplomado.modelo.entidades.orden.OrdenEntity;
import unam.dgtic.diplomado.modelo.entidades.producto.ProductoEntity;

public class ServicioProducto implements RepositorioProducto {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("proyectofinal");
    private EntityManager em;

    public ServicioProducto() {
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<ProductoEntity> obtenerProductos() {
        em = emf.createEntityManager();
        try {
            Query query = em.createQuery("SELECT p from ProductoEntity p\n" +
                    "ORDER BY p.idProducto");

            return query.getResultList();
        } finally {
            em.close();
        }

    }

    @Override
    public ProductoEntity obtenerProducto(Integer idProducto) {
        em = emf.createEntityManager();

        try {
            ProductoEntity producto = em.find(ProductoEntity.class, idProducto);

            return producto;
        } finally {
            em.close();
        }
    }

    @Override
    public boolean guardarProducto(ProductoEntity producto) throws Exception {
        em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(producto);
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
    public boolean eliminarProducto(Integer idProducto) throws Exception {
        em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            ProductoEntity producto = em.find(ProductoEntity.class, idProducto);
            em.remove(producto);
            em.flush();
            em.getTransaction().commit();
            if (producto != null) {
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
    public boolean actualizarProducto(ProductoEntity productoParam) throws Exception {
        em = emf.createEntityManager();

        try {

            em.getTransaction().begin();
            em.merge(productoParam);
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
    public List<OrdenEntity> productoJoinOrden(Integer idProducto) {
        em = emf.createEntityManager();

        try {
            Query query = em.createQuery("SELECT o from OrdenEntity o\n" +
                    "JOIN OrdenProductoEntity op on o.idOrden = op.idOrden\n" +
                    "JOIN ProductoEntity p on op.idProducto = p.idProducto\n" +
                    "WHERE p.idProducto = " + idProducto);
            return (List<OrdenEntity>) query.getResultList();

        } finally {
            em.close();
        }
    }
}
