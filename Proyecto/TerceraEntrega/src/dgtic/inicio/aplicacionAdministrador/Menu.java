package dgtic.inicio.aplicacionAdministrador;

import java.util.Scanner;

import dgtic.basedatos.servicio.consulta.Consulta;
import dgtic.modelo.autobus.Autobus;
import dgtic.modelo.autobus.interfaces.Clase;
import dgtic.modelo.autobus.interfaces.TipoTuribus;
import dgtic.modelo.autobus.interfaces.TipoUso;
import dgtic.modelo.empleado.administrador.Administrador;
import dgtic.modelo.empleado.conductor.Conductor;
import dgtic.modelo.empleado.puesto.Puesto;
import dgtic.modelo.viaje.Viaje;
import dgtic.modelo.viaje.implementacion.FactoryViajeCorto;
import dgtic.modelo.viaje.interfaces.AbstractFactory;
import dgtic.modelo.viaje.interfaces.TipoViaje;
import dgtic.modelo.viaje.interfaces.Viajes;

public class Menu {
    private static Scanner input = new Scanner(System.in);

    static void salir() {
        input.close();
        System.exit(0);
    }

    static Viaje nuevoDestino() {
        String origen;
        String destino;
        float precio;
        int distancia;
        int idViaje;
        String fecha;
        Viaje viaje = null;

        boolean bandera = false;

        do {
            try {
                System.out.print("Ingrese el origen: ");
                origen = input.nextLine();

                System.out.print("Ingrese el destino: ");
                destino = input.nextLine();

                System.out.print("Ingrese el precio: ");
                precio = Float.parseFloat(input.nextLine());

                System.out.print("Ingrese la distancia: ");
                distancia = Integer.parseInt(input.nextLine());

                System.out.print("Ingrese el identificador del viaje(número entero del 1 al 999): ");
                idViaje = Integer.parseInt(input.nextLine());

                System.out.print("Ingrese la fecha del viaje en formato MM/DD/YYYY: ");
                fecha = input.nextLine();

                AbstractFactory factory = new FactoryViajeCorto();
                Viajes viajeCortoFactory = factory.crearViaje();
                viaje = viajeCortoFactory.viaje(idViaje, origen, destino, precio, distancia,
                        fecha, TipoViaje.CORTO);

                bandera = true;
            } catch (Exception e) {
                System.out.println("Datos ingresados no válidos, por favor, revise sus datos e ingrese de nuevo.");
                e.printStackTrace();
            }
        } while (bandera == false);

        return viaje;
    }

    static int quitarDestino() {
        System.out.print("Ingrese el identificador del viaje que quiere eliminar: ");
        int idViaje = input.nextInt();
        return idViaje;
    }

