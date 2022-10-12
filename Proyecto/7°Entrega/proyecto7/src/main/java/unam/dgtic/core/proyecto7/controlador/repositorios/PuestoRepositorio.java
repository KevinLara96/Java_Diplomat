package unam.dgtic.core.proyecto7.controlador.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import unam.dgtic.core.proyecto7.modelo.puesto.Puesto;

public interface PuestoRepositorio extends CrudRepository<Puesto, Integer> {

    Optional<Puesto> findByIdPuesto(Integer idPuesto);

    List<Puesto> findAllByIdPuesto(Integer idsPuestos);

}
