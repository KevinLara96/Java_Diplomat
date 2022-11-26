package mx.unam.dgtic.main;

import java.nio.file.spi.FileSystemProvider;
import java.util.Collection;
import java.util.Iterator;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import mx.unam.dgtic.dominio.Company;
import mx.unam.dgtic.dominio.Employee;
import mx.unam.dgtic.modelo.CompanyService;
import mx.unam.dgtic.modelo.EmpleadoService;

public class Prueba26SharingEmbebedObj {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("modulo11");
		EntityManager em = emf.createEntityManager();
		
		EmpleadoService service = new EmpleadoService(em);
		CompanyService cService = new CompanyService(em);
		
		
		
		System.out.println("Insertar Compañia");
		Company company = cService.createCompany("iTacoz",
									"Circuito universitario",
									"CU",
									"CDMX",
									"4343");
		
		System.out.println(company);
		
		Collection<Company> companies = cService.findAllCompanies();
		if(companies.isEmpty())
		{
			System.out.println("no se localizaron comanias");
		}
		else
		{
			System.out.println("Companias localizados");
			
		for (Company c: companies) {
			System.out.println(c.getId() + " " + c.getName() + " "  );
			System.out.println("Ciudad: " + c.getAddress().getCity()
					+ " Calle: " + c.getAddress().getStreet()
					+ " Estado: " + c.getAddress().getState()
					+ " CP: " + c.getAddress().getZip());
			
			}
		}
		
		

		System.out.println("Insertar Empleado");
		Employee employee = service.createEmployee("Brenda Alvarez",
									6767,
									"Valle hidalgo",
									"Agua azul",
									"Leon",
									"37297");
		
		System.out.println(employee);
    	Collection<Employee> empleados = service.findAllEmpleados();
		
		if(empleados.isEmpty())
		{
			System.out.println("no se localizaron empleados");
		}
		else
		{
			System.out.println("Empleados localizados");
			
		for (Employee e: empleados) {
			System.out.println(e.getId() + " " + e.getName() + " " + e.getSalary() );
			System.out.println("Ciudad: " + e.getAddress().getCity()
					+ " Calle: " + e.getAddress().getStreet()
					+ " Estado: " + e.getAddress().getState()
					+ " CP: " + e.getAddress().getZip());
			
			}
		}
		
		/*System.out.println("Cambiar empleado");
		Employee e = service.findEmployee(100);
		e.setName("Brenda");
		e.setSalary(999);
		
		Employee eu = service.updateEmployee(e);
		System.out.println(eu);
		
		
		
		///
		System.out.println("Eliminar empleado");
		service.removeEmployee(200);
		
		//Listando todos
		empleados = service.findAllEmpleados();
		
		if(empleados.isEmpty())
		{
			System.out.println("no se localizaron empleados");
		}
		else
		{
			System.out.println("Empleados localizados");
			
		for (Employee ec: empleados) {
			System.out.println(ec.getId() + " " + ec.getName() + " " + ec.getSalary() );
			
			}
		}*/
		
	}
}
