package dgtic.inicio.aplicacionAdministrador;

import java.util.Scanner;
import java.util.prefs.BackingStoreException;

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
        System.out.print("Ingrese el nombre completo: ");
        String nombre = input.nextLine();

        System.out.print("Ingrese el correo institucional: ");
        String correo = input.nextLine();

        System.out.print("Ingrese la contraseña: ");
        String contrasena = input.nextLine();

        System.out.print("Ingrese el rfc: ");
        String rfc = input.nextLine();

        System.out.print("Ingrese el salario del nuevo conductor: ");
        float salario = input.nextFloat();

        System.out.print("Ingrese la clave del Empleado (código de 3 letras y 2 números): ");
        String claveEmpleado = input.nextLine();

        System.out.print("Ingrese la clave del conductor(número entero del 0 al 999): ");
        input.nextLine();
        int claveConductor = input.nextInt();

        Conductor conductor = new Conductor(claveEmpleado, nombre, correo, contrasena, rfc,
                salario, Puesto.CONDUCTOR, claveConductor, null, null);

        return conductor;
    }

    static String quitarConductor() {
        input.nextLine();
        System.out.print("Ingrese la clave del conductor que quiere despedir: ");
        String claveConductor = input.nextLine();

        return claveConductor;
    }

    static Administrador nuevoAdministrador() {
        System.out.print("Ingrese el nombre completo: ");
        String nombre = input.nextLine();

        System.out.print("Ingrese el correo institucional: ");
        String correo = input.nextLine();

        System.out.print("Ingrese la contraseña: ");
        String contrasena = input.nextLine();

        System.out.print("Ingrese el rfc: ");
        String rfc = input.nextLine();

        System.out.print("Ingrese el salario del nuevo administrador: ");
        float salario = input.nextFloat();

        System.out.print("Ingrese la clave del Empleado (código de 3 letras y 2 números): ");
        String claveEmpleado = input.nextLine();

        System.out.print("Ingrese la clave del administrador(número entero del 0 al 999): ");
        input.nextLine();
        int claveConductor = input.nextInt();

        Administrador administrador = new Administrador(claveEmpleado, nombre, correo, contrasena, rfc,
                salario, Puesto.ADMINISTRADOR, claveConductor);

        return administrador;
    }

    static String quitarAdministrador() {
        input.nextLine();
        System.out.print("Ingrese el administrador que quiere despedir: ");
        String claveAdministrador = input.nextLine();
        return claveAdministrador;
    }

    static Autobus nuevAutobus() {
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

    public void opcion8() {
        Autobus autobus = new Autobus.Builder(2, "Modelo1", "Marca1", 60).setTipoTour(TipoUso.TOUR)
                .setTipoTuribus(TipoTuribus.DOS_PISOS).build();
    }

    public void opcion9() {
        System.out.print("Ingrese el autobús que quiere vender: ");
        int claveAutobus = input.nextInt();
    }

    public void opcion10() {
        System.out.println(Consulta.consultaConductores());
    }

    public void opcion11() {
        System.out.println(Consulta.consultaAdministradores());
    }

    public void opcion12() {
        System.out.println(Consulta.consultaViajes());
    }

    public void opcion13() {
        System.out.println(Consulta.consultaAutobuses());
    }

    public void opcion14() {
        System.out.print("Ingrese la clave de Conductor: ");
        input.nextLine();
        String claveConductor = input.nextLine();
        System.out.print("\nIngrese el id del Viaje: ");
        int idViaje = input.nextInt();
        administrador.asignarViaje(claveConductor, idViaje);
    }

    public void opcion15() {
        System.out.print("Ingrese la clave de Conductor: ");
        input.nextLine();
        String claveConductor = input.nextLine();
        System.out.print("\nIngrese el id del Autobús: ");
        int idAutobus = input.nextInt();
        administrador.asignarAutobus(claveConductor, idAutobus);
    }

    public void opcion16() {
        System.out.print("Ingrese la clave de Conductor: ");
        input.nextLine();
        String claveConductor = input.nextLine();
        System.out.print("\nIngrese el id del Viaje: ");
        int idViaje = input.nextInt();
        administrador.quitarViajeConductor(claveConductor, idViaje);
    }

    public void opcion17() {
        System.out.print("Ingrese la clave de Conductor: ");
        input.nextLine();
        String claveConductor = input.nextLine();
        System.out.print("\nIngrese el id del Autobús: ");
        int idAutobus = input.nextInt();
        administrador.quitarAutobusConductor(claveConductor, idAutobus);
    }
}
