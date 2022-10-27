package mx.unam.diplomado.service.servicioAgencia;

import java.util.List;
import java.util.Optional;

import mx.unam.diplomado.modelo.entidades.agencia.Agencia;

public interface AgenciaService {
    Optional<Agencia> findByIdAgencia(Integer idAgencia);

    List<Agencia> findAllByIdAgencia(Integer idAgencia);

}
