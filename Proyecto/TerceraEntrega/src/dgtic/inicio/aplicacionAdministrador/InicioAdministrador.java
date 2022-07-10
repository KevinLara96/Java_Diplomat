package dgtic.inicio.aplicacionAdministrador;

public class InicioAdministrador {
    private AplicacionAdminstrador aplicacionAdministrador;
    private InicioSesionAdministrador inicioSesionAdministrador;

    public static void main(String[] args) {
        InicioAdministrador inicioAdministrador = new InicioAdministrador();

        if (inicioAdministrador.inicioSesion()) {
            inicioAdministrador.aplicacionAdministrador = new AplicacionAdminstrador();
            inicioAdministrador.aplicacionAdministrador.ejecutarAplicacion();
        }
    }

    public boolean inicioSesion() {
        this.inicioSesionAdministrador = new InicioSesionAdministrador();// Recupera el archivo SER.
        this.inicioSesionAdministrador.ingresarDatos();
        return this.inicioSesionAdministrador.iniciarSesion();
    }
}
