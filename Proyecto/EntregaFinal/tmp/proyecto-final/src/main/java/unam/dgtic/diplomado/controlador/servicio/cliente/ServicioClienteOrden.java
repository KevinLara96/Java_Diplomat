package unam.dgtic.diplomado.controlador.servicio.cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import unam.dgtic.diplomado.controlador.repositorio.cliente.RepositorioClienteOrden;
import unam.dgtic.diplomado.modelo.entidades.cliente.ClienteOrden;

public class ServicioClienteOrden implements RepositorioClienteOrden {

    protected EntityManager em;

    public ServicioClienteOrden(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Iterable<ClienteOrden> obtenerClientesOrdenes() {
        Query query = em.createQuery("SELECT co from ClienteOrden co\n" +
                "ORDER BY co.idClienteOrden");

        return (Iterable<ClienteOrden>) query.getResultList();
    }

    @Override
    public ClienteOrden obtenerClienteOrden(Integer idCliente, Integer idOrden) {
        Query query = em.createQuery("SELECT co from ClienteOrden co\n" +
                "WHERE idCliente = " + idCliente +
                "AND idOrden = " + idOrden);
        return (ClienteOrden) query.getResultList().get(0);
    }

    @Override
    public void guardarClienteOrden(ClienteOrden agencia) throws Exception {
        em.getTransaction().begin();
        em.persist(agencia);
        em.flush();
        em.getTransaction().commit();
    }

    @Override
    public void eliminarClienteOrden(Integer idCliente, Integer idOrden) {
        ClienteOrden clienteOrden = obtenerClienteOrden(idCliente, idOrden);
        if (clienteOrden != null) {
            em.getTransaction().begin();
            em.remove(clienteOrden);
            em.flush();
            em.getTransaction().commit();
        }
    }

    @Override
    public void actualizarClienteOrden(ClienteOrden clienteOrdenParam) {
        ClienteOrden clienteOrden = obtenerClienteOrden(clienteOrdenParam.getIdCliente(),
                clienteOrdenParam.getIdOrden());
        if (clienteOrden != null) {
            em.getTransaction().begin();
            clienteOrden = em.merge(clienteOrdenParam);
            em.getTransaction().commit();
        }

    }
}
