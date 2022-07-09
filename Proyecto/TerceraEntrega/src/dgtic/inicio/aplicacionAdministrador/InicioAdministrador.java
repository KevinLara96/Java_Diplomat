package dgtic.inicio.aplicacionAdministrador;

public class InicioAdministrador {
    private AplicacionAdminstrador aplicacionAdministrador;
    private InicioSesionAdministrador inicioSesionAdministrador;

    public static void main(String[] args) {
        InicioAdministrador mainAdministrador = new InicioAdministrador();

        if (mainAdministrador.inicioSesion()) {
            mainAdministrador.aplicacionAdministrador = new AplicacionAdminstrador();
            mainAdministrador.aplicacionAdministrador.ejecutarAplicacion();
        }
    }

    public boolean inicioSesion() {
        this.inicioSesionAdministrador = new InicioSesionAdministrador();
        this.inicioSesionAdministrador.ingresarDatos();
        return this.inicioSesionAdministrador.iniciarSesion();
    }
}
