package mx.unam.diplomado.service;

import java.util.List;
import java.util.Optional;

import mx.unam.diplomado.modelo.entidades.viaje.Viaje;

public interface ViajeService {

    List<Viaje> cargaViajes();

    void guardaViaje(Viaje viaje);

    Optional<Viaje> cargaViaje(Integer id);

    void eliminaViaje(Integer id);
}
