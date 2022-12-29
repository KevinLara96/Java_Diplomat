package unam.dgtic.diplomado.controlador.servicio.empleado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import unam.dgtic.diplomado.controlador.repositorio.empleado.RepositorioEmpleado;
import unam.dgtic.diplomado.modelo.entidades.empleado.EmpleadoEntity;

public class ServicioEmpleado implements RepositorioEmpleado {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("proyectofinal");
    private EntityManager em;

    public ServicioEmpleado() {
    }

    @Override
    @SuppressWarnings("unchecked")
    public Iterable<EmpleadoEntity> obtenerEmpleados() {
        em = emf.createEntityManager();

        try {
            Query query = em.createQuery("SELECT e from EmpleadoEntity e\n" +
                    "ORDER BY e.idEmpleado");

            return (Iterable<EmpleadoEntity>) query.getResultList();
        } finally {
            em.close();
        }

    }

    @Override
    public EmpleadoEntity obtenerEmpleado(Integer idEmpleado) {
        em = emf.createEntityManager();
        try {
            return em.find(EmpleadoEntity.class, idEmpleado);
        } finally {
            em.close();
        }
    }

    @Override
    public boolean guardarEmpleado(EmpleadoEntity empleado) throws Exception {
        em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(empleado);
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
    public boolean eliminarEmpleado(Integer idEmpleado) throws Exception {
        em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            EmpleadoEntity empleado = em.find(EmpleadoEntity.class, idEmpleado);
            em.remove(empleado);
            em.flush();
            em.getTransaction().commit();
            if (empleado != null) {
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
    public boolean actualizarEmpleado(EmpleadoEntity empleadoParam) throws Exception {
        em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.merge(empleadoParam);
            em.flush();
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            em.close();
        }

        return true;
    }

    public EmpleadoEntity login(String correo, String contrasena) {
        em = emf.createEntityManager();

        Query query = em.createQuery("SELECT e\n" +
                "from EmpleadoEntity e\n" +
                "WHERE e.correo = '" + correo + "'\n" +
                "AND e.contrasena = '" + contrasena + "'");

        return (EmpleadoEntity) query.getSingleResult();
    }
}
