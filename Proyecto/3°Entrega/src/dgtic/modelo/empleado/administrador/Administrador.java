package dgtic.modelo.empleado.administrador;

import java.util.Random;

import dgtic.basedatos.servicio.borrado.Borrado;
import dgtic.basedatos.servicio.escritura.Escritura;
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

    /**************** Operaciones administrador. ****************/
    public boolean anadirAdministrador(Administrador administrador) {
        if (administrador.getNombre().toLowerCase().equals("sys")) {
            // Solo puede haber un usuario Sys.
            return false;
        }
        Escritura.altaAdministrador(administrador);
        return true;
    }

    public boolean eliminarAdministrador(String claveAdministrador) {
        if (Borrado.bajaAdministrador(claveAdministrador)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean anadirViaje(Viaje viaje) {
        if (Escritura.altaViaje(viaje)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean eliminarViaje(int idViaje) {
        if (Borrado.bajaViaje(idViaje)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean anadirConductor(Conductor conductor) {
        if (Escritura.altaConductor(conductor)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean eliminarConductor(String claveConductor) {
        if (Borrado.bajaConductor(claveConductor)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean anadirAutobus(Autobus autobus) {
        if (Escritura.altaAutobus(autobus)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean eliminarAutobus(int claveAutobus) {
        if (Borrado.bajaAutobus(claveAutobus)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean asignarViaje(String claveConductor, int idViaje) {
        if (Escritura.asignarViaje(claveConductor, idViaje)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean asignarAutobus(String claveConductor, int idAutobus) {
        if (Escritura.asignarAutobus(claveConductor, idAutobus)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean quitarAutobusConductor(String claveConductor, int claveAutobus) {
        if (Borrado.removerAutobusConductor(claveConductor, claveAutobus)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean quitarViajeConductor(String claveConductor, int idViaje) {
        if (Borrado.removerViajeConductor(claveConductor, idViaje)) {
            return true;
        } else {
            return false;
        }
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
