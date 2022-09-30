package unam.dgtic.core.ejercicio1;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

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
    List<Automovil> getByModelo(String modelo);

    long countByModelo(String modelo);

    boolean existsByModelo(String modelo);

    // Color.
    List<Automovil> getByColor(String color);

    long countByColor(String color);

    boolean existsByColor(String color);

    // Torque
    List<Automovil> getByTorque(Integer torque);

    long countByTorque(Integer torque);

    boolean existsByTorque(Integer torque);

    // Potencia
    List<Automovil> getByPotencia(Integer potencia);

    long countByPotencia(Integer potencia);

    boolean existsByPotencia(Integer potencia);

    // Consultas derivadas Marca y Modelo.
    List<Automovil> getByMarcaAndModelo(String marca, String modelo);

    List<Automovil> getByMarcaOrModelo(String marca, String modelo);

    long countByMarcaAndModelo(String marca, String modelo);

    long countByMarcaOrModelo(String marca, String modelo);

    List<Automovil> findByMarcaStartingWith(String prefijo);

    List<Automovil> findByModeloStartingWith(String prefijo);

    List<Automovil> findByMarcaEndingWith(String sufijo);

    List<Automovil> findByModeloEndingWith(String sufijo);

    List<Automovil> findByMarcaLike(String contiene);

    List<Automovil> findByModeloLike(String contiene);

    // Consultas derivadas Torque y Potencia.
    List<Automovil> findTop2ByTorque(Integer torque);

    List<Automovil> findTop2ByPotencia(Integer potencia);

    List<Automovil> findFirstByOrderByTorque();

    List<Automovil> findFirstByOrderByPotencia();

    List<Automovil> findByTorqueBetween(Integer torqueIni, Integer torqueFin);

    List<Automovil> findByPotenciaBetween(Integer potenciaIni, Integer potenciaFin);

    // Consultas derivadas Potencia, Torque, Marca.
    List<Automovil> findByMarcaOrderByTorque(String marca);

    List<Automovil> findByMarcaOrderByPotencia(String marca);

    // Consultas derivadas Color.
    List<Automovil> findByColorIn(Collection<String> colores);

    /*
     * Operaciones persistencia.
     */
    // Delete.
    @Transactional
    void deleteByIdAutomovil(Integer idAutomovil);

    @Transactional
    void deleteByMarca(String marca);

    @Transactional
    void deleteByModelo(String modelo);
}
