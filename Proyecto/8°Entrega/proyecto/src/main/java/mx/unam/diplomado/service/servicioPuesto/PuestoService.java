package mx.unam.diplomado.service.servicioPuesto;

import java.util.List;
import java.util.Optional;

import mx.unam.diplomado.modelo.entidades.puesto.Puesto;

public interface PuestoService {

    List<Puesto> cargaPuestos();

    void guardaPuesto(Puesto puesto);

    Optional<Puesto> cargaPuesto(Integer id);

    void eliminaPuesto(Integer id);
}
