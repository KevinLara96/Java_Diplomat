package unam.dgtic.core.ejercicio3;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AutomovilPagingAndSortingRepository extends PagingAndSortingRepository<Automovil, String> {
    public List<Automovil> findByOrderByMarca();

    public List<Automovil> findByOrderByMarcaDescModeloDesc();

    public List<Automovil> findAllByPotencia(int potencia, Pageable pageable);

}