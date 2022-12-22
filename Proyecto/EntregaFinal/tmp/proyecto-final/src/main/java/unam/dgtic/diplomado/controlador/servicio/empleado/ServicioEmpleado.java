package unam.dgtic.diplomado.controlador.servicio.empleado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import unam.dgtic.diplomado.controlador.repositorio.empleado.RepositorioEmpleado;
import unam.dgtic.diplomado.modelo.entidades.empleado.EmpleadoEntity;

public class ServicioEmpleado implements RepositorioEmpleado {

    protected EntityManager em;

    public ServicioEmpleado(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Iterable<EmpleadoEntity> obtenerEmpleados() {
        Query query = em.createQuery("SELECT e from Empleado e\n" +
                "ORDER BY e.idEmpleado");

        return (Iterable<EmpleadoEntity>) query.getResultList();
    }

    @Override
    public EmpleadoEntity obtenerEmpleado(Integer idEmpleado) {
        return em.find(EmpleadoEntity.class, idEmpleado);
    }

    @Override
    public void guardarEmpleado(EmpleadoEntity empleado) throws Exception {
        em.getTransaction().begin();
        em.persist(empleado);
        em.flush();
        em.getTransaction().commit();
    }

    @Override
    public void eliminarEmpleado(Integer idEmpleado) {
        EmpleadoEntity empleado = obtenerEmpleado(idEmpleado);
        if (empleado != null) {
            em.getTransaction().begin();
            em.remove(empleado);
            em.flush();
            em.getTransaction().commit();
        }
    }

    @Override
    public void actualizarEmpleado(EmpleadoEntity empleadoParam) {
        EmpleadoEntity empleado = obtenerEmpleado(empleadoParam.getIdEmpleado());
        if (empleado != null) {
            em.getTransaction().begin();
            empleado = em.merge(empleadoParam);
            em.flush();
            em.getTransaction().commit();
        }

    }
}
