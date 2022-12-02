package unam.dgtic.diplomado.m1100base.modelo;

import java.util.Collection;


import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import unam.dgtic.diplomado.m1100base.dominio.Address;
import unam.dgtic.diplomado.m1100base.dominio.Employee;

public class EmployeeService {

    protected EntityManager em;

    public EmployeeService(EntityManager em) {
        this.em = em;
    }

    public Employee findEmployee(Integer id) {

        return em.find(Employee.class, id);
    }

    @SuppressWarnings("unchecked")
    public Collection<Employee> findAllEmployees() {
        Query query = em.createQuery("SELECT e from Employee e");

        return (Collection<Employee>) query.getResultList();
    }

    public Employee createEmployee(Employee e) {

        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();

        return e;
    }

    public Employee createEmployeeWithAddress(Employee e, Address a) {
        em.getTransaction().begin();
        em.persist(e);
        em.persist(a);
        em.getTransaction().commit();

        return e;
    }

    public void removeEmployee(Integer id) {
        Employee employee = findEmployee(id);
        if (employee != null) {
            em.getTransaction().begin();
            em.remove(employee);
            em.getTransaction().commit();
        }
    }

    public Employee updateEmployee(Employee employeeParam) {
        Employee employee = findEmployee(employeeParam.getId());
        if (employee != null) {
            em.getTransaction().begin();
            employee = em.merge(employeeParam);
            em.getTransaction().commit();
        }

        return employee;
    }
}
