package unam.dgtic.diplomado.m1100base;

import java.util.Collection;
import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import unam.dgtic.diplomado.m1100base.dominio.empleado.Empleado;
import unam.dgtic.diplomado.m1100base.dominio.viaje.Viaje;
import unam.dgtic.diplomado.m1100base.modelo.EmpleadoService;
import unam.dgtic.diplomado.m1100base.modelo.ViajeService;

public class Principal {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("modulo11");
        EntityManager em = emf.createEntityManager();

        EmpleadoService empleadoService = new EmpleadoService(em);
        ViajeService viajeService = new ViajeService(em);

        Scanner input = new Scanner(System.in);
        Integer opcion;

        while (true) {

            StringBuilder display = new StringBuilder();
            display.append("Menú: \n");
            display.append("Opción 1 -> Mostrar empleados\n");
            display.append("Opción 2 -> Mostrar viajes\n");
            display.append("Opción 3 -> Salir\n");
            System.out.println(display.toString());

            opcion = Integer.parseInt(input.nextLine());

            switch (opcion) {
                case 1:
                    System.out.println("Empleados embebidos:");
                    Collection<Empleado> empleados = empleadoService.findAllEmpleados();
                    for (Empleado e : empleados) {
                        System.out.println(e);
                    }

                    break;

                case 2:
                    System.out.println("Viajes embebidos:");
                    Collection<Viaje> viajes = viajeService.findAllViajes();
                    for (Viaje v : viajes) {
                        System.out.println(v);
                    }

                    break;

                case 3:
                    input.close();
                    System.exit(0);

                    break;
            }
        }

    }
}
