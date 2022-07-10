package dgtic.modelo.empleado.conductor;

import java.util.List;
import java.util.Random;

import dgtic.modelo.empleado.Empleado;
import dgtic.modelo.empleado.puesto.Puesto;
import dgtic.modelo.autobus.Autobus;
import dgtic.modelo.viaje.Viaje;

public class Conductor extends Empleado {
    private int claveConductor;
    private List<Autobus> autobusesAsignados;
    private Viaje viajeAsignado;

    public Conductor(String claveEmpleado, String nombre, String correo, String contrasena, String rfc, float salario,
            Puesto puesto,
            int claveConductor, List<Autobus> autobusesAsignados, Viaje viajeAsignado) {
        super(claveEmpleado, nombre, correo, contrasena, rfc, salario, puesto);
        setClaveConductor(claveConductor);
        setAutobusesAsignados(autobusesAsignados);
        setViajeAsignado(viajeAsignado);
    }

    public int getClaveConductor() {
        return claveConductor;
    }

    public void setClaveConductor(int claveConductor) {
        if (claveConductor <= 0) {
            Random rand = new Random();
            this.claveConductor = rand.nextInt(100);
        }
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
                "\n claveConductor=" + claveConductor +
                "\n autobusesAsignados=" + autobusesAsignados +
                "\n viajeAsignado=" + viajeAsignado + "]";
    }
}
