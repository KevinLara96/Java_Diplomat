package dgtic.core.controlador.servicio.tablas;

import java.util.List;

import dgtic.core.modelo.entidades.autobus.Autobus;

public interface ServiciosAutobus {
    Autobus cargaAutobusPorId(Integer id);

    List<Autobus> cargaAutobuses();

    void guardaAutobus(Autobus empleado);

    void actualizaAutobus(Autobus empleado);

    void eliminaAutobus(Autobus empleado);
}
