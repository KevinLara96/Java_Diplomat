package dgtic.modelo.empleado.administrador;

import java.util.Random;

import dgtic.basedatos.servicio.escritura.Escritura;
import dgtic.modelo.agencia.Agencia;
import dgtic.modelo.empleado.Empleado;
import dgtic.modelo.empleado.puesto.Puesto;
import dgtic.modelo.viaje.Viaje;

public class Administrador extends Empleado {
    private int claveAdministrador;

    /* Constructor */
    public Administrador(String claveEmpleado, String nombre, String correo, String contrasena, String rfc,
            float salario, Puesto puesto,
            int claveAdministrador) {
        super(claveEmpleado, nombre, correo, contrasena, rfc, salario, puesto);
        setClaveAdministrador(claveAdministrador);
    }

    /* Operaciones administrador. */
    public boolean anadirAdministrador(Administrador administrador) {
        Agencia agencia = Agencia.getInstancia();
        if (administrador.getNombre().toLowerCase().equals("sys")) {
            // Solo puede haber un usuario Sys.
            return false;
        }
        agencia.getAdministradores().add(administrador);
        Escritura.altaAdministrador(administrador);
        return true;
    }

    public boolean eliminarAdministrador() {
        return true;
    }

    public boolean anadirViaje(Viaje viaje) {
        Agencia agencia = Agencia.getInstancia();
        agencia.getDestinos().add(viaje);
        return Escritura.altaViaje(viaje);
    }

    /* Getters y Setters */
    public int getClaveAdministrador() {
        return claveAdministrador;
    }

    public void setClaveAdministrador(int claveAdministrador) {
        if (claveAdministrador <= 0) {
            Random rand = new Random();
            this.claveAdministrador = rand.nextInt(100);
        } else {
            this.claveAdministrador = claveAdministrador;
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", claveAdministrador=" + claveAdministrador + "\n";
    }

}
