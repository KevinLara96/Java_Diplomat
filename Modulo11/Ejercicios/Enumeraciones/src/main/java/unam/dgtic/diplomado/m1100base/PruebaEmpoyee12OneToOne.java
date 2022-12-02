package unam.dgtic.diplomado.m1100base;

import java.util.Collection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import unam.dgtic.diplomado.m1100base.dominio.Employee;
import unam.dgtic.diplomado.m1100base.modelo.EmployeeService;

public class PruebaEmpoyee12OneToOne {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("modulo11");
        EntityManager em = emf.createEntityManager();

        System.out.println("Ingresar empleado");
        EmployeeService service = new EmployeeService(em);

        // Employee emp = new Employee("Omar Mendoza", 5000);
        // Address address = new Address("Rancho Seco", "Neza", "Edo Mex", "56000");

        // service.createEmployeeWithAddress(emp, address);

        System.out.println("KEVIN ARTURO LARA SALA");

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
