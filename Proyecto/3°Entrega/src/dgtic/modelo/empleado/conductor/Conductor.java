package dgtic.modelo.empleado.conductor;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import dgtic.modelo.empleado.Empleado;
import dgtic.modelo.empleado.puesto.Puesto;
import dgtic.modelo.autobus.Autobus;
import dgtic.modelo.viaje.Viaje;
import dgtic.modelo.viaje.implementacion.FactoryViajeCorto;
import dgtic.modelo.viaje.interfaces.AbstractFactory;
import dgtic.modelo.viaje.interfaces.TipoViaje;
import dgtic.modelo.viaje.interfaces.Viajes;

public class Conductor extends Empleado {
    private int claveConductor;
    private List<Autobus> autobusesAsignados;
    private Viaje viajeAsignado;

    public Conductor(String claveEmpleado, String nombre, String correo, String contrasena, String rfc, float salario,
            Puesto puesto,
            int claveConductor, List<Autobus> autobusesAsignados, Viaje viajeAsignado) {
        super(claveEmpleado, nombre, correo, contrasena, rfc, salario, puesto);
        setClaveConductor(claveConductor);
        setViajeAsignado(viajeAsignado);
    }

    public int getClaveConductor() {
        return claveConductor;
    }

    public void setClaveConductor(int claveConductor) {
        if (claveConductor <= 0) {
            Random rand = new Random();
            this.claveConductor = rand.nextInt(100);
        } else {
            this.claveConductor = claveConductor;
        }
    }

    public List<Autobus> getAutobusesAsignados() {
        return autobusesAsignados;
    }

    public Viaje getViajeAsignado() {
        return viajeAsignado;
    }

    public void setViajeAsignado(Viaje viajeAsignado) {
        if (viajeAsignado == null) {
            Random rand = new Random();
            AbstractFactory factory = new FactoryViajeCorto();
            Viajes viajes = factory.crearViaje();
            Viaje viaje = viajes.viaje(rand.nextInt(999), "Origen", "Destino",
                    20.0f, 300, LocalDate.now().toString(), TipoViaje.CORTO);
            this.viajeAsignado = viaje;
        } else {
            this.viajeAsignado = viajeAsignado;
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n claveConductor=" + claveConductor +
                "\n autobusesAsignados=" + autobusesAsignados +
                "\n viajeAsignado=" + viajeAsignado + "]";
    }
}
