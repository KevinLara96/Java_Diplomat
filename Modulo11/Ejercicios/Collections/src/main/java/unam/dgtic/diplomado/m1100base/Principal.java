package unam.dgtic.diplomado.m1100base;

import java.util.Collection;
import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import unam.dgtic.diplomado.m1100base.dominio.agencia.Agencia;
import unam.dgtic.diplomado.m1100base.modelo.AgenciaService;

public class Principal {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("modulo11");
        EntityManager em = emf.createEntityManager();

        AgenciaService agenciaService = new AgenciaService(em);

        Scanner input = new Scanner(System.in);
        Integer opcion;

        while (true) {

            StringBuilder display = new StringBuilder();
            display.append("Menú: \n");
            display.append("Opción 1 -> Mostrar clientes por Agencia\n");
            display.append("Opción 2 -> Salir\n");
            System.out.println(display.toString());

            opcion = Integer.parseInt(input.nextLine());

            switch (opcion) {
                case 1:
                    System.out.println("Mostrando clientes:");
                    Collection<Agencia> agencias = agenciaService.findAllAgenciasClientes();
                    for (Agencia a : agencias) {
                        System.out.println(a);
                        System.out.println("\n");
                    }

                    break;

                case 2:
                    input.close();
                    System.exit(0);

                    break;
            }
        }

    }
}
