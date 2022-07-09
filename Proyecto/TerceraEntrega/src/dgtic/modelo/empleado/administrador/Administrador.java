package dgtic.modelo.empleado.administrador;

import dgtic.modelo.agencia.Agencia;
import dgtic.modelo.empleado.Empleado;
import dgtic.modelo.empleado.puesto.Puesto;

public class Administrador extends Empleado {
    private String claveAdministrador;
    private int idAdministrador;

    /* Constructor */
    public Administrador(String nombre, String correo, String contrasena, String rfc, float salario, Puesto puesto,
            String claveAdministrador, int idAdministrador) {
        super(nombre, correo, contrasena, rfc, salario, puesto);
        this.claveAdministrador = claveAdministrador;
        this.idAdministrador = idAdministrador;
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
    public String getClaveAdministrador() {
        return claveAdministrador;
    }

    public void setClaveAdministrador(String claveAdministrador) {
        this.claveAdministrador = claveAdministrador;
    }

    public int getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    @Override
    public String toString() {
        return super.toString() + ", idAdministrador=" + idAdministrador + "\n";
    }

}
