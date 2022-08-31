package dgtic.baseDatos.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.*;

import dgtic.baseDatos.BaseDeDatos;
import dgtic.baseDatos.intf.BaseDeDatosDAO;
import dgtic.modelo.entidades.autobus.Autobus;
import dgtic.modelo.entidades.empleado.Empleado;
import dgtic.modelo.entidades.viaje.Viaje;

@Component
public class BaseDeDatosDAOImpl implements BaseDeDatosDAO {

    @Override
    public List<Empleado> getEmpleados() {
        return BaseDeDatos.empleados;
    }

    @Override
    public List<Autobus> getAutobuses() {
        return BaseDeDatos.autobuses;
    }

    @Override
    public Map<Empleado, Viaje> getViajesAsignados() {
        return BaseDeDatos.conductorViaje;
    }

}
