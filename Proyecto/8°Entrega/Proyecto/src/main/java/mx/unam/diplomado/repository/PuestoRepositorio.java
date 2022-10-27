package mx.unam.diplomado.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import mx.unam.diplomado.modelo.puesto.Puesto;

public interface PuestoRepositorio extends CrudRepository<Puesto, Integer> {

    Optional<Puesto> findByIdPuesto(Integer idPuesto);

    List<Puesto> findAllByIdPuesto(Integer idsPuestos);

    Optional<Puesto> findByPuesto(String puesto);

}
