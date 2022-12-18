package unam.dgtic.diplomado;

import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import unam.dgtic.diplomado.controlador.servicio.agencia.ServicioAgencia;
import unam.dgtic.diplomado.controlador.servicio.cliente.ServicioCliente;
//import unam.dgtic.diplomado.controlador.servicio.cliente.ServicioOrden;
import unam.dgtic.diplomado.modelo.entidades.agencia.Agencia;
import unam.dgtic.diplomado.modelo.entidades.cliente.*;

public class Pruebas {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("proyectofinal");
        EntityManager em = emf.createEntityManager();

        Scanner input = new Scanner(System.in);
        ServicioCliente servicioCliente = new ServicioCliente(em);
        ServicioAgencia servicioAgencia = new ServicioAgencia(em);
        // ServicioOrden servicioOrden = new ServicioOrden(em);

        while (true) {
            System.out.println("\nMenú principal:\n");
            System.out.println("1. Consulta grupo.");
            System.out.println("2. Consulta individual.");
            System.out.println("3. Creación.");
            System.out.println("4. Modificación.");
            System.out.println("5. Eliminación.");
            System.out.println("6. Salir.");
            System.out.print("Su opción: ");
            int opcion = Integer.parseInt(input.nextLine());

            switch (opcion) {
                case 1:
                    Iterable<Cliente> iterable = servicioCliente.obtenerClientes();
                    for (Cliente a : iterable) {
                        System.out.println(a);
                        System.out.println();
                    }

                    break;

                case 2: {
                    System.out.print("Ingrese el id: ");
                    int id = Integer.parseInt(input.nextLine());
                    Cliente consulta = servicioCliente.obtenerCliente(id);
                    System.out.println(consulta);
                    System.out.println();

                    break;
                }

                case 3: {

                    try {
                        Cliente nuevo = new Cliente();
                        System.out.print("Nombres: ");
                        String a = input.nextLine();
                        nuevo.setNombres(a);

                        System.out.print("Apellidos: ");
                        String b = input.nextLine();
                        nuevo.setApellidos(b);

                        System.out.print("calle: ");
                        String c = input.nextLine();
                        nuevo.setCalle(c);

                        System.out.print("colonia: ");
                        String d = input.nextLine();
                        nuevo.setColonia(d);

                        System.out.print("cp: ");
                        String e = input.nextLine();
                        nuevo.setCodigoPostal(e);

                        System.out.print("telefono: ");
                        String f = input.nextLine();
                        nuevo.setTelefono(f);

                        System.out.print("rfc: ");
                        String g = input.nextLine();
                        nuevo.setRfc(g);

                        System.out.print("correo: ");
                        String h = input.nextLine();
                        nuevo.setCorreo(h);

                        System.out.print("contrasena: ");
                        String i = input.nextLine();
                        nuevo.setContrasena(i);

                        System.out.print("idAgencia: ");
                        String j = input.nextLine();
                        if (j == null) {
                            throw new NumberFormatException("ERROR. Id de Agencia inválido.");
                        } else {
                            Integer j2 = Integer.parseInt(j);
                            Agencia agencia = servicioAgencia.obtenerAgencia(j2);
                            nuevo.setAgencia(agencia);
                        }

                        servicioCliente.guardarCliente(nuevo);

                    } catch (NumberFormatException e) {
                        System.out.println(e.getMessage());
                        e.printStackTrace();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                }

                case 4: {
                    System.out.print("Id: ");
                    int id = Integer.parseInt(input.nextLine());
                    Cliente actualizar = servicioCliente.obtenerCliente(id);

                    if (actualizar == null) {
                        System.out.println("Cliente no encontrada");
                    } else {
                        try {
                            System.out.print("RFC: ");
                            String a = input.nextLine();

                            actualizar.setRfc(a);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            break;
                        }
                        servicioCliente.actualizarCliente(actualizar);
                    }

                    break;
                }

                case 5: {

                    System.out.print("Id: ");
                    int id = Integer.parseInt(input.nextLine());
                    Cliente agenciaElim = servicioCliente.obtenerCliente(id);

                    if (agenciaElim != null) {
                        servicioCliente.eliminarCliente(agenciaElim.getIdCliente());
                    } else {
                        System.out.println("No se encuentra dicha agencia");
                    }

                    break;
                }

                case 6:
                    input.close();
                    System.exit(0);

                    break;
            }
        }
    }
}
