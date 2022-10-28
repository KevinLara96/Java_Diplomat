package mx.unam.diplomado.service;

import java.util.List;
import java.util.Optional;

import mx.unam.diplomado.modelo.entidades.Agencia;

public interface AgenciaService {

    List<Agencia> cargaAgencias();

    void guardaAgencia(Agencia autobus);

    Optional<Agencia> cargaAgencia(Integer idAgencia);

    void eliminaAgencia(Integer idAgencia);

    List<Agencia> getListaAgencia();

    Agencia cargaPorNombre(String nombre);
}
