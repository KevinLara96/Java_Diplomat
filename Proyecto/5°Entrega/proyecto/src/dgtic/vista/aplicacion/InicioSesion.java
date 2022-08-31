package dgtic.vista.aplicacion;

import java.util.Scanner;

import dgtic.controlador.servicio.tablas.ServiciosEmpleadoImpl;
import dgtic.modelo.entidades.empleado.Empleado;

public class InicioSesion {

    /* Método que recibe correo y contrasena */
    /* Método que verifica que exista el usuario en la base de datos. */
    public static boolean inicioSesion() {

        Scanner input = new Scanner(System.in);
        String correo;
        String contrasena;
        Integer idEmpleado;

        try {
            System.out.print("\nIngrese su correo: ");
            correo = input.nextLine();
            System.out.print("\nIngrese su contrasena: ");
            contrasena = input.nextLine();
            System.out.print("\nIngrese su id de empleado: ");
            idEmpleado = Integer.parseInt(input.nextLine());

            ServiciosEmpleadoImpl servicioEmp = ServiciosEmpleadoImpl.getInstance();
            Empleado tmp = servicioEmp.cargaEmpleadoPorId(idEmpleado);
            if (tmp.getCorreo().equals(correo) &&
                    tmp.getContrasena().equals(contrasena) &&
                    tmp.getIdEmpleado().equals(idEmpleado) &&
                    (tmp.getPuesto().getIdPuesto() == 1 || tmp.getPuesto().getIdPuesto() == 2)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Datos inválidos, por favor verifique e intente de nuevo.");
            return false;
        }
    }
}
