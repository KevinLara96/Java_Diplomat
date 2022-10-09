package dgtic.core.vista.aplicacion;

import java.util.Scanner;

import dgtic.core.modelo.entidades.empleado.Empleado;

public class Aplicacion {

    public static void ejecutarAplicacion() {
        Menu menu = new Menu();

        int opcion = -1;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Elegir una operación.\n");
            System.out.println("1. Nuevo empleado.");
            System.out.println("2. Eliminar empleado.");
            System.out.println("3. Nuevo destino.");
            System.out.println("4. Eliminar destino.");
            System.out.println("5. Nuevo autobus.");
            System.out.println("7. Eliminar autobus.");
            System.out.println("8. Asignar autobus a conductor.");
            System.out.println("9. Asignar destino a conductor.");
            System.out.println("10. Consulta empleados.");
            System.out.println("11. Consulta destinos.");
            System.out.println("12. Consulta autobuses.");
            System.out.println("13. Actualiza empleado.");
            System.out.println("14. Actualiza destino.");
            System.out.println("15. Actualiza autobus.");
            System.out.println("0. Salir");
            System.out.print("Su opción: ");

            try {
                opcion = Integer.parseInt(input.nextLine());
            } catch (Exception e) {
                System.out.println("Ingrese un dato válido.");
                input.nextLine();
            }

            switch (opcion) {
                case 0:
                    input.close();
                    menu.salir();
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
                    break;

                case 10:
                    for (Empleado e : menu.consultaEmpleados()) {
                        System.out.println(e);
                    }
                    break;

                case 11:

                    break;

                case 12:

                    break;

                case 13:

                    break;

                case 14:

                    break;

                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        } while (opcion != 0);
    }
}