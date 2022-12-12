package unam.dgtic.diplomado.m1100base;

import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import unam.dgtic.diplomado.m1100base.dominio.agencia.Agencia;
import unam.dgtic.diplomado.m1100base.dominio.cliente.Cliente;
import unam.dgtic.diplomado.m1100base.dominio.cliente.Orden;
import unam.dgtic.diplomado.m1100base.modelo.AgenciaService;
import unam.dgtic.diplomado.m1100base.modelo.ClienteService;

public class Principal {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("modulo11");
        EntityManager em = emf.createEntityManager();

        AgenciaService agenciaService = new AgenciaService(em);
        ClienteService clienteService = new ClienteService(em);

        Scanner input = new Scanner(System.in);
        Integer opcion;

        while (true) {

            StringBuilder display = new StringBuilder();
            display.append("Menú: \n");
            display.append("Opción 1 -> Mostrar agencias y sus datos.\n");
            display.append("Opción 2 -> Mostrar órdenes de clientes.\n");
            display.append("Opción 3 -> Salir\n");
            System.out.println(display.toString());

            opcion = Integer.parseInt(input.nextLine());

            switch (opcion) {
                case 1:
                    System.out.println("Agencias activas:");
                    Collection<Agencia> agencias = agenciaService.findAllAgencias();
                    for (Agencia a : agencias) {
                        System.out.println(a);
                    }

                    break;

                case 2:
                    System.out.println("Órdenes de los clientes: ");
                    Collection<Cliente> clientes = clienteService.findAllClientes();
                    for (Cliente c : clientes) {
                        Query queryOrdenes = em
                                .createQuery(
                                        "SELECT o from Orden o\n" +
                                                "JOIN ClienteOrden co on o.idOrden = co.idOrden\n" +
                                                "JOIN Cliente c on c.idCliente = co.idCliente\n" +
                                                "WHERE c.idCliente = " + c.getIdCliente());
                        Collection<Orden> ordenes = (Collection<Orden>) queryOrdenes.getResultList();
                        c.setOrdenes((List<Orden>) ordenes);

                        System.out.println(c.getIdCliente() + " -> " + c.getOrdenes() + "\n");
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
