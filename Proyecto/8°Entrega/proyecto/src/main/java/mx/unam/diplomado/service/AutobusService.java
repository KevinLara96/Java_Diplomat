package mx.unam.diplomado.service;

import java.util.List;
import java.util.Optional;

import mx.unam.diplomado.modelo.entidades.Autobus;

public interface AutobusService {

    List<Autobus> cargaAutobuses();

    void guardaAutobus(Autobus autobus);

    Optional<Autobus> cargaAutobus(Integer idAutobus);

    void eliminaAutobus(Integer idAutobus);

    List<Autobus> getListaAutobus();

    Autobus cargaPorNombre(String nombre);
}
