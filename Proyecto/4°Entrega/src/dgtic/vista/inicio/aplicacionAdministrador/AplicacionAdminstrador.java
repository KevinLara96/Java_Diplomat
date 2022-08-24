package dgtic.inicio.aplicacionAdministrador;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;

import dgtic.basedatos.servicio.HibernateUtil;
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
        HibernateUtil.init();
        do {
            System.out.println("Elegir una operación.\n");
            System.out.println("1. Nuevo administrador.");
            System.out.println("2. Borrar administrador.");
            System.out.println("3. Nuevo conductor.");
            System.out.println("4. Borrar conductor.");
            System.out.println("5. Consulta administradores.");
            System.out.println("6. Consulta conductores.");
            System.out.println("7. Actualiza administrador.");
            System.out.println("8. Actualiza conductor.");
            System.out.println("9. Salir");
            System.out.print("Su opción: ");

            try {
                this.opcion = Integer.parseInt(input.nextLine());
            } catch (Exception e) {
                System.out.println("Ingrese un dato válido.");
                input.nextLine();
            }

            switch (this.opcion) {
                case 1:
                    administrador.anadirAdministrador(Menu.nuevoAdministrador());
                    break;

                case 2:
                    administrador.eliminarAdministrador(Menu.quitarAdministrador());
                    break;

                case 3:
                    administrador.anadirConductor(Menu.nuevoConductor());
                    break;

                case 4:
                    administrador.eliminarConductor(Menu.quitarConductor());
                    break;

                case 5:
                    administrador.consultaAdministradores();
                    break;

                case 6:
                    administrador.consultaConductores();
                    break;

                case 7:
                    administrador.actualizaAdministrador(Menu.actualizaAdministrador());
                    break;

                case 8:
                    administrador.actualizaConductor(Menu.actualizaConductor());
                    break;

                case 9:
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