package unam.dgtic.diplomado.m1100base;

import java.util.Collection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import unam.dgtic.diplomado.m1100base.dominio.Employee;
import unam.dgtic.diplomado.m1100base.modelo.EmployeeService;

public class PrincipalEmployee {

    /*
     * public static void main(String[] args) {
     * EntityManagerFactory emf =
     * Persistence.createEntityManagerFactory("modulo11");
     * EntityManager em = emf.createEntityManager();
     * 
     * EmployeeService service = new EmployeeService(em);
     * 
     * Collection<Employee> employees = service.findAllEmployees();
     * if (employees.isEmpty()) {
     * System.out.println("No se localizaron empleados");
     * } else {
     * System.out.println("Empleados localizados");
     * for (Employee e : employees) {
     * System.out.println(e.getId() + " / " + e.getName() + " / " + e.getSalary());
     * }
     * }
     * 
     * System.out.println("Cambiar empleado");
     * Employee e = new Employee(100);
     * e.setName("Óscar Medina");
     * e.setSalary(1100L);
     * 
     * Employee eu = service.updateEmployee(e);
     * System.out.println(eu);
     * 
     * System.out.println("Insertar empleado");
     * eu = service.createEmployee(500, "Kevin Lara", 5000L);
     * System.out.println(eu);
     * 
     * System.out.println("Eliminar empleado");
     * service.removeEmployee(200);
     * 
     * employees = service.findAllEmployees();
     * if (employees.isEmpty()) {
     * System.out.println("No se localizaron empleados");
     * } else {
     * System.out.println("Empleados localizados (CRUD)");
     * for (Employee ec : employees) {
     * System.out.println(ec.getId() + " / " + ec.getName() + " / " +
     * ec.getSalary());
     * }
     * }
     * 
     * }
     */
}
