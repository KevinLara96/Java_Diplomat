package dgtic.core.baseDatos.impl;

import java.util.Set;

import org.springframework.stereotype.*;

import dgtic.core.baseDatos.BaseDeDatos;
import dgtic.core.baseDatos.intf.BaseDeDatosDAO;
import dgtic.core.modelo.entidades.agencia.asignaciones.ConductorAutobus;
import dgtic.core.modelo.entidades.agencia.asignaciones.ConductorViaje;
import dgtic.core.modelo.entidades.autobus.Autobus;
import dgtic.core.modelo.entidades.empleado.Empleado;
import dgtic.core.modelo.entidades.viaje.Viaje;

@Component("BaseDeDatosDAO")
public class BaseDeDatosDAOImpl implements BaseDeDatosDAO {

    @Override
    public Set<Empleado> getEmpleados() {
        return BaseDeDatos.empleados;
    }

    @Override
    public Set<Autobus> getAutobuses() {
        return BaseDeDatos.autobuses;
    }

    @Override
    public Set<Viaje> getDestinos() {
        return BaseDeDatos.destinos;
    }

    @Override
    public Set<ConductorAutobus> getAutobusesAsignados() {
        return BaseDeDatos.conductorAutobus;
    }

    @Override
    public Set<ConductorViaje> getViajesAsignados() {
        return BaseDeDatos.conductorViaje;
    }

}
