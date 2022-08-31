package dgtic.modelo.entidades.agencia;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import dgtic.modelo.entidades.agencia.asignaciones.ConductorViaje;
import dgtic.modelo.entidades.autobus.Autobus;
import dgtic.modelo.entidades.empleado.Empleado;
import dgtic.modelo.entidades.viaje.Viaje;

public class Agencia implements Serializable {
    private Integer idAgencia;
    private String nombreAgencia;
    private String ubicacion;
    private Set<Empleado> empleados;
    private Set<Viaje> destinos;
    private Set<Autobus> autobuses;
    private Set<ConductorViaje> viajesAsignados;
    private Set<ConductorViaje> autobusesAsignados;

    public Agencia() {
        this.empleados = new HashSet<>();
        this.destinos = new HashSet<>();
        this.autobuses = new HashSet<>();
        this.viajesAsignados = new HashSet<>();
        this.autobusesAsignados = new HashSet<>();
    }

    public Integer getIdAgencia() {
        return idAgencia;
    }

    public void setIdAgencia(Integer idAgencia) {
        this.idAgencia = idAgencia;
    }

    public String getNombreAgencia() {
        return nombreAgencia;
    }

    public void setNombreAgencia(String nombreAgencia) {
        this.nombreAgencia = nombreAgencia;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Set<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Set<Empleado> empleados) {
        this.empleados = empleados;
    }

    public Set<Viaje> getDestinos() {
        return destinos;
    }

    public void setDestinos(Set<Viaje> destinos) {
        this.destinos = destinos;
    }

    public Set<Autobus> getAutobuses() {
        return autobuses;
    }

    public void setAutobuses(Set<Autobus> autobuses) {
        this.autobuses = autobuses;
    }

    public Set<ConductorViaje> getViajesAsignados() {
        return viajesAsignados;
    }

    public void setViajesAsignados(Set<ConductorViaje> viajesAsignados) {
        this.viajesAsignados = viajesAsignados;
    }

    public Set<ConductorViaje> getAutobusesAsignados() {
        return autobusesAsignados;
    }

    public void setAutobusesAsignados(Set<ConductorViaje> autobusesAsignados) {
        this.autobusesAsignados = autobusesAsignados;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("");
        str.append("\n\nAgencia ").append(nombreAgencia);
        str.append("\nUbicación: ").append(ubicacion);
        str.append("\n\nempleados:\n").append(empleados);
        str.append("\n\ndestinos:\n").append(destinos);
        str.append("\n\nautobuses:\n").append(autobuses);
        str.append("\n\n");
        return str.toString();
    }
}