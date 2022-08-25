package dgtic.vista.inicio.aplicacionAdministrador;

import java.util.Scanner;

import dgtic.modelo.hibernate.HibernateUtil;

public class AplicacionAdminstrador {
    private int opcion = -1;
    private Scanner input = new Scanner(System.in);

    public void ejecutarAplicacion() {
        HibernateUtil.init();
        do {
            System.out.println("Elegir una operación.\n");
            System.out.println("1. Nuevo administrador.");
            System.out.println("2. Borrar administrador.");
            System.out.println("3. Nuevo conductor.");
            System.out.println("4. Borrar conductor.");
            System.out.println("5. Consulta administradores.");
            System.out.println("6. Consulta conductores.");
            System.out.println("7. Actualiza administrador.");
            System.out.println("8. Actualiza conductor.");
            System.out.println("9. Salir");
            System.out.print("Su opción: ");

            try {
                this.opcion = Integer.parseInt(input.nextLine());
            } catch (Exception e) {
                System.out.println("Ingrese un dato válido.");
                input.nextLine();
            }

            switch (this.opcion) {
                case 1:

                    break;

                case 2:

                    break;

                case 3:

                    break;

                case 4:

                    break;

                case 5:

                    break;

                case 6:

                    break;

                case 7:

                    break;

                case 8:

                    break;

                case 9:
                    input.close();
                    Menu.salir();
                    break;

                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        } while (opcion != 0);
    }
}