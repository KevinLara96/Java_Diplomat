package dgtic.core.modelo.DAO.tablas;

import java.util.List;

import dgtic.core.modelo.entidades.agencia.asignaciones.ConductorAutobus;

public interface ConductorAutobusDAO {

    ConductorAutobus cargaConductorAutobusPorId(Integer id);

    // ConductorAutobus cargaConductorAutobusPorIdNQ(Integer id);

    List<ConductorAutobus> cargaAutobusesAsignados();

    void guardaConductorAutobus(ConductorAutobus asignacionConductorAutobus);

    void actualizaConductorAutobus(ConductorAutobus asignacionConductorAutobus);

    void eliminaConductorAutobus(ConductorAutobus asignacionConductorAutobus);
}
