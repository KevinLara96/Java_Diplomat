package dgtic.baseDatos.intf;

import java.util.List;
import java.util.Map;

import dgtic.modelo.entidades.autobus.Autobus;
import dgtic.modelo.entidades.empleado.Empleado;
import dgtic.modelo.entidades.viaje.Viaje;

public interface BaseDeDatosDAO {
    public List<Empleado> getEmpleados();

    public List<Autobus> getAutobuses();

    public Map<Empleado, Viaje> getViajesAsignados();

}
