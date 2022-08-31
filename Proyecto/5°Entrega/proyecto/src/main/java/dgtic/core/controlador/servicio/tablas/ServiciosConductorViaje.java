package dgtic.controlador.servicio.tablas;

import java.util.List;

import dgtic.modelo.entidades.agencia.asignaciones.ConductorViaje;

public interface ServiciosConductorViaje {
    ConductorViaje cargaConductorViajePorId(Integer id);

    List<ConductorViaje> cargaConductorViajes();

    void guardaConductorViaje(ConductorViaje conductorViaje);

    void actualizaConductorViaje(ConductorViaje conductorViaje);

    void eliminaConductorViaje(ConductorViaje conductorViaje);
}
