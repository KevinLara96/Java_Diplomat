package unam.dgtic.diplomado.controlador.servicio.cliente;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import unam.dgtic.diplomado.controlador.repositorio.cliente.RepositorioCliente;
import unam.dgtic.diplomado.modelo.entidades.cliente.ClienteEntity;

public class ServicioCliente implements RepositorioCliente {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("proyectofinal");
    EntityManager em;

    public ServicioCliente() {
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<ClienteEntity> obtenerClientes() {
        em = emf.createEntityManager();

        try {
            Query query = em.createQuery("SELECT c from ClienteEntity c\n" +
                    "ORDER BY c.idCliente");

            return query.getResultList();
        } finally {
            em.close();
        }

    }

    @Override
    public ClienteEntity obtenerCliente(Integer idCliente) {
        em = emf.createEntityManager();

        try {
            ClienteEntity cliente = em.find(ClienteEntity.class, idCliente);

            return cliente;
        } finally {
            em.close();
        }
    }

    @Override
    public boolean guardarCliente(ClienteEntity cliente) throws Exception {
        em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(cliente);
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
    public boolean eliminarCliente(Integer idCliente) throws Exception {
        em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            ClienteEntity cliente = em.find(ClienteEntity.class, idCliente);
            em.remove(cliente);
            em.flush();
            em.getTransaction().commit();
            if (cliente != null) {
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
    public boolean actualizarCliente(ClienteEntity clienteParam) throws Exception {
        em = emf.createEntityManager();

        try {

            em.getTransaction().begin();
            em.merge(clienteParam);
            em.flush();
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            em.close();
        }

        return true;
    }

}
