package unam.dgtic.diplomado.m1100base;

import java.util.Collection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import unam.dgtic.diplomado.m1100base.dominio.ContractEmployee;
import unam.dgtic.diplomado.m1100base.dominio.Employee;
import unam.dgtic.diplomado.m1100base.dominio.FullTimeEmployee;
import unam.dgtic.diplomado.m1100base.dominio.PartTimeEmployee;
import unam.dgtic.diplomado.m1100base.modelo.EmployeeService;

public class PrincipalEmployee03TablePerConcreteClass {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("modulo11");
        EntityManager em = emf.createEntityManager();

        EmployeeService service = new EmployeeService(em);

        System.out.println("KEVIN ARTURO LARA SALA");
        Employee emp = null;
        emp = new FullTimeEmployee();
        emp = new PartTimeEmployee();
        emp = new ContractEmployee();

        Collection<Employee> employees = service.findAllEmployees();
        if (employees.isEmpty()) {
            System.out.println("No se localizaron empleados");
        } else {
            System.out.println("Empleados localizados");
            for (Employee e : employees) {
                System.out.println(e);
            }
        }

    }
}
