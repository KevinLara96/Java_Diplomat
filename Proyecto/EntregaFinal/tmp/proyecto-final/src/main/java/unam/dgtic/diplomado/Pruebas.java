package unam.dgtic.diplomado;

import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import unam.dgtic.diplomado.controlador.servicio.agencia.ServicioAgencia;
import unam.dgtic.diplomado.modelo.beans.agencia.AgenciaBean;

public class Pruebas {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("proyectofinal");
        EntityManager em = emf.createEntityManager();

        Scanner input = new Scanner(System.in);
        ServicioAgencia servicioAgencia = new ServicioAgencia(em);

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
                    Iterable<AgenciaBean> iterable = servicioAgencia.obtenerAgencias();
                    for (AgenciaBean o : iterable) {
                        System.out.println(o);
                        System.out.println();
                    }

                    break;

                case 2: {
                    System.out.print("Ingrese el id: ");
                    int id = Integer.parseInt(input.nextLine());
                    AgenciaBean consulta = servicioAgencia.obtenerAgencia(id);
                    System.out.println(consulta);
                    System.out.println();

                    break;
                }

                case 3: {

                    AgenciaBean agenciaBean = new AgenciaBean();
                    try {
                        servicioAgencia.guardarAgencia(agenciaBean);
                    } catch (Exception e) {

                    }
                }

                case 4: {
                    System.out.print("Id: ");
                    int id = Integer.parseInt(input.nextLine());
                    AgenciaBean actualizar = servicioAgencia.obtenerAgencia(id);
                    try {
                        actualizar.setUbicacionAgencia("Hola");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    servicioAgencia.actualizarAgencia(actualizar);

                    break;
                }

                case 5: {

                    System.out.print("Id: ");
                    servicioAgencia.eliminarAgencia(Integer.parseInt(input.nextLine()));

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
