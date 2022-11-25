package unam.dgtic.diplomado.m1100base.modelo;

import java.util.Collection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
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

    public Employee addEmployeeNickname(Integer id, String nickname) {
        Employee employee = findEmployee(id);
        if (employee != null) {
            employee.getNickNames().add(nickname);
            updateEmployee(employee);
        }

        return employee;
    }

    public Employee createEmployee(Integer id, String name, Long salary) {
        Employee employee = new Employee();

        employee.setId(id);
        employee.setName(name);
        employee.setSalary(salary);

        em.getTransaction().begin();
        em.persist(employee);
        em.flush();
        em.getTransaction().commit();

        return employee;
    }

    public Employee createEmployee(Employee e) {

        em.getTransaction().begin();
        em.persist(e);
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

    public Employee addEmployeeProject(Integer idEmp, Integer idProj) {
        Employee employee = findEmployee(idEmp);

        return employee;
    }
}
