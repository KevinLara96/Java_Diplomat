package dgtic.modelo.empleado.administrador;

import java.util.Random;

import dgtic.modelo.agencia.Agencia;
import dgtic.modelo.empleado.Empleado;
import dgtic.modelo.empleado.puesto.Puesto;

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
        return true;
    }

    public boolean eliminarAdministrador() {
        return true;
    }

    /* Getters y Setters */
    public int getClaveAdministrador() {
        return claveAdministrador;
    }

    public void setClaveAdministrador(int claveAdministrador) {
        if (claveAdministrador <= 0) {
            Random rand = new Random();
            this.claveAdministrador = rand.nextInt(100);
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", claveAdministrador=" + claveAdministrador + "\n";
    }

}
