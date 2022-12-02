package unam.dgtic.diplomado.m1100base;

import java.util.Collection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import unam.dgtic.diplomado.m1100base.dominio.Employee;
import unam.dgtic.diplomado.m1100base.dominio.ParkingSpace;
import unam.dgtic.diplomado.m1100base.modelo.EmployeeService;
import unam.dgtic.diplomado.m1100base.modelo.ParkingSpaceService;

public class PruebaEmployee16OneToOne {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("modulo11");
        EntityManager em = emf.createEntityManager();

        EmployeeService service = new EmployeeService(em);
        ParkingSpaceService service2 = new ParkingSpaceService(em);

        System.out.println("KEVIN ARTURO LARA SALA");

        Employee employee = new Employee("Kevin Lara", 5000);
        service.createEmployee(employee);
        ParkingSpace pSpace = service2.createParkingSpace(employee, 600, "E-600");
        employee.setParkingSpace(pSpace);
        service.updateEmployee(employee);

        Collection<Employee> employees = service.findAllEmployees();
        if (employees.isEmpty()) {
            System.out.println("No se localizaron empleados");
        } else {
            System.out.println("Empleados localizados");
            for (Employee e : employees) {
                System.out.println(e);
            }
        }

        Collection<ParkingSpace> parkingSpaces = service2.findAllParkingSpace();
        if (parkingSpaces.isEmpty()) {
            System.out.println("No se encontraron Espacios de estacionamiento");
        } else {
            System.out.println("Espacios localizados:");
            for (ParkingSpace p : parkingSpaces) {
                System.out.println(p);
            }
        }
    }
}
