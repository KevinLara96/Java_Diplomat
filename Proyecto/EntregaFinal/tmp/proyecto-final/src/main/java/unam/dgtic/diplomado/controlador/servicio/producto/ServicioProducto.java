package unam.dgtic.diplomado.controlador.servicio.producto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import unam.dgtic.diplomado.controlador.repositorio.producto.RepositorioProducto;
import unam.dgtic.diplomado.modelo.beans.orden.OrdenBean;
import unam.dgtic.diplomado.modelo.beans.producto.ProductoBean;

public class ServicioProducto implements RepositorioProducto {

    protected EntityManager em;

    public ServicioProducto(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Iterable<ProductoBean> obtenerProductos() {
        Query query = em.createQuery("SELECT p from Producto p\n" +
                "ORDER BY p.idProducto");

        Iterable<ProductoBean> productos = (Iterable<ProductoBean>) query.getResultList();
        return productos;
    }

    @Override
    public ProductoBean obtenerProducto(Integer idProducto) {
        return em.find(ProductoBean.class, idProducto);
    }

    @Override
    public void guardarProducto(ProductoBean producto) throws Exception {
        em.getTransaction().begin();
        em.persist(producto);
        em.flush();
        em.getTransaction().commit();
    }

    @Override
    public void eliminarProducto(Integer idProducto) {
        ProductoBean producto = obtenerProducto(idProducto);
        if (producto != null) {
            em.getTransaction().begin();
            em.remove(producto);
            em.flush();
            em.getTransaction().commit();
        }
    }

    @Override
    public void actualizarProducto(ProductoBean productoParam) {
        ProductoBean producto = obtenerProducto(productoParam.getIdProducto());
        if (producto != null) {
            em.getTransaction().begin();
            producto = em.merge(productoParam);
            em.getTransaction().commit();
        }

    }

    @SuppressWarnings("unchecked")
    public Iterable<OrdenBean> productoJoinCliente(Integer idProducto) {
        Query query = em.createQuery("SELECT o from Orden o\n" +
                "JOIN OrdenProducto op on o.idOrden = op.idOrden\n" +
                "JOIN Producto p on op.idProducto = p.idProducto\n" +
                "WHERE p.idProducto = " + idProducto);
        return (Iterable<OrdenBean>) query.getResultList();
    }
}
