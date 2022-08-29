package dgtic.modelo.entidades.agencia;

import java.io.Serializable;
import java.util.HashSet;

import dgtic.modelo.entidades.agencia.asignaciones.ConductorViaje;
import dgtic.modelo.entidades.autobus.Autobus;
import dgtic.modelo.entidades.empleado.Empleado;
import dgtic.modelo.entidades.viaje.Viaje;

public class Agencia implements Serializable {
    private Integer idAgencia;
    private String nombreAgencia;
    private String ubicacion;
    private HashSet<Empleado> empleados = new HashSet<>();
    private HashSet<Viaje> destinos = new HashSet<>();
    private HashSet<Autobus> autobuses = new HashSet<>();
    private HashSet<ConductorViaje> viajesAsignados = new HashSet<>();
    private HashSet<ConductorViaje> autobusesAsignados = new HashSet<>();

    private static Agencia INSTANCIA;

    private Agencia() {
    }

    public synchronized static Agencia getInstancia() {
        if (INSTANCIA == null) {
            INSTANCIA = new Agencia();
        }
        return INSTANCIA;
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

    public HashSet<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(HashSet<Empleado> empleados) {
        this.empleados = empleados;
    }

    public HashSet<Viaje> getDestinos() {
        return destinos;
    }

    public void setDestinos(HashSet<Viaje> destinos) {
        this.destinos = destinos;
    }

    public HashSet<Autobus> getAutobuses() {
        return autobuses;
    }

    public void setAutobuses(HashSet<Autobus> autobuses) {
        this.autobuses = autobuses;
    }

    public HashSet<ConductorViaje> getViajesAsignados() {
        return viajesAsignados;
    }

    public void setViajesAsignados(HashSet<ConductorViaje> viajesAsignados) {
        this.viajesAsignados = viajesAsignados;
    }

    public HashSet<ConductorViaje> getAutobusesAsignados() {
        return autobusesAsignados;
    }

    public void setAutobusesAsignados(HashSet<ConductorViaje> autobusesAsignados) {
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

    public static Agencia getINSTANCIA() {
        return INSTANCIA;
    }

    public static void setINSTANCIA(Agencia iNSTANCIA) {
        INSTANCIA = iNSTANCIA;
    }

}
