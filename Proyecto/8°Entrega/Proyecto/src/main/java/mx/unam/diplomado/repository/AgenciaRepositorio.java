package mx.unam.diplomado.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import mx.unam.diplomado.modelo.agencia.Agencia;

public interface AgenciaRepositorio extends CrudRepository<Agencia, Integer> {

    Optional<Agencia> findByIdAgencia(Integer idAgencia);

    List<Agencia> findAllByIdAgencia(Integer idAgencia);

    Optional<Agencia> findByNombreAgencia(String nombreAgencia);

}
