package unam.dgtic.diplomado.controlador.servicio.empleado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import unam.dgtic.diplomado.controlador.repositorio.empleado.RepositorioEmpleado;
import unam.dgtic.diplomado.modelo.beans.empleado.Empleado;

public class ServicioEmpleado implements RepositorioEmpleado {

    protected EntityManager em;

    public ServicioEmpleado(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Iterable<Empleado> obtenerEmpleados() {
        Query query = em.createQuery("SELECT e from Empleado e\n" +
                "ORDER BY e.idEmpleado");

        return (Iterable<Empleado>) query.getResultList();
    }

    @Override
    public Empleado obtenerEmpleado(Integer idEmpleado) {
        return em.find(Empleado.class, idEmpleado);
    }

    @Override
    public void guardarEmpleado(Empleado empleado) throws Exception {
        em.getTransaction().begin();
        em.persist(empleado);
        em.flush();
        em.getTransaction().commit();
    }

    @Override
    public void eliminarEmpleado(Integer idEmpleado) {
        Empleado empleado = obtenerEmpleado(idEmpleado);
        if (empleado != null) {
            em.getTransaction().begin();
            em.remove(empleado);
            em.flush();
            em.getTransaction().commit();
        }
    }

    @Override
    public void actualizarEmpleado(Empleado empleadoParam) {
        Empleado empleado = obtenerEmpleado(empleadoParam.getIdEmpleado());
        if (empleado != null) {
            em.getTransaction().begin();
            empleado = em.merge(empleadoParam);
            em.flush();
            em.getTransaction().commit();
        }

    }
}
