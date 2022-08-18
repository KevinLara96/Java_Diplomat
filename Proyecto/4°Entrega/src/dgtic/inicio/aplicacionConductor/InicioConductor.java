package dgtic.inicio.aplicacionConductor;

public class InicioConductor {
    private AplicacionConductor aplicacionConductor;
    private InicioSesionConductor inicioSesionConductor;

    public static void main(String[] args) {
        InicioConductor mainConductor = new InicioConductor();

        if (mainConductor.inicioSesion()) {
            mainConductor.aplicacionConductor = new AplicacionConductor();
            mainConductor.aplicacionConductor.ejecutarAplicacion();
        }
    }

    public boolean inicioSesion() {
        this.inicioSesionConductor = new InicioSesionConductor();
        this.inicioSesionConductor.ingresarDatos();
        return this.inicioSesionConductor.iniciarSesion();
    }
}
