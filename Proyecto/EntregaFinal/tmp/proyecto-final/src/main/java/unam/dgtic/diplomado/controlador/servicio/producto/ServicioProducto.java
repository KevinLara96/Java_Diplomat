package unam.dgtic.diplomado.controlador.servicio.producto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import unam.dgtic.diplomado.controlador.repositorio.producto.RepositorioProducto;
import unam.dgtic.diplomado.modelo.entidades.orden.Orden;
import unam.dgtic.diplomado.modelo.entidades.producto.Producto;

public class ServicioProducto implements RepositorioProducto {

    protected EntityManager em;

    public ServicioProducto(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Iterable<Producto> obtenerProductos() {
        Query query = em.createQuery("SELECT p from Producto p\n" +
                "ORDER BY p.idProducto");

        Iterable<Producto> productos = (Iterable<Producto>) query.getResultList();
        return productos;
    }

    @Override
    public Producto obtenerProducto(Integer idProducto) {
        return em.find(Producto.class, idProducto);
    }

    @Override
    public void guardarProducto(Producto producto) throws Exception {
        em.getTransaction().begin();
        em.persist(producto);
        em.flush();
        em.getTransaction().commit();
    }

    @Override
    public void eliminarProducto(Integer idProducto) {
        Producto producto = obtenerProducto(idProducto);
        if (producto != null) {
            em.getTransaction().begin();
            em.remove(producto);
            em.flush();
            em.getTransaction().commit();
        }
    }

    @Override
    public void actualizarProducto(Producto productoParam) {
        Producto producto = obtenerProducto(productoParam.getIdProducto());
        if (producto != null) {
            em.getTransaction().begin();
            producto = em.merge(productoParam);
            em.getTransaction().commit();
        }

    }

    @SuppressWarnings("unchecked")
    public Iterable<Orden> productoJoinCliente(Integer idProducto) {
        Query query = em.createQuery("SELECT o from Orden o\n" +
                "JOIN OrdenProducto op on o.idOrden = op.idOrden\n" +
                "JOIN Producto p on op.idProducto = p.idProducto\n" +
                "WHERE p.idProducto = " + idProducto);
        return (Iterable<Orden>) query.getResultList();
    }
}
