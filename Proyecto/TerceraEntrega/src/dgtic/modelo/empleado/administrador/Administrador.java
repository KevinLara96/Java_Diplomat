package dgtic.modelo.empleado.administrador;

import java.util.Random;

import dgtic.basedatos.servicio.escritura.Escritura;
import dgtic.modelo.agencia.Agencia;
import dgtic.modelo.autobus.Autobus;
import dgtic.modelo.empleado.Empleado;
import dgtic.modelo.empleado.conductor.Conductor;
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
        if (Escritura.altaViaje(viaje)) {
            agencia.getDestinos().add(viaje);
            return true;
        } else {
            return false;
        }
    }

    public boolean eliminarViaje() {
        return true;
    }

    public boolean anadirConductor(Conductor conductor) {
        Agencia agencia = Agencia.getInstancia();
        if (Escritura.altaConductor(conductor)) {
            agencia.getConductores().add(conductor);
            return true;
        } else {
            return false;
        }
    }

    public boolean eliminarConductor() {
        return true;
    }

    public boolean anadirAutobus(Autobus autobus) {
        Agencia agencia = Agencia.getInstancia();
        if (Escritura.altaAutobus(autobus)) {
            agencia.getAutobuses().add(autobus);
            return true;
        } else {
            return false;
        }
    }

    public boolean eliminarAutobus() {
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
        } else {
            this.claveAdministrador = claveAdministrador;
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", claveAdministrador=" + claveAdministrador + "\n";
    }

}
