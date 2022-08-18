package dgtic.inicio.aplicacionAdministrador;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
//import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

import dgtic.modelo.agencia.Agencia;
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
import dgtic.modelo.viaje.interfaces.Viajes;

public class AplicacionAdminstrador {
    private Agencia agencia;
    private int opcion = -1;
    private Scanner input = new Scanner(System.in);

    public AplicacionAdminstrador() {
        try {
            FileInputStream fileIn = new FileInputStream("src/dgtic/modelo/agencia/repositorio/Agencia.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            this.agencia = (Agencia) in.readObject();
            in.close();
            fileIn.close();
        } catch (Exception e) {
            System.out.println("No se pudo recuperar la información.");
        }
    }

    public void ejecutarAplicacion() {
        do {
            System.out.println("Elegir una operación.\n");
            System.out.println("1. Añadir destino.");
            System.out.println("2. Eliminar destino.");
            System.out.println("3. Contratar empleado.");
            System.out.println("4. Despedir empleado.");
            System.out.println("5. Contratar administrador.");
            System.out.println("6. Despedir administrador.");
            System.out.println("7. Agregar autobús.");
            System.out.println("8. Agregar Turibús.");
            System.out.println("9. Vender autobús.");
            System.out.println("10. Mostrar conductores.");
            System.out.println("11. Mostrar administradores.");
            System.out.println("12. Mostrar destinos.");
            System.out.println("13. Mostrar autobuses.");
            System.out.println("0. Salir.");
            System.out.print("Su opción: ");

            try {
                this.opcion = input.nextInt();
            } catch (Exception e) {
                input.nextLine();
                System.out.println("Ingrese un dato válido.");
            }

            switch (this.opcion) {
                case 1:
                    opcion1();
                    break;

                case 2:
                    opcion2();
                    break;

                case 3:
                    opcion3();
                    break;

                case 4:
                    opcion4();
                    break;

                case 5:
                    opcion5();
                    break;

                case 6:
                    opcion6();
                    break;

                case 7:
                    opcion7();
                    break;

                case 8:
                    opcion8();
                    break;

                case 9:
                    opcion9();
                    break;

                case 10:
                    opcion10();
                    break;

                case 11:
                    opcion11();
                    break;

                case 12:
                    opcion12();
                    break;

                case 13:
                    opcion13();
                    break;

                case 0:
                    opcion0();
                    break;

                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        } while (opcion != 0);
    }

    public void opcion1() {
        AbstractFactory factory = new FactoryViajeCorto();
        Viajes viajes = factory.crearViaje();
        Viaje viaje = viajes.viaje("Origen", "Destino", 20.0f, 300, LocalDate.now());
        agencia.getDestinos().add(viaje);
    }

    public void opcion2() {
        Scanner input = new Scanner(System.in);
        System.out.print("Ingrese el viaje que quiere eliminar: ");
        int opcion = input.nextInt();
        agencia.getDestinos().remove(opcion);
        input.close();
    }

    public void opcion3() {
        Conductor conductor = new Conductor("Conductor1", "cond1@sak.com", "pwdCond1", "",
                0.0f, Puesto.CONDUCTOR, 1, null, null);
        agencia.getConductores().add(conductor);
    }

    public void opcion4() {
        Scanner input = new Scanner(System.in);
        System.out.print("Ingrese el conductor que quiere despedir: ");
        int opcion = input.nextInt();
        agencia.getConductores().remove(opcion);
        input.close();
    }

    public void opcion5() {
        Administrador administrador = new Administrador("Conductor1", "cond1@sak.com", "pwdCond1", "",
                0.0f, Puesto.ADMINISTRADOR, "admin1", 1);
        agencia.getAdministradores().add(administrador);
    }

    public void opcion6() {
        Scanner input = new Scanner(System.in);
        System.out.print("Ingrese el conductor que quiere despedir: ");
        int opcion = input.nextInt();
        agencia.getConductores().remove(opcion);
        input.close();
    }

    public void opcion7() {
        Autobus autobus = new Autobus.Builder("Modelo1", "Marca1", 60).setTipoViaje(TipoUso.VIAJE)
                .setClase(Clase.EJECUTIVO).build();
        agencia.getAutobuses().add(autobus);
    }

    public void opcion8() {
        Autobus autobus = new Autobus.Builder("Modelo1", "Marca1", 60).setTipoTour(TipoUso.TOUR)
                .setTipoTuribus(TipoTuribus.DOS_PISOS).build();
        agencia.getAutobuses().add(autobus);
    }

    public void opcion9() {
        Scanner input = new Scanner(System.in);
        System.out.print("Ingrese el autobús que quiere vender: ");
        int opcion = input.nextInt();
        agencia.getAutobuses().remove(opcion);
        input.close();
    }

    public void opcion10() {
        System.out.println(agencia.getConductores());
    }

    public void opcion11() {
        System.out.println(agencia.getAdministradores());
    }

    public void opcion12() {
        System.out.println(agencia.getDestinos());
    }

    public void opcion13() {
        System.out.println(agencia.getAutobuses());
    }

    public void opcion0() {
        System.exit(0);
    }
}