package dgtic.modelo.empleado.administrador;

import java.util.Random;

import dgtic.basedatos.servicio.borrado.Borrado;
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

    /**************** Operaciones administrador. ****************/
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

    public boolean eliminarAdministrador(String claveAdministrador) {
        Agencia agencia = Agencia.getInstancia();
        if (Borrado.bajaAdministrador(claveAdministrador)) {
            for (Administrador itAdmin : agencia.getAdministradores()) {
                if (itAdmin.getClaveEmpleado().equals(claveAdministrador)) {
                    agencia.getAdministradores().remove(itAdmin);
                }
            }
            return true;
        } else {
            return false;
        }
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

    public boolean eliminarViaje(int idViaje) {
        Agencia agencia = Agencia.getInstancia();
        if (Borrado.bajaViaje(idViaje)) {
            for (Viaje itViaje : agencia.getDestinos()) {
                if (itViaje.getIdViaje() == idViaje) {
                    agencia.getDestinos().remove(itViaje);
                }
            }
            return true;
        } else {
            return false;
        }
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

    public boolean eliminarConductor(String claveConductor) {
        Agencia agencia = Agencia.getInstancia();
        if (Borrado.bajaConductor(claveConductor)) {
            for (Conductor itConductor : agencia.getConductores()) {
                if (itConductor.getClaveEmpleado().equals(claveConductor)) {
                    agencia.getConductores().remove(itConductor);
                }
            }
            return true;
        } else {
            return false;
        }
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

    public boolean eliminarAutobus(int claveAutobus) {
        Agencia agencia = Agencia.getInstancia();
        if (Borrado.bajaAutobus(claveAutobus)) {
            for (Autobus itAutobus : agencia.getAutobuses()) {
                if (itAutobus.getClaveAutobus() == claveAutobus) {
                    agencia.getAutobuses().remove(itAutobus);
                }
            }
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
