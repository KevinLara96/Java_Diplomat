package unam.dgtic.diplomado.m1100base;

import java.util.Collection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import unam.dgtic.diplomado.m1100base.dominio.Department;
import unam.dgtic.diplomado.m1100base.dominio.Employee;
import unam.dgtic.diplomado.m1100base.modelo.DepartmentService;
import unam.dgtic.diplomado.m1100base.modelo.EmployeeService;

public class PruebaEmployee14ManyToOne {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("modulo11");
        EntityManager em = emf.createEntityManager();

        EmployeeService service = new EmployeeService(em);
        DepartmentService service2 = new DepartmentService(em);

        System.out.println("KEVIN ARTURO LARA SALA");
        // Employee employee = new Employee("Kevin Lara", 5000);
        // employee.setDepartment(service2.findDepartment(4));
        // service.createEmployee(employee);

        Collection<Employee> employees = service.findAllEmployees();
        if (employees.isEmpty()) {
            System.out.println("No se localizaron empleados");
        } else {
            System.out.println("Empleados localizados");
            for (Employee e : employees) {
                System.out.println(e);
            }
        }

        Collection<Department> departments = service2.findAllDepartments();
        if (departments.isEmpty()) {
            System.out.println("No se encontraron departamentos");
        } else {
            System.out.println("Departamentos localizados");
            for (Department d : departments) {
                System.out.println(d);
            }
        }
    }
}
