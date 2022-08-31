package dgtic.controlador.servicio.tablas;

import java.util.List;

import dgtic.modelo.entidades.viaje.Viaje;

public interface ServiciosViaje {
    Viaje cargaViajePorId(Integer id);

    List<Viaje> cargaViajes();

    void guardaViaje(Viaje empleado);

    void actualizaViaje(Viaje empleado);

    void eliminaViaje(Viaje empleado);
}
