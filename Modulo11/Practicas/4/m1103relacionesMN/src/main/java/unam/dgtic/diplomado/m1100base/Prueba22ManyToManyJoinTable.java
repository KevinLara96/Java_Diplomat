package unam.dgtic.diplomado.m1100base;

import java.util.Collection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import unam.dgtic.diplomado.m1100base.dominio.Employee;
import unam.dgtic.diplomado.m1100base.dominio.Project;
import unam.dgtic.diplomado.m1100base.modelo.EmployeeService;
import unam.dgtic.diplomado.m1100base.modelo.ProjectService;

public class Prueba22ManyToManyJoinTable {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("modulo11");
        EntityManager em = emf.createEntityManager();

        EmployeeService service = new EmployeeService(em);
        ProjectService service2 = new ProjectService(em);

        System.out.println("KEVIN ARTURO LARA SALA");
        System.out.println("Insertar empleado");
        Employee employee = new Employee("Kevin Lara", 5000);
        employee = service.createEmployee(employee);
        System.out.println(employee);

        System.out.println("Insertar proyecto");
        Project project = service2.createProject("JAVA");
        System.out.println(project);

        System.out.println("Agregar proyecto a empleado");
        employee.addProject(project);
        employee.addProject(service2.findProject(1));
        employee.addProject(service2.findProject(2));

        Collection<Project> projects;
        Collection<Employee> employees = service.findAllEmployees();

        if (employees.isEmpty()) {
            System.out.println("No se localizaron empleados");
        } else {
            System.out.println("Empleados localizados");
            for (Employee e : employees) {
                System.out.println(e);
                projects = e.getProjects();
                if (projects.isEmpty()) {
                    System.out.println("El empleado " + e.getName() + " no tiene proyectos asignados");
                } else {
                    System.out.println("Proyectos del empleado " + e.getName() + ":");
                    for (Project p : projects) {
                        System.out.println(p.getName());
                    }
                }
            }
        }

        projects = service2.findProjects();
        if (projects.isEmpty()) {
            System.out.println("No hay proyectos");
        } else {
            System.out.println("Proyectos localizados:");
            for (Project p : projects) {
                System.out.println(p);
                employees = p.getEmployees();
                if (projects.isEmpty()) {
                    System.out.println("El proyecto" + p.getName() + " no tiene empleados asignados");
                } else {
                    System.out.println("Empleados del proyecto " + p.getName() + ":");
                    for (Employee e : employees) {
                        System.out.println(e.getName());
                    }
                }
            }
        }
    }
}
