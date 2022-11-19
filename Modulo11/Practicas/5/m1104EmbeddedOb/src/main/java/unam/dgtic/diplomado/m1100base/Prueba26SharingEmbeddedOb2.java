package unam.dgtic.diplomado.m1100base;

import java.util.Collection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import unam.dgtic.diplomado.m1100base.dominio.Company;
import unam.dgtic.diplomado.m1100base.dominio.Employee;
import unam.dgtic.diplomado.m1100base.modelo.CompanyService;
import unam.dgtic.diplomado.m1100base.modelo.EmployeeService;

public class Prueba26SharingEmbeddedOb2 {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("modulo11");
        EntityManager em = emf.createEntityManager();

        EmployeeService service = new EmployeeService(em);
        CompanyService cService = new CompanyService(em);

        System.out.println("Insertar Compa�ia");
        Company company = cService.createCompany("iTacoz",
                "Circuito universitario",
                "CU",
                "CDMX",
                "4343");

        System.out.println(company);

        Collection<Company> companies = cService.findAllCompanies();
        if (companies.isEmpty()) {
            System.out.println("no se localizaron comanias");
        } else {
            System.out.println("Companias localizados");

            for (Company c : companies) {
                System.out.println(c.getId() + " " + c.getName() + " ");
                System.out.println("Ciudad: " + c.getAddress().getCity()
                        + " Calle: " + c.getAddress().getStreet()
                        + " Estado: " + c.getAddress().getState()
                        + " CP: " + c.getAddress().getZip());

            }
        }

        System.out.println("Insertar Employee");
        Employee employee = service.createEmployee("Kevin Lara",
                6767L,
                "Valle hidalgo",
                "Agua azul",
                "Leon",
                "37297");

        System.out.println(employee);
        Collection<Employee> empleados = service.findAllEmployees();

        if (empleados.isEmpty()) {
            System.out.println("no se localizaron empleados");
        } else {
            System.out.println("Employees localizados");

            for (Employee e : empleados) {
                System.out.println(e.getId() + " " + e.getName() + " " + e.getSalary());
                System.out.println("Ciudad: " + e.getAddress().getCity()
                        + " Calle: " + e.getAddress().getStreet()
                        + " Estado: " + e.getAddress().getState()
                        + " CP: " + e.getAddress().getZip());

            }
        }
    }
}