    static Conductor nuevoConductor() {
        String nombre;
        String correo;
        String contrasena;
        String rfc;
        float salario;
        String claveEmpleado;
        int claveConductor;
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

                System.out.print("Ingrese la clave del Empleado (código de 3 letras y 2 números): ");
                claveEmpleado = input.nextLine();

                System.out.print("Ingrese la clave del conductor(número entero del 0 al 999): ");
                input.nextLine();
                claveConductor = Integer.parseInt(input.nextLine());

                conductor = new Conductor(claveEmpleado, nombre, correo, contrasena, rfc,
                        salario, Puesto.CONDUCTOR, claveConductor, null, null);
            } catch (Exception e) {
                System.out.println("Datos no válidos, por favor, revise los datos y vuelva a ingresarlos.");
                e.printStackTrace();
            }

        } while (bandera == false);

        return conductor;
    }

    static String quitarConductor() {
        input.nextLine();
        System.out.print("Ingrese la clave del conductor que quiere despedir: ");
        String claveConductor = input.nextLine();

        return claveConductor;
    }

    static Administrador nuevoAdministrador() {
        String nombre;
        String correo;
        String contrasena;
        String rfc;
        float salario;
        String claveEmpleado;
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
                salario = input.nextFloat();

                System.out.print("Ingrese la clave del Empleado (código de 3 letras y 2 números): ");
                claveEmpleado = input.nextLine();

                System.out.print("Ingrese la clave del administrador(número entero del 0 al 999): ");
                input.nextLine();
                claveAdministrador = input.nextInt();

                administrador = new Administrador(claveEmpleado, nombre, correo, contrasena, rfc,
                        salario, Puesto.ADMINISTRADOR, claveAdministrador);
            } catch (Exception e) {
                System.out.println("Datos no válidos, por favor, revise los datos y vuelva a ingresarlos.");
                e.printStackTrace();
            }
        } while (bandera == false);
        return administrador;
    }

    static String quitarAdministrador() {
        input.nextLine();
        System.out.print("Ingrese el administrador que quiere despedir: ");
        String claveAdministrador = input.nextLine();
        return claveAdministrador;
    }

    static Autobus nuevoAutobus() {
        String modelo;
        String marca;
        int claveAutobus;
        int capacidad;
        Autobus autobus = null;

        boolean bandera = false;
        do {
            try {
                System.out.print("Ingrese la marca del autobús: ");
                marca = input.nextLine();

                System.out.print("Ingrese el modelo del autobús: ");
                modelo = input.nextLine();

                System.out.print("Ingrese la clave del autobús(número entero del 1 al 999):");
                claveAutobus = Integer.parseInt(input.nextLine());

                System.out.print("Ingrese la capacidad del autobús: ");
                capacidad = Integer.parseInt(input.nextLine());

                autobus = new Autobus.Builder(claveAutobus, modelo, marca, capacidad).setTipoViaje(TipoUso.VIAJE)
                        .setClase(Clase.EJECUTIVO).build();

                bandera = true;
            } catch (Exception e) {
                System.out.println("Datos inválidos, por favor, revise sus datos e ingrese de nuevo.");
            }
        } while (bandera == false);
        return autobus;
    }

    static Autobus nuevoTuribus() {
        String modelo;
        String marca;
        int claveAutobus;
        int capacidad;
        Autobus turibus = null;

        boolean bandera = false;
        do {
            try {
                System.out.print("Ingrese la marca del turibús: ");
                marca = input.nextLine();

                System.out.print("Ingrese el modelo del turibús: ");
                modelo = input.nextLine();

                System.out.print("Ingrese la clave del turibús(número entero del 1 al 999):");
                claveAutobus = Integer.parseInt(input.nextLine());

                System.out.print("Ingrese la capacidad del turibús: ");
                capacidad = Integer.parseInt(input.nextLine());

                turibus = new Autobus.Builder(claveAutobus, modelo, marca, capacidad).setTipoTour(TipoUso.TOUR)
                        .setTipoTuribus(TipoTuribus.UN_PISO).build();

                bandera = true;
            } catch (Exception e) {
                System.out.println("Datos inválidos, por favor, revise sus datos e ingrese de nuevo.");
            }
        } while (bandera == false);
        return turibus;
    }

    static int quitarAutobus() {
        System.out.print("Ingrese el autobús que quiere vender: ");
        int claveAutobus = input.nextInt();
        return claveAutobus;
    }

    static String consultaConductores() {
        return Consulta.consultaConductores();
    }

    static String consultaAdministradores() {
        return Consulta.consultaAdministradores();
    }

    static String consultaViajes() {
        return Consulta.consultaViajes();
    }

    static String consultaAutobuses() {
        return Consulta.consultaAutobuses();
    }

    static String[] asignarViaje() {
        String claveConductor;
        String idViaje;
        String array[] = new String[2];

        boolean bandera = false;

        do {
            try {
                System.out.print("Ingrese la clave de Conductor: ");
                claveConductor = input.nextLine();
                System.out.print("\nIngrese el id del Viaje: ");
                idViaje = input.nextLine();
                array[0] = claveConductor;
                array[1] = idViaje;
                bandera = true;
            } catch (Exception e) {
                System.out.println("Datos inválidos, por favor verifique sus datos e intente de nuevo.");
                e.printStackTrace();
            }
        } while (bandera == false);

        return array;
    }

    static String[] asignarAutobus() {
        String claveConductor;
        String idAutobus;
        String array[] = new String[2];

        boolean bandera = false;

        do {
            try {
                System.out.print("Ingrese la clave de Conductor: ");
                claveConductor = input.nextLine();
                System.out.print("\nIngrese el id del Autobús: ");
                idAutobus = input.nextLine();
                array[0] = claveConductor;
                array[1] = idAutobus;
                bandera = true;
            } catch (Exception e) {
                System.out.println("Datos inválidos, por favor verifique sus datos e intente de nuevo.");
                e.printStackTrace();
            }
        } while (bandera == false);

        return array;
    }

    static String[] removerViajeConductor() {
        String claveConductor;
        String idViaje;
        String array[] = new String[2];

        boolean bandera = false;

        do {
            try {
                System.out.print("Ingrese la clave de Conductor: ");
                claveConductor = input.nextLine();
                System.out.print("\nIngrese el id del Viaje: ");
                idViaje = input.nextLine();
                array[0] = claveConductor;
                array[1] = idViaje;
                bandera = true;
            } catch (Exception e) {
                System.out.println("Datos inválidos, por favor verifique sus datos e intente de nuevo.");
                e.printStackTrace();
            }
        } while (bandera == false);

        return array;
    }

    static String[] removerAutobusConductor() {
        String claveConductor;
        String idAutobus;
        String array[] = new String[2];

        boolean bandera = false;

        do {
            try {
                System.out.print("Ingrese la clave de Conductor: ");
                claveConductor = input.nextLine();
                System.out.print("\nIngrese el id del Autobús: ");
                idAutobus = input.nextLine();
                array[0] = claveConductor;
                array[1] = idAutobus;
                bandera = true;
            } catch (Exception e) {
                System.out.println("Datos inválidos, por favor verifique sus datos e intente de nuevo.");
                e.printStackTrace();
            }
        } while (bandera == false);

        return array;
    }
}
