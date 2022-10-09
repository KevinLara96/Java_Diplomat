package unam.dgtic.core.ejercicio4;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface DuenoRepository extends CrudRepository<Dueno, Integer> {

    List<Dueno> findByNombre(String nombre);

    List<Dueno> findByRfc(String rfc);

}
