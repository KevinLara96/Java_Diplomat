package dgtic.inicio.aplicacionAdministrador;

import java.util.Scanner;

import dgtic.modelo.viaje.Viaje;
import dgtic.modelo.viaje.implementacion.FactoryViajeCorto;
import dgtic.modelo.viaje.interfaces.AbstractFactory;
import dgtic.modelo.viaje.interfaces.TipoViaje;
import dgtic.modelo.viaje.interfaces.Viajes;

public class Menu {
    private static Scanner input = new Scanner(System.in);

    static void opcion0(Scanner input) {
        input.close();
        System.exit(0);
    }

    static Viaje opcion1() {
        String origen;
        String destino;
        float precio;
        int distancia;
        int idViaje;
        String fecha;
        Viaje viaje = null;

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

        } catch (Exception e) {
            System.out.println("Datos ingresados no válidos, por favor, revise sus datos e ingrese de nuevo.");
            e.printStackTrace();
        }
        return viaje;
    }
}
