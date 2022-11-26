package unam.dgtic.diplomado.m1100base;

import java.util.Collection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import unam.dgtic.diplomado.m1100base.dominio.Employee;
import unam.dgtic.diplomado.m1100base.modelo.EmployeeService;

public class PrincipalEmployee02OverrideCollections {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("modulo11");
        EntityManager em = emf.createEntityManager();

        EmployeeService service = new EmployeeService(em);

        System.out.println("KEVIN ARTURO LARA SALA");
        System.out.println("Insertar empleado:");
        // Employee employee = service.createEmployee(500, "Kevin Lara", 5000l);
        // service.addEmployeeNickname(employee.getId(), "Borrego");

        Collection<Employee> employees = service.findAllEmployeesVacations();
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
