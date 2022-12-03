package unam.dgtic.diplomado.m1100base.modelo;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import unam.dgtic.diplomado.m1100base.dominio.empleado.Empleado;
import unam.dgtic.diplomado.m1100base.dominio.puesto.Puesto;

public class EmpleadoService {

    protected EntityManager em;
    @Autowired
    private AgenciaService agenciaService;

    public EmpleadoService(EntityManager em) {
        this.em = em;
    }

    public Empleado findEmpleado(Integer idEmpleado) {
        return em.find(Empleado.class, idEmpleado);
    }

    @SuppressWarnings("unchecked")
    public Collection<Empleado> findAllEmpleados() {
        Query query = em.createQuery("SELECT e FROM Empleado e");

        return (Collection<Empleado>) query.getResultList();
    }

    public Empleado createEmpleado(Empleado nuevoEmpleado) {
        em.getTransaction().begin();
        em.persist(nuevoEmpleado);
        em.getTransaction().commit();

        return nuevoEmpleado;
    }

    public Empleado createEmpleado(Integer idEmpleado, String nombreEmpleado, String correo, String contrasena,
            String rfc, Float salario, String puestoStr, Integer idAgencia) {

        Puesto puesto = new Puesto();
        puesto.setPuesto(puestoStr);

        Empleado empleado = new Empleado();
        empleado.setIdEmpleado(idEmpleado);
        empleado.setNombre(nombreEmpleado);
        empleado.setCorreo(correo);
        empleado.setContrasena(contrasena);
        empleado.setRfc(rfc);
        empleado.setSalario(salario);

        empleado.setAgencia(agenciaService.findAgencia(idAgencia));
        empleado.setPuesto(puesto);

        em.getTransaction().begin();
        em.persist(empleado);
        em.getTransaction().commit();

        return empleado;
    }

    public void removeEmpleado(Integer idempleado) {
        Empleado empleado = findEmpleado(idempleado);
        if (empleado != null) {
            em.getTransaction().begin();
            em.remove(empleado);
            em.getTransaction().commit();
        }
    }

    public Empleado cambiarSalarioEmpleado(Integer idempleado, Float nuevoSalario) {
        Empleado empleado = findEmpleado(idempleado);
        if (empleado != null) {
            em.getTransaction().begin();
            empleado.setSalario(nuevoSalario);
            em.getTransaction().commit();
        }
        return empleado;
    }
}
