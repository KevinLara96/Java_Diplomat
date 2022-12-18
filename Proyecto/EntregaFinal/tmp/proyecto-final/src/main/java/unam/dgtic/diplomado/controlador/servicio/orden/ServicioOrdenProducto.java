package unam.dgtic.diplomado.controlador.servicio.orden;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import unam.dgtic.diplomado.controlador.repositorio.orden.RepositorioOrdenProducto;
import unam.dgtic.diplomado.modelo.entidades.orden.OrdenProducto;

public class ServicioOrdenProducto implements RepositorioOrdenProducto {

    protected EntityManager em;

    public ServicioOrdenProducto(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Iterable<OrdenProducto> obtenerOrdenesProductos() {
        Query query = em.createQuery("SELECT op from OrdenProducto op\n" +
                "ORDER BY op.idOrdenProducto");

        Iterable<OrdenProducto> ordenes = (Iterable<OrdenProducto>) query.getResultList();
        return ordenes;
    }

    @Override
    @SuppressWarnings("unchecked")
    public OrdenProducto obtenerOrdenProducto(Integer idOrden, Integer idProducto) {
        Query query = em.createQuery("SELECT op from OrdenProducto op\n");

        return (OrdenProducto) query.getResultList().get(0);
    }

    @Override
    public void guardarOrdenProducto(OrdenProducto orden) throws Exception {
        em.getTransaction().begin();
        em.persist(orden);
        em.flush();
        em.getTransaction().commit();
    }

    @Override
    public void eliminarOrdenProducto(Integer idOrden, Integer idProducto) {
        OrdenProducto orden = obtenerOrdenProducto(idOrden, idProducto);
        if (orden != null) {
            em.getTransaction().begin();
            em.remove(orden);
            em.flush();
            em.getTransaction().commit();
        }
    }

    @Override
    public void actualizarOrdenProducto(OrdenProducto ordenParam) {
        OrdenProducto orden = obtenerOrdenProducto(ordenParam.getIdOrdenProducto());
        if (orden != null) {
            em.getTransaction().begin();
            orden = em.merge(ordenParam);
            em.getTransaction().commit();
        }

    }

}
