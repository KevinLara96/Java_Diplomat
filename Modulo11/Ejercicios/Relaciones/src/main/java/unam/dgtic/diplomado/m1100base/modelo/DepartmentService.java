package unam.dgtic.diplomado.m1100base.modelo;

import java.util.Collection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import unam.dgtic.diplomado.m1100base.dominio.Department;

public class DepartmentService {

    protected EntityManager em;

    public DepartmentService(EntityManager em) {
        this.em = em;
    }

    public Department createDepartment(String name) {
        Department d = new Department();
        d.setName(name);

        em.getTransaction().begin();
        em.persist(d);
        em.getTransaction().commit();

        return d;
    }

    public Department findDepartment(Integer id) {
        return em.find(Department.class, id);
    }

    @SuppressWarnings("unchecked")
    public Collection<Department> findAllDepartments() {
        Query query = em.createQuery("SELECT d from Department d");

        return (Collection<Department>) query.getResultList();
    }
}
