package dgtic.modelo.empleado.administrador;

import java.util.List;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import dgtic.basedatos.servicio.borrado.Borrado;
import dgtic.basedatos.servicio.consulta.Consulta;
import dgtic.basedatos.servicio.escritura.Escritura;
import dgtic.modelo.empleado.Empleado;
import dgtic.modelo.empleado.conductor.Conductor;
import dgtic.modelo.empleado.puesto.Puesto;

@Entity
@Table(name = "Administrador")
public class Administrador extends Empleado {
    private Integer claveAdministrador;

    public Administrador() {
    }

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
        System.out.println("Admiiiin: " + administrador.getNombre());
        Escritura.altaAdministrador(administrador);
        return true;
    }

    public boolean eliminarAdministrador(Administrador administrador) {
        if (Borrado.bajaAdministrador(administrador)) {
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

    public boolean eliminarConductor(Conductor conductor) {
        if (Borrado.bajaConductor(conductor)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean actualizaAdministrador(Administrador administrador) {
        if (Escritura.actualizaAdministrador(administrador)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean actualizaConductor(Conductor conductor) {
        if (Escritura.actualizaConductor(conductor)) {
            return true;
        } else {
            return false;
        }
    }

    public List<Administrador> consultaAdministradores() {
        return Consulta.consultaAdministradores();
    }

    public List<Conductor> consultaConductores() {
        return Consulta.consultaConductores();
    }

    /* Getters y Setters */
    @Column(name = "claveAdministrador")
    public Integer getClaveAdministrador() {
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
    @Column(name = "claveEmpleado")
    public String getClaveEmpleado() {
        return super.getClaveEmpleado();
    }

    @Override
    public String toString() {
        return super.toString() + ", claveAdministrador=" + claveAdministrador + "\n";
    }

}
