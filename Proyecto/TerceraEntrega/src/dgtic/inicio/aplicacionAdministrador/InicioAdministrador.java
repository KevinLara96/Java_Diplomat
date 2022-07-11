package dgtic.inicio.aplicacionAdministrador;

import dgtic.modelo.empleado.Empleado;

public class InicioAdministrador {
    private AplicacionAdminstrador aplicacionAdministrador;
    private InicioSesionAdministrador inicioSesionAdministrador;

    /*
     * Main. Inicio de aplicación de adminstrador.
     */
    public static void main(String[] args) {
        InicioAdministrador inicioAdministrador = new InicioAdministrador();

        Empleado admin = inicioAdministrador.inicioSesion();
        if (admin != null) {
            inicioAdministrador.aplicacionAdministrador = new AplicacionAdminstrador(admin);
            inicioAdministrador.aplicacionAdministrador.ejecutarAplicacion();
        } else {
            System.out.println("Fin de la aplicación.");
        }
    }

    public Empleado inicioSesion() {
        this.inicioSesionAdministrador = new InicioSesionAdministrador();// Recupera el archivo SER.
        this.inicioSesionAdministrador.ingresarDatos(); // Ingresar los datos del administrador.
        return this.inicioSesionAdministrador.iniciarSesion(); // Se verifica que existan los datos del administrador.
    }
}
