package unam.dgtic.diplomado.controlador.servicio.cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import unam.dgtic.diplomado.controlador.repositorio.cliente.RepositorioCliente;
import unam.dgtic.diplomado.modelo.beans.cliente.ClienteBean;

public class ServicioCliente implements RepositorioCliente {

    protected EntityManager em;

    public ServicioCliente(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Iterable<ClienteBean> obtenerClientes() {
        Query query = em.createQuery("SELECT c from Cliente c\n" +
                "ORDER BY c.idCliente");

        Iterable<ClienteBean> clientes = (Iterable<ClienteBean>) query.getResultList();
        return clientes;
    }

    @Override
    public ClienteBean obtenerCliente(Integer idCliente) {
        return em.find(ClienteBean.class, idCliente);
    }

    @Override
    public void guardarCliente(ClienteBean cliente) throws Exception {
        em.getTransaction().begin();
        em.persist(cliente);
        em.flush();
        em.getTransaction().commit();
    }

    @Override
    public void eliminarCliente(Integer idCliente) {
        ClienteBean cliente = obtenerCliente(idCliente);
        if (cliente != null) {
            em.getTransaction().begin();
            em.remove(cliente);
            em.flush();
            em.getTransaction().commit();
        }
    }

    @Override
    public void actualizarCliente(ClienteBean clienteParam) {
        ClienteBean cliente = obtenerCliente(clienteParam.getIdCliente());
        if (cliente != null) {
            em.getTransaction().begin();
            cliente = em.merge(clienteParam);
            em.flush();
            em.getTransaction().commit();
        }
    }

}
