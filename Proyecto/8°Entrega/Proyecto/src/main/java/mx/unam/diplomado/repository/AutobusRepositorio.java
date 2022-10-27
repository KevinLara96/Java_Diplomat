package mx.unam.diplomado.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import mx.unam.diplomado.modelo.autobus.Autobus;

public interface AutobusRepositorio extends CrudRepository<Autobus, Integer> {

    // Id.
    Optional<Autobus> findByIdAutobus(Integer idAutobus);

    List<Autobus> findAllByIdAutobus(Integer idAutobus);

    // Modelo.
    List<Autobus> getByModelo(String modelo);

    long countByModelo(String modelo);

    boolean existsByModelo(String modelo);

    // Marca.
    List<Autobus> getByMarca(String marca);

    long countByMarca(String marca);

    boolean existsByMarca(String marca);

    // Capacidad.
    List<Autobus> getByCapacidad(String capacidad);

    long countByCapacidad(String capacidad);

    boolean existsByCapacidad(String capacidad);

    // Consultas derivadas Modelo y marca.
    List<Autobus> getByModeloAndMarca(String modelo, String marca);

    List<Autobus> findByMarcaStartingWith(String prefijo);

    List<Autobus> findByModeloStartingWith(String prefijo);

    List<Autobus> findByMarcaEndingWith(String sufijo);

    List<Autobus> findByModeloEndingWith(String sufijo);

    public List<Autobus> findByMarcaContaining(String contiene);

    public List<Autobus> findByModeloContaining(String contiene);

    // Consultas derivadas capacidad.
    List<Autobus> findByCapacidadBetween(Integer capacidadIni, Integer capacidadFin);

    /*
     * Operaciones persistencia.
     */
    @Transactional
    void deleteByIdAutobus(Integer idAutobus);

    @Transactional
    void deleteByMarcaAndModelo(String marca, String modelo);

    /*
     * Named Queries
     */
    List<Autobus> buscarTodos();
}
