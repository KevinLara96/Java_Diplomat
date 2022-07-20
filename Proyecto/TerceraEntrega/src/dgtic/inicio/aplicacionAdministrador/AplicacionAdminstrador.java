package dgtic.inicio.aplicacionAdministrador;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;

import dgtic.basedatos.servicio.consulta.Consulta;
import dgtic.modelo.agencia.Agencia;
import dgtic.modelo.autobus.Autobus;
import dgtic.modelo.autobus.interfaces.Clase;
import dgtic.modelo.autobus.interfaces.TipoTuribus;
import dgtic.modelo.autobus.interfaces.TipoUso;
import dgtic.modelo.empleado.Empleado;
import dgtic.modelo.empleado.administrador.Administrador;
import dgtic.modelo.empleado.conductor.Conductor;
import dgtic.modelo.empleado.puesto.Puesto;

public class AplicacionAdminstrador {
    private Agencia agencia;
    private int opcion = -1;
    private Scanner input = new Scanner(System.in);
    private Administrador administrador;

    public AplicacionAdminstrador(Empleado administrador) {
        try {
            FileInputStream fileIn = new FileInputStream("src/dgtic/modelo/agencia/repositorio/Agencia.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            this.agencia = (Agencia) in.readObject();
            in.close();
            fileIn.close();
            this.administrador = (Administrador) administrador;
        } catch (Exception e) {
            System.out.println("No se pudo recuperar la información.");
        }
    }

    public void ejecutarAplicacion() {
        do {
            System.out.println("Elegir una operación.\n");
            System.out.println("1. Añadir destino.");
            System.out.println("2. Eliminar destino.");
            System.out.println("3. Contratar conductor.");
            System.out.println("4. Despedir conductor.");
            System.out.println("5. Contratar administrador.");
            System.out.println("6. Despedir administrador.");
            System.out.println("7. Agregar autobús.");
            System.out.println("8. Agregar Turibús.");
            System.out.println("9. Vender autobús.");
            System.out.println("10. Mostrar conductores.");
            System.out.println("11. Mostrar administradores.");
            System.out.println("12. Mostrar destinos.");
            System.out.println("13. Mostrar autobuses.");
            System.out.println("14. Asignar viaje a conductor.");
            System.out.println("15. Asignar autobús a conductor.");
            System.out.println("16. Remover viaje a conductor.");
            System.out.println("17. Remover autobús a conductor.");
            System.out.println("0. Salir.");
            System.out.print("Su opción: ");

            try {
                this.opcion = input.nextInt();
            } catch (Exception e) {
                System.out.println("Ingrese un dato válido.");
                input.nextLine();
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

                case 14:
                    opcion14();
                    break;

                case 15:
                    opcion15();
                    break;

                case 16:
                    opcion16();
                    break;

                case 17:
                    opcion17();
                    break;

                case 0:
                    input.close();
                    Menu.opcion0(input);
                    break;

                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        } while (opcion != 0);
    }

    public void opcion1() {
        administrador.anadirViaje(Menu.opcion1());
    }

    public void opcion2() {
        System.out.print("Ingrese el identificador del viaje que quiere eliminar: ");
        int idViaje = input.nextInt();
        administrador.eliminarViaje(idViaje);
    }

    public void opcion3() {
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
        agencia.getConductores().add(conductor);
        administrador.anadirConductor(conductor);
    }

    public void opcion4() {
        input.nextLine();
        System.out.print("Ingrese la clave del conductor que quiere despedir: ");
        String claveConductor = input.nextLine();
        administrador.eliminarConductor(claveConductor);
    }

    public void opcion5() {
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
        agencia.getConductores().add(conductor);
        administrador.anadirConductor(conductor);
        Administrador admin = new Administrador("adm", "Administrador1", "cond1@sak.com", "pwdCond1", "",
                0.0f, Puesto.ADMINISTRADOR, 1);
        agencia.getAdministradores().add(admin);
        administrador.anadirAdministrador(admin);
    }

    public void opcion6() {
        input.nextLine();
        System.out.print("Ingrese el administrador que quiere despedir: ");
        String claveAdministrador = input.nextLine();
        // agencia.getConductores().remove(opcion);
        administrador.eliminarAdministrador(claveAdministrador);
    }

    public void opcion7() {
        Autobus autobus = new Autobus.Builder(1, "Modelo1", "Marca1", 60).setTipoViaje(TipoUso.VIAJE)
                .setClase(Clase.EJECUTIVO).build();
        agencia.getAutobuses().add(autobus);
        administrador.anadirAutobus(autobus);
    }

    public void opcion8() {
        Autobus autobus = new Autobus.Builder(2, "Modelo1", "Marca1", 60).setTipoTour(TipoUso.TOUR)
                .setTipoTuribus(TipoTuribus.DOS_PISOS).build();
        agencia.getAutobuses().add(autobus);
        administrador.anadirAutobus(autobus);
    }

    public void opcion9() {
        System.out.print("Ingrese el autobús que quiere vender: ");
        int claveAutobus = input.nextInt();
        // agencia.getAutobuses().remove(opcion);
        administrador.eliminarAutobus(claveAutobus);
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