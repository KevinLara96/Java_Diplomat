package unam.dgtic.diplomado.m1100base;

import java.util.Collection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import unam.dgtic.diplomado.m1100base.dominio.Department;
import unam.dgtic.diplomado.m1100base.dominio.Employee;
import unam.dgtic.diplomado.m1100base.modelo.DepartmentService;
import unam.dgtic.diplomado.m1100base.modelo.EmployeeService;

public class PruebaEmployee14aOneToMany {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("modulo11");
        EntityManager em = emf.createEntityManager();

        EmployeeService service = new EmployeeService(em);
        DepartmentService service2 = new DepartmentService(em);

        System.out.println("KEVIN ARTURO LARA SALA");
        Employee employee = service.findEmployee(301);
        Department department = service2.findDepartment(5);

    }
}
