package unam.dgtic.diplomado.m1100base;

import java.util.Collection;
import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import unam.dgtic.diplomado.m1100base.dominio.agencia.Agencia;
import unam.dgtic.diplomado.m1100base.dominio.viaje.TipoViaje;
import unam.dgtic.diplomado.m1100base.dominio.viaje.Viaje;
import unam.dgtic.diplomado.m1100base.modelo.AgenciaService;
import unam.dgtic.diplomado.m1100base.modelo.TipoViajeService;
import unam.dgtic.diplomado.m1100base.modelo.ViajeService;

public class Principal {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("modulo11");
        EntityManager em = emf.createEntityManager();

        ViajeService viajeService = new ViajeService(em);
        TipoViajeService tipoViajeService = new TipoViajeService(em);
        AgenciaService agenciaService = new AgenciaService(em);

        Scanner input = new Scanner(System.in);
        Integer opcion;

        while (true) {

            StringBuilder display = new StringBuilder();
            display.append("Menú: \n");
            display.append("Opción 1 -> Mostrar tablas\n");
            display.append("Opción 2 -> Nuevo Viaje\n");
            display.append("Opción 3 -> Salir\n");
            System.out.println(display.toString());

            opcion = Integer.parseInt(input.nextLine());

            switch (opcion) {
                case 1:
                    Collection<Viaje> viajes = viajeService.findAllViajes();

                    System.out.println("\nViajes disponibles:");
                    for (Viaje v : viajes) {
                        System.out.println(v);
                        System.out.println("\n");
                    }

                    break;

                case 2:
                    System.out.println("Nuevo viaje. Ingrese los datos del viaje:");
                    Viaje viaje = new Viaje();

                    // System.out.println("\nId viaje: ");
                    // viaje.setIdViaje(Integer.parseInt(input.nextLine()));

                    System.out.println("\nOrigen: ");
                    viaje.setOrigen(input.nextLine());

                    System.out.println("\nDestino: ");
                    viaje.setDestino(input.nextLine());

                    System.out.println("\nPrecio: ");
                    viaje.setPrecio(Float.parseFloat(input.nextLine()));

                    System.out.println("\nFecha: ");
                    viaje.setFecha(input.nextLine());

                    System.out.println("\nAgencia asociada (Id de agencia): ");
                    Agencia agenciaTmp = agenciaService.findAgencia(Integer.parseInt(input.nextLine()));
                    viaje.setAgencia(agenciaTmp);

                    System.out.println("\nTipo viaje (Id del tipo de viaje): ");
                    TipoViaje tipoViajeTmp = tipoViajeService.findTipoViaje(Integer.parseInt(input.nextLine()));
                    viaje.setTipoViaje(tipoViajeTmp);

                    viajeService.createViaje(viaje);

                    break;

                case 3:
                    input.close();
                    System.exit(0);

                    break;
            }
        }

    }
}
