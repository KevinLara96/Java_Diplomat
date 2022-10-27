package mx.unam.diplomado.service.servicioAutobus;

import java.util.List;
import java.util.Optional;

import mx.unam.diplomado.modelo.entidades.autobus.Autobus;

public interface AutobusService {

    List<Autobus> cargaAutobuses();

    void guardaAutobus(Autobus autobus);

    Optional<Autobus> cargaAutobus(Integer idAutobus);

    void eliminaAutobus(Integer idAutobus);
}
