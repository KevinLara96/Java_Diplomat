package dgtic.inicio.aplicacionAdministrador;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;

import dgtic.modelo.agencia.Agencia;
import dgtic.modelo.empleado.Empleado;

public class InicioSesionAdministrador {
    private Agencia agencia;
    private String correo;
    private String contrasena;
    Scanner input = new Scanner(System.in);

    /* Constructor. Inicializa los datos de la agencia. */
    public InicioSesionAdministrador() {
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

    /* Método que recibe correo y contrasena */
    public void ingresarDatos() {
        System.out.println("Inicio sesión administrador.\n");
        boolean flag = false;

        do {
            try {
                System.out.print("Correo: ");
                this.correo = input.nextLine();
                System.out.println();

                System.out.print("Contrasena: ");
                this.contrasena = input.nextLine();
                System.out.println();
                flag = true;
            } catch (Exception e) {
                System.out.println("Datos no válidos. Ingrese un correo y contrasena válidos.");
            }
        } while (flag == false);
    }

    /* Método que verifica que exista el usuario en la base de datos. */
    public Empleado iniciarSesion() {
        for (Empleado empleado : this.agencia.getAdministradores()) {
            if (empleado.getCorreo().equals(this.correo)) {
                if (empleado.getContrasena().equals((this.contrasena))) {
                    System.out.println("Inicio de sesión con éxito.");
                    return empleado;
                }
            }
        }
        System.out.println("Datos incorrectos.");
        return null;
    }
}
