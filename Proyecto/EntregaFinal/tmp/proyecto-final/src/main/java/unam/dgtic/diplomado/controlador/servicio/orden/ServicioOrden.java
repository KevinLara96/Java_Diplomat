package unam.dgtic.diplomado.controlador.servicio.orden;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import unam.dgtic.diplomado.controlador.repositorio.orden.RepositorioOrden;
import unam.dgtic.diplomado.modelo.beans.orden.Orden;

public class ServicioOrden implements RepositorioOrden {

    protected EntityManager em;

    public ServicioOrden(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Iterable<Orden> obtenerOrdenes() {
        Query query = em.createQuery("SELECT o from Orden o\n" +
                "ORDER BY o.idOrden");

        Iterable<Orden> ordenes = (Iterable<Orden>) query.getResultList();
        return ordenes;
    }

    @Override
    public Orden obtenerOrden(Integer idOrden) {
        return em.find(Orden.class, idOrden);
    }

    @Override
    public void guardarOrden(Orden orden) throws Exception {
        em.getTransaction().begin();
        em.persist(orden);
        em.flush();
        em.getTransaction().commit();
    }

    @Override
    public void actualizarOrden(Orden ordenParam) {
        Orden orden = obtenerOrden(ordenParam.getIdOrden());
        if (orden != null) {
            em.getTransaction().begin();
            orden = em.merge(ordenParam);
            em.getTransaction().commit();
        }

    }

    @SuppressWarnings("unchecked")
    public Iterable<Orden> ordenJoinProducto(Integer idOrden) {
        Query query = em.createQuery("SELECT p from Producto p\n" +
                "JOIN OrdenProducto op on p.idProducto = op.idProducto\n" +
                "JOIN Orden o on o.idOrden = op.idOrden\n" +
                "WHERE o.idOrden = " + idOrden);
        return (Iterable<Orden>) query.getResultList();
    }
}
