package unam.dgtic.diplomado.m1100base;

import java.util.Collection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import unam.dgtic.diplomado.m1100base.dominio.Employee;
import unam.dgtic.diplomado.m1100base.dominio.VacationEntry;
import unam.dgtic.diplomado.m1100base.modelo.EmployeeService;

public class PrincipalEmployee01ElementCollections {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("modulo11");
        EntityManager em = emf.createEntityManager();

        EmployeeService service = new EmployeeService(em);

        System.out.println("KEVIN ARTURO LARA SALA");
        System.out.println("Insertar empleado:");
        // Employee employee = service.createEmployee(500, "Kevin Lara", 5000l);
        // service.addEmployeeNickname(500, "Borrego");

        Collection<Employee> employees = service.findAllEmployees();
        if (employees.isEmpty()) {
            System.out.println("No se localizaron empleados");
        } else {
            System.out.println("Empleados localizados");
            for (Employee e : employees) {
                System.out.println(e);
                System.out.println("Vacaciones del empleado " + e.getName());
                for (VacationEntry v : e.getVacationBookings()) {
                    System.out.println(v);
                }
                for (String v : e.getNickNames()) {
                    System.out.println(v);
                }
            }
        }

    }
}
