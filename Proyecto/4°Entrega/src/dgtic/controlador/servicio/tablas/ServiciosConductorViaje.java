package dgtic.controlador.servicio.tablas;

import java.util.List;

import dgtic.modelo.entidades.agencia.asignaciones.ConductorAutobus;

public interface ServiciosConductorViaje {
    ConductorAutobus cargaConductorAutobusPorId(Integer id);

    List<ConductorAutobus> cargaConductorAutobuss();

    void guardaConductorAutobus(ConductorAutobus conductorAutobus);

    void actualizaConductorAutobus(ConductorAutobus conductorAutobus);

    void eliminaConductorAutobus(ConductorAutobus conductorAutobus);
}
