package mx.unam.diplomado.service.servicioAgencia;

import java.util.List;
import java.util.Optional;

import mx.unam.diplomado.modelo.entidades.agencia.Agencia;

public interface AgenciaService {

    List<Agencia> cargaAgencias();

    void guardaAgencia(Agencia autobus);

    Optional<Agencia> cargaAgencia(Integer idAgencia);

    void eliminaAgencia(Integer idAgencia);
}
