package unam.dgtic.diplomado.m1100base.modelo;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import unam.dgtic.diplomado.m1100base.dominio.cliente.Cliente;
import unam.dgtic.diplomado.m1100base.dominio.cliente.Orden;

public class ClienteService {

    protected EntityManager em;
    @Autowired
    private AgenciaService agenciaService;
    @Autowired
    private OrdenService ordenService;

    public ClienteService(EntityManager em) {
        this.em = em;
    }

    public Cliente findCliente(Integer idCliente) {
        return em.find(Cliente.class, idCliente);
    }

    @SuppressWarnings("unchecked")
    public Collection<Cliente> findAllClientes() {
        Query query = em.createQuery("SELECT c FROM Cliente c");

        return (Collection<Cliente>) query.getResultList();
    }

    @SuppressWarnings("unchecked")
    public Collection<Cliente> findClientesJoinOrdenes(Integer idOrden) {
        String query = "SELECT c.idCliente, c.nombre, c.calle, c.colonia, c.telefono, c.rfc, c.idAgencia\n" +
                "FROM Cliente c\n" +
                "JOIN ClienteOrden co on c.idCliente = co.idCliente\n" +
                "JOIN Orden o on co.idOrden = o.idOrden\n" +
                "WHERE c.idOrden = " + idOrden;
        Query queryObj = em.createQuery(query);

        return (Collection<Cliente>) queryObj.getResultList();
    }

    public Cliente createCliente(Cliente nuevoCliente) {
        em.getTransaction().begin();
        em.persist(nuevoCliente);
        em.getTransaction().commit();

        return nuevoCliente;
    }

    public Cliente createCliente(Integer idCliente, String nombreCliente, String calle, String colonia,
            String telefono, String rfc, Integer idAgencia) {
        Cliente cliente = new Cliente();
        cliente.setIdCliente(idCliente);
        cliente.setNombre(nombreCliente);
        cliente.setCalle(calle);
        cliente.setColonia(colonia);
        cliente.setTelefono(telefono);
        cliente.setRfc(rfc);

        cliente.setAgencia(agenciaService.findAgencia(idAgencia));
        Collection<Orden> ordenes = ordenService.findOrdenJoinClientes(idCliente);
        cliente.setOrdenes((List<Orden>) ordenes);

        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();

        return cliente;
    }

    public void removeCliente(Integer idcliente) {
        Cliente cliente = findCliente(idcliente);
        if (cliente != null) {
            em.getTransaction().begin();
            em.remove(cliente);
            em.getTransaction().commit();
        }
    }

    public Cliente cambiarTelefonoCliente(Integer idcliente, String nuevoTelefono) {
        Cliente cliente = findCliente(idcliente);
        if (cliente != null) {
            em.getTransaction().begin();
            cliente.setTelefono(nuevoTelefono);
            em.getTransaction().commit();
        }
        return cliente;
    }

}
