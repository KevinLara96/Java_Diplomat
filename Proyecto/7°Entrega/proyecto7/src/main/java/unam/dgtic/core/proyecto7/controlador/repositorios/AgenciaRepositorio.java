package unam.dgtic.core.proyecto7.controlador.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import unam.dgtic.core.proyecto7.modelo.agencia.Agencia;

public interface AgenciaRepositorio extends CrudRepository<Agencia, Integer> {

    Optional<Agencia> findByIdAgencia(Integer idAgencia);

    List<Agencia> findAllByIdAgencia(Integer idAgencia);

}
