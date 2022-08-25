package dgtic.modelo.entidades.agencia;

import java.io.Serializable;
import java.util.HashSet;

import dgtic.modelo.entidades.autobus.Autobus;
import dgtic.modelo.entidades.empleado.administrador.Administrador;
import dgtic.modelo.entidades.empleado.conductor.Conductor;
import dgtic.modelo.entidades.viaje.Viaje;

public class Agencia implements Serializable {
    private Integer idAgencia;
    private String nombreAgencia;
    private String ubicacion;
    private HashSet<Conductor> conductores;
    private HashSet<Administrador> administradores;
    private HashSet<Viaje> destinos;
    private HashSet<Autobus> autobuses;

    private static Agencia INSTANCIA;

    private Agencia() {
        this.idAgencia = 1;
        this.nombreAgencia = "SAK";
        this.destinos = new HashSet<>();
        this.conductores = new HashSet<>();
        this.administradores = new HashSet<>();
        this.autobuses = new HashSet<>();
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

    public String getNombreAgencia() {
        return nombreAgencia;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public HashSet<Viaje> getDestinos() {
        return destinos;
    }

    public HashSet<Conductor> getConductores() {
        return conductores;
    }

    public HashSet<Administrador> getAdministradores() {
        return administradores;
    }

    public HashSet<Autobus> getAutobuses() {
        return autobuses;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("");
        str.append("Agencia ").append(nombreAgencia);
        str.append("\nadministradores: ").append(administradores);
        str.append("\nconductores: ").append(conductores);
        str.append("\ndestinos: ").append(destinos);
        str.append("\nautobuses: ").append(autobuses);
        return str.toString();
    }

}
