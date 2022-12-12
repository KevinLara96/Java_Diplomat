package unam.dgtic.diplomado.m1100base.modelo;

import java.util.Collection;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import unam.dgtic.diplomado.m1100base.dominio.agencia.Agencia;
import unam.dgtic.diplomado.m1100base.dominio.cliente.Cliente;
import unam.dgtic.diplomado.m1100base.dominio.empleado.Empleado;
import unam.dgtic.diplomado.m1100base.dominio.transporte.Transporte;

public class AgenciaService {

    protected EntityManager em;

    public AgenciaService(EntityManager em) {
        this.em = em;
    }

    public Agencia findAgencia(Integer idAgencia) {
        return em.find(Agencia.class, idAgencia);
    }

    @SuppressWarnings("unchecked")
    public Collection<Agencia> findAllAgencias() {
        Query query = em.createQuery("SELECT a FROM Agencia a");
        Collection<Agencia> agencias = (Collection<Agencia>) query.getResultList();

        for (Agencia a : agencias) {
            Query queryEmpleados = em
                    .createQuery("SELECT e from Empleado e where e.agencia.idAgencia = " + a.getIdAgencia());
            Collection<Empleado> empleados = (Collection<Empleado>) queryEmpleados.getResultList();
            a.setEmpleados((List<Empleado>) empleados);

            Query queryClientes = em
                    .createQuery("SELECT c from Cliente c where c.agencia.idAgencia = " + a.getIdAgencia());
            Collection<Cliente> clientes = (Collection<Cliente>) queryClientes.getResultList();
            a.setClientes((List<Cliente>) clientes);

            Query queryTransporte = em
                    .createQuery("SELECT t from Transporte t where t.agencia.idAgencia = " + a.getIdAgencia());
            Collection<Transporte> transportes = (Collection<Transporte>) queryTransporte.getResultList();
            a.setTransportes((List<Transporte>) transportes);
        }

        return agencias;
    }

    public Agencia createAgencia(Integer idAgencia, String nombreAgencia, String ubicacion) {
        Agencia agencia = new Agencia();
        agencia.setIdAgencia(idAgencia);
        agencia.setNombreAgencia(nombreAgencia);
        agencia.setUbicacion(ubicacion);

        em.getTransaction().begin();
        em.persist(agencia);
        em.getTransaction().commit();

        return agencia;
    }

    public void removeAgencia(Integer idAgencia) {
        Agencia agencia = findAgencia(idAgencia);
        if (agencia != null) {
            em.getTransaction().begin();
            em.remove(agencia);
            em.getTransaction().commit();
        }
    }

    public Agencia cambiarNombreAgencia(Integer idAgencia, String nuevoNombreAgencia) {
        Agencia agencia = findAgencia(idAgencia);
        if (agencia != null) {
            em.getTransaction().begin();
            agencia.setNombreAgencia(nuevoNombreAgencia);
            em.getTransaction().commit();
        }
        return agencia;
    }
}