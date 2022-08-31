package dgtic.controlador.servicio.tablas;

import java.util.List;

import dgtic.modelo.entidades.agencia.asignaciones.ConductorAutobus;

public interface ServiciosConductorAutobus {

    ConductorAutobus cargaConductorAutobusPorId(Integer id);

    List<ConductorAutobus> cargaConductorAutobuses();

    void guardaConductorAutobus(ConductorAutobus conductorAutobus);

    void actualizaConductorAutobus(ConductorAutobus conductorAutobus);

    void eliminaConductorAutobus(ConductorAutobus conductorAutobus);
}
