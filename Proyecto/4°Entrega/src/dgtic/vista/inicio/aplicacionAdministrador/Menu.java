package dgtic.vista.inicio.aplicacionAdministrador;

import java.util.List;
import java.util.Scanner;

import dgtic.modelo.entidades.empleado.administrador.Administrador;
import dgtic.modelo.entidades.empleado.conductor.Conductor;

public class Menu {
    private static Scanner input = new Scanner(System.in);

    static void salir() {
        input.close();
        System.exit(0);
    }

    static Conductor nuevoConductor() {
        String nombre;
        String correo;
        String contrasena;
        String rfc;
        Float salario;
        Integer claveConductor;
        Conductor conductor = null;

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

                System.out.print("Ingrese el salario del nuevo conductor: ");
                salario = Float.parseFloat(input.nextLine());

                System.out.print("Ingrese la clave del conductor(número entero del 0 al 999): ");
                claveConductor = Integer.parseInt(input.nextLine());

                conductor = new Conductor(claveConductor, nombre, correo, contrasena, rfc,
                        salario);

                bandera = true;
            } catch (Exception e) {
                System.out.println("Datos no válidos, por favor, revise los datos y vuelva a ingresarlos.");
                e.printStackTrace();
            }

        } while (bandera == false);

        return conductor;
    }

    static Conductor quitarConductor() {
        System.out.print("Ingrese la clave del conductor que quiere despedir: ");
        String claveConductor = input.nextLine();

        return new Conductor();
    }

    static Administrador nuevoAdministrador() {
        String nombre;
        String correo;
        String contrasena;
        String rfc;
        float salario;
        int claveAdministrador;
        Administrador administrador = null;

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

                System.out.print("Ingrese el salario del nuevo administrador: ");
                salario = Float.parseFloat(input.nextLine());

                System.out.print("Ingrese la clave del administrador(número entero del 0 al 999): ");
                claveAdministrador = Integer.parseInt(input.nextLine());

                administrador = new Administrador(claveAdministrador, nombre, correo, contrasena, rfc,
                        salario);
                bandera = true;
            } catch (Exception e) {
                System.out.println("Datos no válidos, por favor, revise los datos y vuelva a ingresarlos.");
                e.printStackTrace();
            }
        } while (bandera == false);
        return administrador;
    }

    static Administrador quitarAdministrador() {
        System.out.print("Ingrese el administrador que quiere despedir: ");
        String claveAdministrador = input.nextLine();
        return new Administrador();
    }

    static List<Conductor> consultaConductores() {
        return null;
    }

    static List<Administrador> consultaAdministradores() {
        return null;
    }

    public static Administrador actualizaAdministrador() {
        return new Administrador();
    }

    public static Conductor actualizaConductor() {
        return new Conductor();
    }
}
