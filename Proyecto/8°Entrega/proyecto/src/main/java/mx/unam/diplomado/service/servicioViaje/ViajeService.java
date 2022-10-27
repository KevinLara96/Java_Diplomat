package mx.unam.diplomado.service.servicioViaje;

import java.util.List;

import mx.unam.diplomado.modelo.entidades.viaje.Viaje;

public interface ViajeService {

    List<Viaje> cargaViajes();

    void guardaViaje(Viaje viaje);

    Viaje cargaViaje(Integer id);

    void eliminaViaje(Integer id);
}
