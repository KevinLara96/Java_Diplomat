package vista;

import java.util.Scanner;

import modelo.empleado.*;
import controlador.Agencia;

public class Aplicacion {

    private Agencia agencia;

    public Aplicacion(Agencia agencia) {
        this.agencia = agencia;

        run(); // Inicia la aplicación.
    }

    /*
     * Método que inicia la aplicación.
     * Lleva a cabo el inicio de sesión de los empleados.
     */
    private void run() {
        Scanner input = new Scanner(System.in);
        System.out.println("Inicio de sesión.");

        System.out.print("Correo: ");
        String correo = input.nextLine();
        System.out.print("\nContrasenia: ");
        String contrasenia = input.nextLine();
        System.out.print("\n¿Es administrador?: 1=Sí. 2=No. \nSu respuesta: ");
        // input.nextLine();
        byte admin = input.nextByte();

        input.close();

        if (admin == 1) {
            String claveAdmin = input.nextLine();
            inicioSesionAdmin(claveAdmin);
        } else {
            inicioSesionConductor();
        }
    }

    /*
     * Se encarga de verificar los datos del administrador.
     * Muestra la ventana correspondiente al empleado administrador.
     * Verifica que el administrador exista en la empresa.
     */
    public static void inicioSesionAdmin(String claveAdmin) {
        new InterfazAdmin(claveAdmin);
    }

    /*
     * Se encarga de verificar los datos del conductor.
     * Muestra la ventana correspondiente al empleado conductor.
     * Verifica que el conductor exista en la empresa.
     */
    public static void inicioSesionConductor() {
        new InterfazConductor();
    }
}
