package unam.dgtic.diplomado.controlador.servicio.empleado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import unam.dgtic.diplomado.controlador.repositorio.empleado.RepositorioEmpleado;
import unam.dgtic.diplomado.modelo.beans.empleado.EmpleadoBean;

public class ServicioEmpleado implements RepositorioEmpleado {

    protected EntityManager em;

    public ServicioEmpleado(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Iterable<EmpleadoBean> obtenerEmpleados() {
        Query query = em.createQuery("SELECT e from Empleado e\n" +
                "ORDER BY e.idEmpleado");

        return (Iterable<EmpleadoBean>) query.getResultList();
    }

    @Override
    public EmpleadoBean obtenerEmpleado(Integer idEmpleado) {
        return em.find(EmpleadoBean.class, idEmpleado);
    }

    @Override
    public void guardarEmpleado(EmpleadoBean empleado) throws Exception {
        em.getTransaction().begin();
        em.persist(empleado);
        em.flush();
        em.getTransaction().commit();
    }

    @Override
    public void eliminarEmpleado(Integer idEmpleado) {
        EmpleadoBean empleado = obtenerEmpleado(idEmpleado);
        if (empleado != null) {
            em.getTransaction().begin();
            em.remove(empleado);
            em.flush();
            em.getTransaction().commit();
        }
    }

    @Override
    public void actualizarEmpleado(EmpleadoBean empleadoParam) {
        EmpleadoBean empleado = obtenerEmpleado(empleadoParam.getIdEmpleado());
        if (empleado != null) {
            em.getTransaction().begin();
            empleado = em.merge(empleadoParam);
            em.flush();
            em.getTransaction().commit();
        }

    }
}
