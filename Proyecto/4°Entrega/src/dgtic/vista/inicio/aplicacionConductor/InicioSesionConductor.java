package dgtic.vista.inicio.aplicacionConductor;

import java.util.Scanner;

public class InicioSesionConductor {
    private String correo;
    private String contrasena;
    Scanner input = new Scanner(System.in);

    /* Método que recibe correo y contrasena */
    public void ingresarDatos() {
        System.out.println("Inicio sesión administrador.\n");
        boolean flag = false;

        do {
            try {
                System.out.print("Correo: ");
                this.correo = input.nextLine();
                System.out.println(correo);

                System.out.print("Contrasena: ");
                this.contrasena = input.nextLine();
                System.out.println(contrasena);
                flag = true;
            } catch (Exception e) {
                System.out.println("Datos no válidos. Ingrese un correo y contrasena válidos.");
            }
        } while (flag == false);
    }

    /* Método que verifica que exista el usuario en la base de datos. */
    public boolean iniciarSesion() {
        return true;
    }
}
