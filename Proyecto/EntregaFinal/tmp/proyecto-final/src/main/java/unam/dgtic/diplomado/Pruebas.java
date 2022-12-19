package unam.dgtic.diplomado;

import java.util.Calendar;
import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import unam.dgtic.diplomado.controlador.servicio.agencia.ServicioAgencia;
import unam.dgtic.diplomado.controlador.servicio.viaje.ServicioTipoViajeAutobus;
import unam.dgtic.diplomado.controlador.servicio.viaje.ServicioTipoViajeAvion;
import unam.dgtic.diplomado.controlador.servicio.viaje.ServicioViaje;
import unam.dgtic.diplomado.modelo.entidades.viaje.TipoViajeAutobus;
import unam.dgtic.diplomado.modelo.entidades.viaje.TipoViajeAvion;
import unam.dgtic.diplomado.modelo.entidades.viaje.Viaje;

public class Pruebas {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("proyectofinal");
        EntityManager em = emf.createEntityManager();

        Scanner input = new Scanner(System.in);
        ServicioViaje servicioViaje = new ServicioViaje(em);
        ServicioAgencia servicioAgencia = new ServicioAgencia(em);
        ServicioTipoViajeAvion servicioTipoViajeAvion = new ServicioTipoViajeAvion(em);
        ServicioTipoViajeAutobus servicioTipoViajeAutobus = new ServicioTipoViajeAutobus(em);

        while (true) {
            System.out.println("\nMenú principal:\n");
            System.out.println("1. Consulta grupo.");
            System.out.println("2. Consulta individual.");
            System.out.println("3. Creación.");
            System.out.println("4. Modificación.");
            System.out.println("5. Eliminación.");
            System.out.println("6. Salir.");
            System.out.print("Su opción: ");
            int opcion = Integer.parseInt(input.nextLine());

            switch (opcion) {
                case 1:
                    Iterable<Viaje> iterable = servicioViaje.obtenerViajes();
                    for (Viaje o : iterable) {
                        System.out.println(o);
                        System.out.println();
                    }

                    break;

                case 2: {
                    System.out.print("Ingrese el id: ");
                    int id = Integer.parseInt(input.nextLine());
                    Viaje consulta = servicioViaje.obtenerViaje(id);
                    System.out.println(consulta);
                    System.out.println();

                    break;
                }

                case 3: {
                    System.out.println("1. Viaje avión.");
                    System.out.println("2. Viaje autobús.");
                    int opcionViaje = Integer.parseInt(input.nextLine());

                    switch (opcionViaje) {
                        case 1:
                            TipoViajeAvion tipoViajeAvion = servicioTipoViajeAvion.obtenerTipoViajeAvion(2);
                            Viaje viaje1 = new Viaje.Builder().setViajeAvion(tipoViajeAvion).build();
                            try {
                                viaje1.setOrigen("null");
                                viaje1.setDestino("null");
                                viaje1.setPrecio(110.0f);
                                viaje1.setFecha(Calendar.getInstance().getTime());
                                viaje1.setAgencia(servicioAgencia.obtenerAgencia(1));
                                viaje1.setTipoViajeAutobus(servicioTipoViajeAutobus.obtenerTipoViajeAutobus(4));
                                servicioViaje.guardarViaje(viaje1);

                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }

                            break;

                        case 2:
                            TipoViajeAutobus tipoViajeAutobus = servicioTipoViajeAutobus.obtenerTipoViajeAutobus(2);
                            Viaje viaje2 = new Viaje.Builder().setViajeAutobus(tipoViajeAutobus).build();
                            try {
                                viaje2.setOrigen("null");
                                viaje2.setDestino("null");
                                viaje2.setPrecio(110.0f);
                                viaje2.setFecha(Calendar.getInstance().getTime());
                                viaje2.setAgencia(servicioAgencia.obtenerAgencia(1));
                                viaje2.setTipoViajeAvion(servicioTipoViajeAvion.obtenerTipoViajeAvion(4));
                                servicioViaje.guardarViaje(viaje2);

                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }

                            break;

                        default:
                            break;
                    }

                    break;
                }

                case 4: {
                    System.out.print("Id: ");
                    int id = Integer.parseInt(input.nextLine());
                    Viaje actualizar = servicioViaje.obtenerViaje(id);
                    try {
                        actualizar.setPrecio(500000.0f);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    servicioViaje.actualizarViaje(actualizar);

                    break;
                }

                case 5: {

                    System.out.print("Id: ");
                    servicioViaje.eliminarViaje(Integer.parseInt(input.nextLine()));

                    break;
                }

                case 6:
                    input.close();
                    System.exit(0);

                    break;
            }
        }
    }
}
