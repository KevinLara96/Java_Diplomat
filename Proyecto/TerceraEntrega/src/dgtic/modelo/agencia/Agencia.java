package dgtic.modelo.agencia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import dgtic.modelo.autobus.Autobus;
import dgtic.modelo.empleado.administrador.Administrador;
import dgtic.modelo.empleado.conductor.Conductor;
import dgtic.modelo.viaje.Viaje;

public class Agencia implements Serializable {
    public String nombreAgencia;
    private List<Viaje> destinos;
    private List<Conductor> conductores;
    private List<Administrador> administradores;
    private List<Autobus> autobuses;

    private static Agencia INSTANCIA;

    public Agencia() {
        this.nombreAgencia = "SAK";
        this.destinos = new ArrayList<Viaje>();
        this.conductores = new ArrayList<Conductor>();
        this.administradores = new ArrayList<Administrador>();
        this.autobuses = new ArrayList<Autobus>();
    }

    public List<Viaje> getDestinos() {
        return destinos;
    }

    /*
     * public void setDestinos(List<Viaje> destinos) {
     * this.destinos = destinos;
     * }
     */

    public List<Conductor> getConductores() {
        return conductores;
    }

    /*
     * public void setConductores(List<Conductor> conductores) {
     * this.conductores = conductores;
     * }
     */

    public List<Administrador> getAdministradores() {
        return administradores;
    }

    /*
     * public void setAdministradores(List<Administrador> administradores) {
     * this.administradores = administradores;
     * }
     */

    public List<Autobus> getAutobuses() {
        return autobuses;
    }

    /*
     * public void setAutobuses(List<Autobus> autobuses) {
     * this.autobuses = autobuses;
     * }
     */

    public synchronized static Agencia getInstancia() {
        if (INSTANCIA == null) {
            INSTANCIA = new Agencia();
        }
        return INSTANCIA;
    }

    @Override
    public String toString() {
        return "Agencia " + nombreAgencia + ":" +
                "\n administradores=" + administradores +
                "\n autobuses=" + autobuses +
                "\n conductores=" + conductores +
                "\n destinos=" + destinos;
    }

}
