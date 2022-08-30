package dgtic.vista.aplicacion;

import java.util.List;
import java.util.Scanner;

import dgtic.controlador.servicio.catalogos.ServiciosCatalogoPuestoImpl;
import dgtic.controlador.servicio.tablas.ServiciosAgenciaImpl;
import dgtic.controlador.servicio.tablas.ServiciosEmpleadoImpl;
import dgtic.modelo.entidades.empleado.Empleado;
import dgtic.modelo.hibernate.HibernateUtil;

public class Menu {
    private static Scanner input = new Scanner(System.in);

    public Menu() {
        HibernateUtil.init();
    }

    static void salir() {
        input.close();
        System.exit(0);
    }

    public boolean nuevoEmpleado() {
        String nombre;
        String correo;
        String contrasena;
        String rfc;
        Float salario;
        Integer idEmpleado;
        Empleado empleado = null;
        Integer puesto;

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

                System.out.println("Ingrese el puesto:");
                System.out.println("1. SYS.");
                System.out.println("2. Administrador.");
                System.out.println("3. Conductor.");
                System.out.println("4. Programador.");
                System.out.println("5. Recursos Humanos.");
                System.out.print("Su opción: ");
                puesto = Integer.parseInt(input.nextLine());
                ServiciosCatalogoPuestoImpl serviciosPuesto = ServiciosCatalogoPuestoImpl.getInstance();

                ServiciosAgenciaImpl servicioAgencia = ServiciosAgenciaImpl.getInstance();

                empleado = new Empleado();
                empleado.setNombre(nombre);
                empleado.setCorreo(correo);
                empleado.setContrasena(contrasena);
                empleado.setRfc(rfc);
                empleado.setSalario(salario);
                empleado.setIdEmpleado(idEmpleado);
                empleado.setPuesto(serviciosPuesto.cargaPuestoPorId(puesto));
                empleado.setAgencia(servicioAgencia.cargaAgencia());

                ServiciosEmpleadoImpl servicioEmpleado = ServiciosEmpleadoImpl.getInstance();
                servicioEmpleado.guardaEmpleado(empleado);

                return true;
            } catch (Exception e) {
                System.out.println("Datos no válidos, por favor, revise los datos y vuelva a ingresarlos.");
                return false;
            }
        } while (true);
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
