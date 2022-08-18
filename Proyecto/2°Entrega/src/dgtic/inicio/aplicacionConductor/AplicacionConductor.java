package dgtic.inicio.aplicacionConductor;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;

import dgtic.modelo.agencia.Agencia;
import dgtic.modelo.empleado.Empleado;

public class AplicacionConductor {
    private Agencia agencia;
    private int opcion = -1;
    private Scanner input = new Scanner(System.in);

    public AplicacionConductor() {
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
        for (Empleado conductor : agencia.getConductores()) {
            System.out.println(conductor);
        }
    }

    public void opcion0() {
        System.exit(0);
    }
}