package ejercicios02;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int opcion = -1;
        Scanner input = new Scanner(System.in);

        do {
            System.out.println("\n\nSistema de Base de datos.\nElija una opci�n: ");
            System.out.println("1. Insertar entidad.");
            System.out.println("2. Eliminar entidad.");
            System.out.println("3. Cambiar dato.");
            System.out.println("4. Mostrar datos.");
            System.out.println("0. Salir");
            System.out.print("Su opci�n: ");
            try {
                opcion = input.nextInt();
                menu(opcion);
            } catch (Exception e) {
                System.out.println("Opción inválida. Ingrese un dato válido.");
                input.next();
            }
        } while (opcion != 0);
        input.close();
        System.out.println("Fin del programa.");
    }

    public static void menu(int opcion) {
        Scanner input = new Scanner(System.in);

        switch (opcion) {
            case 1:
                System.out.print("Entidad a ingresar: ");
                String entidad = input.nextLine();

                System.out.print("Clave: ");
                int clave = input.nextInt();

                System.out.print("Poblaci�n: ");
                long poblacion = input.nextLong();

                Entidad alta = new Entidad(clave, entidad, poblacion);
                alta.alta();
                break;

            case 2:
                System.out.print("Registro a borrar: ");
                Entidad baja = new Entidad();

                baja.baja(input.nextInt());
                break;

            case 3:
                System.out.print("Registro a cambiar: ");
                int registro = input.nextInt();
                System.out.print("\nEntidad: ");
                input.nextLine();
                String nuevaEntidad = input.nextLine();

                Entidad cambio = new Entidad();
                cambio.cambio(registro, nuevaEntidad);
                break;

            case 4:
                System.out.print("Registro a buscar: ");
                int busqueda = input.nextInt();

                Entidad select = new Entidad();
                System.out.println(select.select(busqueda));
                break;

            case 0:
                System.out.println("Fin del programa.");
                System.exit(0);
                break;

            default:
                System.out.println("Opción inválida. Ingrese una opción válida.");
        }
        input.close();
    }

}