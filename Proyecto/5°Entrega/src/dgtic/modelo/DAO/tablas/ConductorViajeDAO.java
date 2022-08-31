package dgtic.modelo.DAO.tablas;

import java.util.List;

import dgtic.modelo.entidades.agencia.asignaciones.ConductorViaje;

public interface ConductorViajeDAO {

    ConductorViaje cargaConductorViajePorId(Integer id);

    // ConductorViaje cargaConductorViajePorIdNQ(Integer id);

    List<ConductorViaje> cargaConductorViajes();

    void guardaConductorViaje(ConductorViaje asignacionConductorViaje);

    void actualizaConductorViaje(ConductorViaje asignacionConductorViaje);

    void eliminaConductorViaje(ConductorViaje asignacionConductorViaje);
}
