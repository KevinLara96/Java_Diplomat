package unam.dgtic.core.ejercicio1;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface AutomovilRepositorio extends CrudRepository<Automovil, Integer> {

    // Id.
    Optional<Automovil> findByIdAutomovil(Integer idAutomovil);

    List<Automovil> findByIdAutomovilNot(Integer idAutomovil);

    // Marca.
    List<Automovil> getByMarca(String marca);

    List<Automovil> getByMarcaNot(String marca);

    long countByMarca(String marca);

    long countByMarcaNot(String marca);

    boolean existsByMarca(String marca);

    // Modelo.
    Optional<Automovil> getByModelo(String modelo);

    long countByModelo(String modelo);

    boolean existsByModelo(String modelo);
}
