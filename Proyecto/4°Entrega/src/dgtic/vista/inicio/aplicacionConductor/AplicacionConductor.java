package dgtic.vista.inicio.aplicacionConductor;

import java.util.Scanner;

public class AplicacionConductor {
    private int opcion = -1;
    private Scanner input = new Scanner(System.in);

    public void ejecutarAplicacion() {
        do {
            System.out.println("Elegir una operación.\n");
            System.out.println("1. Mostrar viajes asignados.");
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

    }

    public void opcion0() {
        System.exit(0);
    }
}