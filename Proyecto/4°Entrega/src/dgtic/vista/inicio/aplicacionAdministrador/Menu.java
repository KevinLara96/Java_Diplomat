package dgtic.vista.inicio.aplicacionAdministrador;

import java.util.List;
import java.util.Scanner;

import dgtic.modelo.entidades.empleado.Empleado;

public class Menu {
    private static Scanner input = new Scanner(System.in);

    static void salir() {
        input.close();
        System.exit(0);
    }

    public static Empleado nuevoEmpleado() {
        String nombre;
        String correo;
        String contrasena;
        String rfc;
        Float salario;
        Integer idEmpleado;
        Empleado empleado = null;

        boolean bandera = false;

        do {
            try {
                System.out.print("Ingrese el nombre completo: ");
                nombre = input.nextLine();

                System.out.print("Ingrese el correo institucional: ");
                correo = input.nextLine();

                System.out.print("Ingrese la contraseña: ");
                contrasena = input.nextLine();

                System.out.print("Ingrese el rfc: ");
                rfc = input.nextLine();

                System.out.print("Ingrese el salario del nuevo empleado: ");
                salario = Float.parseFloat(input.nextLine());

                System.out.print("Ingrese la clave del Empleado(número entero del 0 al 999 irrepetible): ");
                idEmpleado = Integer.parseInt(input.nextLine());

                // empleado = new Empleado(idEmpleado, nombre, correo, contrasena, rfc,
                // salario);
                empleado = new Empleado();
                bandera = true;
            } catch (Exception e) {
                System.out.println("Datos no válidos, por favor, revise los datos y vuelva a ingresarlos.");
                e.printStackTrace();
            }
        } while (bandera == false);
        return empleado;
    }

    public static Empleado quitarEmpleado() {
        System.out.print("Ingrese el empleado que quiere despedir: ");
        // String claveAdministrador = input.nextLine();
        return null;
    }

    static List<Empleado> consultaEmpleados() {
        return null;
    }

    public static Empleado actualizaEmpleado() {
        return null;
    }
}
