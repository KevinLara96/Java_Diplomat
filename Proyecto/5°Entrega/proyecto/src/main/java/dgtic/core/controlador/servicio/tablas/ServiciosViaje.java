package dgtic.core.controlador.servicio.tablas;

import java.util.List;

import dgtic.core.modelo.entidades.viaje.Viaje;

public interface ServiciosViaje {
    Viaje cargaViajePorId(Integer id);

    List<Viaje> cargaViajes();

    void guardaViaje(Viaje empleado);

    void actualizaViaje(Viaje empleado);

    void eliminaViaje(Viaje empleado);
}
