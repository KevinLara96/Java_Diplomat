package dgtic.inicio.aplicacionAdministrador;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;

import dgtic.modelo.agencia.Agencia;
import dgtic.modelo.empleado.Empleado;
import dgtic.modelo.empleado.administrador.Administrador;

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
                    administrador.anadirViaje(Menu.nuevoDestino());
                    break;

                case 2:
                    administrador.eliminarViaje(Menu.quitarDestino());
                    break;

                case 3:
                    administrador.anadirConductor(Menu.nuevoConductor());
                    break;

                case 4:
                    administrador.eliminarConductor(Menu.quitarConductor());
                    break;

                case 5:
                    administrador.anadirAdministrador(Menu.nuevoAdministrador());
                    break;

                case 6:
                    administrador.eliminarAdministrador(Menu.quitarAdministrador());
                    break;

                case 7:
                    administrador.anadirAutobus(Menu.nuevoAutobus());
                    break;

                case 8:
                    administrador.anadirAutobus(Menu.nuevoTuribus());
                    break;

                case 9:
                    administrador.eliminarAutobus(Menu.quitarAutobus());
                    break;

                case 10:
                    System.out.println(Menu.consultaConductores());
                    break;

                case 11:
                    System.out.println(Menu.consultaAdministradores());
                    break;

                case 12:
                    System.out.println(Menu.consultaViajes());
                    break;

                case 13:
                    System.out.println(Menu.consultaAutobuses());
                    break;

                case 14:
                    administrador.asignarViaje(Menu.asignarViaje()[0], Integer.parseInt(Menu.asignarViaje()[1]));
                    break;

                case 15:
                    administrador.asignarAutobus(Menu.asignarAutobus()[0], Integer.parseInt(Menu.asignarAutobus()[1]));
                    break;

                case 16:
                    administrador.quitarViajeConductor(Menu.removerViajeConductor()[0],
                            Integer.parseInt(Menu.removerViajeConductor()[1]));
                    break;

                case 17:
                    administrador.quitarAutobusConductor(Menu.removerAutobusConductor()[0],
                            Integer.parseInt(Menu.removerAutobusConductor()[1]));
                    break;

                case 0:
                    input.close();
                    Menu.salir();
                    break;

                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        } while (opcion != 0);
    }
}