package dgtic.core.baseDatos.intf;

import java.util.Set;

import dgtic.core.modelo.entidades.autobus.Autobus;
import dgtic.core.modelo.entidades.empleado.Empleado;
import dgtic.core.modelo.entidades.viaje.Viaje;

public interface BaseDeDatosDAO {
    public Set<Empleado> getEmpleados();

    public Set<Autobus> getAutobuses();

    public Set<Viaje> getDestinos();

}
