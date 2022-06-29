package dgtic.modelo.empleado.conductor;

import java.util.List;

import dgtic.modelo.empleado.Empleado;
import dgtic.modelo.empleado.puesto.Puesto;
import dgtic.modelo.autobus.Autobus;
import dgtic.modelo.viaje.Viaje;

public class Conductor extends Empleado {
    private int idConductor;
    private List<Autobus> autobusesAsignados;
    private Viaje viajeAsignado;

    public Conductor(String nombre, String correo, String contrasena, String rfc, float salario, Puesto puesto,
            int idConductor, List<Autobus> autobusesAsignados, Viaje viajeAsignado) {
        super(nombre, correo, contrasena, rfc, salario, puesto);
        this.idConductor = idConductor;
        this.autobusesAsignados = autobusesAsignados;
        this.viajeAsignado = viajeAsignado;
    }

    public int getIdConductor() {
        return idConductor;
    }

    public void setIdConductor(int idConductor) {
        this.idConductor = idConductor;
    }

    public List<Autobus> getAutobusesAsignados() {
        return autobusesAsignados;
    }

    public void setAutobusesAsignados(List<Autobus> autobusesAsignados) {
        this.autobusesAsignados = autobusesAsignados;
    }

    public Viaje getViajeAsignado() {
        return viajeAsignado;
    }

    public void setViajeAsignado(Viaje viajeAsignado) {
        this.viajeAsignado = viajeAsignado;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n idConductor=" + idConductor +
                "\n autobusesAsignados=" + autobusesAsignados +
                "\n viajeAsignado=" + viajeAsignado + "]";
    }
}
