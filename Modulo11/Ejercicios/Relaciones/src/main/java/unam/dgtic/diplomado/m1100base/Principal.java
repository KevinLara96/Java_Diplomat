package unam.dgtic.diplomado.m1100base;

import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import unam.dgtic.diplomado.m1100base.dominio.cliente.Cliente;
import unam.dgtic.diplomado.m1100base.dominio.cliente.Orden;
import unam.dgtic.diplomado.m1100base.modelo.ClienteService;
import unam.dgtic.diplomado.m1100base.modelo.OrdenService;

public class Principal {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("modulo11");
        EntityManager em = emf.createEntityManager();

        ClienteService clienteService = new ClienteService(em);
        OrdenService ordenService = new OrdenService(em);

        Scanner input = new Scanner(System.in);
        Integer opcion;

        while (true) {

            StringBuilder display = new StringBuilder();
            display.append("Menú: \n");
            display.append("Opción 1 -> Mostrar clientes\n");
            display.append("Opción 2 -> Mostrar ordenes\n");
            display.append("Opción 3 -> Salir\n");
            System.out.println(display.toString());

            opcion = Integer.parseInt(input.nextLine());
            Cliente cliente;

            switch (opcion) {
                case 1:
                    System.out.println("\nClientes:");
                    Collection<Cliente> clientes = clienteService.findAllClientes();
                    for (Cliente c : clientes) {
                        System.out.println(c);
                        System.out.println("\n");
                    }

                    break;

                case 2:
                    System.out.println("Mostrar órdenes de los clientes:\n");
                    System.out.println("Ingrese el id del cliente: ");

                    cliente = clienteService.findCliente(Integer.parseInt(input.nextLine()));
                    if (cliente != null) {
                        System.out.println("Órdenes encontradas:");
                        List<Orden> tmp = (List<Orden>) ordenService.findOrdenJoinClientes(cliente.getIdCliente());
                        for (Object o : tmp) {
                            System.out.println(o);
                        }
                        System.out.println("\n");
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
