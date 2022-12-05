package unam.dgtic.diplomado.m1100base.modelo;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import unam.dgtic.diplomado.m1100base.dominio.cliente.Cliente;
import unam.dgtic.diplomado.m1100base.dominio.cliente.Orden;

public class OrdenService {

    protected EntityManager em;
    @Autowired
    private ClienteService clienteService;

    public OrdenService(EntityManager em) {
        this.em = em;
    }

    public Orden findOrden(Integer idOrden) {
        return em.find(Orden.class, idOrden);
    }

    @SuppressWarnings("unchecked")
    public Collection<Orden> findAllOrdens() {
        Query query = em.createQuery("SELECT o FROM Orden o");

        return (Collection<Orden>) query.getResultList();
    }

    @SuppressWarnings("unchecked")
    public Collection<Orden> findOrdenJoinClientes(Integer idCliente) {
        String query = "SELECT o\n" +
                "FROM Orden o\n" +
                "JOIN ClienteOrden co on o.idOrden = co.idOrden\n" +
                "JOIN Cliente c on co.idCliente = c.idCliente\n" +
                "WHERE c.idCliente = " + idCliente;
        Query queryObj = em.createQuery(query);

        return (Collection<Orden>) queryObj.getResultList();
    }

    public Orden createOrden(Orden nuevaOrden) {
        em.getTransaction().begin();
        em.persist(nuevaOrden);
        em.getTransaction().commit();

        return nuevaOrden;
    }

    public Orden createOrden(Integer idOrden, String fecha, Float pago, String descripcion) {
        Orden orden = new Orden();
        orden.setIdOrden(idOrden);
        orden.setFecha(fecha);
        orden.setPago(pago);
        orden.setDescripcion(descripcion);

        Collection<Cliente> clientes = clienteService.findClientesJoinOrdenes(orden.getIdOrden());
        orden.setClientes((List<Cliente>) clientes);

        em.getTransaction().begin();
        em.persist(orden);
        em.getTransaction().commit();

        return orden;
    }

    public void removeOrden(Integer idorden) {
        Orden orden = findOrden(idorden);
        if (orden != null) {
            em.getTransaction().begin();
            em.remove(orden);
            em.getTransaction().commit();
        }
    }

    public Orden cambiarDescripcionOrden(Integer idOrden, String nuevaDescripcion) {
        Orden orden = findOrden(idOrden);
        if (orden != null) {
            em.getTransaction().begin();
            orden.setDescripcion(nuevaDescripcion);
            em.getTransaction().commit();
        }
        return orden;
    }

}
